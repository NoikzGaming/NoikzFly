package me.noikzgaming.companyshops.inventories;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import java.util.Collections;
import java.util.List;

public class CompanyMainMenu implements InventoryHolder {

    private Inventory inv;

    public CompanyMainMenu() {
        inv = Bukkit.createInventory(this, 45, "§7Företags Meny | Startmeny"); //54 Max Size
        init();
    }

    private void init() {
        ItemStack item;

        for(int i = 20; i < 21; i++) {
            item = createItem("§c§lAlla företag", Material.ENCHANTED_BOOK, Collections.singletonList("§7Klicka här för att se alla företag!"));
            inv.setItem(i,item);
        }
        for(int i = 24; i < 25; i++) {
            item = createItem("§c§lDina företag", Material.WRITABLE_BOOK, Collections.singletonList("§7Klicka här för att se alla dina företag!"));
            inv.setItem(i,item);
        }
        for(int i = 40; i < 41; i++) {
            item = createItem("§cStäng", Material.BARRIER, Collections.EMPTY_LIST);
            inv.setItem(i,item);
        }
        for(int i = 0; i < 20; i++) {
            item = createItem("", Material.LIGHT_BLUE_STAINED_GLASS_PANE, Collections.EMPTY_LIST);
            inv.setItem(i,item);
        }
        for(int i = 21; i < 24; i++) {
            item = createItem("", Material.LIGHT_BLUE_STAINED_GLASS_PANE, Collections.EMPTY_LIST);
            inv.setItem(i,item);
        }
        for(int i = 25; i < 40; i++) {
            item = createItem("", Material.LIGHT_BLUE_STAINED_GLASS_PANE, Collections.EMPTY_LIST);
            inv.setItem(i,item);
        }
        for(int i = 41; i < 45; i++) {
            item = createItem("", Material.LIGHT_BLUE_STAINED_GLASS_PANE, Collections.EMPTY_LIST);
            inv.setItem(i,item);
        }
    }

    private ItemStack createItem(String name, Material mat, List<String> lore) {
        ItemStack item = new ItemStack(mat, 1); {
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(name);
            meta.setLore(lore);
            item.setItemMeta(meta);
            return item;
        }
    }
    @Override
    public Inventory getInventory() {
        return inv;
    }
}
