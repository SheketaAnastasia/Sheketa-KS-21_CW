package com.my;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


/**
 * головний клас проекту запускає графічний інтерфейс
 * @author Sheketa
 */

public class Application extends javafx.application.Application {

    public static void main(String... args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        System.out.println(getClass().getResource("/Application.fxml"));
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/Application.fxml")));
        primaryStage.setTitle("Sheketa");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}