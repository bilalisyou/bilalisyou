package com.Baba;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class App extends Application
{
    @Override
    public void start(Stage stage) throws IOException, FileNotFoundException
    {
        Pane root = new Pane();
        Scene scene = new Scene(root, 400, 400);

        Image img = new Image(new FileInputStream("src/main/resources/img/test.jpg"));

        ImageView test = new ImageView(img);

        root.getChildren().add(test);
        stage.setTitle("baba is you");
        
        stage.setScene(scene);
        stage.show();
    }

        public static void main(String[] args)
        {
            launch(args);
        }
}
