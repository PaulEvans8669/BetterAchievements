package com.gmail.amatokus8669.plugin.betterachievements;

import java.util.logging.Logger;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	private static final Logger log = Logger.getLogger("Minecraft");
	public static Economy econ = null;
	private boolean ecoworks = false;

	@Override
	public void onEnable() {

		this.getConfig().addDefault("config.firstpot.effect", "JUMP");
		this.getConfig().addDefault("config.firstpot.time", 2400);
		this.getConfig().addDefault("config.firstpot.level", 1);

		this.getConfig().addDefault("config.secondpot.effect", "SPEED");
		this.getConfig().addDefault("config.secondpot.time", 1200);
		this.getConfig().addDefault("config.secondpot.level", 2);

		this.getConfig().options().copyDefaults(true);
		this.saveConfig();

		if (!setupEconomy()) {
			log.severe(String
					.format("[%s] - Economy Disabled due to no Vault dependency found!",
							getDescription().getName()));
			return;
		} else {
			ecoworks = true;
		}

		Listener eventsListener = new Events(this);
		Bukkit.getServer().getPluginManager()
				.registerEvents(eventsListener, this);
		getLogger().info("Enabling the BetterAchievement Plugin");
		getLogger().info("Check bukkit DevPage for updates!");
	}

	@Override
	public void onDisable() {
		log.info(String.format("[%s] Disabled Version %s", getDescription()
				.getName(), getDescription().getVersion()));
	}

	// Vault economy soft-depend
	private boolean setupEconomy() {
		if (getServer().getPluginManager().getPlugin("Vault") == null) {
			return false;
		}
		RegisteredServiceProvider<Economy> rsp = getServer()
				.getServicesManager().getRegistration(Economy.class);
		if (rsp == null) {
			return false;
		}
		econ = rsp.getProvider();
		return econ != null;
	}

}
