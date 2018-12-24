package main;

import file.ReadFile;
import file.Replay;

import formation.Formation;

import god.Attack;
import god.God;
import god.Statu;

import object.Group;

import java.io.File;

import javafx.application.Application;

import javafx.event.EventHandler;

import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;

import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class Main extends Application {
    private static God god;
    private static boolean isAction = false;

    public static God getGod() {
        return god;
    }

    synchronized public static void setAction(boolean action) {
        isAction = action;
    }

    public static boolean isAction() {
        return isAction;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        god = new God();
        Formation.setYanYueFormation(god.getCalabashes(), Group.PLAYER);
        Formation.setFengShiFormation(god.getMonsters(), Group.ENEMY);

        root.getChildren().add(god.getMapCanvas());

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("葫芦娃大战妖精  战斗/Space   回放/L");
        primaryStage.setScene(scene);
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                System.out.println(god.getStatu());

                if ((event.getCode() == KeyCode.SPACE) && !isAction &&
                        God.isCalabashCanAction() &&
                        God.isMonsterCanAction()) {
                    setAction(true);
                    god.setStatu(Statu.PROCEED);
                    god.removeFrameRecord();
                    god.initCreatureThread();

                    Thread thread = new Thread(new Attack());
                    thread.start();
                } else if ((event.getCode() == KeyCode.L) &&
                        (god.getStatu() == Statu.WAIT)) {
                    Stage stage = null;
                    FileChooser fileChooser = new FileChooser();
                    fileChooser.setTitle("Open Resource File");

                    File file = fileChooser.showOpenDialog(stage);
                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                new Replay().replay(ReadFile.readFile(
                                        file.getPath()));
                                Main.getGod().setStatu(Statu.WAIT);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });

                    if (file.exists()) {
                        thread.start();
                    }
                }
            }
        });
        primaryStage.setResizable(false);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
