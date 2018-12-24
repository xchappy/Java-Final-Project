package formation;
import java.util.*;

import god.God;
import main.Main;
import object.*;


public class Formation {

    static int count = 0;
    /**
     * 长蛇阵
     * @param cre
     */
    public static void setChangSheFormation (List<? extends Creature> cre,Group group) {
        if(group==Group.PLAYER) {
            Main.getGod().initCalabashes();
            God.setCalabashCanAction(true);
            for(int i=0;i<cre.size();i++) {
                cre.get(i).setLocation(4,i+5);
            }
        }else {
            Main.getGod().initMonsters();
            God.setMonsterCanAction(true);
            for(int i=0;i<cre.size();i++) {
                cre.get(i).setLocation(15,i+5);
            }
        }


    }

    /**
     * 鹤翼阵
     * @param cre
     */
    public static void setHeYiFormation (List<? extends Creature> cre,Group group) {

        if(group==Group.PLAYER) {
            Main.getGod().initCalabashes();
            God.setCalabashCanAction(true);
            cre.get(0).setLocation(6,6+2);
            cre.get(1).setLocation(6,7+2);

            cre.get(2).setLocation(5,5+2);
            cre.get(3).setLocation(5,8+2);
            cre.get(5).setLocation(4,9+2);
            cre.get(4).setLocation(4,4+2);


            cre.get(6).setLocation(3,3+2);
            cre.get(7).setLocation(3,10+2);

        }else {
            Main.getGod().initMonsters();
            God.setMonsterCanAction(true);
            cre.get(0).setLocation(13,6+2);
            cre.get(1).setLocation(13,7+2);

            cre.get(2).setLocation(14,5+2);
            cre.get(3).setLocation(14,8+2);

            cre.get(4).setLocation(15,4+2);
            cre.get(5).setLocation(15,9+2);

            cre.get(6).setLocation(16,3+2);
            cre.get(7).setLocation(16,10+2);


        }


    }

    /**
     * 雁行阵
     * @param cre
     */
    public static void setYanXingFormation (List<? extends Creature> cre,Group group) {
        if(group==Group.PLAYER) {
            Main.getGod().initCalabashes();
            God.setCalabashCanAction(true);
            for(int i=0;i<cre.size();i++) {
                cre.get(i).setLocation(8-i,3+i+2);
            }
        }else {
            Main.getGod().initMonsters();
            God.setMonsterCanAction(true);
            for(int i=0;i<cre.size();i++) {
                cre.get(i).setLocation(11+i,3+i+2);
            }
        }

    }


    /**
     * 锋矢阵
     * @param cre
     */
    public static void setFengShiFormation (List<? extends Creature> cre,Group group) {
        if(group==Group.PLAYER) {
            Main.getGod().initCalabashes();
            God.setCalabashCanAction(true);
            cre.get(0).setLocation(6,6+2);
            cre.get(1).setLocation(4,6+2);
            cre.get(2).setLocation(2,6+2);
            cre.get(3).setLocation(0,6+2);
            cre.get(4).setLocation(5,5+2);
            cre.get(5).setLocation(4,4+2);
            cre.get(6).setLocation(5,7+2);
            cre.get(7).setLocation(4,8+2);
        }else {
            Main.getGod().initMonsters();
            God.setMonsterCanAction(true);
            cre.get(0).setLocation(13,6+2);
            cre.get(1).setLocation(15,6+2);
            cre.get(2).setLocation(17,6+2);
            cre.get(3).setLocation(19,6+2);
            cre.get(4).setLocation(14,5+2);
            cre.get(5).setLocation(15,4+2);
            cre.get(6).setLocation(14,7+2);
            cre.get(7).setLocation(15,8+2);
        }

    }


