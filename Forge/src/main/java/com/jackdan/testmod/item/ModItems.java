package com.jackdan.testmod.item;

import com.jackdan.testmod.TestMod;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Locale;


public class ModItems {

    private static final CreativeModeTab creativeModeTab = new CreativeModeTab(12,"jackanddan") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.BOMBOMB.get());
        }
    };

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TestMod.MOD_ID);


    public static final RegistryObject<Item> BOMBOMB = ITEMS.register("bombomb",
                () -> new Item(new Item.Properties().tab(creativeModeTab)));

    public static final RegistryObject<Item> BOWSER = ITEMS.register("bowser",
            () -> new Item(new Item.Properties().tab(creativeModeTab)));

    public static final RegistryObject<Item> MUSHROOM = ITEMS.register("mushroom", () -> {
        Item.Properties itemProperty = new Item.Properties();

        FoodProperties.Builder foodProperties = new FoodProperties.Builder();
        foodProperties.alwaysEat();
        foodProperties.meat();
        foodProperties.nutrition(50);
        foodProperties.saturationMod(50);

        itemProperty.food(foodProperties.build());

        itemProperty.tab(creativeModeTab);

        return new Item(itemProperty);
    });


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
