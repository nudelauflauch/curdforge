package net.stehschnitzel.curdforge.common.blocks;

import java.util.Random;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.IPlantable;
import net.stehschnitzel.curdforge.init.CFItemInit;

public class CuddlyCactus extends BushBlock implements IPlantable {
	public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 8);;
	private static final VoxelShape BUSHLING_SHAPE = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 8.0D, 13.0D);
	private static final VoxelShape GROWING_SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

	public CuddlyCactus(Properties properties) {
		super(properties);
	}

	@Override
	public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(CFItemInit.OPUNTIEN_BLOSSOM.get());
	}

	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		if (state.getValue(AGE) == 0) {
			return BUSHLING_SHAPE;
		} else {
			return GROWING_SHAPE;
		}
	}

	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn,
			BlockHitResult hit) {
		int i = state.getValue(AGE);
		boolean flag = i == 3;
		System.out.println(player.walkDist);
		if (!flag && player.getItemInHand(handIn).getItem() == Items.BONE_MEAL) {
			return InteractionResult.PASS;
		} else if (i > 4 && i == 8) {
			int j = 1 + worldIn.random.nextInt(2);
			popResource(worldIn, pos, new ItemStack(CFItemInit.OPUNTIEN_BLOSSOM.get(), j + (flag ? i : i - 4) - 2));
			popResource(worldIn, pos, new ItemStack(CFItemInit.TIBICOS.get(), j + (flag ? i : 1 - 0) - 1));
			worldIn.setBlock(pos, state.setValue(AGE, Integer.valueOf(4)), 2);
			return InteractionResult.SUCCESS;
		} else if (i > 4) {
			int j = 1 + worldIn.random.nextInt(2);
			popResource(worldIn, pos, new ItemStack(CFItemInit.OPUNTIEN_BLOSSOM.get(), j + (flag ? i : i - 4) - 1));
			worldIn.setBlock(pos, state.setValue(AGE, Integer.valueOf(4)), 2);
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.FAIL;
		}
	}

	public boolean isRandomlyTicking(BlockState state) {
		return state.getValue(AGE) < 8;
	}

    @Override
    public void randomTick(BlockState state, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
		int i = state.getValue(AGE);
		if (i < 8 && pLevel.getRawBrightness(pPos.above(), 0) >= 9
				&& net.minecraftforge.common.ForgeHooks.onCropsGrowPre(pLevel, pPos, state, pRandom.nextInt(5) == 0)) {
            pLevel.setBlock(pPos, state.setValue(AGE, Integer.valueOf(i + 1)), 2);
			net.minecraftforge.common.ForgeHooks.onCropsGrowPost(pLevel, pPos, state);
		}

	}

	@Override
	protected boolean mayPlaceOn(BlockState p_51042_, BlockGetter p_51043_, BlockPos p_51044_) {
		return p_51042_.is(BlockTags.SAND);
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(AGE);
	}

	public boolean isValidBonemealTarget(BlockGetter worldIn, BlockPos pos, BlockState state, boolean isClient) {
		return state.getValue(AGE) < 8;
	}

	public boolean isBonemealSuccess(Level worldIn, Random rand, BlockPos pos, BlockState state) {
		return true;
	}

	public void performBonemeal(ServerLevel worldIn, Random rand, BlockPos pos, BlockState state) {
		int i = Math.min(8, state.getValue(AGE) + 1);
		worldIn.setBlock(pos, state.setValue(AGE, Integer.valueOf(i)), 2);
	}

}
