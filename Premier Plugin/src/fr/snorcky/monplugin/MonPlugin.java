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
		getCommand("soleil").setExecutor(new CommandTest());
		getCommand("nuit").setExecutor(new CommandTest());
		getCommand("jour").setExecutor(new CommandTest());
		getCommand("gm").setExecutor(new CommandTest());
		getCommand("randomtp").setExecutor(new CommandTprandom());
		getCommand("ci").setExecutor(new CommandTest());
		getServer().getPluginManager().registerEvents(new MonPluginListeners(), this);
	}
	
	@Override
	public void onDisable() {
		System.out.println("Le plugin vient de s'éteindre");
	}

}
