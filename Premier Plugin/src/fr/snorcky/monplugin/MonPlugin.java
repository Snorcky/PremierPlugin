package fr.snorcky.monplugin;

import org.bukkit.plugin.java.JavaPlugin;

import fr.snorcky.monplugin.commands.CommandSpawn;
import fr.snorcky.monplugin.commands.CommandTest;
import fr.snorcky.monplugin.commands.CommandTprandom;

public class MonPlugin extends JavaPlugin {
	
	@Override
	public void onEnable() {
		System.out.println("Le plugin vient de s'allumer !");
		getCommand("test").setExecutor(new CommandTest());
		getCommand("alert").setExecutor(new CommandTest());
		getCommand("spawn").setExecutor(new CommandSpawn());
		getCommand("randomtp").setExecutor(new CommandTprandom());
		getServer().getPluginManager().registerEvents(new MonPluginListeners(), this);
	}
	
	@Override
	public void onDisable() {
		System.out.println("Le plugin vient de s'�teindre");
	}

}