package com.gmail.amatokus8669.plugin.betterachievements;


import java.util.logging.Logger;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;



public class Main extends JavaPlugin{
	
	  private static final Logger log = Logger.getLogger("Minecraft");
	  public static Economy econ = null;
	
	  
	  
	  @Override  
	public void onEnable(){
		
		if (!setupEconomy() ) {
			log.severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
			getServer().getPluginManager().disablePlugin(this);
			return;
			}
		
		
		this.getServer().getPluginManager().registerEvents(new Events(), this);
		getLogger().info("Enabling the BetterAchievement Plugin");
		getLogger().info("Check bukkit DevPage for updates!");
	}
	
	  
	  
	  @Override
	public void onDisable(){
		  
        log.info(String.format("[%s] Disabled Version %s", getDescription().getName(), getDescription().getVersion()));
        	
	}  
	  
	  
	//Vault economy soft-depend   
	private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }
	
}
