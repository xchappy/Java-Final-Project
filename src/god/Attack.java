package god;

import javafx.scene.image.Image;
import main.Main;
import map.GameMap;
import math.MyMath;
import object.Calabash;
import object.Monster;

import java.util.ArrayList;

public class Attack implements Runnable{
    @Override
    public void run() {
        try {
            ArrayList<Calabash> calabashes = Main.getGod().getCalabashes();
            ArrayList<Monster> monsters = Main.getGod().getMonsters();
            while (Main.getGod().getStatu() == Statu.PROCEED) {
                for (Calabash calabash : calabashes) {
                    for (Monster monster : monsters) {
                        if (MyMath.getDistanceOfTwoPoint(calabash.getX(), calabash.getY(), monster.getX(), monster.getY()) <= 1 && calabash.getisAlive() && monster.getisAlive()) {
                            //妖怪获胜
                            if (Math.random() > 0.5) {
                                GameMap.removePoint(calabash.getX(), calabash.getY());
                                calabash.setAlive(false);
                                calabash.setImage(new Image(getClass().getResourceAsStream("/source/die.png")));
                            } else {
                                GameMap.removePoint(monster.getX(), monster.getY());
                                monster.setAlive(false);
                                monster.setImage(new Image(getClass().getResourceAsStream("/source/die.png")));
                            }
                            try {
                                Thread.currentThread().sleep(500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
