package us.aquarin.hub.Inventory;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import us.aquarin.hub.Hub;

import static us.aquarin.hub.Hub.plugin;

/**
 * Created by aidan on 5/14/2017.
 */
public class Cosmetics implements Listener {


    private ItemStack createButton(ItemStack stack, String name) {
        ItemMeta m = stack.getItemMeta();
        m.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
        stack.setItemMeta(m);
        return stack;
    }

    private void message(Player p, String msg) {
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
    }



    private void openCosmetics(Player p) {

        Inventory cos = Bukkit.createInventory(null, 9, "§bCosmetics");

        ItemStack hats = new ItemStack(Material.WOOL, 1, DyeColor.RED.getData());
        createButton(hats, "&eHats");

        ItemStack armors = new ItemStack(Material.IRON_CHESTPLATE, 1);
        createButton(armors, "&bArmor");

        ItemStack f = new ItemStack(Material.STAINED_GLASS_PANE, 1, DyeColor.RED.getData());
        createButton(f, " ");

        cos.setItem(0, f);
        cos.setItem(1, f);
        cos.setItem(2, f);
        cos.setItem(3, hats);
        cos.setItem(4, f);
        cos.setItem(5, armors);
        cos.setItem(6, f);
        cos.setItem(7, f);
        cos.setItem(8, f);

        p.openInventory(cos);
    }

    private void openHats(Player p) {
        Inventory hat = Bukkit.createInventory(null, 9, "§bHats");

        ItemStack red = new ItemStack(Material.WOOL, 1, DyeColor.RED.getData());
        createButton(red, "&cRed");

        ItemStack aqua = new ItemStack(Material.WOOL, 1, DyeColor.LIGHT_BLUE.getData());
        createButton(aqua, "&bAqua");

        ItemStack green = new ItemStack(Material.WOOL, 1, DyeColor.GREEN.getData());
        createButton(green, "&2Green");

        ItemStack yellow = new ItemStack(Material.WOOL, 1, DyeColor.YELLOW.getData());
        createButton(yellow, "&eYellow");

        ItemStack orange = new ItemStack(Material.WOOL, 1, DyeColor.ORANGE.getData());
        createButton(orange, "&6Orange");

        ItemStack black = new ItemStack(Material.WOOL, 1, DyeColor.BLACK.getData());
        createButton(black, "&0Black");

        ItemStack white = new ItemStack(Material.WOOL, 1, DyeColor.WHITE.getData());
        createButton(white, "&fWhite");

        ItemStack f = new ItemStack(Material.STAINED_GLASS_PANE, 1, DyeColor.RED.getData());
        createButton(f, " ");

        ItemStack no = new ItemStack(Material.SKULL_ITEM, 1);
        createButton(no, "&4Remove Current Hat");

        hat.setItem(0, red);
        hat.setItem(1, aqua);
        hat.setItem(2, green);
        hat.setItem(3, yellow);
        hat.setItem(4, orange);
        hat.setItem(5, black);
        hat.setItem(6, white);
        hat.setItem(7, f);
        hat.setItem(8, no);

        p.openInventory(hat);
    }