    /**
     * 方门阵
     * @param cre
     */
    public static void setFangMenFormation (List<? extends Creature> cre,Group group) {
        if(group==Group.PLAYER) {
            Main.getGod().initCalabashes();
            God.setCalabashCanAction(true);
            cre.get(0).setLocation(6,6+2);
            cre.get(1).setLocation(5,5+2);
            cre.get(2).setLocation(4,4+2);
            cre.get(3).setLocation(3,5+2);
            cre.get(4).setLocation(2,6+2);
            cre.get(5).setLocation(3,7+2);
            cre.get(6).setLocation(4,8+2);
            cre.get(7).setLocation(5,7+2);
        }else {
            Main.getGod().initMonsters();
            God.setMonsterCanAction(true);
            cre.get(0).setLocation(13,6+2);
            cre.get(1).setLocation(14,5+2);
            cre.get(2).setLocation(15,4+2);
            cre.get(3).setLocation(16,5+2);
            cre.get(4).setLocation(17,6+2);
            cre.get(5).setLocation(16,7+2);
            cre.get(6).setLocation(15,8+2);
            cre.get(7).setLocation(14,7+2);
        }

    }

    /**
     * 雁月阵
     * @param cre
     */
    public static void setYanYueFormation (List<? extends Creature> cre,Group group) {
        if(group==Group.PLAYER) {
            Main.getGod().initCalabashes();
            God.setCalabashCanAction(true);
            cre.get(0).setLocation(5,8+2);
            cre.get(1).setLocation(6,9+2);
            cre.get(2).setLocation(5,5+2);
            cre.get(3).setLocation(6,4+2);
            cre.get(4).setLocation(4,6+2);
            cre.get(5).setLocation(4,7+2);
            cre.get(6).setLocation(2,7+2);
            cre.get(7).setLocation(2,6+2);
        }else {
            Main.getGod().initMonsters();
            God.setMonsterCanAction(true);
            cre.get(0).setLocation(14,8+2);
            cre.get(1).setLocation(13,9+2);
            cre.get(2).setLocation(14,5+2);
            cre.get(3).setLocation(13,4+2);
            cre.get(4).setLocation(15,6+2);
            cre.get(5).setLocation(15,7+2);
            cre.get(6).setLocation(17,7+2);
            cre.get(7).setLocation(17,6+2);
        }

    }

    /**
     * 衡轭阵
     * @param cre
     */
    public static void setHengEFormation (List<? extends Creature> cre,Group group) {
        if(group==Group.PLAYER) {
            Main.getGod().initCalabashes();
            God.setCalabashCanAction(true);
            cre.get(0).setLocation(6,3+2);
            cre.get(1).setLocation(6,5+2);
            cre.get(2).setLocation(6,7+2);
            cre.get(3).setLocation(6,9+2);
            cre.get(4).setLocation(5,4+2);
            cre.get(5).setLocation(5,6+2);
            cre.get(6).setLocation(5,8+2);
            cre.get(7).setLocation(5,10+2);
        }else {
            Main.getGod().initMonsters();
            God.setMonsterCanAction(true);
            cre.get(0).setLocation(13,3+2);
            cre.get(1).setLocation(13,5+2);
            cre.get(2).setLocation(13,7+2);
            cre.get(3).setLocation(13,9+2);
            cre.get(4).setLocation(14,4+2);
            cre.get(5).setLocation(14,6+2);
            cre.get(6).setLocation(14,8+2);
            cre.get(7).setLocation(14,10+2);
        }

    }

    /**
     * 鱼鳞阵
     * @param cre
     */
    public static void setYuLinFormation (List<? extends Creature> cre,Group group) {
        if(group==Group.PLAYER) {
            Main.getGod().initCalabashes();
            God.setCalabashCanAction(true);
            cre.get(0).setLocation(4,7+2);
            cre.get(1).setLocation(5,7+2);
            cre.get(2).setLocation(4,8+2);
            cre.get(3).setLocation(4,6+2);
            cre.get(4).setLocation(6,6+2);
            cre.get(5).setLocation(5,5+2);
            cre.get(6).setLocation(4,4+2);
            cre.get(7).setLocation(3,7+2);
        }else {
            Main.getGod().initMonsters();
            God.setMonsterCanAction(true);
            cre.get(0).setLocation(14,7+2);
            cre.get(1).setLocation(13,7+2);
            cre.get(2).setLocation(14,8+2);
            cre.get(3).setLocation(14,6+2);
            cre.get(4).setLocation(12,6+2);
            cre.get(5).setLocation(13,5+2);
            cre.get(6).setLocation(14,4+2);
            cre.get(7).setLocation(15,7+2);
        }

    }


}
