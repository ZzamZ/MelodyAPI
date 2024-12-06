package net.zam.melodyapi.api.item;

import net.minecraft.world.item.ItemStack;
import net.zam.melodyapi.api.util.Rarity;

public class RarityItem {
    private final ItemStack itemStack;
    private final Rarity rarity;

    public RarityItem(ItemStack itemStack, Rarity rarity) {
        this.itemStack = itemStack;
        this.rarity = rarity;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public Rarity getRarity() {
        return rarity;
    }
}
