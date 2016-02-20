package uk.co.terragaming.TerraEssentials.commands;

import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.source.LocatedSource;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.world.World;

import uk.co.terragaming.TerraCore.Commands.annotations.Alias;
import uk.co.terragaming.TerraCore.Commands.annotations.Command;
import uk.co.terragaming.TerraCore.Commands.annotations.Desc;
import uk.co.terragaming.TerraCore.Commands.annotations.Perm;
import uk.co.terragaming.TerraCore.Commands.exceptions.CommandException;
import uk.co.terragaming.TerraCore.Util.Context;


public class TeleportCommand {
	
	@Command("teleport")
	@Desc("Teleport to a world.")
	@Perm("tc.core.tp.world")
	@Alias("tp")
	public CommandResult onTpToWorld(Context context,
		@Desc("The world to teleport to.") World world
	) throws CommandException{
		CommandSource source = context.get(CommandSource.class);
		
		if (source instanceof Player){
			Player player = (Player) source;
			
			if (!world.isLoaded()){
				source.sendMessage(Text.of(TextColors.RED, "The world ", TextColors.YELLOW, world.getName(), TextColors.RED, " is not loaded."));
				return CommandResult.empty();
			}
			
			if (player.transferToWorld(world.getUniqueId(), world.getSpawnLocation().getPosition())){
				source.sendMessage(Text.of(TextColors.AQUA, "Teleported you to world ", TextColors.YELLOW, world.getName(), TextColors.AQUA, "."));
			} else {
				source.sendMessage(Text.of(TextColors.RED, "Could not teleport you to world ", TextColors.YELLOW, world.getName(), TextColors.RED, "."));
				return CommandResult.empty();
			}

			return CommandResult.success();
		} else {
			source.sendMessage(Text.of(TextColors.RED, "This command can only be run as a Player."));
			return CommandResult.empty();
		}
	}
	
	@Command("teleport")
	@Desc("Teleport to a player.")
	@Perm("tc.core.tp.player")
	@Alias("tp")
	public CommandResult onTpToPlayer(Context context,
		@Desc("The player to teleport to.") Player target
	){
		CommandSource source = context.get(CommandSource.class);
		
		if (source instanceof Player){
			Player player = (Player) source;
			
			if (player.setLocationSafely(target.getLocation())){
				source.sendMessage(Text.of(TextColors.AQUA, "Teleported you to ", TextColors.YELLOW, target.getName(), TextColors.AQUA, "."));
			} else {
				source.sendMessage(Text.of(TextColors.RED, "Could not teleport you to ", TextColors.YELLOW, target.getName(), TextColors.RED, "."));
				return CommandResult.empty();
			}

			return CommandResult.success();
		} else {
			source.sendMessage(Text.of(TextColors.RED, "This command can only be run as a Player."));
			return CommandResult.empty();
		}
	}
	
	@Command("teleport")
	@Desc("Teleport a player to a player.")
	@Perm("tc.core.tp.player")
	@Alias("tp")
	public CommandResult onTpToPlayer(Context context,
		@Desc("The player to teleport.") Player target,
		@Desc("The player to teleport to.") Player destination
	){
		CommandSource source = context.get(CommandSource.class);
		
		if (source.equals(target)){
			if (target.setLocationSafely(destination.getLocation())){
				target.sendMessage(Text.of(TextColors.AQUA, "Teleported you to ", TextColors.YELLOW, destination.getName(), TextColors.AQUA, "."));
			} else {
				target.sendMessage(Text.of(TextColors.RED, "Could not teleport you to ", TextColors.YELLOW, destination.getName(), TextColors.RED, "."));
				return CommandResult.empty();
			}
		} else {
			if (target.setLocationSafely(destination.getLocation())){
				source.sendMessage(Text.of(TextColors.AQUA, "Teleported ", TextColors.YELLOW, target.getName(), TextColors.AQUA, " to ", TextColors.YELLOW, destination.getName(), TextColors.AQUA, "."));
				target.sendMessage(Text.of(TextColors.YELLOW, source.getName(), TextColors.AQUA, " teleported you to ", TextColors.YELLOW, destination.getName(), TextColors.AQUA, "."));
			} else {
				source.sendMessage(Text.of(TextColors.RED, "Could not teleport ", TextColors.YELLOW, target.getName(), TextColors.RED, " to ", TextColors.YELLOW, target.getName(), TextColors.RED, "."));
				return CommandResult.empty();
			}
		}
		
		return CommandResult.success();
	}
	
	@Command("bring")
	@Desc("Teleport a player to me.")
	@Perm("tc.core.tp.player")
	@Alias("tphere")
	public CommandResult onBring(Context context,
		@Desc("The players to teleport.") Player... targets
	){
		CommandSource source = context.get(CommandSource.class);
		
		if (source instanceof LocatedSource){
			LocatedSource locatedSource = (LocatedSource) source;
			
			for (Player target : targets){
				if (target.setLocationSafely(locatedSource.getLocation())){
					target.sendMessage(Text.of(TextColors.YELLOW, locatedSource.getName(), TextColors.AQUA, " teleported you to them."));
					source.sendMessage(Text.of(TextColors.AQUA, "Teleported ", TextColors.YELLOW, target.getName(), TextColors.AQUA, " to you."));					
				} else {
					source.sendMessage(Text.of(TextColors.RED, "Could not teleport ", TextColors.YELLOW, target.getName(), TextColors.RED, " to you."));
					return CommandResult.empty();
				}
			}
			
			return CommandResult.success();
		} else {
			source.sendMessage(Text.of(TextColors.RED, "This command can only be run as a Player."));
			return CommandResult.empty();
		}
	}
}