    private void openArmor(Player p) {
        Inventory armor = Bukkit.createInventory(null, 9, "§bArmor");

        ItemStack helm = new ItemStack(Material.GOLD_HELMET, 1);
        createButton(helm, "&eHelmet");

        ItemStack chest = new ItemStack(Material.GOLD_CHESTPLATE, 1);
        createButton(chest, "&eChestplate");

        ItemStack pants = new ItemStack(Material.GOLD_LEGGINGS, 1);
        createButton(pants, "&eLeggings");

        ItemStack boots = new ItemStack(Material.GOLD_BOOTS, 1);
        createButton(boots, "&eBoots");

        ItemStack f = new ItemStack(Material.STAINED_GLASS_PANE, 1, DyeColor.RED.getData());
        createButton(f, " ");

        ItemStack no = new ItemStack(Material.SKULL_ITEM, 1);
        createButton(no, "&4Remove Current Armor");

        armor.setItem(0, helm);
        armor.setItem(1, chest);
        armor.setItem(2, pants);
        armor.setItem(3, boots);
        armor.setItem(4, f);
        armor.setItem(5, f);
        armor.setItem(6, f);
        armor.setItem(7, f);
        armor.setItem(8, no);

        p.openInventory(armor);
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (p.getItemInHand().getType() == null) { return; }
        if (p.getItemInHand().getType() == Material.HOPPER) {
            openCosmetics(p);
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        String name = e.getCurrentItem().getItemMeta().getDisplayName();
        if (name == null) { return; }
        if (e.getInventory().getTitle().equalsIgnoreCase("§bCosmetics")) {
            if (name.equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&eHats"))) {
                e.setCancelled(true);
                p.closeInventory();
                openHats(p);

            }
            if (name.equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&bArmor"))) {
                e.setCancelled(true);
                p.closeInventory();
                openArmor(p);
            }
        }

        if (e.getInventory().getTitle().equalsIgnoreCase("§bHats")) {

            ItemStack red = new ItemStack(Material.WOOL, 1, DyeColor.RED.getData());
            createButton(red, "&cRed");

            ItemStack aqua = new ItemStack(Material.WOOL, 1, DyeColor.LIGHT_BLUE.getData());
            createButton(aqua, "&bAqua");

            ItemStack green = new ItemStack(Material.WOOL, 1, DyeColor.GREEN.getData());
            createButton(green, "&2Green");

            ItemStack yellow = new ItemStack(Material.WOOL, 1, DyeColor.YELLOW.getData());
            createButton(yellow, "&eYellow");

            ItemStack orange = new ItemStack(Material.WOOL, 1, DyeColor.ORANGE.getData());
            createButton(orange, "&6Orange");

            ItemStack black = new ItemStack(Material.WOOL, 1, DyeColor.BLACK.getData());
            createButton(black, "&0Black");

            ItemStack white = new ItemStack(Material.WOOL, 1, DyeColor.WHITE.getData());
            createButton(white, "&fWhite");

            if (name.equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&cRed"))) {
                message(p, plugin.getConfig().getString("Messages.Cosmetics.Apply Hat"));
                p.getInventory().setHelmet(red);
                e.setCancelled(true);
                p.closeInventory();
            }
            if (name.equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&bAqua"))) {
                message(p, plugin.getConfig().getString("Messages.Cosmetics.Apply Hat"));
                p.getInventory().setHelmet(aqua);
                e.setCancelled(true);
                p.closeInventory();
            }
            if (name.equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&2Green"))) {
                message(p, plugin.getConfig().getString("Messages.Cosmetics.Apply Hat"));
                p.getInventory().setHelmet(green);
                e.setCancelled(true);
                p.closeInventory();
            }
            if (name.equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&eYellow"))) {
                message(p, plugin.getConfig().getString("Messages.Cosmetics.Apply Hat"));
                p.getInventory().setHelmet(yellow);
                e.setCancelled(true);
                p.closeInventory();
            }
            if (name.equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&6Orange"))) {
                message(p, plugin.getConfig().getString("Messages.Cosmetics.Apply Hat"));
                p.getInventory().setHelmet(orange);
                e.setCancelled(true);
                p.closeInventory();
            }
            if (name.equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&0Black"))) {
                message(p, plugin.getConfig().getString("Messages.Cosmetics.Apply Hat"));
                p.getInventory().setHelmet(black);
                e.setCancelled(true);
                p.closeInventory();
            }
            if (name.equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&fWhite"))) {
                message(p, plugin.getConfig().getString("Messages.Cosmetics.Apply Hat"));
                p.getInventory().setHelmet(white);
                e.setCancelled(true);
                p.closeInventory();
            }
            if (name.equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&4Remove Current Hat"))) {
                message(p, plugin.getConfig().getString("Messages.Cosmetics.Remove Hat"));
                p.getInventory().setHelmet(null);
                e.setCancelled(true);
                p.closeInventory();
            }
        }

        if (e.getInventory().getTitle().equalsIgnoreCase("§bArmor")) {

            ItemStack helm = new ItemStack(Material.GOLD_HELMET, 1);
            createButton(helm, "&eHelmet");

            ItemStack chest = new ItemStack(Material.GOLD_CHESTPLATE, 1);
            createButton(chest, "&eChestplate");

            ItemStack pants = new ItemStack(Material.GOLD_LEGGINGS, 1);
            createButton(pants, "&eLeggings");

            ItemStack boots = new ItemStack(Material.GOLD_BOOTS, 1);
            createButton(boots, "&eBoots");

            if (name.equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&eHelmet"))) {
                message(p, plugin.getConfig().getString("Messages.Cosmetics.Apply Armor"));
                p.getInventory().setHelmet(helm);
            }
            if (name.equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&eChestplate"))) {
                message(p, plugin.getConfig().getString("Messages.Cosmetics.Apply Armor"));
                p.getInventory().setChestplate(chest);
            }
            if (name.equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&eLeggings"))) {
                message(p, plugin.getConfig().getString("Messages.Cosmetics.Apply Armor"));
                p.getInventory().setLeggings(pants);
            }
            if (name.equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&eBoots"))) {
                message(p, plugin.getConfig().getString("Messages.Cosmetics.Apply Armor"));
                p.getInventory().setBoots(boots);
            }
            if (name.equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&4Remove Current Armor"))) {
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);
                message(p, plugin.getConfig().getString("Messages.Cosmetics.Remove Armor"));
            }

        }
    }
}
