package main;

import file.WriteFile;

import formation.Formation;

import object.Group;

import javafx.event.*;

import javafx.fxml.FXML;

import javafx.scene.control.MenuItem;


public class Controller {
    @FXML
    private MenuItem huLuWaHeYi;
    @FXML
    private MenuItem huLuWaChangShe;
    @FXML
    private MenuItem huLuWaYanXing;
    @FXML
    private MenuItem huLuWaYuLin;
    @FXML
    private MenuItem huLuWaYanYue;
    @FXML
    private MenuItem huLuWaHengE;
    @FXML
    private MenuItem huLuWaFangMen;
    @FXML
    private MenuItem huLuWaFangShi;
    @FXML
    private MenuItem MonsterHeYi;
    @FXML
    private MenuItem MonsterChangShe;
    @FXML
    private MenuItem MonsterYanXing;
    @FXML
    private MenuItem MonsterYuLin;
    @FXML
    private MenuItem MonsterYanYue;
    @FXML
    private MenuItem MonsterHengE;
    @FXML
    private MenuItem MonsterFangMen;
    @FXML
    private MenuItem MonsterFengShi;

    @FXML
    void changSheFormationLoadOfCalabash(ActionEvent event) {
        Formation.setChangSheFormation(Main.getGod().getCalabashes(),
                Group.PLAYER);
    }

    @FXML
    void changSheFormationLoadOfMonster(ActionEvent event) {
        Formation.setChangSheFormation(Main.getGod().getMonsters(), Group.ENEMY);
    }

    @FXML
    void fangMenFormationLoadOfCalabash(ActionEvent event) {
        Formation.setFangMenFormation(Main.getGod().getCalabashes(),
                Group.PLAYER);
    }

    @FXML
    void fangMenFormationLoadOfMonster(ActionEvent event) {
        Formation.setFangMenFormation(Main.getGod().getMonsters(), Group.ENEMY);
    }

    @FXML
    void fengShiFormationLoadOfCalabash(ActionEvent event) {
        Formation.setFengShiFormation(Main.getGod().getCalabashes(),
                Group.PLAYER);
    }

    @FXML
    void fengShiFormationLoadOfMonster(ActionEvent event) {
        Formation.setFengShiFormation(Main.getGod().getMonsters(), Group.ENEMY);
    }

    @FXML
    void heYiFormationLoadOfCalabash(ActionEvent event) {
        Formation.setHeYiFormation(Main.getGod().getCalabashes(), Group.PLAYER);
    }

    @FXML
    void heYiFormationLoadOfMonster(ActionEvent event) {
        Formation.setHeYiFormation(Main.getGod().getMonsters(), Group.ENEMY);
    }

    @FXML
    void hengEFormationLoadOfCalabash(ActionEvent event) {
        Formation.setHengEFormation(Main.getGod().getCalabashes(), Group.PLAYER);
    }

    @FXML
    void hengEFormationLoadOfMonster(ActionEvent event) {
        Formation.setHengEFormation(Main.getGod().getMonsters(), Group.ENEMY);
    }

    @FXML
    void yanXingFormationLoadOfCalabash(ActionEvent event) {
        Formation.setYanXingFormation(Main.getGod().getCalabashes(),
                Group.PLAYER);
    }

    @FXML
    void yanXingFormationLoadOfMonster(ActionEvent event) {
        Formation.setYanXingFormation(Main.getGod().getMonsters(), Group.ENEMY);
    }

    @FXML
    void yanYueFormationLoadOfCalabash(ActionEvent event) {
        Formation.setYanYueFormation(Main.getGod().getCalabashes(), Group.PLAYER);
    }

    @FXML
    void yanYueFormationLoadOfMonster(ActionEvent event) {
        Formation.setYanYueFormation(Main.getGod().getMonsters(), Group.ENEMY);
    }

    @FXML
    void yuLinFormationLoadOfCalabash(ActionEvent event) {
        Formation.setYuLinFormation(Main.getGod().getCalabashes(), Group.PLAYER);
    }

    @FXML
    void yuLinFormationLoadOfMonster(ActionEvent event) {
        Formation.setYuLinFormation(Main.getGod().getMonsters(), Group.ENEMY);
    }

    @FXML
    void doReplay(ActionEvent event) {
        new WriteFile().wirteFile();
        System.out.println("点击了 回放按钮");
    }
}
