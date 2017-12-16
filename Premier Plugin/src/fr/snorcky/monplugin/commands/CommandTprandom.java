package fr.snorcky.monplugin.commands;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandTprandom implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			
			//Pour téléporter le joueur de façon random
			Random random = new Random();
			Player player = (Player) sender;
			Location ploc = player.getLocation();
			Location randomtp = new Location(player.getWorld(), ploc.getX() + random.nextInt(3000), ploc.getY() + random.nextInt(100), ploc.getZ() + random.nextInt(3000));
			player.sendMessage("§aVous venez d'être téléporté aléatoirement");
			player.teleport(randomtp);
			

		}
		
		return false;
	}

}
