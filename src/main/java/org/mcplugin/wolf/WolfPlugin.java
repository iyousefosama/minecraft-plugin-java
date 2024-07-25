package org.mcplugin.wolf;

import org.bukkit.plugin.java.JavaPlugin;
import org.mcplugin.wolf.Handlers.TntHandler;
import org.mcplugin.wolf.Handlers.spawnListeners;
import org.mcplugin.wolf.commands.*;

import java.util.Objects;

public final class WolfPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Wolf plugin activated!");

        // Load config
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        // Register all commands
        Objects.requireNonNull(getCommand("fly")).setExecutor(new fly());
        Objects.requireNonNull(getCommand("setspawn")).setExecutor(new setSpawn(this));
        Objects.requireNonNull(getCommand("spawn")).setExecutor(new spawn(this));
        Objects.requireNonNull(getCommand("setHome")).setExecutor(new setHome(this));
        Objects.requireNonNull(getCommand("home")).setExecutor(new home(this));
        Objects.requireNonNull(getCommand("home")).setTabCompleter(new home(this));
        Objects.requireNonNull(getCommand("delHome")).setExecutor(new delHome(this));

        // Register all event listeners
        getServer().getPluginManager().registerEvents(new TntHandler(), this);
        getServer().getPluginManager().registerEvents(new spawnListeners(this), this);
    }

}
