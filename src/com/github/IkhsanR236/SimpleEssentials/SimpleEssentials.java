package com.github.IkhsanR236.SimpleEssentials;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.IkhsanR236.SimpleEssentials.commands.ClearChatCmd;
import com.github.IkhsanR236.SimpleEssentials.commands.LockChatCmd;
import com.github.IkhsanR236.SimpleEssentials.events.ChatListener;


public class SimpleEssentials extends JavaPlugin {

	private boolean locked;
	
	@Override
	public void onEnable() {
		// Plugin startup logic
		locked = false;
        new ChatListener(this);
        new LockChatCmd(this);
        new ClearChatCmd(this);
		this.getCommand("heal").setExecutor(new heal());
		this.saveDefaultConfig();
	}

	@Override
	public void onDisable() {
		// Plugin shutdown logic
	}
    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked, String name) {
        this.locked = locked;
        Bukkit.broadcastMessage((locked ? ChatlockMessage.CHAT_LOCK_SUCCESS.get() :
                ChatlockMessage.CHAT_UNLOCK_SUCCESS.get()).replace("{0}", name));
    }
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	    if (label.equalsIgnoreCase("Essentials")) {
	    	sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&l(i)&bThis &bServer &eRunning &bSS &bSimpleEssentials &BV-1.0(beta) &dBy &6IcanR &eCopyright &cIcanR 2020"));
	    		return true;
	    	}
	    return false;
	}
}