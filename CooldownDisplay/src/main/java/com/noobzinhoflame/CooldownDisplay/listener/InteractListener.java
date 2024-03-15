package com.noobzinhoflame.CooldownDisplay.listener;

import com.noobzinhoflame.CooldownDisplay.utils.cooldown.Cooldown;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class InteractListener extends Cooldown implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        Action action = e.getAction();

        if (player.getInventory().getItemInHand().getType() == Material.PAPER && (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK)) {

        if (inCooldown(player)) {
            sendCooldown(player);
            return;
        }
            addCooldown(player, 5);
            player.getInventory().addItem(new ItemStack(Material.DIAMOND));
            player.playSound(player.getLocation(), Sound.EAT, 1f, 1f);
            player.sendMessage("§aVocê ganhou um diamante!");
        }
    }
}
