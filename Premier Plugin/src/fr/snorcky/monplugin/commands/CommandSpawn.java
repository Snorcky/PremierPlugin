package fr.snorcky.monplugin.commands;

//import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSpawn implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String labl, String[] args) {
		if(sender instanceof Player){
			
			
			Player player = (Player) sender;
			
			//On définit la location du spawn (x, y, z, yawF, pitchF ) rajouter f car float 
			//On utilise Bukkit.getWorld("nomdumonde") pour un monde spécifié
//			Location spawn = new Location(Bukkit.getWorld("nomdumonde"));
			Location spawn = new Location(player.getWorld(), -59.439, 68.00, 256.540, -87.8f, -3.8f);
			player.sendMessage("§eVous venez d'être téléporté au spawn !");
			player.teleport(spawn);
		}
		return false;
	}

}
