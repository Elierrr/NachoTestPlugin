package me.elier.nachospigot.testplugin;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class TestPlugin extends JavaPlugin {

    private FileConfiguration config;

    @Override
    public FileConfiguration getConfig() {
        if(config == null) return super.getConfig();
        return config;
    }

    public static TestPlugin getInstance() {
        return JavaPlugin.getPlugin(TestPlugin.class);
    }

    @Override
    public void onEnable() {
        this.getConfig().addDefault("log-entity-explode-blocklist", false);
        this.getConfig().addDefault("cancel-block-place-events", false);
        this.getConfig().options().copyDefaults();
        saveConfig();

        this.getServer().getPluginManager().registerEvents(new ExplosionListener(), this);
        SpawnPearlCommand spawnPearlCommand = new SpawnPearlCommand();
        this.getServer().getCommandMap().register(spawnPearlCommand.getName(), "testplugin", spawnPearlCommand);
    }

    @Override
    public void onDisable() {
    }
}
