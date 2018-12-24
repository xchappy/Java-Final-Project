package object;

import map.GameMap;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.*;


/**
 * 基本的抽象生物类继承自java基类 Object
 * 生物类有一些基本的属性 坐标 是否存活 所属阵营 图像
 */
public abstract class Creature {
    protected int width;
    protected int height;
    protected int x;
    protected int y;
    protected boolean isAlive = true;
    protected Group group;
    protected Image image;
    protected int imageIndex;

    public abstract void draw(GraphicsContext gContext);

    public abstract void doMove() throws Exception;

    public int getImageIndex() {
        return imageIndex;
    }

    synchronized public void setImageIndex(int imageIndex) {
        this.imageIndex = imageIndex;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    synchronized public void setLocation(int x, int y) {
        GameMap.removePoint(this.getX(), this.getY());
        setX(x);
        setY(y);
        GameMap.setPoint(x, y);
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Group getGroup() {
        return group;
    }

    public boolean getisAlive() {
        return isAlive;
    }

    synchronized public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public int getX() {
        return x;
    }

    synchronized public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    synchronized public void setY(int y) {
        this.y = y;
    }
}
