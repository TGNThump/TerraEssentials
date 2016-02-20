package uk.co.terragaming.TerraEssentials.commands;

import java.util.Optional;

import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.source.LocatedSource;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.world.storage.WorldProperties;

import uk.co.terragaming.TerraCore.Commands.annotations.Command;
import uk.co.terragaming.TerraCore.Commands.annotations.Desc;
import uk.co.terragaming.TerraCore.Commands.annotations.Perm;
import uk.co.terragaming.TerraCore.Util.Context;
import uk.co.terragaming.TerraCore.Util.WorldTime;

public class TimeCommand {
	
	@Command("time")
	@Desc("Get the current time.")
	@Perm("tc.essentials.world.time")
	public CommandResult onGetTime(Context context,
		@Desc("The world to get the time from.") Optional<WorldProperties> world
	){
		CommandSource source = context.get(CommandSource.class);
		if (!(source instanceof LocatedSource) && !world.isPresent()){
			source.sendMessage(Text.of(TextColors.RED, "Please specify a world in which to get the time."));
			return CommandResult.empty();
		}
		
		WorldProperties wp = world.orElse(((LocatedSource) source).getWorld().getProperties());
		WorldTime time = new WorldTime(wp.getWorldTime());
		
		source.sendMessage(Text.of(TextColors.AQUA, "The current time in ", TextColors.YELLOW, wp.getWorldName(), TextColors.AQUA, " is ", TextColors.YELLOW, time.get12Hour(), TextColors.AQUA, "."));
		return CommandResult.success();
	}
	
	@Command("time")
	@Desc("Sets the current time.")
	@Perm("tc.essentials.world.time.set")
	public CommandResult onSetTime(Context context,
		@Desc("The time to set.") WorldTime time,
		@Desc("The world in which to set the time.") Optional<WorldProperties> world
	){
		CommandSource source = context.get(CommandSource.class);
		if (!(source instanceof LocatedSource) && !world.isPresent()){
			source.sendMessage(Text.of(TextColors.RED, "Please specify a world in which to get the time."));
			return CommandResult.empty();
		}
		
		WorldProperties wp = world.orElse(((LocatedSource) source).getWorld().getProperties());
		wp.setWorldTime(time.getTickTime());
		source.sendMessage(Text.of(TextColors.AQUA, "You set the time in ", TextColors.YELLOW, wp.getWorldName(), TextColors.AQUA, " to ", TextColors.YELLOW, time.get12Hour(), TextColors.AQUA, "."));
		
		return CommandResult.success();
	}
}
