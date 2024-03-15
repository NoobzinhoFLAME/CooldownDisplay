package com.noobzinhoflame.CooldownDisplay;

import com.noobzinhoflame.CooldownDisplay.events.custom.TimeSecondEvent;
import com.noobzinhoflame.CooldownDisplay.listener.InteractListener;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public final class Main extends JavaPlugin {

    @Getter
    public static Main instance;

    @Override
    public void onEnable() {
        instance = this;

        Bukkit.getPluginManager().registerEvents(new InteractListener(), this);

        new BukkitRunnable() {
            @Override
            public void run() {
                new TimeSecondEvent(TimeSecondEvent.TimeType.MILLISECONDS).call();
            }
        }.runTaskTimer(this, 0L, 1L);
    }

    @Override
    public void onDisable() {
    }
}
