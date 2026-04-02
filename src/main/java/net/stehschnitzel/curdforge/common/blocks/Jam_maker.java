package net.stehschnitzel.curdforge.common.blocks;

import java.util.stream.Stream;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Jam_maker extends Block {

	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

	private static final VoxelShape SHAPE_S = Stream.of(Block.box(3, 2.3000000000000003, 15, 4, 3.3000000000000003, 16),
			Block.box(1, 0, 1.0000000000000036, 15, 4, 15),
			Block.box(2, 1, 13.600000000000001, 7, 4.5, 15.600000000000001),
			Block.box(5, 2.3000000000000003, 15, 6, 3.3000000000000003, 16), Block.box(4, 4, 4, 12, 5, 12),
			Block.box(5, 4, 3.099999999999998, 11, 5, 4.099999999999998),
			Block.box(5, 4, 11.900000000000002, 11, 5, 12.900000000000002),
			Block.box(3.099999999999998, 4, 5, 4.099999999999998, 5, 11),
			Block.box(11.899999999999999, 4, 5, 12.899999999999999, 5, 11), Block.box(2, 6, 2, 14, 13, 14),
			Block.box(3, 13, 3, 13, 14, 13), Block.box(3, 5, 3, 13, 6, 13),
			Block.box(9, 14, 7.400000000000002, 10, 15, 8.400000000000002),
			Block.box(6, 15, 7.400000000000002, 10, 16, 8.400000000000002),
			Block.box(6, 14, 7.400000000000002, 7, 15, 8.400000000000002)).reduce((v1, v2) -> {
				return Shapes.joinUnoptimized(v1, v2, BooleanOp.OR);
			}).get();

	private static final VoxelShape SHAPE_W = Stream.of(Block.box(0, 2.3000000000000003, 3, 1, 3.3000000000000003, 4),
			Block.box(1, 0, 1, 14.999999999999996, 4, 15),
			Block.box(0.3999999999999986, 1, 2, 2.3999999999999986, 4.5, 7),
			Block.box(0, 2.3000000000000003, 5, 1, 3.3000000000000003, 6), Block.box(4, 4, 4, 12, 5, 12),
			Block.box(11.900000000000002, 4, 5, 12.900000000000002, 5, 11),
			Block.box(3.099999999999998, 4, 5, 4.099999999999998, 5, 11),
			Block.box(5, 4, 3.099999999999998, 11, 5, 4.099999999999998),
			Block.box(5, 4, 11.899999999999999, 11, 5, 12.899999999999999), Block.box(2, 6, 2, 14, 13, 14),
			Block.box(3, 13, 3, 13, 14, 13), Block.box(3, 5, 3, 13, 6, 13),
			Block.box(7.599999999999998, 14, 9, 8.599999999999998, 15, 10),
			Block.box(7.599999999999998, 15, 6, 8.599999999999998, 16, 10),
			Block.box(7.599999999999998, 14, 6, 8.599999999999998, 15, 7)).reduce((v1, v2) -> {
				return Shapes.joinUnoptimized(v1, v2, BooleanOp.OR);
			}).get();

	private static final VoxelShape SHAPE_E = Stream
			.of(Block.box(0, 2.3000000000000003, 3.000000000000001, 1, 3.3000000000000003, 4.000000000000001),
					Block.box(1, 0, 1, 14.999999999999996, 4, 15),
					Block.box(0.3999999999999986, 1, 2.000000000000001, 2.3999999999999986, 4.5, 7.000000000000001),
					Block.box(0, 2.3000000000000003, 5.000000000000001, 1, 3.3000000000000003, 6.000000000000001),
					Block.box(4, 4, 4.000000000000001, 12, 5, 12),
					Block.box(11.900000000000002, 4, 5.000000000000001, 12.900000000000002, 5, 11),
					Block.box(3.099999999999998, 4, 5.000000000000001, 4.099999999999998, 5, 11),
					Block.box(5, 4, 3.0999999999999988, 11, 5, 4.099999999999999),
					Block.box(5, 4, 11.899999999999999, 11, 5, 12.899999999999999), Block.box(2, 6, 2, 14, 13, 14),
					Block.box(3, 13, 3, 13, 14, 13), Block.box(3, 5, 3, 13, 6, 13),
					Block.box(7.599999999999998, 14, 9, 8.599999999999998, 15, 10),
					Block.box(7.599999999999998, 15, 6.000000000000001, 8.599999999999998, 16, 10),
					Block.box(7.599999999999998, 14, 6.000000000000001, 8.599999999999998, 15, 7.000000000000001))
			.reduce((v1, v2) -> {
				return Shapes.joinUnoptimized(v1, v2, BooleanOp.OR);
			}).get();

	private static final VoxelShape SHAPE_N = Stream.of(Block.box(3, 2.3000000000000003, 15, 4, 3.3000000000000003, 16),
			Block.box(1, 0, 1.0000000000000036, 15, 4, 15),
			Block.box(2, 1, 13.600000000000001, 7, 4.5, 15.600000000000001),
			Block.box(5, 2.3000000000000003, 15, 6, 3.3000000000000003, 16), Block.box(4, 4, 4, 12, 5, 12),
			Block.box(5, 4, 3.099999999999998, 11, 5, 4.099999999999998),
			Block.box(5, 4, 11.900000000000002, 11, 5, 12.900000000000002),
			Block.box(3.099999999999998, 4, 5, 4.099999999999998, 5, 11),
			Block.box(11.899999999999999, 4, 5, 12.899999999999999, 5, 11), Block.box(2, 6, 2, 14, 13, 14),
			Block.box(3, 13, 3, 13, 14, 13), Block.box(3, 5, 3, 13, 6, 13),
			Block.box(9, 14, 7.400000000000002, 10, 15, 8.400000000000002),
			Block.box(6, 15, 7.400000000000002, 10, 16, 8.400000000000002),
			Block.box(6, 14, 7.400000000000002, 7, 15, 8.400000000000002)).reduce((v1, v2) -> {
				return Shapes.joinUnoptimized(v1, v2, BooleanOp.OR);
			}).get();

	public Jam_maker(Properties config) {
		super(config);

		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		switch (state.getValue(FACING)) {
		case EAST:
			return SHAPE_E;
		case SOUTH:
			return SHAPE_S;
		case WEST:
			return SHAPE_W;
		default:
			return SHAPE_N;

		}
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}

	/*
	 * @Override public TileEntity createTileEntity(BlockState state, IBlockReader
	 * world) { return new TileEntityTypesInit(); }
	 * 
	 * @SuppressWarnings("deprecation")
	 * 
	 * @Override public ActionResultType onBlockActivated(BlockState state, World
	 * worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult
	 * hit) { if (!worldIn.isRemote()) { TileEntity te = worldIn.getTileEntity(pos);
	 * if (te instanceof JamMakerTileEntity) { INamedContainerProvider
	 * containerProvider = new INamedContainerProvider() {
	 * 
	 * @Override public ITextComponent getDisplayName() { return new
	 * TranslationTextComponent("screen.curd_mod.JamMaker"); }
	 * 
	 * @Override public Container createMenue(int i, PlayerInventory playerInv,
	 * PlayerEntity plyerEntity) { return new JamMakerConatainer(i, world, pos,
	 * playerInv, playerEntity); } }; NetworkHooks.openGui((ServerPlayerEntity)
	 * player, (JamMakerTileEntity) te, pos); } else { throw new
	 * IllegalStateException("Jam Maker container provider is missing!"); } } return
	 * ActionResultType.SUCCESS; }
	 */

}