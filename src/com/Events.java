package com.gmail.amatokus8669.plugin.betterachievements;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Events implements Listener {

	JavaPlugin plugin;

	public Events(Main plugin) {
		this.plugin = plugin;
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerAchievementAwarded(PlayerAchievementAwardedEvent event) {
		
		
		// location of played sound, goes with line 71 - DONE
		
		Location location = event.getPlayer().getLocation();

		
		// set name in config message, goest ith line 39 - DONE
		
		String name = event.getPlayer().getName();
		String premessage = plugin.getConfig().getString("config.message");
		String postmessage = premessage.replace("%Player", name);
		String finalmessage = ChatColor.translateAlternateColorCodes('&',postmessage);

		
		event.getPlayer().sendMessage(finalmessage);
		event.getPlayer().addPotionEffect(
				new PotionEffect(PotionEffectType.getByName(plugin.getConfig()
						.getString("config.firstpot.effect")), plugin
						.getConfig().getInt("config.firstpot.time"), plugin
						.getConfig().getInt("config.firstpot.level")));
		event.getPlayer().addPotionEffect(
				new PotionEffect(PotionEffectType.getByName(plugin.getConfig()
						.getString("config.secondpot.effect")), plugin
						.getConfig().getInt("config.secondpot.time"), plugin
						.getConfig().getInt("config.secondpot.level")));
		event.getPlayer().sendMessage(
				ChatColor.AQUA
						+ "The potion effect"
						+ ChatColor.GOLD
						+ ChatColor.ITALIC
						+ " "
						+ plugin.getConfig()
								.getString("config.firstpot.effect") + " "
						+ ChatColor.RESET + ChatColor.AQUA
						+ "has been given to you for two minutes!"
						+ ChatColor.WHITE);
		event.getPlayer().sendMessage(
				ChatColor.AQUA
						+ "The potion effect"
						+ ChatColor.GOLD
						+ ChatColor.ITALIC
						+ " "
						+ plugin.getConfig().getString(
								"config.secondpot.effect") + " "
						+ ChatColor.RESET + ChatColor.AQUA
						+ "has been given to you for two minutes!"
						+ ChatColor.WHITE);
		event.getPlayer().playSound(location, Sound.LEVEL_UP, 1, 0);
	}
}
