package org.mcplugin.wolf.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.mcplugin.wolf.WolfPlugin;

public class setHome implements CommandExecutor {
    private final WolfPlugin plugin;

    public setHome(WolfPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command!");
            return false;
        }

        Player player = (Player) sender;
        Location location = player.getLocation();
        if(args.length == 0) {
            player.sendMessage(ChatColor.RED + "Usage: /setHome <homeName>");
            return false;
        }
        String homeName = args[0];

        // Check if there is already a home with that name
        if(plugin.getConfig().contains("homes." + player.getDisplayName() + "." + homeName)) {
            player.sendMessage(ChatColor.RED + "There is already a home with that name!");
            return false;
        }

        plugin.getConfig().set("homes." + player.getDisplayName() + "." + homeName, location);
        plugin.saveConfig();
        player.sendMessage(ChatColor.GREEN + "Successfully set home " + homeName + " at " + location.getBlockX() + ", " + location.getBlockY() + ", " + location.getBlockZ() + "!");
        return true;
    }
}
