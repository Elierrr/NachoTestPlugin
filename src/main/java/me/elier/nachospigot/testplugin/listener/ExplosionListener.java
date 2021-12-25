package me.elier.nachospigot.testplugin.listener;

import me.elier.nachospigot.testplugin.TestPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class ExplosionListener implements Listener {
    @EventHandler
    public void onEntityExplode(EntityExplodeEvent e) {
        if(TestPlugin.Config.logEntityExplodeBlocklist) System.out.println(e.blockList());
    }
}
