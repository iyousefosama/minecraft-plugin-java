package org.mcplugin.wolf.Handlers;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.mcplugin.wolf.WolfPlugin;

public class spawnListeners implements Listener {

    private final WolfPlugin plugin;

    public spawnListeners(WolfPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        // If it's the first time player joins the server
        if(!player.hasPlayedBefore()) {
            Location location = plugin.getConfig().getLocation("spawn");

            if(location != null) {
                player.teleport(location);
            }
        }
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent e) {
        Location location = plugin.getConfig().getLocation("spawn");

        if(location != null) {
            e.setRespawnLocation(location);
        }
    }
}
