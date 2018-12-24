package god;

import javafx.application.Platform;
import javafx.scene.image.Image;
import main.Main;
import map.GameMap;
import map.MapCanvas;
import math.MyMath;
import object.*;
import record.Record;


import java.util.ArrayList;

public class God {
    private Calabash[] arrayCalabash = new Calabash[8];
    private Monster[] arrayMonster = new Monster[8];

    private ArrayList<Calabash>	calabashes	= new ArrayList<>();
    private ArrayList<Monster>	monsters	= new ArrayList<>();

    private Statu statu = Statu.WAIT;

    private boolean isRunning	= true;
    private long	sleep		= 100;

    private static boolean calabashCanAction = false;

    private static boolean monsterCanAction = false;

    private ArrayList<ArrayList<Record> > frameRecord = new ArrayList<>();

    private MapCanvas mapCanvas;

    public void removeFrameRecord()
    {
        frameRecord.clear();
    }


    synchronized public Statu getStatu()
    {
        return statu;
    }


    public void setStatu( Statu statu )
    {
        this.statu = statu;
    }


    public ArrayList<ArrayList<Record> > getFrameRecord()
    {
        return frameRecord;
    }


    public static boolean isCalabashCanAction()
    {
        return calabashCanAction;
    }


    public static boolean isMonsterCanAction()
    {
        return monsterCanAction;
    }


    public static void setCalabashCanAction( boolean calabashCanAction )
    {
        God.calabashCanAction = calabashCanAction;
    }


    public static void setMonsterCanAction( boolean monsterCanAction )
    {
        God.monsterCanAction = monsterCanAction;
    }


    public void removeCreatures() {
        for ( Calabash cal : calabashes ) {
            GameMap.removePoint( cal.getX(), cal.getY() );
        }
        for ( Monster mon : monsters ) {
            GameMap.removePoint( mon.getX(), mon.getY() );
        }
        monsters.clear();
        calabashes.clear();
    }


    public void initCalabashes() {
        for ( Calabash cal : calabashes ) {
            GameMap.removePoint( cal.getX(), cal.getY() );
        }
        calabashes.clear();
        for ( int i = 0; i < arrayCalabash.length; i++ ) {
            arrayCalabash[i] = new Calabash();
            arrayCalabash[i].setImageIndex( i + 1 );
            Image image = new Image( getClass().getResourceAsStream( "/source/c" + (i + 1) + ".png" ) );
            arrayCalabash[i].setImage( image );
        }
        for ( Calabash calabash : arrayCalabash ) {
            calabashes.add( calabash );
        }
    }




    public void initMonsters() {
        for (Monster mon : monsters ) {
            GameMap.removePoint( mon.getX(), mon.getY() );
        }
        monsters.clear();
        for ( int i = 0; i < arrayMonster.length; i++ ) {
            arrayMonster[i] = new Monster();
            arrayMonster[i].setImageIndex( i + 9 );
            Image image = new Image( getClass().getResourceAsStream( "/source/Monster" + (i + 9) + ".png" ) );
            arrayMonster[i].setImage( image );
        }
        for ( Monster monster : arrayMonster ) {
            monsters.add( monster );
        }
    }


    public God() {
        mapCanvas = new MapCanvas( 800, 600 );
        thread.start();
    }


    public void initCreatureThread() {
        for ( Monster bsp : monsters ) {
            Thread thread1 = new Thread( bsp );
            thread1.start();
        }
        for ( Calabash bsp : calabashes ) {
            Thread thread1 = new Thread( bsp );
            thread1.start();
        }
    }


    synchronized public void doAttack() {
        for ( Calabash calabash : calabashes ) {
            for ( Monster monster : monsters ) {
                if ( MyMath.getDistanceOfTwoPoint( calabash.getX(), calabash.getY(), monster.getX(), monster.getY() ) <= 1 && calabash.getisAlive() && monster.getisAlive() ) {
                    /* 妖怪获胜 */

                    if ( Math.random() > 0.5 ) {
                        GameMap.removePoint( calabash.getX(), calabash.getY() );
                        calabash.setAlive( false );
                    }else {
                        GameMap.removePoint( monster.getX(), monster.getY() );
                        monster.setAlive( false );
                    }

                    try {
                        Thread.currentThread().sleep( 300 );
                    }catch ( InterruptedException e ) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    public MapCanvas getMapCanvas() {
        return mapCanvas;
    }


    public ArrayList<Calabash> getCalabashes() {
        return calabashes;
    }


    public ArrayList<Monster> getMonsters() {
        return monsters;
    }


    public void drawMap() {
        mapCanvas.getGameMap().drawMap(mapCanvas.getgContext());
    }


    public void drawPlayer() {
        for ( Calabash player : calabashes ) {
            if ( player.getisAlive() == false )
                player.draw( mapCanvas.getgContext() );
        }
        for ( Monster enemy : monsters ) {
            if ( enemy.getisAlive() == false )
                enemy.draw( mapCanvas.getgContext() );
        }

        for ( Calabash player : calabashes ) {
            if ( player.getisAlive() == true )
                player.draw( mapCanvas.getgContext() );
        }
        for ( Monster enemy : monsters ) {
            if ( enemy.getisAlive() == true )
                enemy.draw( mapCanvas.getgContext() );
        }

        if ( Main.getGod().getStatu() == Statu.PROCEED ) {
            ArrayList<Record> records = new ArrayList<>();
            for ( Calabash player : calabashes ) {
                records.add( new Record( player.getX(), player.getY(), player.getImageIndex(), player.getisAlive() ) );
            }
            for ( Monster enemy : monsters ) {
                records.add( new Record( enemy.getX(), enemy.getY(), enemy.getImageIndex(), enemy.getisAlive() ) );
            }
            frameRecord.add( records );
        }
    }


    private Thread thread = new Thread(new Runnable() {

        @Override
        public void run() {
            while (isRunning) {
                Platform.runLater(new Runnable() {

                    @Override
                    public void run() {
                        drawMap();
                        drawPlayer();
                    }
                });
                try {
                    Thread.sleep(sleep);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    });

}
