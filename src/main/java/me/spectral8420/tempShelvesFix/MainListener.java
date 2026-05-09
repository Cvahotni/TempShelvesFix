package me.spectral8420.tempShelvesFix;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.block.Shelf;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class MainListener implements Listener {
    @EventHandler
    public void onShelfInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if(player.hasPermission("tempShelvesFix.bypass")) {
            return;
        }

        if(event.getBlockFace() == BlockFace.UP || event.getBlockFace() == BlockFace.DOWN) {
            return;
        }

        if(player.isSneaking()) {
            return;
        }

        Block block = event.getClickedBlock();

        if(block != null && isShelf(block.getType())) {
            if(event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onHopperPush(InventoryMoveItemEvent event) {
        if(event.getDestination().getHolder() instanceof Shelf) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onShelfBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();

        if(player.hasPermission("tempShelvesFix.bypass")) {
            return;
        }

        Block block = event.getBlock();

        if(isShelf(block.getType())) {
            BlockState state = event.getBlock().getState();

            if(state instanceof Shelf shelf) {
                shelf.getInventory().clear();
            }
        }
    }

    private boolean isShelf(Material material) {
        return (
                material == Material.OAK_SHELF ||
                        material == Material.SPRUCE_SHELF ||
                        material == Material.BIRCH_SHELF ||
                        material == Material.JUNGLE_SHELF ||
                        material == Material.ACACIA_SHELF ||
                        material == Material.DARK_OAK_SHELF ||
                        material == Material.MANGROVE_SHELF ||
                        material == Material.PALE_OAK_SHELF ||
                        material ==  Material.BAMBOO_SHELF ||
                        material == Material.CRIMSON_SHELF ||
                        material == Material.WARPED_SHELF
        );
    }
}
