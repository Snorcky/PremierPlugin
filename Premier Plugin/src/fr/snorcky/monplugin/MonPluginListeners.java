package fr.snorcky.monplugin;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class MonPluginListeners implements Listener {
	
	//Pour enregister un évenement mettre @EventHandler
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		//Récupère le joueur qui s'est connecté !
		Player player = event.getPlayer();
		player.getInventory().clear();
		player.getInventory().addItem(new ItemStack(Material.IRON_SWORD, 3));
		
		ItemStack customsword = new ItemStack(Material.COMPASS, 1);
		
		//On récupère la meta de l'item pour le personnaliser
		ItemMeta customM = customsword.getItemMeta();

		//On change le nom de l'item
		customM.setDisplayName("Ma superbe épée custom !");
		
		//On met une description et on créer une mini liste
		customM.setLore(Arrays.asList("Premiere ligne","deuxième ligne","etc ..."));
		
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
//		player.getInventory().setItemInMainHand(customsword);
		player.getInventory().setItem(8, customsword);
		
		player.updateInventory();
		
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		Action action = event.getAction();
		ItemStack it = event.getItem();
		
		//Stop l'execution du code si le joueur n'a rien dans la main
		if(it == null) return;
		
		//Si l'item est différent de nul ( si le joueur n'a rien dans la main ) 
		if(it.getType() == Material.DIAMOND_HOE) {
			if(action == Action.RIGHT_CLICK_AIR) {
				player.sendMessage("Vous venez de faire un clic !");
			}
		}
		
		//Si l'item a une meta et si la meta = Ma superbe [...]
		if(it.getType() == Material.COMPASS && it.hasItemMeta() && it.getItemMeta().getDisplayName().equalsIgnoreCase("Ma superbe épée custom !")) {
			//Ajoute un effet de potion 
//			player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 3));
			
			//Ouvre un menu
			Inventory inv = Bukkit.createInventory(null, 9, "§8Mon menu");
			
			//On met un item dans le menu a un emplacement définit
			//Optimisation du code ci dessous à la ligne 109
//			ItemStack apple = new ItemStack(Material.DIAMOND_SWORD, 1);
//			ItemMeta appleM = apple.getItemMeta();
//			appleM.setDisplayName("&cMettre le jour");
//			apple.setItemMeta(appleM);

//			ItemStack anvilTnt = new ItemStack(Material.ANVIL, 1);
//			ItemMeta anvilM = anvilTnt.getItemMeta();
//			anvilM.setDisplayName("&cBOOOOOOOM");
//			anvilTnt.setItemMeta(anvilM);
			
//			inv.setItem(3, anvilTnt);
//			inv.setItem(0, apple);
			
			inv.setItem(0, getItem(Material.DIAMOND_SWORD, "§cMet le jour"));
			inv.setItem(3, getItem(Material.ANVIL, "§cBOOOOOOOOOMM !!!"));
			
			//On ouvre l'inventaire du joueur et on prend en paramètre l'inventaire custom
			player.openInventory(inv);
			
			
		}
	}
	
	//Création d'un event lorsque le joueur clique sur un des item dans le menu
	@EventHandler
	public void onClick(InventoryClickEvent event) {
		
		Inventory inv = event.getInventory();
		//savoir qui a cliqué
		Player player = (Player) event.getWhoClicked();
		//Item sur lequel on a interargit
		ItemStack current = event.getCurrentItem();
		
		if(current == null) return;
		//On vérifie le nom de l'inventaire
		if(inv.getName().equalsIgnoreCase("§8Mon Menu")) {
			
			//On fait en sorte que le joueur ne puisse pas récupérer l'item
			event.setCancelled(true);
//			player.closeInventory();
			
			switch(current.getType()) {	
				case DIAMOND_SWORD:
					player.getWorld().setTime(1000);
					player.sendMessage("§eVous venez de mettre le jour !");
				break;
				case ANVIL:
					player.getWorld().createExplosion(player.getLocation(), 10);
					player.sendMessage("§4BOOOOOOOOOM!!!");
				break;
				default: break;
			}
			
//			if(current.getType() == Material.DIAMOND_SWORD) {
//
//				player.getWorld().setTime(1000);
//				player.sendMessage("§eVous venez de mettre le jour !");
//				//Si on veut forcer une commande :
//				//player.chat("/example");
//				// ou alors :
//				//Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "<commande>";
//			}
//			if(current.getType() == Material.ANVIL) {
//				player.getWorld().createExplosion(player.getLocation(), 10);
//				player.sendMessage("§4BOOOOOOOOOM!!!");
//			}
		}
		 
	}
	
	//Pour optimiser le code on créer un objet
	public ItemStack getItem(Material material, String customMeta) {
		ItemStack it = new ItemStack(material, 1);
		ItemMeta itM = it.getItemMeta();
		if(customMeta != null) itM.setDisplayName(customMeta);
		it.setItemMeta(itM);
		return it; 
	}
	
	
	
}
