package nudelauflauch.curd_mod.common.blocks;

import java.util.Random;
import java.util.stream.Stream;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.stehschnitzel.curdforge.common.blocks.te.KefirJarTickEntity;

public class Kefir extends Block implements EntityBlock {
	public static final IntegerProperty LEVEL = IntegerProperty.create("level", 0, 15);

	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

	private static final VoxelShape SHAPE_N = Stream
			.of(Block.box(6, 10, 6, 10, 12, 10), Block.box(5, 0, 5, 11, 10, 11), Block.box(4, 1, 5, 5, 9, 11),
					Block.box(11, 1, 5, 12, 9, 11), Block.box(5, 1, 4, 11, 9, 5), Block.box(5, 1, 11, 11, 9, 12))
			.reduce((v1, v2) -> {
				return Shapes.joinUnoptimized(v1, v2, BooleanOp.OR);
			}).get();

	public Kefir(Properties config) {
		super(config);
	}

	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		return SHAPE_N;
	}

	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn,
			BlockHitResult hit) {
		int i = state.getValue(LEVEL);
		ItemStack itemstack = player.getItemInHand(handIn);
		Item item = itemstack.getItem();
		if (itemstack.isEmpty()) {
			return InteractionResult.PASS;
		} else if (!worldIn.isClientSide) {
			if (i == 0 && item == nudelauflauch.curd_mod.core.init.CFItemInit.WHEY.get()) {
				worldIn.playSound((Player) null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
				Funktions.dropp(state, worldIn, pos, player, handIn, hit, Items.GLASS_BOTTLE, true, LEVEL, i += 1);
			} else if (i == 1 && item == nudelauflauch.curd_mod.core.init.CFItemInit.KEFIR_CRYSTAL.get()) {
				worldIn.playSound((Player) null, pos, SoundEvents.BOAT_PADDLE_WATER, SoundSource.BLOCKS, 1.0F, 1.0F);
				Funktions.dropp(state, worldIn, pos, player, handIn, hit, item, false, LEVEL, 3);
			} else if (i == 2 && item == nudelauflauch.curd_mod.core.init.CFItemInit.RAISINS.get()) {
				Funktions.dropp(state, worldIn, pos, player, handIn, hit, item, false, LEVEL, 3);
			} else if (i == 3) {
				worldIn.playSound((Player) null, pos, SoundEvents.VINE_STEP, SoundSource.BLOCKS, 1.0F, 1.0F);
				if (item == nudelauflauch.curd_mod.core.init.CFItemInit.PLUM.get()) {
					worldIn.setBlockAndUpdate(pos, state.setValue(LEVEL, Integer.valueOf(Mth.clamp(4, 0, 13))));
				} else if (item == nudelauflauch.curd_mod.core.init.CFItemInit.APRICOT.get()) {
					worldIn.setBlockAndUpdate(pos, state.setValue(LEVEL, Integer.valueOf(Mth.clamp(6, 0, 13))));
				} else if (item == nudelauflauch.curd_mod.core.init.CFItemInit.LEMON.get()) {
					worldIn.setBlockAndUpdate(pos, state.setValue(LEVEL, Integer.valueOf(Mth.clamp(8, 0, 13))));
				} else if (item == nudelauflauch.curd_mod.core.init.CFItemInit.CHERRY.get()) {
					worldIn.setBlockAndUpdate(pos, state.setValue(LEVEL, Integer.valueOf(Mth.clamp(10, 0, 13))));
				} else if (item == Items.APPLE) {
					Funktions.dropp(state, worldIn, pos, player, handIn, hit, item, false, LEVEL, 12);
					worldIn.setBlockAndUpdate(pos, state.setValue(LEVEL, Integer.valueOf(Mth.clamp(12, 0, 13))));
				} else if (item == Items.SWEET_BERRIES) {
					worldIn.setBlockAndUpdate(pos, state.setValue(LEVEL, Integer.valueOf(Mth.clamp(14, 0, 13))));
				}
			} else if (item == nudelauflauch.curd_mod.core.init.CFItemInit.KEFIR_TUMBLER.get()) {
				if (i == 5) {
					worldIn.playSound((Player) null, pos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
					Funktions.dropp(state, worldIn, pos, player, handIn, hit, nudelauflauch.curd_mod.core.init.CFItemInit.KEFIR_PLUM.get(), true, LEVEL,
							0);
				} else if (i == 7) {
					worldIn.playSound((Player) null, pos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
					Funktions.dropp(state, worldIn, pos, player, handIn, hit, nudelauflauch.curd_mod.core.init.CFItemInit.KEFIR_APRICOT.get(), true, LEVEL,
							0);
				} else if (i == 9) {
					worldIn.playSound((Player) null, pos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
					Funktions.dropp(state, worldIn, pos, player, handIn, hit, nudelauflauch.curd_mod.core.init.CFItemInit.KEFIR_LEMON.get(), true, LEVEL,
							0);
				} else if (i == 11) {
					worldIn.playSound((Player) null, pos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
					Funktions.dropp(state, worldIn, pos, player, handIn, hit, nudelauflauch.curd_mod.core.init.CFItemInit.KEFIR_CHERRY.get(), true, LEVEL,
							0);
				} else if (i == 13) {
					worldIn.playSound((Player) null, pos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
					Funktions.dropp(state, worldIn, pos, player, handIn, hit, nudelauflauch.curd_mod.core.init.CFItemInit.KEFIR_APPLE.get(), true, LEVEL,
							0);
				} else if (i == 15) {
					worldIn.playSound((Player) null, pos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
					Funktions.dropp(state, worldIn, pos, player, handIn, hit, nudelauflauch.curd_mod.core.init.CFItemInit.KEFIR_SWEETBERRY.get(), true,
							LEVEL, 0);
				}
			}
		}
		return InteractionResult.SUCCESS;
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(LEVEL, FACING);
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new KefirJarTickEntity(pos, state);
	}

	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state,
			BlockEntityType<T> type) {
		return type == BlockEntityTypesInit.KEFIR_JAR_TICK_ENTITY.get() ? KefirJarTickEntity::tick : null;
	}
	
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState stateIn, Level worldIn, BlockPos pos, Random rand) {
		int i = stateIn.getValue(LEVEL);
		if (i == 4 || i == 6 || i == 8 || i == 10 || i == 12 || i == 14) {
			double d0 = (double) pos.getX() + 0.5D;
			double d1 = (double) pos.getY() + 0.7D;
			double d2 = (double) pos.getZ() + 0.5D;
			worldIn.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
		}
	}
}