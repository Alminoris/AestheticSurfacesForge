package net.alminoris.aestheticsurfaces.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.swing.text.html.BlockView;

public class CofferedCeilingBlock extends WaterloggableBlock
{
    private final VoxelShape SHAPE1 = CofferedCeilingBlock.box(0, 13, 0, 1.5f, 16, 16);

    private final VoxelShape SHAPE2 = CofferedCeilingBlock.box(14.5f, 13, 0, 16, 16, 16);

    private final VoxelShape SHAPE3 = CofferedCeilingBlock.box(1.5f, 13, 14.5f, 14.5f, 16, 16);

    private final VoxelShape SHAPE4 = CofferedCeilingBlock.box(1.5f, 13, 0, 14.5f, 16, 1.5f);

    public CofferedCeilingBlock(BlockBehaviour.Properties settings)
    {
        super(settings.noOcclusion());
        this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, false));
    }

    @Override
    protected BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor world, BlockPos pos, BlockPos neighborPos)
    {
        if (direction == Direction.UP)
        {
            BlockPos supportPos = pos.offset(Direction.UP.getNormal());

            if (!world.getBlockState(supportPos).isSolidRender(world, supportPos))
            {
                if (world instanceof Level realWorld)
                {
                    realWorld.destroyBlock(pos, true);
                }
                return Blocks.AIR.defaultBlockState();
            }
        }

        return super.updateShape(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader world, BlockPos pos)
    {
        BlockPos supportPos = pos.offset(Direction.UP.getNormal());
        return world.getBlockState(supportPos).isSolidRender(world, supportPos);
    }

    @Override
    protected VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_)
    {
        return Shapes.or(SHAPE1, SHAPE2, SHAPE3, SHAPE4);
    }
}