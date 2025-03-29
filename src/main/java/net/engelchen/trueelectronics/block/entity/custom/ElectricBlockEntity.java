package net.engelchen.trueelectronics.block.entity.custom;

import net.engelchen.trueelectronics.block.entity.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;
import org.joml.Math;
import org.joml.Vector3d;
import org.joml.Vector3i;

import java.util.HashMap;
import java.util.Map;

public class ElectricBlockEntity extends BlockEntity {
    private byte[][][] cableArray = new byte[16][16][16];

    private int timer;

    public ElectricBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.ELECTRIC_BLOCK_ENTITY, pos, state);
        //super(ModBlockEntities.ORE_PROCESSING_UNIT_BLOCK_ENTITY, pos, state) ;

        for (int x = 0; x < 16; x++) {
            for (int y = 0; y < 16; y++) {
                for (int z = 0; z < 16; z++) {
                    double rand = 100*(Math.random());
                    if (rand <= 95)
                    {
                        cableArray[x][y][z] = 0; // Luft (0)
                    } else if (rand <= 100) {
                        cableArray[x][y][z] = (byte) (Math.round(rand)-95);
                    }
                }
            }
        }

    }


    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        //Inventories.writeNbt(nbt, inventory, registryLookup);
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        //Inventories.readNbt(nbt, inventory, registryLookup);
    }


    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
        return createNbt(registryLookup);
    }


    public void setCable(byte[][][] newCableArray) {
        cableArray = newCableArray;
    }

    public void setCableFillAll(int type) {
        for (int x = 0; x < 16; x++) {
            for (int y = 0; y < 16; y++) {
                for (int z = 0; z < 16; z++) {
                    cableArray[x][y][z] = (byte) type;
                }
            }
        }
    }

    public void setCableAt(int x, int y, int z, int type) {
        if (x >= 0 && x < 16 && y >= 0 && y < 16 && z >= 0 && z < 16) {
            cableArray[x][y][z] = (byte) type;
        }
    }

    public byte getCableAt(int x, int y, int z) {
        return cableArray[x][y][z];
    }

    public byte[][][] getCable() {
        return cableArray;
    }


}