package object;

import god.God;
import god.Statu;
import javafx.scene.image.Image;
import main.Main;
import map.GameMap;
import math.MyMath;
import javafx.scene.canvas.GraphicsContext;

import java.util.List;

public class Calabash extends Creature implements Runnable{

    public Calabash () {
        setGroup(Group.PLAYER);
        setHeight(40);
        setWidth(40);
    }

    public Calabash (int x,int y,int imageIndex,boolean isAlive) {
        setGroup(Group.PLAYER);
        setHeight(40);
        setWidth(40);
        this.setX(x);
        this.setY(y);
        this.setImageIndex(imageIndex);
        this.setAlive(isAlive);
        image = new Image(getClass().getResourceAsStream("/source/c"+imageIndex+".png"));
    }
    @Override
    public void draw(GraphicsContext gContext) {
        //gContext.save();
        if (image != null) {
            gContext.drawImage(image, x*getWidth(), y*getHeight(),getWidth(),getHeight());
        }
        //gContext.restore();
    }

    synchronized public Monster getNearestMonster(List<? extends Monster> enemys) throws Exception{
        Monster monster = null;

        int size = 0;
        for(int i=0;i<enemys.size();i++){
            if(enemys.get(i).getisAlive()){
                size++;
                break;
            }
        }

        if(size>0) {
            monster = new Monster();
            monster.setX(1000);
            monster.setY(1000);
            for(int i=0;i<enemys.size();i++)
            {
                if(MyMath.getDistanceOfTwoPoint(this.getX(),this.getY(),enemys.get(i).getX(),enemys.get(i).getY())
                        <  MyMath.getDistanceOfTwoPoint(this.getX(),this.getY(),monster.getX(),monster.getY()) && enemys.get(i).getisAlive())
                    monster = enemys.get(i);
            }
            return monster;
        }
        else {

            throw new Exception("没有找到敌人");
        }

    }
    @Override
    synchronized public  void doMove() throws Exception{

        try {
            Monster monster = this.getNearestMonster(Main.getGod().getMonsters());

            int dest_x = monster.getX();
            int dest_y = monster.getY();
            int now_x = this.getX();
            int now_y = this.getY();
            int sx = now_x,sy = now_y;
            int distance = MyMath.getDistanceOfTwoPoint(now_x,now_y,dest_x,dest_y);
            int distance1 = MyMath.getDistanceOfTwoPoint(now_x,now_y-1,dest_x,dest_y);
            int distance2 = MyMath.getDistanceOfTwoPoint(now_x-1,now_y,dest_x,dest_y);
            int distance3 = MyMath.getDistanceOfTwoPoint(now_x+1,now_y,dest_x,dest_y);
            int distance4 = MyMath.getDistanceOfTwoPoint(now_x,now_y+1,dest_x,dest_y);

            if(distance3<distance && GameMap.getGameMapPoint(now_x+1,now_y) == 0) {
                distance = distance3;
                sx = now_x+1;
                sy = now_y;
            }


            if(distance1<distance && GameMap.getGameMapPoint(now_x,now_y-1) == 0) {
                distance = distance1;
                sx = now_x;
                sy = now_y-1;
            }

            if(distance2<distance && GameMap.getGameMapPoint(now_x-1,now_y) == 0) {
                distance = distance2;
                sx = now_x-1;
                sy = now_y;
            }


            if(distance4<distance && GameMap.getGameMapPoint(now_x,now_y+1) == 0) {
                distance = distance4;
                sx = now_x;
                sy = now_y + 1;
            }
            this.setLocation(sx,sy);

        }catch (Exception e) {
            throw new Exception("没有敌人，停止移动，终止线程");
        }


    }


    @Override
    public void run() {
        while(true) {
            if(this.isAlive && Main.getGod().getStatu()==Statu.PROCEED && Main.isAction()) {
                try {
                    doMove();
                }catch (Exception e) {
                    GameMap.initMapIndex();
                    Main.getGod().setStatu(Statu.WAIT);
                    System.out.println("没有敌人游戏结束");
                    Main.setAction(false);
                    God.setCalabashCanAction(false);
                    God.setMonsterCanAction(false);
                    break;
                }

                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }else {
                break;
            }

        }
    }
}
