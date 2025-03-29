package net.engelchen.trueelectronics.block.entity.custom.electronics_block;

import net.fabricmc.fabric.api.renderer.v1.Renderer;
import net.fabricmc.fabric.api.renderer.v1.RendererAccess;
import net.fabricmc.fabric.api.renderer.v1.material.MaterialFinder;
import net.fabricmc.fabric.api.renderer.v1.material.RenderMaterial;
import net.fabricmc.fabric.api.renderer.v1.render.*;
import net.minecraft.block.BlockState;
import net.minecraft.client.texture.Sprite;

public class CanvasHelper {
    private CanvasHelper() { }

    public static RenderMaterial getMaterial(BlockState state, Sprite sprite) {
        Renderer renderer = RendererAccess.INSTANCE.getRenderer();
        if (renderer == null) {
            throw new IllegalStateException("Kein Renderer gefunden! Stelle sicher, dass die Fabric Renderer API aktiv ist.");
        }
        MaterialFinder finder = renderer.materialFinder();
        // Je nachdem, wie du dein RenderLayer setzen möchtest, musst du den passenden Parameter angeben.
        // Hier fehlt oft noch die konkrete Methode, da sich die API-Versionen ändern können.
        // Prüfe bitte die aktuelle Dokumentation oder Beispiele im Fabric GitHub Repository.
        // Beispiel (falls unterstützt):
        // finder.blendMode(...);
        // finder.texture(sprite);
        return finder.find();
    }
}
