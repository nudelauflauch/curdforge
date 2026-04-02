package net.stehschnitzel.curdforge.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.stehschnitzel.curdforge.Curdforge;

public class CFCreativeTabInit{

    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Curdforge.MOD_ID);

    public static final RegistryObject<CreativeModeTab> SHUTTER_TAB = TABS.register("curdforge_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.curdforge_tab"))
                    .icon(() -> new ItemStack(CFItemInit.CURD_CHEESE_POCKET.get()))
                    .displayItems((pParameters, pOutput) -> {
                        CFCreativeTabInit.fillItemList(pOutput);
                    })
                    .build()
    );

	public static void fillItemList(CreativeModeTab.Output items) {
		items.accept(CFItemInit.CURD_CHEESE_POCKET.get());
		items.accept(CFItemInit.APPLE_STRUDEL.get());
		items.accept(CFItemInit.MILK_PUDDING.get());
		items.accept(CFItemInit.PUMPKIN_TART.get());
		items.accept(CFItemInit.SWEET_BERRY_ROLE.get());

		items.accept(CFItemInit.CURD.get());
		items.accept(CFItemInit.OPUNTIA_BLOSSOM.get());
	}


    public static void register(IEventBus bus) {
        TABS.register(bus);
    }
}
