package net.engelchen.trueelectronics.block.entity.custom.electronics_block;


import java.util.ArrayList;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;

public class StupidUtil {
    private StupidUtil() { }

    private static ArrayList<Stupid> ugg = new ArrayList<>();

    static {
        FabricLoader fl = FabricLoader.getInstance();
    }

    public static boolean canBreak(ServerPlayerEntity player, BlockPos pos) {
        for (Stupid s : ugg) {
            if (!s.canBreak(player, pos)) return false;
        }
        return true;
    }

    public static boolean canPlace(ServerPlayerEntity player, BlockPos pos) {
        for (Stupid s : ugg) {
            if (!s.canPlace(player, pos)) return false;
        }
        return true;
    }
}
