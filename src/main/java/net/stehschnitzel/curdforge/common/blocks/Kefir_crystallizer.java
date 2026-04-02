package net.stehschnitzel.curdforge.common.blocks;

import java.util.Random;
import java.util.stream.Stream;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
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

/*
public class Kefir_crystallizer extends Block implements EntityBlock {

	public static final IntegerProperty LEVEL = IntegerProperty.create("level", 0, 4);;

	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

	private static final VoxelShape SHAPE_0 = Stream.of(Block.box(15, 0, 0, 16, 16, 16), Block.box(0, 0, 0, 1, 16, 16),
			Block.box(1, 0, 0, 15, 16, 1), Block.box(1, 0, 15, 15, 16, 16), Block.box(1, 15, 0, 15, 16, 1),
			Block.box(0, 15, 1, 1, 16, 15), Block.box(1, 15, 15, 15, 16, 16), Block.box(15, 15, 1, 16, 16, 15),
			Block.box(15, 7, 15, 16, 16, 16), Block.box(15, 7, 0, 16, 16, 1), Block.box(0, 7, 15, 1, 16, 16),
			Block.box(0, 7, 0, 1, 16, 1), Block.box(0, 0, 0, 16, 7, 16)).reduce((v1, v2) -> {
				return Shapes.joinUnoptimized(v1, v2, BooleanOp.OR);
			}).get();

	private static final VoxelShape SHAPE_1 = Stream.of(Block.box(15, 0, 0, 16, 16, 16), Block.box(0, 0, 0, 1, 16, 16),
			Block.box(1, 0, 0, 15, 16, 1), Block.box(1, 0, 15, 15, 16, 16), Block.box(1, 15, 0, 15, 16, 1),
			Block.box(0, 15, 1, 1, 16, 15), Block.box(1, 15, 15, 15, 16, 16), Block.box(15, 15, 1, 16, 16, 15),
			Block.box(15, 7, 15, 16, 16, 16), Block.box(15, 7, 0, 16, 16, 1), Block.box(0, 7, 15, 1, 16, 16),
			Block.box(0, 7, 0, 1, 16, 1), Block.box(0, 0, 0, 16, 7, 16)).reduce((v1, v2) -> {
				return Shapes.joinUnoptimized(v1, v2, BooleanOp.OR);
			}).get();

	private static final VoxelShape SHAPE_2 = Stream
			.of(Block.box(0.4999999999999999, 3, 0.5, 15.500000000000002, 10.600000000000001, 15.500000000000002),
					Block.box(7, 10.600000000000001, 7, 9, 11.600000000000001, 9), Block.box(6, 10, 6, 10, 11, 10),
					Block.box(0, 0, 0, 1, 16, 16), Block.box(1, 0, 0, 15, 16, 1), Block.box(15, 0, 0, 16, 16, 16),
					Block.box(1, 0, 15, 15, 16, 16), Block.box(0, 0, 0, 16, 7, 16))
			.reduce((v1, v2) -> {
				return Shapes.joinUnoptimized(v1, v2, BooleanOp.OR);
			}).get();

	public Kefir_crystallizer(Properties config) {
		super(config);

		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		switch (state.getValue(LEVEL)) {
		case 1:
			return SHAPE_1;
		case 2:
			return SHAPE_2;
		default:
			return SHAPE_0;
		}
	}

	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn,
			BlockHitResult hit) {
		int i = state.getValue(LEVEL);
		ItemStack itemstack = player.getItemInHand(handIn);
		Item item = itemstack.getItem();
		if (!worldIn.isClientSide) {

			if (i == 0 && item == CFItemInit.TIBICOS.get()) {
				worldIn.playSound((Player) null, pos, SoundEvents.SAND_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
				Funktions.dropp(state, worldIn, pos, player, handIn, hit, item, false, LEVEL, 1);
			} else if (i == 1 && item == Items.SUGAR) {
				worldIn.playSound((Player) null, pos, SoundEvents.SAND_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
				Funktions.dropp(state, worldIn, pos, player, handIn, hit, item, false, LEVEL, 2);
			} else if (i == 3) {
				popResource(worldIn, pos, new ItemStack(CFItemInit.KEFIR_CRYSTAL.get(), 1));
				worldIn.setBlockAndUpdate(pos, state.setValue(LEVEL, Integer.valueOf(Mth.clamp(0, 0, 3))));
			}
		}
		return InteractionResult.SUCCESS;
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(LEVEL);
		builder.add(FACING);
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new KefirKrystallizerTileEntity(pos, state);
	}

	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state,
			BlockEntityType<T> type) {
		return type == BlockEntityTypesInit.KEFIR_CRYSTALLIZER_TICK_ENTITY.get() ? KefirKrystallizerTileEntity::tick
				: null;
	}

	public static void setLevel(Level level, BlockPos pos, int i) {
		level.setBlockAndUpdate(pos, BlockInit.KEFIR_CRYSTALLIZER.get().defaultBlockState()
				.setValue(Kefir_crystallizer.LEVEL, Integer.valueOf(Mth.clamp(3, 3, 3))));
	}

	@Override
	public void animateTick(BlockState stateIn, Level worldIn, BlockPos pos, Random rand) {
		int i = stateIn.getValue(LEVEL);
		if (i == 2) {
			double d0 = (double) pos.getX() + 0.5D;
			double d1 = (double) pos.getY() + 1.2D;
			double d2 = (double) pos.getZ() + 0.5D;
			worldIn.addParticle(ParticleTypes.CLOUD, d0, d1, d2, 0.0D, 0.0D, 0.0D);
		}
	}

} */