package record;

import java.io.Serializable;


public class Record implements Serializable {
    private int x;
    private int y;
    private int picIndex;
    private boolean statu;

    public Record(int x, int y, int picIndex, boolean statu) {
        this.x = x;
        this.y = y;
        this.picIndex = picIndex;
        this.statu = statu;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getPicIndex() {
        return picIndex;
    }

    public boolean isStatu() {
        return statu;
    }
}
