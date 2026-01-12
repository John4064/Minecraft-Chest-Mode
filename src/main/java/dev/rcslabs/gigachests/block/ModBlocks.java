package dev.rcslabs.gigachests.block;

import dev.rcslabs.gigachests.GigaChests;
import dev.rcslabs.gigachests.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;
import java.util.function.Supplier;

import static net.minecraft.world.item.Items.registerBlock;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(GigaChests.MOD_ID);
    public static final DeferredRegister.Entities BLOCK_ENTITIES = DeferredRegister.createEntities(GigaChests.MOD_ID);


    public static final DeferredBlock<Block> OMEGA_CHEST = registerBlock("omega_chest",
            (properties) -> new SimpleChestBlock(properties.strength(4f).requiresCorrectToolForDrops().sound(SoundType.WOOD)));


    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SimpleChestBlockEntity>> OMEGA_CHEST_ENTITY =
            BLOCK_ENTITIES.register(
            "omega_chest",() -> new BlockEntityType<>(SimpleChestBlockEntity::new, ModBlocks.OMEGA_CHEST.get()));


    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> function) {
        DeferredBlock<T> toReturn = BLOCKS.registerBlock(name, function);
        registerBlockItem(name, toReturn);
        return toReturn;
    }


    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.registerItem(name, (properties) -> new BlockItem(block.get(), properties.useBlockDescriptionPrefix()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        BLOCK_ENTITIES.register(eventBus);
    }


}
