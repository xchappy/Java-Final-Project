package map;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public class GameMap {
    private static int[][] mapIndex = new int[14][20];

    //地图大小  800*600
    // 20 * 15
    private final int mapWidth = 20;
    private final int mapHeight = 15;
    private final int mapImageWidth = 1067;
    private final int mapImageHeight = 600;
    private final int tileWidth = 40;
    private final int tileHeight = 40;
    private Image image;

    //将map各个位置初始化为 0
    public GameMap(Image map) {
        this.image = map;
        initMapIndex();
    }

    synchronized public static void initMapIndex() {
        for (int i = 0; i < 14; i++)
            for (int j = 0; j < 20; j++)
                mapIndex[i][j] = 0;
    }

    public static void printMap() {
        for (int[] p : mapIndex) {
            for (int num : p) {
                System.out.print(num);
            }

            System.out.println();
        }
    }

    synchronized public static int getGameMapPoint(int x, int y) {
        return mapIndex[y][x];
    }

    synchronized public static void removePoint(int x, int y) {
        mapIndex[y][x] = 0;
    }

    synchronized public static void setPoint(int x, int y) {
        mapIndex[y][x] = 1;
    }

    public void drawMap(GraphicsContext gc) {
        gc.drawImage(image, 0, 0, mapImageWidth, mapImageHeight, 0, 0, 800, 600);
    }
}
