package uk.co.terragaming.TerraEssentials.commands;

import javax.inject.Inject;

import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.world.Locatable;

import uk.co.terragaming.TerraCore.Commands.annotations.Alias;
import uk.co.terragaming.TerraCore.Commands.annotations.Command;
import uk.co.terragaming.TerraCore.Commands.annotations.Desc;
import uk.co.terragaming.TerraCore.Commands.annotations.Perm;
import uk.co.terragaming.TerraCore.Util.Context;
import uk.co.terragaming.TerraEssentials.config.EssentialsData;


public class SpawnCommand {
	
	@Inject
	EssentialsData data;
	
	@Command("spawn")
	@Desc("Teleport to spawn.")
	@Perm("tc.essentials.tp.spawn")
	public CommandResult onSpawn(Context context){
		CommandSource source = context.get(CommandSource.class);
		
		if (source instanceof Player){
			Player player = (Player) source;
			
			if (player.setLocationSafely(data.spawn.get())){
				source.sendMessage(Text.of(TextColors.AQUA, "Teleported you to spawn."));
			} else {
				source.sendMessage(Text.of(TextColors.RED, "Could not teleport you to spawn."));
			}

			return CommandResult.success();
		} else {
			source.sendMessage(Text.of(TextColors.RED, "This command can only be run as a Player."));
			return CommandResult.empty();
		}
	}
	
	@Command("setspawn")
	@Desc("Set the spawn point.")
	@Perm("tc.essentials.tp.spawn.set")
	@Alias("spawn set")
	public CommandResult onSpawnSet(Context context){
		CommandSource source = context.get(CommandSource.class);
		
		if (source instanceof Locatable){
			data.spawn.set(((Locatable) source).getLocation());
			((Locatable) source).getWorld().getProperties().setSpawnPosition(((Locatable) source).getLocation().getBlockPosition());
			source.sendMessage(Text.of(TextColors.AQUA, "The spawn point has been set to your location."));
			return CommandResult.success();
		} else {
			source.sendMessage(Text.of(TextColors.RED, "This command can only be run as a Player."));
			return CommandResult.empty();
		}
	}
}
