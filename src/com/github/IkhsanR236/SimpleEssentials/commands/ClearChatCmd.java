package com.github.IkhsanR236.SimpleEssentials.commands;

import com.github.IkhsanR236.SimpleEssentials.ChatlockMessage;
import com.github.IkhsanR236.SimpleEssentials.SimpleEssentials;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Objects;

public class ClearChatCmd implements CommandExecutor {

    final SimpleEssentials main;

    public ClearChatCmd(SimpleEssentials main) {
        this.main = main;
        Objects.requireNonNull(main.getCommand("clearchat")).setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!sender.hasPermission("chatlock.clearchat")) {
            sender.sendMessage(ChatlockMessage.NO_PERMISSION.get());
            return true;
        }

        for (int i = 0; i < 1000; i++) {
            Bukkit.broadcastMessage(" ");
        }
        Bukkit.broadcastMessage(ChatlockMessage.CHAT_CLEARED.get().replace("{0}", sender.getName()));
        return true;
    }
}
