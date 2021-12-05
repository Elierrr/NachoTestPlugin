package me.elier.nachospigot.testplugin;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.List;

public class SpawnPearlCommand extends Command {
    public SpawnPearlCommand() {
        super("pearl");
        this.description = "Spawns an ender pearl above the sender.";
        this.usageMessage = "/pearl";
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Please run this command as a player");
            return true;
        }
        Player player = (Player) sender;
        World world = player.getWorld();
        Location location = player.getLocation();
        world.spawnEntity(new Location(world, location.getX(), location.getY()+10, location.getZ()), EntityType.ENDER_PEARL);
        return false;
    }
}
