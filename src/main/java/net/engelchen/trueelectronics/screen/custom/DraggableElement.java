package net.engelchen.trueelectronics.screen.custom;

import net.minecraft.client.texture.Sprite;
import net.minecraft.util.Identifier;
import org.joml.Vector2d;

import java.util.List;

public class DraggableElement {

    private boolean draggable;
    private int posX;
    private int posY;
    private int width;
    private int height;
    private Identifier sprite;
    private List<Vector2d> connection_pos;
    private List<Vector2d> available_connection_pos;

    public DraggableElement(Identifier sprite, int posX, int posY, int width, int height, List<Vector2d> connection_pos, List<Vector2d> available_connection_pos) {

        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        this.sprite = sprite;
        this.connection_pos = connection_pos;
        this.available_connection_pos = available_connection_pos;
    }

    public Identifier getSprite() {
        return sprite;
    }


    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public List<Vector2d> getConnection_pos() {
        return connection_pos;
    }

    public List<Vector2d> getAvailable_connection_pos() {
        return available_connection_pos;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setSprite(Identifier sprite) {
        this.sprite = sprite;
    }

    public void setPos(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isMouseOver(int mouseX, int mouseY, int offsetX, int offsetY, float scale) {
        return mouseX >= posX + offsetX && mouseX <= posX + offsetX + width*scale && mouseY >= posY + offsetY && mouseY <= posY + offsetY + height*scale;
    }
}
