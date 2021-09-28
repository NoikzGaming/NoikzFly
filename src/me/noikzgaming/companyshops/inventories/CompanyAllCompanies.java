package me.noikzgaming.companyshops.inventories;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompanyAllCompanies implements InventoryHolder {

    private Inventory inv;

    public CompanyAllCompanies() {
        inv = Bukkit.createInventory(this, 45, "§7Företags Meny | Alla företag"); //54 Max Size
        init();
    }

    private void init() {
        ArrayList<String> staten = new ArrayList<String>();
        staten.add("§bÄgare: §7ThorinEk, DerisAviator");
        staten.add("§bPengar: §7∞");
        ArrayList<String> polisverket = new ArrayList<String>();
        polisverket.add("§bÄgare: §7ThorinEk, DerisAviator");
        polisverket.add("§bPengar: §7∞");
        ItemStack item;
        for(int i = 0; i < 1; i++) {
            item = createItem("§aStaten", Material.ENCHANTED_BOOK, staten);
            inv.setItem(i,item);
        }
        for(int i = 1; i < 2; i++) {
            item = createItem("§aPolisverket", Material.ENCHANTED_BOOK, polisverket);
            inv.setItem(i, item);
        }
        for(int i = 22; i < 23; i++) { //Mitten
        }
        for(int i = 40; i < 41; i++) {
            item = createItem("§cStäng", Material.BARRIER, Collections.EMPTY_LIST);
            inv.setItem(i,item);
        }
        for(int i = 0; i < 0; i++) {
            item = createItem("", Material.LIGHT_BLUE_STAINED_GLASS_PANE, Collections.EMPTY_LIST);
            inv.setItem(getInventory().firstEmpty(), item);
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
