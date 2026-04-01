package net.stehschnitzel.curdforge.init;

import net.minecraft.core.NonNullList;
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
                    .icon(() -> new ItemStack(CFItemInit.CCP.get()))
                    .displayItems((pParameters, pOutput) -> {
                        CFCreativeTabInit.fillItemList(pOutput);
                    })
                    .build()
    );

	public static void fillItemList(CreativeModeTab.Output items) {
		registerTools(items);
		registerWapon(items);
		registerArmor(items);
		registerDifferentFood(items);
		registerCurdCheesePocket(items);
		registerAppleStrudel(items);
		registerCurdStrudel(items);
		registerRaisinsKaiserschmarrn(items);
		registerKaiserschmarrn(items);
		registerOmlett(items);
		registerKefir(items);
		registerFoodMaterials(items);
		registerJam(items);
		registerBlocks(items);
	}
	
	private static void registerTools(NonNullList<ItemStack> items) {
		items.add(new ItemStack(CFItemInit.LOST_CCP_AXE.get()));
		items.add(new ItemStack(CFItemInit.LOST_CCP_HOE.get()));
		items.add(new ItemStack(CFItemInit.LOST_CCP_SHOVEL.get()));
		items.add(new ItemStack(CFItemInit.LOST_CCP_PICKAXE.get()));
	}
	
	private static void registerWapon(NonNullList<ItemStack> items) {
		items.add(new ItemStack(CFItemInit.LOST_CCP_SWORD.get()));
		items.add(new ItemStack(CFItemInit.LOST_CCP_MACE.get()));
	}
	
	private static void registerArmor(NonNullList<ItemStack> items) {
		items.add(new ItemStack(CFItemInit.LOST_CCP_HELMET.get()));
		items.add(new ItemStack(CFItemInit.LOST_CCP_CHESTPLATE.get()));
		items.add(new ItemStack(CFItemInit.LOST_CCP_LEGGINGS.get()));
		items.add(new ItemStack(CFItemInit.LOST_CCP_BOOTS.get()));
	}
	
	private static void registerDifferentFood(NonNullList<ItemStack> items) {
		items.add(new ItemStack(CFItemInit.WIENER_SCHNITZEL.get()));
		items.add(new ItemStack(CFItemInit.WIENER_SCHNITZEL_LEMON.get()));
		items.add(new ItemStack(CFItemInit.WIENER_SCHNITZEL_LEMON_JAM.get()));
		items.add(new ItemStack(CFItemInit.FRIES.get()));
		items.add(new ItemStack(CFItemInit.LIMONADE.get()));
	}
	
	private static void registerCurdCheesePocket(NonNullList<ItemStack> items) {
		items.add(new ItemStack(CFItemInit.CCP.get()));
		items.add(new ItemStack(CFItemInit.CCP_RAW.get()));
		items.add(new ItemStack(CFItemInit.CCP_SUGARD.get()));
		items.add(new ItemStack(CFItemInit.CCP_WET_OP.get()));
		items.add(new ItemStack(CFItemInit.CCP_WET.get()));
		items.add(new ItemStack(CFItemInit.CCP_BURNT_OP.get()));
		items.add(new ItemStack(CFItemInit.CCP_BURNT.get()));
		items.add(new ItemStack(CFItemInit.CCP_AIRY.get()));
		items.add(new ItemStack(CFItemInit.CCP_DURTY.get()));
	}
	
	private static void registerAppleStrudel(NonNullList<ItemStack> items) {
		items.add(new ItemStack(CFItemInit.APPLE_STRUDEL_RAW.get()));
		items.add(new ItemStack(CFItemInit.APPLE_STRUDEL.get()));
		items.add(new ItemStack(CFItemInit.APPLE_STRUDEL_PIECE.get()));
		items.add(new ItemStack(CFItemInit.APPLE_STRUDEL_PIECE_SUGARD.get()));
		items.add(new ItemStack(CFItemInit.APPLE_STRUDEL_PIECE_CUSTARD.get()));
		items.add(new ItemStack(CFItemInit.APPLE_STRUDEL_PIECE_SUGARD_CUSTARD.get()));
	}
	
	private static void registerCurdStrudel(NonNullList<ItemStack> items) {
		items.add(new ItemStack(CFItemInit.CURD_STRUDEL_RAW.get()));
		items.add(new ItemStack(CFItemInit.CURD_STRUDEL.get()));
		items.add(new ItemStack(CFItemInit.CURD_STRUDEL_PIECE.get()));
		items.add(new ItemStack(CFItemInit.CURD_STRUDEL_PIECE_SUGARD.get()));
		items.add(new ItemStack(CFItemInit.CURD_STRUDEL_PIECE_CUSTARD.get()));
		items.add(new ItemStack(CFItemInit.CURD_STRUDEL_PIECE_SUGARD_CUSTARD.get()));
	}
	
	private static void registerRaisinsKaiserschmarrn(NonNullList<ItemStack> items) {
		items.add(new ItemStack(CFItemInit.KAISERSCHMARRN_RAISINS.get()));
		items.add(new ItemStack(CFItemInit.KAISERSCHMARRN_RAISINS_APPLE_PURE.get()));
		items.add(new ItemStack(CFItemInit.KAISERSCHMARRN_RAISINS_POWIDL.get()));
		items.add(new ItemStack(CFItemInit.KAISERSCHMARRN_RAISINS_SWEETBERRY.get()));
		items.add(new ItemStack(CFItemInit.KAISERSCHMARRN_RAISINS_APRICOT.get()));
		items.add(new ItemStack(CFItemInit.KAISERSCHMARRN_RAISINS_CHERRY.get()));
	}
	
	private static void registerKaiserschmarrn(NonNullList<ItemStack> items) {
		items.add(new ItemStack(CFItemInit.KAISERSCHMARRN.get()));
		items.add(new ItemStack(CFItemInit.KAISERSCHMARRN_POWIDL.get()));
		items.add(new ItemStack(CFItemInit.KAISERSCHMARRN_APRICOT.get()));
		items.add(new ItemStack(CFItemInit.KAISERSCHMARRN_APPLE_PURE.get()));
		items.add(new ItemStack(CFItemInit.KAISERSCHMARRN_SWEETBERRY.get()));
		items.add(new ItemStack(CFItemInit.KAISERSCHMARRN_CHERRY.get()));
	}
	
	private static void registerOmlett(NonNullList<ItemStack> items) {
		items.add(new ItemStack(CFItemInit.OMLETT_CHOCO.get()));
		items.add(new ItemStack(CFItemInit.OMLETT_SWEETBERRY.get()));
		items.add(new ItemStack(CFItemInit.OMLETT_APRICOT.get()));
		items.add(new ItemStack(CFItemInit.OMLETT_POWIDL.get()));
		items.add(new ItemStack(CFItemInit.OMLETT_APPLE.get()));
		items.add(new ItemStack(CFItemInit.DUFF.get()));
		items.add(new ItemStack(CFItemInit.DUFF_RAISINS.get()));
	}
	
	private static void registerKefir(NonNullList<ItemStack> items) {
		items.add(new ItemStack(CFItemInit.KEFIR_TUMBLER.get()));
		items.add(new ItemStack(CFItemInit.KEFIR_PLUM.get()));
		items.add(new ItemStack(CFItemInit.KEFIR_CHERRY.get()));
		items.add(new ItemStack(CFItemInit.KEFIR_LEMON.get()));
		items.add(new ItemStack(CFItemInit.KEFIR_APRICOT.get()));
		items.add(new ItemStack(CFItemInit.KEFIR_SWEETBERRY.get()));
		items.add(new ItemStack(CFItemInit.KEFIR_APPLE.get()));
	}
	
	private static void registerFoodMaterials(NonNullList<ItemStack> items) {
		items.add(new ItemStack(CFItemInit.KEFIR_CRYSTAL.get()));
		items.add(new ItemStack(CFItemInit.CURD.get()));
		items.add(new ItemStack(CFItemInit.WHEY.get()));
		items.add(new ItemStack(CFItemInit.RAISINS.get()));
		items.add(new ItemStack(CFItemInit.COCOLATE.get()));
		items.add(new ItemStack(CFItemInit.COCO_BEAN_ROASTED.get()));
		items.add(new ItemStack(CFItemInit.VANILLE.get()));
		items.add(new ItemStack(CFItemInit.VANILLIN.get()));
		items.add(new ItemStack(CFItemInit.PUFF_PASTE_RAW.get()));
		items.add(new ItemStack(CFItemInit.PUFF_PASTE.get()));
		items.add(new ItemStack(CFItemInit.CUSTARD.get()));
		items.add(new ItemStack(CFItemInit.DUFF_RAW.get()));
		items.add(new ItemStack(CFItemInit.DUFF_RAW_RAISINS.get()));
		items.add(new ItemStack(CFItemInit.SIEVE.get()));
		items.add(new ItemStack(CFItemInit.TIBICOS.get()));
	}
	
	private static void registerJam(NonNullList<ItemStack> items) {
		items.add(new ItemStack(CFItemInit.JAM_APRICOT.get()));
		items.add(new ItemStack(CFItemInit.JAM_SWEETBERRY.get()));
		items.add(new ItemStack(CFItemInit.JAM_APPLE_PURE.get()));
		items.add(new ItemStack(CFItemInit.JAM_POWIDL.get()));
		items.add(new ItemStack(CFItemInit.JAM_CHERRY.get()));
		items.add(new ItemStack(CFItemInit.APRICOT.get()));
		items.add(new ItemStack(CFItemInit.PLUM.get()));
		items.add(new ItemStack(CFItemInit.LEMON.get()));
		items.add(new ItemStack(CFItemInit.CHERRY.get()));
		items.add(new ItemStack(CFItemInit.PIT.get()));
		items.add(new ItemStack(CFItemInit.STOVE.get()));
		items.add(new ItemStack(CFItemInit.KEFIR_JAR.get()));
	}
	
	private static void registerBlocks(NonNullList<ItemStack> items) {
        items.add(new ItemStack(CFItemInit.CURD_POT.get()));
        items.add(new ItemStack(CFItemInit.KEFIR_CRYSTALLIZER.get()));
        items.add(new ItemStack(CFItemInit.LOST_CCP_ORE.get()));
        items.add(new ItemStack(CFItemInit.LOST_CCP_ITEM.get()));
        items.add(new ItemStack(CFItemInit.LOST_CCP_BLOCK.get()));
        items.add(new ItemStack(CFItemInit.LOST_CCP_BLOCK.get()));
        items.add(new ItemStack(CFItemInit.OPUNTIEN_BLOSSOM.get()));
        items.add(new ItemStack(CFItemInit.PLUM.get()));
        items.add(new ItemStack(CFItemInit.LEMON.get()));
        items.add(new ItemStack(CFItemInit.CHERRY.get()));
        items.add(new ItemStack(CFItemInit.PIT.get()));
    }

    public static void register(IEventBus bus) {
        TABS.register(bus);
    }
}
