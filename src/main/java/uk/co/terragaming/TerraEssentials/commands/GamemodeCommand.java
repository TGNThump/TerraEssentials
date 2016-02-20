package uk.co.terragaming.TerraEssentials.commands;

import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.player.gamemode.GameMode;
import org.spongepowered.api.entity.living.player.gamemode.GameModes;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

import uk.co.terragaming.TerraCore.Commands.annotations.Alias;
import uk.co.terragaming.TerraCore.Commands.annotations.Command;
import uk.co.terragaming.TerraCore.Commands.annotations.Desc;
import uk.co.terragaming.TerraCore.Commands.annotations.Perm;
import uk.co.terragaming.TerraCore.Commands.exceptions.AuthorizationException;
import uk.co.terragaming.TerraCore.Commands.exceptions.CommandException;
import uk.co.terragaming.TerraCore.Util.Context;

public class GamemodeCommand {
	
	@Command("gamemode")
	@Desc("Set the target players gamemode.")
	@Perm("tc.essentials.cheats.gamemode")
	@Alias("gm")
	public CommandResult onGamemode(Context context,
		@Desc("The gamemode to set.") GameMode gamemode,
		@Desc("The players who's gamemode to set.") Player... targets
	) throws CommandException{
		CommandSource source = context.get(CommandSource.class);
		
		if (targets.length == 0){
			if (source instanceof Player){
				Player player = (Player) source;
				if (player.offer(Keys.GAME_MODE, gamemode).isSuccessful()){
					source.sendMessage(Text.of(TextColors.AQUA, "Set your gamemode to ", TextColors.YELLOW, gamemode.getName(), TextColors.AQUA, "."));
					return CommandResult.success();
				} else {
					throw new CommandException("Could not set players gamemode.");
				}
			} else {
				source.sendMessage(Text.of(TextColors.RED, "Please specify at least one player."));
				return CommandResult.empty();
			}
		} else {
			for (Player player : targets){
				if (player.equals(source)){
					if (player.offer(Keys.GAME_MODE, gamemode).isSuccessful()){
						source.sendMessage(Text.of(TextColors.AQUA, "Set your gamemode to ", TextColors.YELLOW, gamemode.getName(), TextColors.AQUA, "."));
					} else {
						throw new CommandException("Could not set players gamemode.");
					}
				} else if (player.hasPermission("tc.essentials.cheats.gamemode.others")){
					if (player.offer(Keys.GAME_MODE, gamemode).isSuccessful()){
						source.sendMessage(Text.of(TextColors.AQUA, "Set ", TextColors.YELLOW, player.getName(), TextColors.AQUA, "s gamemode to ", TextColors.YELLOW, gamemode.getName(), TextColors.AQUA, "."));
						player.sendMessage(Text.of(TextColors.YELLOW, source.getName(), TextColors.AQUA, TextColors.AQUA, " set your gamemode to ", TextColors.YELLOW, gamemode.getName(), TextColors.AQUA, "."));
					} else {
						throw new CommandException("Could not set players gamemode.");
					}
				} else {
					throw new AuthorizationException();
				}
			}
			return CommandResult.success();
		}
	}
	
	@Command("gmc")
	@Desc("Set the players gamemode to creative.")
	@Perm("tc.essentials.cheats.gamemode")
	public CommandResult onGamemodeC(Context context, @Desc("The player who's gamemode to set.") Player... targets) throws CommandException{
		return onGamemode(context, GameModes.CREATIVE, targets);
	}
	
	@Command("gms")
	@Desc("Set the players gamemode to survival.")
	@Perm("tc.essentials.cheats.gamemode")
	public CommandResult onGamemodeS(Context context, @Desc("The player who's gamemode to set.") Player... targets) throws CommandException{
		return onGamemode(context, GameModes.SURVIVAL, targets);
	}
	
	@Command("gma")
	@Desc("Set the players gamemode to adventure.")
	@Perm("tc.essentials.cheats.gamemode")
	public CommandResult onGamemodeA(Context context, @Desc("The player who's gamemode to set.") Player... targets) throws CommandException{
		return onGamemode(context, GameModes.ADVENTURE, targets);
	}
}
