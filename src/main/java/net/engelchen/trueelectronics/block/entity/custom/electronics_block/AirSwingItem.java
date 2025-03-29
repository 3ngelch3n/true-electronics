package net.engelchen.trueelectronics.block.entity.custom.electronics_block;

import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.ItemStack;

public interface AirSwingItem {
    void airSwing(ClientPlayerEntity player, ItemStack stack);
}
