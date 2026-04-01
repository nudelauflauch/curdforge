package net.stehschnitzel.curdforge.init;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.stehschnitzel.curdforge.Curdforge;

public class CfBlockInit {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			Curdforge.MOD_ID);



    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }

}
