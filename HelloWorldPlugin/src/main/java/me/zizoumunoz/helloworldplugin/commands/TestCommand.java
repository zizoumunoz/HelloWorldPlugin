package me.zizoumunoz.helloworldplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (sender instanceof Player) {
			Player player = (Player) sender;
			player.damage(20);
			player.sendMessage("Hello World! 1");
			player.chat("i died lol");
		} else {
			sender.sendMessage("Only players!!!!111!!");
		}
		
		return false;
	}

}
