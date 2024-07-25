package org.mcplugin.wolf.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.mcplugin.wolf.WolfPlugin;

public class setSpawn implements CommandExecutor {

    private final WolfPlugin plugin;
    public setSpawn(WolfPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command!");
            return true;
        }

        Player player = (Player) sender;
        Location location = player.getLocation();

        plugin.getConfig().set("spawn", location);
        plugin.saveConfig();

        player.sendMessage(ChatColor.GOLD + "Successfully set the new spawn point! ^_^");
        return true;
    }
}
