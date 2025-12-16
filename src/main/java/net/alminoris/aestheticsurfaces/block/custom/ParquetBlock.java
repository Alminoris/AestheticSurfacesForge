package net.alminoris.aestheticsurfaces.block.custom;

import net.alminoris.aestheticsurfaces.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class ParquetBlock extends YAxisRotatedBlock
{
    public ParquetBlock(BlockBehaviour.Properties settings)
    {
        super(settings);
    }

    @Override
    public void destroy(LevelAccessor world, BlockPos pos, BlockState state)
    {
        super.destroy(world, pos, state);

        if (!world.isClientSide())
        {
            world.setBlock(pos, ModBlocks.SMOOTH_STONE_ROAD.get().defaultBlockState(), 3);
        }
    }
}