package net.zam.melodyapi.api.gui.casetest;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import net.zam.melodyapi.MelodyAPI;
import net.zam.melodyapi.api.gui.BaseLootBoxScreen;
import net.zam.melodyapi.api.registry.MelodyItems;

public class TestCaseScreen extends BaseLootBoxScreen<TestCaseMenu> {
    private static final ResourceLocation CUSTOM_TEXTURE = new ResourceLocation(MelodyAPI.MOD_ID, "textures/gui/case.png");
    private static final ItemStack REQUIRED_KEY_ITEM = new ItemStack(MelodyItems.TEST_KEY.get());
    private static final ItemStack REQUIRED_CASE_ITEM = new ItemStack(MelodyItems.TEST_CASE.get());

    public TestCaseScreen(TestCaseMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title, CUSTOM_TEXTURE, REQUIRED_KEY_ITEM, REQUIRED_CASE_ITEM);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
        super.renderBg(guiGraphics, partialTicks, mouseX, mouseY);
    }
}
