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
		
		String fe = plugin.getConfig().getString("config.firstpot.effect");
		String prefpm = plugin.getConfig().getString("config.firstpot.message");
		String postfpm = prefpm.replace("%Player", name);
		String postpostfpm = postfpm.replace("%Effect", fe);
		String finalfpm = ChatColor.translateAlternateColorCodes('&',postpostfpm);
		
		String se = plugin.getConfig().getString("config.secondpot.effect");
		String prespm = plugin.getConfig().getString("config.secondpot.message");
		String postspm = prespm.replace("%Player", name);
		String postpostspm = postspm.replace("%Effect", se);
		String finalspm = ChatColor.translateAlternateColorCodes('&',postpostspm);


		event.getPlayer().sendMessage(finalmessage);
		event.getPlayer().sendMessage(finalfpm);
		event.getPlayer().sendMessage(finalspm);
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
		event.getPlayer().playSound(location, Sound.LEVEL_UP, 1, 0);
	}
}
