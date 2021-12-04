package me.elier.nachospigot.testplugin;

import org.bukkit.plugin.java.JavaPlugin;

public final class TestPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getServer().getPluginManager().registerEvents(new ExplosionListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
