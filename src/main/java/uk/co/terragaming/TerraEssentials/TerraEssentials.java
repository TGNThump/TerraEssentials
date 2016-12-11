package uk.co.terragaming.TerraEssentials;

import org.spongepowered.api.event.EventManager;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.event.game.state.GameStartingServerEvent;
import org.spongepowered.api.event.game.state.GameStoppedServerEvent;

import uk.co.terragaming.TerraCore.CorePlugin;
import uk.co.terragaming.TerraCore.Commands.MethodCommandService;
import uk.co.terragaming.TerraCore.Config.Config;
import uk.co.terragaming.TerraCore.Foundation.GuiceModule;
import uk.co.terragaming.TerraCore.Foundation.Module;
import uk.co.terragaming.TerraEssentials.commands.ClearCommand;
import uk.co.terragaming.TerraEssentials.commands.EnchantCommand;
import uk.co.terragaming.TerraEssentials.commands.FeedCommand;
import uk.co.terragaming.TerraEssentials.commands.FlyCommand;
import uk.co.terragaming.TerraEssentials.commands.GamemodeCommand;
import uk.co.terragaming.TerraEssentials.commands.HealCommand;
import uk.co.terragaming.TerraEssentials.commands.HomeCommand;
import uk.co.terragaming.TerraEssentials.commands.InvseeCommand;
import uk.co.terragaming.TerraEssentials.commands.JumpCommand;
import uk.co.terragaming.TerraEssentials.commands.SpawnCommand;
import uk.co.terragaming.TerraEssentials.commands.SpeedCommand;
import uk.co.terragaming.TerraEssentials.commands.TeleportCommand;
import uk.co.terragaming.TerraEssentials.commands.ThruCommand;
import uk.co.terragaming.TerraEssentials.commands.TimeCommand;
import uk.co.terragaming.TerraEssentials.commands.VanishCommand;
import uk.co.terragaming.TerraEssentials.commands.WeatherCommand;
import uk.co.terragaming.TerraEssentials.config.EssentialsData;
import uk.co.terragaming.TerraEssentials.listeners.PlayerJoinListener;

import com.google.inject.Inject;
import com.google.inject.Provides;
import com.google.inject.name.Names;

@Module(name = PomData.NAME, version = PomData.VERSION)
public class TerraEssentials extends GuiceModule{

	@Override
	public void configure(){
		bind(Config.class).annotatedWith(Names.named("EssentialsData")).to(EssentialsData.class);
	}
	
	@Inject
	CorePlugin plugin;
	
	@Inject
	MethodCommandService commands;
	
	@Inject
	EventManager events;
	
	private EssentialsData data;
	
	@Listener
    public void onInitialize(GameInitializationEvent event) {
		commands.registerCommands(plugin, new GamemodeCommand());
		commands.registerCommands(plugin, new FlyCommand());
		commands.registerCommands(plugin, new SpeedCommand());
		commands.registerCommands(plugin, new ClearCommand());
		commands.registerCommands(plugin, new EnchantCommand());
		commands.registerCommands(plugin, new HealCommand());
		commands.registerCommands(plugin, new FeedCommand());
		commands.registerCommands(plugin, new InvseeCommand());
		commands.registerCommands(plugin, new ThruCommand());
		commands.registerCommands(plugin, new JumpCommand());
		commands.registerCommands(plugin, new VanishCommand());
		commands.registerCommands(plugin, new WeatherCommand());
		commands.registerCommands(plugin, new SpawnCommand());
		commands.registerCommands(plugin, new TimeCommand());
		commands.registerCommands(plugin, new HomeCommand());
		commands.registerCommands(plugin, new TeleportCommand());
	}
	
	@Listener
	public void onServerStarting(GameStartingServerEvent event){
		data = new EssentialsData();
		events.registerListeners(plugin, inject(new PlayerJoinListener()));
	}
	
	@Listener
	public void onServerStopping(GameStoppedServerEvent event){
		data.save();
	}
	
	@Provides
	EssentialsData getData(){
		return data;
	}
	
}