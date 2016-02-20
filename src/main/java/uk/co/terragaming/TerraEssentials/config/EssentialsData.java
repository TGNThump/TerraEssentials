package uk.co.terragaming.TerraEssentials.config;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.inject.Inject;

import ninja.leaping.configurate.objectmapping.Setting;

import org.spongepowered.api.Server;
import org.spongepowered.api.world.storage.WorldProperties;

import uk.co.terragaming.TerraCore.Config.Config;

import com.flowpowered.math.vector.Vector3i;

public class EssentialsData extends Config{

	public EssentialsData() {
		super("data", "essentials.conf");
	}
	
	@Inject
	Server server;
	
	@Override
	public void setDefaults() {
		WorldProperties world = server.getDefaultWorld().get();
		
		Vector3i spawnPos = world.getSpawnPosition();
		
		spawn = setDefault(spawn, new WorldLocation());
		
		spawn.x = setDefault(spawn.x, (double) spawnPos.getX());
		spawn.y = setDefault(spawn.y, (double) spawnPos.getY());
		spawn.z = setDefault(spawn.z, (double) spawnPos.getZ());
		spawn.worldUUID = setDefault(spawn.worldUUID, world.getUniqueId());
		
		homes = setDefault(homes, new HashMap<UUID, WorldLocation>());
	}
	
	@Setting
	public WorldLocation spawn;
	
	@Setting
	public Map<UUID, WorldLocation> homes;
}
