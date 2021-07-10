package de.areon.system.commands;



import de.areon.system.utils.ItemActionbarManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ToolCommand implements CommandExecutor, Listener {

    ItemStack Axe = ItemActionbarManager.addLore("§e§lWorldEdit Axe", Material.WOOD_AXE, "Ist ein Tooles Tool", 1);
    ItemStack BarrierBlock = ItemActionbarManager.addLore("§c§lBarrier", Material.BARRIER, "Ist ein Tooles Tool", 1);
    ItemStack Block = ItemActionbarManager.addLore("§6§lStructure_Block", Material.STRUCTURE_BLOCK, "Ist ein Tooles Tool", 1);


    ItemStack glassb = ItemActionbarManager.createItem(Material.STAINED_GLASS_PANE, 1, 11, "§8");
    ItemStack glass = ItemActionbarManager.createItem(Material.STAINED_GLASS_PANE, 1, 15, "§8");

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (p.hasPermission("areon.tool")) {
            Inventory inv = Bukkit.createInventory(p, 27, "§9Tools Menü");

            inv.setItem(0, glassb);
            inv.setItem(1, glassb);
            inv.setItem(9, glassb);

            inv.setItem(17, glassb);
            inv.setItem(26, glassb);
            inv.setItem(25, glassb);

            inv.setItem(2, glass);
            inv.setItem(3, glass);
            inv.setItem(4, glass);
            inv.setItem(5, glass);
            inv.setItem(6, glass);
            inv.setItem(7, glass);
            inv.setItem(8, glass);
            inv.setItem(10, glass);
            inv.setItem(12, glass);
            inv.setItem(14, glass);
            inv.setItem(16, glass);
            inv.setItem(18, glass);
            inv.setItem(19, glass);
            inv.setItem(20, glass);
            inv.setItem(21, glass);
            inv.setItem(22, glass);
            inv.setItem(23, glass);
            inv.setItem(24, glass);


            inv.setItem(11, Axe);
            inv.setItem(13, BarrierBlock);
            inv.setItem(15, Block);

            p.openInventory(inv);
            p.playSound(p.getLocation(), Sound.BLOCK_LAVA_POP, 1, 1);
        }
        return false;
    }


    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player p = (Player) event.getWhoClicked();

        try {
            if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§e§lWorldEdit Axe")) {
                p.getInventory().setItem(11, Axe);
            } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§c§lBarrier")) {
                p.getInventory().setItem(10, BarrierBlock);
            } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§6§lStructure_Block")) {
                p.getInventory().setItem(9, Block);
            }





        } catch (Exception e1) {

        }
    }



    @EventHandler
    public void onInventoryClickEvent(InventoryClickEvent e) {
        try {


            if (e.getInventory().getTitle().equals("§9Tools Menü")) {
                e.setCancelled(true);
            }

        } catch (Exception e1) {}
    }
}
