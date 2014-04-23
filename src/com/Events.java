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

	public Events(JavaPlugin plugin) {
		this.plugin = plugin;
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerAchievementAwarded(PlayerAchievementAwardedEvent event) {

		Location location = event.getPlayer().getLocation();
		String name = event.getPlayer().getName();

		event.getPlayer().sendMessage(
				ChatColor.AQUA + "" + ChatColor.BOLD + "Congratulations"
						+ ChatColor.GOLD + " " + name + ChatColor.AQUA + "!"
						+ ChatColor.BOLD + " " + "You earned an achievement!"
						+ ChatColor.WHITE);
		event.getPlayer().playSound(location, Sound.LEVEL_UP, 10.0F, 0);
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
				ChatColor.AQUA + "The potion effect" + ChatColor.GOLD
						+ ChatColor.ITALIC + " " + "Speed" + " "
						+ ChatColor.RESET + ChatColor.AQUA
						+ "has been given to you for two minutes!"
						+ ChatColor.WHITE);
		event.getPlayer().sendMessage(
				ChatColor.AQUA + "The potion effect" + ChatColor.GOLD
						+ ChatColor.ITALIC + " " + "Jump" + " "
						+ ChatColor.RESET + ChatColor.AQUA
						+ "has been given to you for two minutes!"
						+ ChatColor.WHITE);
	}
}
