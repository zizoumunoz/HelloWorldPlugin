package me.zizoumunoz.helloworldplugin.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

public class TestCommand implements TabExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (sender instanceof Player) {
			Player player = (Player) sender;
			player.damage(20);
			player.sendMessage("Hello World! 1");
			player.chat("F xd");
		} else {
			sender.sendMessage("Only players!!!!111!!");
		}

		return false;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		List<String> autoTabList = new ArrayList<>();
		List<String> subcommands = Arrays.asList("hello", "test", "poop", "pee");
		if (args.length == 1) {
			for (String subcommand : subcommands) {
				if (StringUtil.startsWithIgnoreCase(subcommand, args[0])) {
					autoTabList.add(subcommand);
				}
			}
		}
		return autoTabList;
	}

}
