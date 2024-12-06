package net.zam.melodyapi.api.event;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.zam.melodyapi.MelodyAPI;
import net.zam.melodyapi.api.advancement.FishingCatchTrigger;

@Mod.EventBusSubscriber(modid = MelodyAPI.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MelodyEventBusEvents {
    @SubscribeEvent
    public static void registerAdvancementTriggers(FMLCommonSetupEvent event) {
        CriteriaTriggers.register(FishingCatchTrigger.INSTANCE);
    }
}
