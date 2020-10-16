package com.github.IkhsanR236.SimpleEssentials;

import org.bukkit.ChatColor;

public enum ChatlockMessage {

    NO_PERMISSION("&f&l(&c&l!&f&l)&c&lAccess &f&lDenied"),
    CHAT_IS_LOCKED("&f&l(&c&l!&f&l)7cYour message was not sent because chat is currently locked."),
    CHAT_LOCK_SUCCESS("&f&l(&c&l!&f&l)&c&lServer chat has been locked by Staff Member."),
    CHAT_UNLOCK_SUCCESS("&f&l(&b&l!&f&l)&a&lServer chat has been unlocked by Staff Member."),
    CHAT_CLEARED("&f&l(&2&l!&f&l)&aServer chat has been cleared by Staff Member.");



    private final String s;

    ChatlockMessage(String s) {
        this.s = s;
    }

    public String get() {
        return ChatColor.translateAlternateColorCodes('&', s);
    }
}
