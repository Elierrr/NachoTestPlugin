package me.elier.nachospigot.testplugin.listener;

import me.elier.nachospigot.testplugin.TestPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.logging.Level;

public class InteractListener implements Listener {
    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        if(TestPlugin.getInstance().config.getBoolean("log-player-interact-events")) TestPlugin.getInstance().getLogger().log(Level.INFO, "PlayerInteractEvent called.");
        if(TestPlugin.getInstance().config.getBoolean("cancel-player-interact-events")) e.setCancelled(true);
    }
}
