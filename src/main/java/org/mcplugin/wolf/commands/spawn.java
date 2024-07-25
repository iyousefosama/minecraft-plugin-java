package org.mcplugin.wolf.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.mcplugin.wolf.WolfPlugin;

public class spawn implements CommandExecutor {

    private final WolfPlugin plugin;

    public spawn(WolfPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command!");
            return true;
        }

        Player player = (Player) sender;
        Location location = plugin.getConfig().getLocation("spawn");

        if(location == null) {
            player.sendMessage(ChatColor.RED + "No spawn point set!");
            return false;
        }

        player.teleport(location);
        player.sendMessage(ChatColor.GREEN + "Teleported to spawn point!");
        return false;
    }
}
