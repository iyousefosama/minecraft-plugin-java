package org.mcplugin.wolf.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class fly implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command!");
            return true;
        }

        Player player = (Player) sender;
        player.setAllowFlight(!player.getAllowFlight());
        if(player.getAllowFlight()) {
            player.sendMessage(ChatColor.GREEN + "Flying enabled!");
        } else {
            player.sendMessage(ChatColor.GREEN + "Flying disabled!");
        }

        return true;
    }
}
