package me.zizoumunoz.helloworldplugin;

import org.bukkit.plugin.java.JavaPlugin;
import me.zizoumunoz.helloworldplugin.commands.TestCommand;
import me.zizoumunoz.helloworldplugin.listeners.TestListener;

public class HelloWorldPlugin extends JavaPlugin {

	@Override
	public void onEnable() {
		/*
		 * "the only ways the player can interact with your plug-in is
		 * through commands and events."
		 */
		getCommand("hello").setExecutor(new TestCommand());
		getServer().getPluginManager().registerEvents(new TestListener(), this);
		new TestListener();
	}

}
