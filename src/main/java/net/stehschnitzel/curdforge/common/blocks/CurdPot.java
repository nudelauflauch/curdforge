package nudelauflauch.curd_mod.common.blocks;

import java.util.stream.Stream;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CurdPot extends Block {
	public static final IntegerProperty LEVEL = IntegerProperty.create("level", 0, 3);;

	private static final VoxelShape SHAPE_N = Stream
			.of(Block.box(14, 4, 2, 16, 16, 14), Block.box(0, 0, 14, 2, 2, 16), Block.box(14, 0, 14, 16, 2, 16),
					Block.box(14, 0, 0, 16, 2, 2), Block.box(0, 0, 0, 2, 2, 2), Block.box(0, 2, 0, 16, 4, 16),
					Block.box(0, 4, 0, 16, 16, 2), Block.box(0, 4, 14, 16, 16, 16), Block.box(0, 4, 2, 2, 16, 14))
			.reduce((v1, v2) -> {
				return Shapes.joinUnoptimized(v1, v2, BooleanOp.OR);
			}).get();

	public CurdPot(Properties properties) {
		super(properties);
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
			if (i < 3 && item == Items.MILK_BUCKET) {
				worldIn.playSound((Player) null, pos, SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
				Funktions.dropp(state, worldIn, pos, player, handIn, hit, Items.BUCKET, true, LEVEL, i += 1);
			} else if (i == 2 && item == nudelauflauch.curd_mod.core.init.CFItemInit.SIEVE.get()) {
				worldIn.playSound((Player) null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
				Funktions.dropp(state, worldIn, pos, player, handIn, hit, nudelauflauch.curd_mod.core.init.CFItemInit.SIEVE.get(), true, LEVEL, 3);
			} else if (i == 3 && item == Items.GLASS_BOTTLE) {
				worldIn.playSound((Player) null, pos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
				Funktions.dropp(state, worldIn, pos, player, handIn, hit, nudelauflauch.curd_mod.core.init.CFItemInit.WHEY.get(), true, LEVEL, 0);
			}
		}
		return InteractionResult.SUCCESS;
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(LEVEL);
	}
}