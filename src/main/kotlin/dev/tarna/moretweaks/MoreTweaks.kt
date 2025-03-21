package dev.tarna.moretweaks

import dev.tarna.moretweaks.api.commands.CommandManager
import dev.tarna.moretweaks.api.config.ConfigManager
import dev.tarna.moretweaks.api.config.objects.Config
import dev.tarna.moretweaks.api.lang.Translatable
import dev.tarna.moretweaks.api.listeners.CropTrampleListener
import dev.tarna.moretweaks.api.recipes.RecipeManager
import dev.tarna.moretweaks.api.tweaks.TweakManager
import org.bstats.bukkit.Metrics
import org.bstats.charts.SimplePie
import org.bukkit.plugin.java.JavaPlugin

class MoreTweaks : JavaPlugin() {
    companion object {
        fun getPlugin() = getPlugin(MoreTweaks::class.java)
    }

    lateinit var configManager: ConfigManager
    lateinit var commandManager: CommandManager
    lateinit var tweakManager: TweakManager
    lateinit var recipeManager: RecipeManager

    override fun onEnable() {
        val start = System.currentTimeMillis()

        configManager = ConfigManager(this)
        Translatable.init(Config.language)

        registerCommands()
        registerTweaks()
        registerRecipes()
        registerListeners()
        loadMetrics()

        logger.info("Enabled in ${System.currentTimeMillis() - start}ms")
    }

    override fun onDisable() {
        val start = System.currentTimeMillis()

        logger.info("Disabled in ${System.currentTimeMillis() - start}ms")
    }

    private fun registerCommands() {
        logger.info("Registering commands")
        commandManager = CommandManager(this)
        commandManager.load()
    }

    private fun registerTweaks() {
        logger.info("Registering tweaks")
        tweakManager = TweakManager(this)
        tweakManager.load()
    }

    private fun registerRecipes() {
        logger.info("Registering recipes")
        recipeManager = RecipeManager(this)
        recipeManager.load()
    }

    private fun registerListeners() {
        logger.info("Registering listeners")
        val listeners = tweakManager.getRequiredCustomListeners()
        listeners.forEach { server.pluginManager.registerEvents(it, this) }
    }

    private fun loadMetrics() {
        logger.info("Loading bStats")
        val metrics = Metrics(this, 24127)
        metrics.addCustomChart(SimplePie("language") {
            Config.language
        })
    }
}