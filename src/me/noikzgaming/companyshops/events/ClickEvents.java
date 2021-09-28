package me.noikzgaming.companyshops.events;

import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.lang.annotation.Annotation;

public class ClickEvents implements Listener {

    @EventHandler
    public void onPlayerClickSign(PlayerInteractEvent event){
        Player p = event.getPlayer();
        if(event.getClickedBlock().getType() == Material.OAK_SIGN ||event.getClickedBlock().getType() == Material.OAK_WALL_SIGN){
            if(event.getAction() == Action.RIGHT_CLICK_BLOCK){
                Sign sign = (Sign) event.getClickedBlock().getState();
                //^^ .getState(); really important
                if(sign.getLine(1).equalsIgnoreCase( "c:Noikz")){
                    p.sendMessage("Test");
                    sign.update();
                }
            }
        }
    }
}