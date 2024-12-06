package net.zam.melodyapi.api.registry;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.zam.melodyapi.MelodyAPI;
import net.zam.melodyapi.api.item.HatItem;
import net.zam.melodyapi.api.item.TestCase;

public class MelodyItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MelodyAPI.MOD_ID);


    public static final RegistryObject<Item> TEST_CASE = ITEMS.register("test_case", () -> new TestCase(new Item.Properties()));
    public static final RegistryObject<Item> TEST_KEY = ITEMS.register("test_key", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}


