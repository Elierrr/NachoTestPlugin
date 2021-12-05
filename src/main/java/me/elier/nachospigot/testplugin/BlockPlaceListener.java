package me.elier.nachospigot.testplugin;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlaceListener implements Listener {
    @EventHandler
    public void cancelEvent(BlockPlaceEvent e) {
        if(TestPlugin.getInstance().config.getBoolean("cancel-block-place-events")) e.setCancelled(true);
    }
}
