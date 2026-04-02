package net.stehschnitzel.curdforge.common.blocks.te;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

/*
public class KefirJarTickEntity extends BlockEntity {
	public static final String TIMER = "timer";

	public int tick = 0;

	public KefirJarTickEntity(BlockPos pos, BlockState state) {
		super(BlockEntityTypesInit.KEFIR_JAR_TICK_ENTITY.get(), pos, state);
	}

	@Override
	public void load(CompoundTag compound) {
		super.load(compound);
		this.tick = compound.getInt(TIMER);
	}

	public static <T extends BlockEntity> void tick(Level level, BlockPos pos, BlockState state, T be) {
		KefirJarTickEntity tile = (KefirJarTickEntity) be;

		if (!level.isClientSide) {
			Integer value = tile.getBlockState().getValue(Kefir.LEVEL);
			if (value == 4 || value == 6 || value == 8 || value == 10 || value == 12 || value == 14) {
				tile.tick++;
			}
			if (value == 4 && tile.tick == 200) {
				tile.level.setBlockAndUpdate(tile.worldPosition, BlockInit.KEFIR_JAR.get().defaultBlockState()
						.setValue(Kefir.LEVEL, Integer.valueOf(Mth.clamp(6, 0, 5))));
				tile.tick = 0;
			} else if (value == 6 && tile.tick == 200) {
				tile.level.setBlockAndUpdate(tile.worldPosition, BlockInit.KEFIR_JAR.get().defaultBlockState()
						.setValue(Kefir.LEVEL, Integer.valueOf(Mth.clamp(8, 0, 7))));
				tile.tick = 0;
			} else if (value == 8 && tile.tick == 200) {
				tile.level.setBlockAndUpdate(tile.worldPosition, BlockInit.KEFIR_JAR.get().defaultBlockState()
						.setValue(Kefir.LEVEL, Integer.valueOf(Mth.clamp(8, 0, 9))));
				tile.tick = 0;
			} else if (value == 10 && tile.tick == 200) {
				tile.level.setBlockAndUpdate(tile.worldPosition, BlockInit.KEFIR_JAR.get().defaultBlockState()
						.setValue(Kefir.LEVEL, Integer.valueOf(Mth.clamp(8, 0, 11))));
				tile.tick = 0;
			} else if (value == 12 && tile.tick == 200) {
				tile.level.setBlockAndUpdate(tile.worldPosition, BlockInit.KEFIR_JAR.get().defaultBlockState()
						.setValue(Kefir.LEVEL, Integer.valueOf(Mth.clamp(8, 0, 13))));
				tile.tick = 0;
			} else if (value == 14 && tile.tick == 200) {
				tile.level.setBlockAndUpdate(tile.worldPosition, BlockInit.KEFIR_JAR.get().defaultBlockState()
						.setValue(Kefir.LEVEL, Integer.valueOf(Mth.clamp(8, 0, 15))));
				tile.tick = 0;
			} else if (value == 2 && tile.tick == 200) {
				tile.level.setBlockAndUpdate(tile.worldPosition, BlockInit.KEFIR_CRYSTALLIZER.get().defaultBlockState()
						.setValue(Kefir_crystallizer.LEVEL, Integer.valueOf(Mth.clamp(8, 0, 3))));
				tile.tick = 0;
			}
		}
	}
}
*/