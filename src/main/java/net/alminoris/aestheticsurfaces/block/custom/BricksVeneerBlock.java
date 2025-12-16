package net.alminoris.aestheticsurfaces.block.custom;

import net.alminoris.aestheticsurfaces.util.helper.VoxelShapeHelper;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.ArrayList;
import java.util.List;

public class BricksVeneerBlock extends WallpaperBlock
{
    private static final VoxelShape SHAPE = WallpaperBlock.box(0, 0, 0, 16, 16, 2);

    public BricksVeneerBlock(BlockBehaviour.Properties settings)
    {
        super(settings);
    }

    @Override
    protected VoxelShape getRotatedShape(BlockState state)
    {
        Direction direction = state.getValue(FACING);

        List<AABB> boxes = new ArrayList<>();
        boxes.add(SHAPE.bounds());

        return VoxelShapeHelper.rotateShape(boxes, direction);
    }
}