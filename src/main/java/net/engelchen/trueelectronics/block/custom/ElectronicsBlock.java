package net.engelchen.trueelectronics.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager.Builder;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

public class ElectronicsBlock extends Block implements BlockEntityProvider, Waterloggable {

    public static final MapCodec<AssemblyWorkbenchBlock> CODEC = AssemblyWorkbenchBlock.createCodec(AssemblyWorkbenchBlock::new);

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    public static final IntProperty LIGHT_LEVEL = IntProperty.of("light_level", 0, 16);

    public ElectronicsBlock(Settings settings) {
        super(settings);
        this.setDefaultState(stateManager.getDefaultState().with(LIGHT_LEVEL, 0).with(Properties.WATERLOGGED, false));
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return null;
    }
}