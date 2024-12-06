package net.zam.melodyapi;

import com.mojang.logging.LogUtils;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.zam.melodyapi.api.gui.casetest.TestCaseScreen;
import net.zam.melodyapi.api.registry.MelodyItems;
import net.zam.melodyapi.api.registry.MelodyMenuTypes;
import net.zam.melodyapi.api.util.network.NetworkHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(MelodyAPI.MOD_ID)
public class MelodyAPI {
    public static final String MOD_ID = "melodyapi";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public MelodyAPI() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::setupClient);

        MelodyItems.register(modEventBus);
        MelodyMenuTypes.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);

        NetworkHandler.register();
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    private void setupClient(final FMLClientSetupEvent event) {
        MenuScreens.register(MelodyMenuTypes.TEST_CASE.get(), TestCaseScreen::new);
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        }
    }

    public static ResourceLocation id(String s) {
        return new ResourceLocation(MelodyAPI.MOD_ID, s);
    }
}
