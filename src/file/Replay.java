package file;

import god.Statu;
import javafx.scene.image.Image;
import main.Main;
import object.Calabash;
import object.Monster;
import record.Record;

import java.util.ArrayList;

public class Replay implements Runnable{
    public void replay(ArrayList<ArrayList<Record>>  re) {
        Main.getGod().setStatu(Statu.REPLAY);
        Main.getGod().removeCreatures();
        ArrayList<Record> arrayList_record = re.get(0);
        for(int i=0;i<arrayList_record.size();i++){
            Record record = arrayList_record.get(i);
            if(record.getPicIndex()<9){
                Calabash calabash = new Calabash(record.getX(),record.getY(),record.getPicIndex(),record.isStatu());
                Main.getGod().getCalabashes().add(calabash);
            }else
            {
                Monster monster = new Monster(record.getX(),record.getY(),record.getPicIndex(),record.isStatu());
                Main.getGod().getMonsters().add(monster);
            }
        }

        for(int i=1;i<re.size();i++)
        {
            ArrayList<Record> status = re.get(i);
            for(int j=0;j<status.size();j++){
                Record record = status.get(j);
                for(int p=0;p<Main.getGod().getCalabashes().size();p++)
                {
                    if(record.getPicIndex() == Main.getGod().getCalabashes().get(p).getImageIndex()){
                        Main.getGod().getCalabashes().get(p).setX(record.getX());
                        Main.getGod().getCalabashes().get(p).setY(record.getY());
                        if(Main.getGod().getCalabashes().get(p).getisAlive() != record.isStatu()){
                            Main.getGod().getCalabashes().get(p).setAlive(record.isStatu());
                            Main.getGod().getCalabashes().get(p).setImage(new Image(getClass().getResourceAsStream("/source/die.png")));
                        }
                        continue;
                    }
                }
                for(int p=0;p<Main.getGod().getMonsters().size();p++)
                {
                    if(record.getPicIndex() == Main.getGod().getMonsters().get(p).getImageIndex()){
                        Main.getGod().getMonsters().get(p).setX(record.getX());
                        Main.getGod().getMonsters().get(p).setY(record.getY());
                        if(Main.getGod().getMonsters().get(p).getisAlive() != record.isStatu()){
                            Main.getGod().getMonsters().get(p).setAlive(record.isStatu());
                            Main.getGod().getMonsters().get(p).setImage(new Image(getClass().getResourceAsStream("/source/die.png")));
                        }
                        continue;
                    }
                }

            }


            try {
                Thread.sleep(200);
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    @Override
    public void run() {

    }
}
