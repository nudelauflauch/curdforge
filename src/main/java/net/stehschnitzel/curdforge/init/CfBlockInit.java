package net.stehschnitzel.curdforge.init;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.stehschnitzel.curdforge.Curdforge;
import net.stehschnitzel.curdforge.common.blocks.CuddlyCactus;

public class CfBlockInit {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			Curdforge.MOD_ID);

    public static final RegistryObject<Block> CUDDLY_CACTUS = BLOCKS.register("cuddly_cactus",
            () -> new CuddlyCactus(BlockBehaviour.Properties.copy(Blocks.CACTUS).noCollission())
    );

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }

}
