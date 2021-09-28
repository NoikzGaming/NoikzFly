package me.noikzgaming.companyshops.events;

import me.noikzgaming.companyshops.inventories.CompanyAllCompanies;
import me.noikzgaming.companyshops.inventories.CompanyYourCompanies;
import me.noikzgaming.companyshops.inventories.CompanyMainMenu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryEvents implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getClickedInventory() == null) { return; }
        if (e.getClickedInventory().getHolder() instanceof CompanyMainMenu) {
            e.setCancelled(true);
        }
        if (e.getClickedInventory().getHolder() instanceof CompanyYourCompanies) {
            e.setCancelled(true);
        }
        if (e.getClickedInventory().getHolder() instanceof CompanyAllCompanies) {
            e.setCancelled(true);
        }
        if (e.isLeftClick()) {
            Player player = (Player) e.getWhoClicked();
            if (e.getCurrentItem() == null) { return; }

            if (e.getCurrentItem().getType() == Material.WRITABLE_BOOK & e.getClickedInventory().getHolder() instanceof CompanyMainMenu) {
                player.closeInventory();
                CompanyYourCompanies gui = new CompanyYourCompanies();
                player.openInventory(gui.getInventory());
            }
            if (e.getCurrentItem().getType() == Material.BARRIER & e.getClickedInventory().getHolder() instanceof CompanyMainMenu) {
                player.closeInventory();
            }
            if (e.getCurrentItem().getType() == Material.BARRIER & e.getClickedInventory().getHolder() instanceof CompanyYourCompanies) {
                player.closeInventory();
            }
            if (e.getCurrentItem().getType() == Material.BARRIER & e.getClickedInventory().getHolder() instanceof CompanyAllCompanies) {
                player.closeInventory();
            }
            if(e.getCurrentItem().getType() == Material.ENCHANTED_BOOK & e.getClickedInventory().getHolder() instanceof CompanyMainMenu) {
                player.closeInventory();
                CompanyAllCompanies gui = new CompanyAllCompanies();
                player.openInventory(gui.getInventory());
            }
        }

    }
}
