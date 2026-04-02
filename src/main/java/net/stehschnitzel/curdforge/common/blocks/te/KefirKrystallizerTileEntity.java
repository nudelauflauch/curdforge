package net.stehschnitzel.curdforge.common.blocks.te;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

/*
public class KefirKrystallizerTileEntity extends BlockEntity {
	public static final String TIMER = "timer";

	public int tick = 0;

	public KefirKrystallizerTileEntity(BlockPos pos, BlockState state) {
		super(BlockEntityTypesInit.KEFIR_CRYSTALLIZER_TICK_ENTITY.get(), pos, state);
	}

	@Override
	public void load(CompoundTag compound) {
		super.load(compound);
		this.tick = compound.getInt(TIMER);
	}

	public static <T extends BlockEntity> void tick(Level level, BlockPos pos, BlockState state, T be) {
		KefirKrystallizerTileEntity tile = (KefirKrystallizerTileEntity) be;

		if (!level.isClientSide) {
			Integer value = tile.getBlockState().getValue(Kefir_crystallizer.LEVEL);
			if (value == 2) {
				tile.tick++;
			}
			if (value == 2 && tile.tick == 200) {
				Kefir_crystallizer.setLevel(level, pos, 1);
				tile.tick = 0;
			}
		}
	}
} */
