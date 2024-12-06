package net.zam.melodyapi.api.gui.casetest;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.zam.melodyapi.api.gui.BaseLootBoxMenu;
import net.zam.melodyapi.api.item.RarityItem;
import net.zam.melodyapi.api.registry.MelodyMenuTypes;
import net.zam.melodyapi.api.util.Rarity;

import java.util.List;

public class TestCaseMenu extends BaseLootBoxMenu<TestCaseMenu> {
    public static final MenuType<TestCaseMenu> TEST_CASE_MENU = MelodyMenuTypes.TEST_CASE.get();

   public TestCaseMenu(int id, Inventory playerInventory) {
       super(TEST_CASE_MENU, id, playerInventory, getCustomLootItems());
   }

    private static List<RarityItem> getCustomLootItems() {
        return List.of(
                new RarityItem(new ItemStack(Items.WOODEN_AXE), Rarity.COMMON),
                new RarityItem(new ItemStack(Items.WOODEN_PICKAXE), Rarity.COMMON),
                new RarityItem(new ItemStack(Items.WOODEN_SHOVEL), Rarity.COMMON),
                new RarityItem(new ItemStack(Items.IRON_AXE), Rarity.UNCOMMON),
                new RarityItem(new ItemStack(Items.IRON_PICKAXE), Rarity.UNCOMMON),
                new RarityItem(new ItemStack(Items.IRON_SHOVEL), Rarity.UNCOMMON),
                new RarityItem(new ItemStack(Items.DIAMOND_AXE), Rarity.RARE),
                new RarityItem(new ItemStack(Items.DIAMOND_PICKAXE), Rarity.RARE),
                new RarityItem(new ItemStack(Items.DIAMOND_SHOVEL), Rarity.RARE),
                new RarityItem(new ItemStack(Items.NETHERITE_AXE), Rarity.VERY_RARE),
                new RarityItem(new ItemStack(Items.NETHERITE_SHOVEL), Rarity.VERY_RARE),
                new RarityItem(new ItemStack(Items.NETHERITE_PICKAXE), Rarity.ULTRA_RARE)
        );
    }
}
