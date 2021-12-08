package me.elier.nachospigot.testplugin;

import me.elier.nachospigot.testplugin.listener.BlockPlaceListener;
import me.elier.nachospigot.testplugin.listener.ExplosionListener;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class TestPlugin extends JavaPlugin {

    public FileConfiguration config;

    public static TestPlugin getInstance() {
        return JavaPlugin.getPlugin(TestPlugin.class);
    }

    @Override
    public void onEnable() {
        config = this.getConfig();
        config.addDefault("log-entity-explode-blocklist", false);
        config.addDefault("cancel-block-place-events", false);
        config.addDefault("cancel-player-interact-events", false);
        config.addDefault("log-player-interact-events", false);
        config.options().copyDefaults(true);
        saveConfig();

        this.getServer().getPluginManager().registerEvents(new ExplosionListener(), this);
        this.getServer().getPluginManager().registerEvents(new BlockPlaceListener(), this);
        SpawnPearlCommand spawnPearlCommand = new SpawnPearlCommand();
        this.getServer().getCommandMap().register(spawnPearlCommand.getName(), "testplugin", spawnPearlCommand);
    }

    @Override
    public void onDisable() {
    }
}
