package dev.rcslabs.gigachests.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class SimpleChestBlockEntity extends BlockEntity implements MenuProvider {

    private final NonNullList<ItemStack> items = NonNullList.withSize(27, ItemStack.EMPTY);

    public SimpleChestBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityType.CHEST, pos, state);
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Simple Chest");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, Inventory playerInv, Player player) {
        return ChestMenu.threeRows(id, playerInv, new SimpleContainer(items.toArray(ItemStack[]::new)));
    }
}

