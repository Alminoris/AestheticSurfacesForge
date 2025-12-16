package net.alminoris.aestheticsurfaces.block.custom;

import net.alminoris.aestheticsurfaces.block.ModBlocks;
import net.alminoris.aestheticsurfaces.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.registries.ForgeRegistries;

public class PathBlock extends Block
{
    private final VoxelShape SHAPE = PathBlock.box(0, 0, 0, 16, 15, 16);

    public PathBlock(BlockBehaviour.Properties settings)
    {
        super(settings.noOcclusion());
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level world, BlockPos pos, Player player, BlockHitResult hit)
    {
        ItemStack stack = player.getItemInHand(InteractionHand.MAIN_HAND);

        if (!world.isClientSide && stack.is(ModTags.Items.PARQUET_CARPETS))
        {
            String woodName = ForgeRegistries.ITEMS.getKey(stack.getItem()).getPath().replace("_parquet_", "-").split("-")[1];
            String typeName = ForgeRegistries.ITEMS.getKey(stack.getItem()).getPath().replace("_parquet_", "-").split("-")[0];

            stack.shrink(1);

            world.setBlock(pos, ModBlocks.PARQUET_BLOCKS.get(woodName+"_"+typeName).get().defaultBlockState()
                    .setValue(ParquetBlock.FACING, player.getDirection()), 3);
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context)
    {
        return SHAPE;
    }

    @Override
    protected RenderShape getRenderShape(BlockState state)
    {
        return RenderShape.MODEL;
    }
}