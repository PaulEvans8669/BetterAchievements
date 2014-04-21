package com.gmail.amatokus8669.plugin.betterachievements;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;



public class Events implements Listener{

	public Main plugin;
	
	public Events(Main plugin){
		this.plugin = plugin;
		}	

	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerAchievementAwarded(PlayerAchievementAwardedEvent AwEv){
		
		Location location = AwEv.getPlayer().getLocation();
		String name = AwEv.getPlayer().getName();
		
		
		AwEv.getPlayer().sendMessage(ChatColor.AQUA+""+ChatColor.BOLD+"Congratulations"+ChatColor.GOLD+" "+name+ChatColor.AQUA+"!"+ChatColor.BOLD+" "+"You earned an achievement!"+ChatColor.WHITE);
		AwEv.getPlayer().playSound(location, Sound.LEVEL_UP, 10.0F, 0);
		AwEv.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, plugin.getConfig().getInt("Firstpot.time"), plugin.getConfig().getInt("Firstpot.level")));
		AwEv.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.JUMP,plugin.getConfig().getInt("Firstpot.time"), plugin.getConfig().getInt("Firstpot.level")));
		AwEv.getPlayer().sendMessage(ChatColor.AQUA+"The potion effect"+ChatColor.GOLD+ChatColor.ITALIC+" "+"Speed"+" "+ChatColor.RESET+ChatColor.AQUA+"has been given to you for two minutes!"+ChatColor.WHITE);
		AwEv.getPlayer().sendMessage(ChatColor.AQUA+"The potion effect"+ChatColor.GOLD+ChatColor.ITALIC+" "+"Jump"+" "+ChatColor.RESET+ChatColor.AQUA+"has been given to you for two minutes!"+ChatColor.WHITE);
	}
}
