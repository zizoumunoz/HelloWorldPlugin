package me.zizoumunoz.helloworldplugin;

import java.io.File;

import org.bukkit.plugin.java.JavaPlugin;

import me.zizoumunoz.helloworldplugin.commands.TestCommand;
import me.zizoumunoz.helloworldplugin.data.PlayerDataSerde;
import me.zizoumunoz.helloworldplugin.listeners.TestListener;

public class HelloWorldPlugin extends JavaPlugin {

	private PlayerDataSerde playerDataSerde;

	public PlayerDataSerde getPlayerDataSerde() {
		return playerDataSerde;
	}

	@Override
	public void onEnable() {
		/*
		 * "the only ways the player can interact with your plug-in is through commands
		 * and events."
		 */

		saveDefaultConfig();

		getCommand("hello").setExecutor(new TestCommand());
		getServer().getPluginManager().registerEvents(new TestListener(), this);
		new TestListener();

		// This returns a value from the config.yml file
		getConfig().getBoolean("test-config");
		// This makes a data file in the data folder
		new File(getDataFolder(), "data.json");
		// Bukkit way to do serialize and deserialize
		// YamlConfiguration playerDataSerde = YamlConfiguration.loadConfiguration(new
		// File(getDataFolder(), "data.yml"));
		playerDataSerde = new PlayerDataSerde(new File(getDataFolder(), "data.yml"));
		playerDataSerde.load();
	}

	public void onDisable() {
		playerDataSerde.save();
	}

}
