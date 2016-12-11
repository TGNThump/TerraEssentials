package uk.co.terragaming.TerraEssentials.commands;

import java.util.Optional;

import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.world.Locatable;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.weather.Weather;

import uk.co.terragaming.TerraCore.Commands.annotations.Command;
import uk.co.terragaming.TerraCore.Commands.annotations.Desc;
import uk.co.terragaming.TerraCore.Commands.annotations.Perm;
import uk.co.terragaming.TerraCore.Util.Context;

public class WeatherCommand {
	
	@Command("weather")
	@Desc("Get the current weather.")
	@Perm("tc.essentials.world.weather")
	public CommandResult onGetWeather(Context context,
		@Desc("The world to get the weather from.") Optional<World> world
	){
		CommandSource source = context.get(CommandSource.class);
		if (!(source instanceof Locatable) && !world.isPresent()){
			source.sendMessage(Text.of(TextColors.RED, "Please specify a world in which to get the weather."));
			return CommandResult.empty();
		}
		
		World w = world.orElse(((Locatable) source).getWorld());
		Weather weather = w.getWeather();
		
		source.sendMessage(Text.of(TextColors.AQUA, "The current weather in ", TextColors.YELLOW, w.getName(), TextColors.AQUA, " is ", TextColors.YELLOW, weather.getName(), TextColors.AQUA, "."));
		return CommandResult.success();
	}
	
	@Command("weather")
	@Desc("Sets the current weather.")
	@Perm("tc.essentials.world.weather.set")
	public CommandResult onSetWeather(Context context,
		@Desc("The weather to set.") Weather weather,
		@Desc("The world in which to set the time.") Optional<World> world,
		@Desc("The duration to forecast.") Optional<Long> duration
	){
		CommandSource source = context.get(CommandSource.class);
		if (!(source instanceof Locatable) && !world.isPresent()){
			source.sendMessage(Text.of(TextColors.RED, "Please specify a world in which to get the time."));
			return CommandResult.empty();
		}
		
		World w = world.orElse(((Locatable) source).getWorld());
		if (duration.isPresent()) w.setWeather(weather, duration.get());
		else w.setWeather(weather);
		source.sendMessage(Text.of(TextColors.AQUA, "You set the weather in ", TextColors.YELLOW, w.getName(), TextColors.AQUA, " to ", TextColors.YELLOW, weather.getName(), TextColors.AQUA, "."));
		
		return CommandResult.success();
	}
}
