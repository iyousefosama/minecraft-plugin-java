package org.mcplugin.wolf.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.mcplugin.wolf.WolfPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class home implements CommandExecutor, TabCompleter {
    private final WolfPlugin plugin;

    public home(WolfPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command!");
            return true;
        }

        Player player = (Player) sender;
        if(args.length == 0) {
            player.sendMessage(ChatColor.RED + "Usage: /home <homeName>");
            return false;
        }
        String homeName = args[0];

        // Check if there is a home with that name
        if(!plugin.getConfig().contains("homes." + player.getDisplayName() + "." + homeName)) {
            player.sendMessage(ChatColor.RED + "There is no home with that name!");
            return true;
        }

        Location location = plugin.getConfig().getLocation("homes." + player.getDisplayName() + "." + homeName);

        if(location == null) {
            player.sendMessage(ChatColor.RED + "There is no home with that name!");
            return true;
        }

        player.teleport(location);
        player.sendMessage(ChatColor.GREEN + "Teleported to home " + homeName + "!");
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1 && sender instanceof Player) {
            Player player = (Player) sender;
            String prefix = "homes." + player.getDisplayName() + ".";
            Set<String> homeNames = plugin.getConfig().getConfigurationSection(prefix).getKeys(false);
            List<String> suggestions = new ArrayList<>();
            for (String homeName : homeNames) {
                if (homeName.toLowerCase().startsWith(args[0].toLowerCase())) {
                    suggestions.add(homeName);
                }
            }
            return suggestions;
        }
        return null;
    }
}
