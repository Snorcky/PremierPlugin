package fr.snorcky.monplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.snorcky.monplugin.MonPlugin;

public class CommandTest implements CommandExecutor {
	
	//On stock l'instance de la classe principale
	private MonPlugin main;
	
	public CommandTest(MonPlugin monPlugin) {
		this.main = monPlugin;
		
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if(sender instanceof Player) {
			Player player = (Player)sender;
			
			if(cmd.getName().equalsIgnoreCase("test")) {
				player.sendMessage(main.getConfig().getString("messages.test").replaceAll("&", "§"));
				return true;
			}
			if(cmd.getName().equalsIgnoreCase("alert")) {
				
				//alert --> aucun argument
				if(args.length == 0) {
					player.sendMessage("La commande est : /alert <message>");
				}
				
				//alert avec arguments
				if(args.length >= 1) {
					
					//Construit quelque chose sous forme d'une chaine 
					StringBuilder bc = new StringBuilder();
					for(String part : args) {
						bc.append(part + " ");
					}
					
					Bukkit.broadcastMessage("["+player.getName() +"] "+ bc.toString());
					
				}
				
				
				return true;
			}
			if(cmd.getName().equalsIgnoreCase("jour")) {
				
				player.getWorld().setTime(1000);
				player.sendMessage("§eVous venez de mettre le jour !");
				
				return true;
			}
			if(cmd.getName().equalsIgnoreCase("nuit")) {
				
				player.getWorld().setTime(13000);
				player.sendMessage("§eVous venez de mettre la nuit !");
				
				return true;
				
				
			}
			if(cmd.getName().equalsIgnoreCase("soleil")) {
				
				player.getWorld().setStorm(false);
				player.sendMessage("§eVous venez de mettre le soleil sur le serveur !");
				
				return true;
				
			}
			
			if(cmd.getName().equalsIgnoreCase("gm")) {
				
				if(args.length == 0) {
					player.sendMessage("§e/gm <0|1|2|3>");
					player.sendMessage("§e Survie | Creative | Adventure | Spectator");
				}
				if(args.length == 1) {
					if(args[0].equalsIgnoreCase("0")){
						player.setGameMode(GameMode.SURVIVAL);
						player.sendMessage("§eVous êtes passé en mode survie");
					}
					if(args[0].equalsIgnoreCase("1")) {
						player.setGameMode(GameMode.CREATIVE);
						player.sendMessage("§eVous êtes passé en mode créatif");
					}
					if(args[0].equalsIgnoreCase("2")) {
						player.setGameMode(GameMode.ADVENTURE);
						player.sendMessage("§eVous êtes passé en mode aventure");
					}
					if(args[0].equalsIgnoreCase("3")) {
						player.setGameMode(GameMode.SPECTATOR);
						player.sendMessage("§eVous êtes passé en mode spectateur");
					}
					
					
										
				}
				
			}
			
			if(cmd.getName().equalsIgnoreCase("ci")) {
				player.getInventory().clear();
				player.sendMessage("§eInventaire nettoyé !");
				
				
				return true;
			}
		}
		
		return false;
	}

}
