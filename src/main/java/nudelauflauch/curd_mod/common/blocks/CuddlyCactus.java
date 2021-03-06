package nudelauflauch.curd_mod.common.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.DeadBushBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import nudelauflauch.curd_mod.common.te.CurdModBlockStateProperties;
import nudelauflauch.curd_mod.core.init.ItemInit;

public class CuddlyCactus extends DeadBushBlock implements IGrowable {
	public static final IntegerProperty AGE = CurdModBlockStateProperties.AGE_0_8;
	private static final VoxelShape BUSHLING_SHAPE = Block.makeCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 8.0D, 13.0D);
	private static final VoxelShape GROWING_SHAPE = Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

	public CuddlyCactus(Properties properties) {
		super(properties);
	}

	@Override
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(ItemInit.OPUNTIEN_BLOSSOM.get());
	}

	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		if (state.get(AGE) == 0) {
			return BUSHLING_SHAPE;
		} else {
			return state.get(AGE) < 3 ? GROWING_SHAPE : super.getShape(state, worldIn, pos, context);
		}
	}

	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult hit) {
		int i = state.get(AGE);
		boolean flag = i == 3;
		System.out.println(i);
		if (!flag && player.getHeldItem(handIn).getItem() == Items.BONE_MEAL) {
			return ActionResultType.PASS;
		} else if (i > 4 && i == 8) {
			int j = 1 + worldIn.rand.nextInt(2);
			spawnAsEntity(worldIn, pos, new ItemStack(ItemInit.OPUNTIEN_BLOSSOM.get(), j + (flag ? i : i - 4) - 2));
			spawnAsEntity(worldIn, pos, new ItemStack(ItemInit.TIBICOS.get(), j + (flag ? i : 1 - 0) - 1));
			worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(4)), 2);
			return ActionResultType.SUCCESS;
		} else if (i > 4) {
			int j = 1 + worldIn.rand.nextInt(2);
			spawnAsEntity(worldIn, pos, new ItemStack(ItemInit.OPUNTIEN_BLOSSOM.get(), j + (flag ? i : i - 4) - 1));
			worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(4)), 2);
			return ActionResultType.SUCCESS;
		} else {
			return ActionResultType.FAIL;
		}
	}

	public boolean ticksRandomly(BlockState state) {
		return state.get(AGE) < 8;
	}

	@Override
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
		int i = state.get(AGE);
		if (i < 8 && worldIn.getLightSubtracted(pos.up(), 0) >= 9
				&& net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, random.nextInt(5) == 0)) {
			worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(i + 1)), 2);
			net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state);
		}

	}

	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(AGE);
	}

	/**
	 * Whether this IGrowable can grow
	 */
	public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
		return state.get(AGE) < 8;
	}

	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
		return true;
	}

	public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
		int i = Math.min(8, state.get(AGE) + 1);
		worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(i)), 2);
	}

	@Override
	protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
		Block block = state.getBlock();
		return block == Blocks.SAND || block == Blocks.RED_SAND;
	}
}
