package me.elier.nachospigot.testplugin;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PrintStatisticCommand extends Command {

    public PrintStatisticCommand() {
        super("print-statistic");
        this.description = "Prints the sender's statistic on mining diamond ore";
        this.usageMessage = "/print-statistic";
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Please run this command as a player");
            return true;
        }
        Player player = (Player) sender;
        sender.sendMessage(String.valueOf(player.getStatistic(Statistic.MINE_BLOCK, Material.DIAMOND_ORE)));
        return false;
    }
}
