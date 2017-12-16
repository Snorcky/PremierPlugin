package fr.snorcky.monplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandTest implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if(sender instanceof Player) {
			Player player = (Player)sender;
			
			if(cmd.getName().equalsIgnoreCase("test")) {
				player.sendMessage("§eBravo tu as réussis §4le test !");
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
		}
		
		return false;
	}

}
