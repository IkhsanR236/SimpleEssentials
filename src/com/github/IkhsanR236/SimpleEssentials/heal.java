package com.github.IkhsanR236.SimpleEssentials;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class heal implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("heal")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED + "You cannot do this");
			}
			Player player = (Player) sender;
			if (!player.hasPermission("ess.heal")) {
				player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "(!) Access Denied");
				return true;
			}
			if (args.length == 0) {
				// /heal
				TextComponent message = new TextComponent("(!)Click Here To get healed");
				message.setColor(ChatColor.GOLD);
				message.setBold(true);
				message.setUnderlined(true);
				message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/ess healme"));
				message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, 
						new ComponentBuilder("Click Here to be healed").color(ChatColor.GRAY).italic(true).create()));
				player.spigot().sendMessage(message);
				return true;
			}
			// /healme
			if (args[0].equalsIgnoreCase("healme")) {
				player.setHealth(20.0);
				//Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "heal " + player.getName());
				player.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "(!) You has been healed");
				return true;
			}
		}
		return false;
	}

}
