package me.elier.nachospigot.testplugin;

import me.elier.nachospigot.testplugin.listener.*;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Locale;

public final class TestPlugin extends JavaPlugin {

    public static TestPlugin getInstance() {
        return JavaPlugin.getPlugin(TestPlugin.class);
    }

    @Override
    public void onEnable() {
        Config.load(this);

        this.registerEvents();
        this.registerCommands();
        this.registerRecipes();
    }

    private void registerRecipes() {
        ItemStack itemStack = new ItemStack(Material.BEDROCK, 1);
        ItemMeta itemMeta = itemStack.getItemMeta();

        itemMeta.setDisplayName(ChatColor.AQUA + "Bedrock");
        itemStack.setItemMeta(itemMeta);

        ShapedRecipe recipe = new ShapedRecipe(itemStack);

        recipe.shape(
                "SSS",
                "SBS",
                "SSS"
        );
        recipe.setIngredient('S', Material.STONE);
        recipe.setIngredient('B', Material.BED);
        getServer().addRecipe(recipe);
    }

    private void registerEvents() {
        this.getServer().getPluginManager().registerEvents(new ExplosionListener(), this);
        this.getServer().getPluginManager().registerEvents(new BlockPlaceListener(), this);
        this.getServer().getPluginManager().registerEvents(new InteractListener(), this);
    }

    private void registerCommands() {
        SpawnPearlCommand spawnPearlCommand = new SpawnPearlCommand();
        PrintStatisticCommand printStatisticCommand = new PrintStatisticCommand();
        this.getServer().getCommandMap().register(spawnPearlCommand.getName(), "testplugin", spawnPearlCommand);
        this.getServer().getCommandMap().register(printStatisticCommand.getName(), "testplugin", printStatisticCommand);
    }

    @Override
    public void onDisable() {
    }

    public static class Config {
        public static boolean logEntityExplodeBlocklist;
        public static boolean cancelBlockPlaceEvents;
        public static boolean cancelPlayerInteractEvents;
        public static boolean logPlayerInteractEvents;
        public static void load(TestPlugin plugin) {
            FileConfiguration config = plugin.getConfig();
            config.addDefault("log-entity-explode-blocklist", false);
            config.addDefault("cancel-block-place-events", false);
            config.addDefault("cancel-player-interact-events", false);
            config.addDefault("log-player-interact-events", false);
            config.options().copyDefaults(true);
            plugin.saveConfig();

            logEntityExplodeBlocklist = config.getBoolean("log-entity-explode-blocklist");
            cancelBlockPlaceEvents = config.getBoolean("cancel-block-place-events");
            cancelPlayerInteractEvents = config.getBoolean("cancel-player-interact-events");
            logPlayerInteractEvents = config.getBoolean("log-player-interact-events");
        }
    }
}
