package fr.snorcky.monplugin;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MonPluginListeners implements Listener {
	
	//Pour enregister un �venement mettre @EventHandler
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		//R�cup�re le joueur qui s'est connect� !
		Player player = event.getPlayer();
		player.getInventory().clear();
		player.getInventory().addItem(new ItemStack(Material.IRON_SWORD, 3));
		
		ItemStack customsword = new ItemStack(Material.IRON_SWORD, 1);
		
		//On r�cup�re la meta de l'item pour le personnaliser
		ItemMeta customM = customsword.getItemMeta();

		//On change le nom de l'item
		customM.setDisplayName("Ma superbe �p�e custom !");
		
		//On met une description et on cr�er une mini liste
		customM.setLore(Arrays.asList("Premiere ligne","deuxi�me ligne","etc ..."));
		
		//On met des enchantements (nom, niveau, true/false(pour fixer ou non l'enchantement))
		customM.addEnchant(Enchantment.DAMAGE_ALL, 200, true);
		//Si on veut cacher les enchantements
		customM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		
		//On fixe les modifications qu'on a fait sur l'item	
		customsword.setItemMeta(customM);
		
		//Si on veut give un item avec une data ( exemple : wool ) 
		ItemStack customwool = new ItemStack(Material.WOOL, 8, (byte)14);
		player.getInventory().setHelmet(customwool);
		
//		player.getInventory().setItemInOffHand(customsword);
		player.getInventory().setItemInMainHand(customsword);
		
		player.updateInventory();
		
	}
	
}
