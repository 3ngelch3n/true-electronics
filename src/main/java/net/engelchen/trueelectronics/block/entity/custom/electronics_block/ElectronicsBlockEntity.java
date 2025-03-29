package net.engelchen.trueelectronics.block.entity.custom.electronics_block;

import net.engelchen.trueelectronics.block.entity.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class ElectronicsBlockEntity extends BlockEntity {
    public ElectronicsBlockEntity(BlockState targetState, BlockPos block, BlockState defaultState, boolean b) {
        super(ModBlockEntities.ASSEMBLY_WORKBENCH_BLOCK_ENTITY, block, defaultState);
    }
}
