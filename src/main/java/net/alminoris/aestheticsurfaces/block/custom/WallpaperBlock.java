package net.alminoris.aestheticsurfaces.block.custom;

import net.alminoris.aestheticsurfaces.util.helper.VoxelShapeHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.ArrayList;
import java.util.List;

public class WallpaperBlock extends YAxisRotatedBlock
{
    private static final VoxelShape SHAPE = WallpaperBlock.box(0, 0, 0, 16, 16, 1);

    public WallpaperBlock(BlockBehaviour.Properties settings)
    {
        super(settings);
    }

    @Override
    public RenderShape getRenderShape(BlockState state)
    {
        return RenderShape.MODEL;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context)
    {
        return getRotatedShape(state);
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor world, BlockPos pos, BlockPos neighborPos)
    {
        Direction facing = state.getValue(FACING);
        if (direction == facing)
        {
            BlockPos supportPos = pos.offset(facing.getNormal());

            if (world.getBlockState(supportPos).isAir())
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

    protected VoxelShape getRotatedShape(BlockState state)
    {
        Direction direction = state.getValue(FACING);

        List<AABB> boxes = new ArrayList<>();
        boxes.add(SHAPE.bounds());

        return VoxelShapeHelper.rotateShape(boxes, direction);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos)
    {
        Direction facing = state.getValue(FACING);
        BlockPos supportPos = pos.offset(facing.getNormal());
        return !world.getBlockState(supportPos).isAir();
    }
}