package net.zam.melodyapi.api.item;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public abstract class HatItem extends Item {

    public HatItem(Properties properties, SoundEvent equipSound) {
        super(properties);
    }

    public HatItem(Properties properties) {
        this(properties, SoundEvents.ARMOR_EQUIP_LEATHER);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        return super.useOn(context);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack heldStack = player.getItemInHand(hand);
        EquipmentSlot slot = getEquipmentSlotForItem(heldStack);
        if (slot != null) {
            if (player.getItemBySlot(slot).getItem() instanceof HatItem) {
                return swapHat(player, heldStack, slot);
            }
            ItemStack currentHelmet = player.getItemBySlot(slot);
            if (!currentHelmet.isEmpty() && currentHelmet.getItem() instanceof ArmorItem
                    && ((ArmorItem) currentHelmet.getItem()).getEquipmentSlot() == EquipmentSlot.HEAD) {
                if (!(currentHelmet.getItem() instanceof HatItem)) {
                    player.getInventory().add(currentHelmet);
                }
            }
            player.setItemSlot(slot, new ItemStack(this, 1));
            player.getInventory().removeItem(heldStack);
            return new InteractionResultHolder<>(InteractionResult.SUCCESS, heldStack);
        }
        return new InteractionResultHolder<>(InteractionResult.PASS, heldStack);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.EAT;
    }

    @Override
    public EquipmentSlot getEquipmentSlot(ItemStack stack) {
        return EquipmentSlot.HEAD;
    }

    private static EquipmentSlot getEquipmentSlotForItem(ItemStack stack) {
        return stack.getItem().canEquip(stack, EquipmentSlot.HEAD, null) ? EquipmentSlot.HEAD : null;
    }

    private InteractionResultHolder<ItemStack> swapHat(Player player, ItemStack newHat, EquipmentSlot slot) {
        ItemStack currentHat = player.getItemBySlot(slot);
        player.setItemSlot(slot, ItemStack.EMPTY);
        if (!player.getInventory().add(currentHat)) {
            player.drop(currentHat, false);
        }
        if (!(newHat.getItem() instanceof HatItem)) {
            player.setItemSlot(slot, new ItemStack(this, 1));
        }
        return new InteractionResultHolder<>(InteractionResult.SUCCESS, newHat);
    }
}
