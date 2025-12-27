package net.alminoris.aestheticsurfaces;

import com.mojang.logging.LogUtils;
import net.alminoris.aestheticsurfaces.block.ModBlocks;
import net.alminoris.aestheticsurfaces.item.ModItemGroups;
import net.alminoris.aestheticsurfaces.item.ModItems;
import net.alminoris.aestheticsurfaces.util.helper.BlockSetsHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(AestheticSurfaces.MOD_ID)
public class AestheticSurfaces
{
    public static final String MOD_ID = "aestheticsurfaces";
    private static final Logger LOGGER = LogUtils.getLogger();

    public AestheticSurfaces(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        modEventBus.addListener(this::commonSetup);

        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);

        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    private void addCreative(CreativeModeTabEvent.BuildContents entries)
    {
        if (entries.getTab() == ModItemGroups.ASURF_TAB)
        {
            for(String name : BlockSetsHelper.COLORS)
                entries.accept(ModBlocks.COFFERED_CEILINGS.get(name).get());

            for(String name : BlockSetsHelper.CEILING_TYPES)
                entries.accept(ModBlocks.SLIM_CEILINGS.get(name).get());

            for(String name : BlockSetsHelper.BRICKS_NAMES)
                entries.accept(ModBlocks.BRICKS_VENEERS.get(name).get());

            entries.accept(ModBlocks.SMOOTH_STONE_ROAD.get());

            for(String name : BlockSetsHelper.WOODS)
                for (String typeName : BlockSetsHelper.PARQUET_TYPES)
                    entries.accept(ModBlocks.PARQUET_CARPETS.get(name+"_"+typeName).get());

            if (ModList.get().isLoaded("arborealnature"))
            {
                for(String name : BlockSetsHelper.EXTRA_WOODS_AN)
                    for (String typeName : BlockSetsHelper.PARQUET_TYPES)
                        entries.accept(ModBlocks.PARQUET_CARPETS.get(name+"_"+typeName).get());
            }

            if (ModList.get().isLoaded("wildfields"))
            {
                for(String name : BlockSetsHelper.EXTRA_WOODS_WF)
                    for (String typeName : BlockSetsHelper.PARQUET_TYPES)
                        entries.accept(ModBlocks.PARQUET_CARPETS.get(name+"_"+typeName).get());
            }

            if (ModList.get().isLoaded("whisperleaftrees"))
            {
                for(String name : BlockSetsHelper.WT_WOOD_NAMES)
                    for (String typeName : BlockSetsHelper.PARQUET_TYPES)
                        entries.accept(ModBlocks.PARQUET_CARPETS.get(name+"_"+typeName).get());
            }

            if (ModList.get().isLoaded("silverwoodtrees"))
            {
                for(String name : BlockSetsHelper.ST_WOOD_NAMES)
                    for (String typeName : BlockSetsHelper.PARQUET_TYPES)
                        entries.accept(ModBlocks.PARQUET_CARPETS.get(name+"_"+typeName).get());
            }

            if (ModList.get().isLoaded("missingtrees"))
            {
                for(String name : BlockSetsHelper.MT_WOOD_NAMES)
                    for (String typeName : BlockSetsHelper.PARQUET_TYPES)
                        entries.accept(ModBlocks.PARQUET_CARPETS.get(name+"_"+typeName).get());
            }

            if (ModList.get().isLoaded("natures_spirit"))
            {
                for(String name : BlockSetsHelper.NSS_WOOD_NAMES)
                    for (String typeName : BlockSetsHelper.PARQUET_TYPES)
                        entries.accept(ModBlocks.PARQUET_CARPETS.get(name+"_"+typeName).get());
            }

            for(String name : BlockSetsHelper.COLORS)
                entries.accept(ModBlocks.WALLPAPERS.get(name).get());
            for(String name : BlockSetsHelper.COLORS)
                entries.accept(ModBlocks.SIMPLE_CARPETS.get(name).get());
            for(String name : BlockSetsHelper.COLORS)
                entries.accept(ModBlocks.SIMPLE_WALLPAPERS.get(name).get());
            for(String name : BlockSetsHelper.COLORS)
                entries.accept(ModBlocks.SIMPLE_CARPET_BLOCKS.get(name).get());
            for(String name : BlockSetsHelper.COLORS)
                entries.accept(ModBlocks.SMOOTH_CARPETS.get(name).get());
            for(String name : BlockSetsHelper.COLORS)
                entries.accept(ModBlocks.SMOOTH_WALLPAPERS.get(name).get());
            for(String name : BlockSetsHelper.COLORS)
                entries.accept(ModBlocks.SMOOTH_CARPET_BLOCKS.get(name).get());
            for(String name : BlockSetsHelper.COLORS)
                entries.accept(ModBlocks.TRANSITIONAL_CARPETS.get(name).get());
            for(String name : BlockSetsHelper.COLORS)
                entries.accept(ModBlocks.TRANSITIONAL_WALLPAPERS.get(name).get());
            for(String name : BlockSetsHelper.COLORS)
                entries.accept(ModBlocks.TRANSITIONAL_CARPET_BLOCKS.get(name).get());

            for(String name : BlockSetsHelper.WOODS)
                for (String typeName : BlockSetsHelper.PARQUET_TYPES)
                    entries.accept(ModBlocks.PARQUET_BLOCKS.get(name+"_"+typeName).get());

            if (ModList.get().isLoaded("arborealnature"))
            {
                for(String name : BlockSetsHelper.EXTRA_WOODS_AN)
                    for (String typeName : BlockSetsHelper.PARQUET_TYPES)
                        entries.accept(ModBlocks.PARQUET_BLOCKS.get(name+"_"+typeName).get());
            }

            if (ModList.get().isLoaded("wildfields"))
            {
                for(String name : BlockSetsHelper.EXTRA_WOODS_WF)
                    for (String typeName : BlockSetsHelper.PARQUET_TYPES)
                        entries.accept(ModBlocks.PARQUET_BLOCKS.get(name+"_"+typeName).get());
            }

            if (ModList.get().isLoaded("whisperleaftrees"))
            {
                for(String name : BlockSetsHelper.WT_WOOD_NAMES)
                    for (String typeName : BlockSetsHelper.PARQUET_TYPES)
                        entries.accept(ModBlocks.PARQUET_BLOCKS.get(name+"_"+typeName).get());
            }

            if (ModList.get().isLoaded("silverwoodtrees"))
            {
                for(String name : BlockSetsHelper.ST_WOOD_NAMES)
                    for (String typeName : BlockSetsHelper.PARQUET_TYPES)
                        entries.accept(ModBlocks.PARQUET_BLOCKS.get(name+"_"+typeName).get());
            }

            if (ModList.get().isLoaded("missingtrees"))
            {
                for(String name : BlockSetsHelper.MT_WOOD_NAMES)
                    for (String typeName : BlockSetsHelper.PARQUET_TYPES)
                        entries.accept(ModBlocks.PARQUET_BLOCKS.get(name+"_"+typeName).get());
            }

            if (ModList.get().isLoaded("natures_spirit"))
            {
                for(String name : BlockSetsHelper.NSS_WOOD_NAMES)
                    for (String typeName : BlockSetsHelper.PARQUET_TYPES)
                        entries.accept(ModBlocks.PARQUET_BLOCKS.get(name+"_"+typeName).get());
            }
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
