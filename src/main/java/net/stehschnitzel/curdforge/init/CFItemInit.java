package net.stehschnitzel.curdforge.init;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BowlFoodItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.stehschnitzel.curdforge.Curdforge;

public class CFItemInit {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Curdforge.MOD_ID);


    public static final RegistryObject<Item> CURD = ITEMS.register("curd",
            () -> new BowlFoodItem(new Item.Properties()
                    .food(new FoodProperties.Builder()
                            .nutrition(1)
                            .saturationMod(1f).build())));

    public static final RegistryObject<Item> OPUNTIA_BLOSSOM = ITEMS.register("opuntia_blossom",
            () -> new BowlFoodItem(new Item.Properties()
                    .food(new FoodProperties.Builder()
                            .nutrition(1)
                            .saturationMod(1f).build())));


    //food items
    public static final RegistryObject<Item> APPLE_STRUDEL = ITEMS.register("apple_strudel",
            () -> new Item(new Item.Properties()
                    .food(new FoodProperties.Builder()
                            .nutrition(8)
                            .saturationMod(0.6f).build())));

    public static final RegistryObject<Item> CURD_CHEESE_POCKET = ITEMS.register("curd_cheese_pocket",
            () -> new Item(new Item.Properties().food(
                    new FoodProperties.Builder().nutrition(7)
                            .saturationMod(0.6F).build())));

    public static final RegistryObject<Item> MILK_PUDDING = ITEMS.register("milk_pudding",
            () -> new Item(new Item.Properties().food(
                    new FoodProperties.Builder()
                            .nutrition(3)
                            .saturationMod(1f)
                            .fast().build())));

    public static final RegistryObject<Item> PUMPKIN_TART = ITEMS.register("pumpkin_tart",
            () -> new Item(new Item.Properties().food(
                    new FoodProperties.Builder().nutrition(6)
                            .saturationMod(0.5f)
                            .fast().build())));

    public static final RegistryObject<Item> SWEET_BERRY_ROLE = ITEMS.register("sweet_berry_role",
            () -> new Item(new Item.Properties().food(
                    new FoodProperties.Builder().nutrition(2)
                            .saturationMod(0.2f).build())));


    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }

}
