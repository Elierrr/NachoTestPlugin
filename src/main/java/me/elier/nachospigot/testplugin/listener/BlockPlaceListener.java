package me.elier.nachospigot.testplugin.listener;

import me.elier.nachospigot.testplugin.TestPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.logging.Level;

public class BlockPlaceListener implements Listener {
    @EventHandler
    public void cancelEvent(BlockPlaceEvent e) {
        if(TestPlugin.Config.cancelBlockPlaceEvents) {
            e.setCancelled(true);
            TestPlugin.getInstance().getLogger().log(Level.INFO, "Cancelled block place event.");
        }
    }
}
