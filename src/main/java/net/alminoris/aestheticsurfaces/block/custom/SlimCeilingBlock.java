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
import net.minecraft.world.phys.shapes.VoxelShape;

public class SlimCeilingBlock extends WaterloggableBlock
{
    private final VoxelShape SHAPE = SlimCeilingBlock.box(0, 15.75, 0, 16, 16, 16);

    public SlimCeilingBlock(BlockBehaviour.Properties settings)
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
    protected VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context)
    {
        return SHAPE;
    }
}