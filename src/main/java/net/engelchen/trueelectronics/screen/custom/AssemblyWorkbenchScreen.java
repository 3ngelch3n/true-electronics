package net.engelchen.trueelectronics.screen.custom;

import com.mojang.blaze3d.systems.RenderSystem;
import net.engelchen.trueelectronics.TrueElectronics;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.texture.Sprite;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import org.joml.Vector2d;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AssemblyWorkbenchScreen extends HandledScreen<AssemblyWorkbenchScreenHandler> {

    private List<DraggableElement> Draggable_Objects = new ArrayList<>();
    private List<DraggableElement> Available_Objects = new ArrayList<>();

    private DraggableElement currentDraggingElement = null;

    private int screenPosX;
    private int screenPosY;

    private int lastMouseX;
    private int lastMouseY;

    private Vector2d holdOffset;

    private float scale;

    private boolean mouseDown = false;
    private boolean mouseHeld = false;
    private boolean mouseUp = false;

    private float scrollAmount;

    private static final Identifier CAPACITOR_SPRITE = Identifier.of(TrueElectronics.MOD_ID, "textures/gui/custom/assembly_workbench/electronics/capacitor.png");
    private static final Identifier LAMP_SPRITE = Identifier.of(TrueElectronics.MOD_ID, "textures/gui/custom/assembly_workbench/electronics/lamp.png");
    private static final Identifier RESISTOR_SPRITE = Identifier.of(TrueElectronics.MOD_ID, "textures/gui/custom/assembly_workbench/electronics/resistor.png");
    private static final Identifier PCB_SPRITE = Identifier.of(TrueElectronics.MOD_ID, "textures/gui/custom/assembly_workbench/electronics/pcb.png");


    


    private static final Identifier BACKGROUND_SPRITE = Identifier.of("minecraft", "textures/block/light_blue_concrete_powder.png");


    public AssemblyWorkbenchScreen(AssemblyWorkbenchScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        this.x = (this.width - this.backgroundWidth) / 2;
        this.y = (this.height - this.backgroundHeight) / 2;
        scale = 1;
        screenPosX = 0;
        screenPosY = 0;
        registerObjects();
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        RenderSystem.setShaderTexture(0, BACKGROUND_SPRITE);

        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;

        context.drawTexture(BACKGROUND_SPRITE, x, y, 0, 0, backgroundWidth, backgroundHeight);
        //context.drawSprite(x, y, 0, backgroundWidth, backgroundHeight, TEXTURE);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (button == 0) {
            mouseDown = true;
            mouseHeld = true;
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        if (button == 0) {
            mouseHeld = false;
            mouseUp = true;
            if (currentDraggingElement != null) {
                currentDraggingElement = null;
            }
        }
        return super.mouseReleased(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double horizontalAmount, double verticalAmount) {
            this.scrollAmount = (float)verticalAmount;

        return true;
    }

    @Override
    protected void drawForeground(DrawContext context, int mouseX, int mouseY) {
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);  // Ensure full opacity


        if (Draggable_Objects != null) {
            for (DraggableElement element : Draggable_Objects) {
                int drawPosX = element.getPosX() - x + screenPosX;
                int drawPosY = element.getPosY() - y + screenPosY;

                var matrices = context.getMatrices();
                matrices.push();

                matrices.scale(scale, scale, 1.0f);

                float adjustedX = drawPosX / scale;
                float adjustedY = drawPosY / scale;

                RenderSystem.setShaderTexture(0, element.getSprite());
                if (currentDraggingElement != null && currentDraggingElement == element)
                {
                    RenderSystem.setShaderColor(0f, 0f, 0f, 0.25f);
                }
                else {
                    RenderSystem.setShaderColor(0f, 0f, 0f, 0.45f);
                }
                context.drawTexture(element.getSprite(), (int) adjustedX + 1, (int) adjustedY + 1, 0, 0,
                        element.getWidth(), element.getHeight());

                RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
                context.drawTexture(element.getSprite(), (int) adjustedX, (int) adjustedY, 0, 0,
                        element.getWidth(), element.getHeight());

                matrices.pop();

                if (element.isMouseOver(mouseX, mouseY, screenPosX, screenPosY, scale)) { //only if mouse is over object
                    if (mouseDown && currentDraggingElement == null) { // and if just clicked + currently not dragging smth
                        currentDraggingElement = element; //current obj is now draggable object
                        holdOffset = new Vector2d(element.getPosX() - mouseX, element.getPosY() - mouseY);
                    }
                }
            }
        }

        if (!Draggable_Objects.isEmpty()) {
            TrueElectronics.LOGGER.info(Draggable_Objects.get(0).getPosX() + "   " + Draggable_Objects.get(0).getPosY());
        }

        if (currentDraggingElement != null) {
        //    currentDraggingElement.setPos((int) (mouseX - holdOffset.x - currentDraggingElement.getWidth()*scale / 2 - screenPosX),
        //            (int) (mouseY - holdOffset.y - currentDraggingElement.getHeight()*scale / 2 - screenPosY));
            currentDraggingElement.setPos((int) (mouseX - screenPosX + holdOffset.x),
                    (int) (mouseY - screenPosY + holdOffset.y));

        }
        else if(mouseHeld) {
            screenPosX -= lastMouseX - mouseX;
            screenPosY -= lastMouseY - mouseY;
        }

        if (scrollAmount != 0) {
            scale = Math.clamp((scale + scrollAmount), 1f, 4f);
        }

        mouseDown = false;
        mouseUp = false;
        scrollAmount = 0;
        lastMouseX = mouseX;
        lastMouseY = mouseY;


        /*RenderSystem.setShaderTexture(0, APPLE);  // Set the texture
        int imageX = 16;
        int imageY = 16;

        //int posX = mouseX - x - imageX/2;
        //int posY = mouseY - y - imageY/2;
        posX = 20;
        posY = 20;

        // Draw the apple texture with the appropriate size
        context.drawTexture(APPLE, posX, posY, 0, 0, imageX, imageY);
        // Optionally, add a debug log to check if the method is called
        //System.out.println("Drawing foreground at (" + x + ", " + y + ")");
        //System.out.println("Drawing SIZE (" + backgroundWidth + ", " + backgroundHeight + ")");
        //System.out.println("MOUSE (" + mouseX + ", " + mouseY + ")");*/
    }

    private void registerObjects() {
        Draggable_Objects.clear();
        Available_Objects.clear();
        Available_Objects.add(new DraggableElement(RESISTOR_SPRITE, 0, 0, 8, 8, null, null));
        Available_Objects.add(new DraggableElement(PCB_SPRITE, 0, 0, 14, 11, null, Arrays.asList(new Vector2d(4, 1), new Vector2d(10, 7), new Vector2d(2, 6), new Vector2d(10, 3))));
        Available_Objects.add(new DraggableElement(LAMP_SPRITE, 0, 0, 6, 12, Arrays.asList(new Vector2d(1, 11), new Vector2d(4, 10)), null));
        Available_Objects.add(new DraggableElement(CAPACITOR_SPRITE, 0, 0, 4, 11, Arrays.asList(new Vector2d(0, 10), new Vector2d(3, 9)), null));


    }


    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }
}
