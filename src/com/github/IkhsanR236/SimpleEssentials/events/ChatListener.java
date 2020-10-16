package com.github.IkhsanR236.SimpleEssentials.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.github.IkhsanR236.SimpleEssentials.ChatlockMessage;
import com.github.IkhsanR236.SimpleEssentials.SimpleEssentials;

public class ChatListener implements Listener {

    private SimpleEssentials main;

    public ChatListener(SimpleEssentials main) {
        this.main = main;
        main.getServer().getPluginManager().registerEvents(this, main);
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        if(e.getPlayer().hasPermission("chatlock.bypass"))
            return;

        if(main.isLocked()) {
            e.setCancelled(true);
            e.getPlayer().sendMessage(ChatlockMessage.CHAT_IS_LOCKED.get());
        }
    }
}
