package dev.rcslabs.gigachests.datagen;


import dev.rcslabs.gigachests.GigaChests;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid= GigaChests.MOD_ID)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherClientData(GatherDataEvent.Client event){
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        BlockTagsProvider blockTagsProvider = new ModBlockTagProvider(packOutput, lookupProvider);

        //Providers
        generator.addProvider(true, blockTagsProvider);
        generator.addProvider(true, new ModRecipeProvider.Runner(packOutput, lookupProvider));
//        generator.addProvider(true, new ModModelProvider(packOutput));

    }

    @SubscribeEvent
    public static void gatherServerData(GatherDataEvent.Server event){
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();

        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        BlockTagsProvider blockTagsProvider = new ModBlockTagProvider(packOutput, lookupProvider);

        generator.addProvider(true, blockTagsProvider);
        generator.addProvider(true, new ModRecipeProvider.Runner(packOutput, lookupProvider));
//        generator.addProvider(true, new ModModelProvider(packOutput));
    }




}
