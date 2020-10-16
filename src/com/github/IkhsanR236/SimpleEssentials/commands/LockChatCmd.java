package com.github.IkhsanR236.SimpleEssentials.commands;

import com.github.IkhsanR236.SimpleEssentials.SimpleEssentials;
import com.github.IkhsanR236.SimpleEssentials.ChatlockMessage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Objects;

public class LockChatCmd implements CommandExecutor {

    final SimpleEssentials main;

    public LockChatCmd(SimpleEssentials main) {
        this.main = main;
        Objects.requireNonNull(main.getCommand("lockchat")).setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!sender.hasPermission("lockchat.lock")) {
            sender.sendMessage(ChatlockMessage.NO_PERMISSION.get());
            return true;
        }

        main.setLocked(!main.isLocked(), sender.getName());
        return true;
    }
}
