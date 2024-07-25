package org.mcplugin.wolf.Handlers;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.mcplugin.wolf.WolfPlugin;

public class TntHandler implements Listener {
    @EventHandler
    public void onTntPlace(BlockPlaceEvent event) {
        Block block = event.getBlock();
        Player player = event.getPlayer();

        if(block.getType() != Material.TNT) {
            return;
        }

        block.setType(Material.TORCH);
        player.sendMessage("Tnt blocks not allowed! placed torch instead :d");
        Bukkit.getLogger().info("TNT block placed: " + block.getX() + ", " + block.getY() + ", " + block.getZ());
    }
}
