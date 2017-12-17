package fr.snorcky.monplugin;

import org.bukkit.plugin.java.JavaPlugin;

import fr.snorcky.monplugin.commands.CommandSpawn;
import fr.snorcky.monplugin.commands.CommandTest;
import fr.snorcky.monplugin.commands.CommandTprandom;

public class MonPlugin extends JavaPlugin {
	
	@Override
	public void onEnable() {
		//On sauvegarde la configuration par default 
		saveDefaultConfig();
		System.out.println("Le plugin vient de s'allumer !");
		getCommand("test").setExecutor(new CommandTest(this));
		//On passe en paramètre la classe principale pour la récupérer avec this pour cibler l'objet courant
		getCommand("alert").setExecutor(new CommandTest(this));
		getCommand("spawn").setExecutor(new CommandSpawn());
		getCommand("soleil").setExecutor(new CommandTest(this));
		getCommand("nuit").setExecutor(new CommandTest(this));
		getCommand("jour").setExecutor(new CommandTest(this));
		getCommand("gm").setExecutor(new CommandTest(this));
		getCommand("randomtp").setExecutor(new CommandTprandom());
		getCommand("ci").setExecutor(new CommandTest(this));
		getServer().getPluginManager().registerEvents(new MonPluginListeners(), this);
		
		//on créer une boucle pour récupérer les configs
		for(String string : getConfig().getConfigurationSection("kits").getKeys(false)) { //getKeys permet de récupérer les clefs à l'interieur de la section "kits"
			System.out.println(getConfig().getConfigurationSection("kits").getInt(string + ".id"));
		}
		
		//Pour afficher une liste ( exemple : liste de mots interdits ) 
		for(String string2 : getConfig().getStringList("badwords")) {
			System.out.println(string2);
		}
	}
	
	@Override
	public void onDisable() {
		System.out.println("Le plugin vient de s'éteindre");
	}

}
