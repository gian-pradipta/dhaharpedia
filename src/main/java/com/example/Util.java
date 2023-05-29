package com.example;

import javafx.event.Event;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Util {

    public static void alertMessage(String title, String message) {
        VBox container = new VBox(20);
        container.setAlignment(Pos.CENTER);
        Text messageText = new Text(message);
        container.getChildren().add(messageText);
        Scene scene = new Scene(container, 200, 200);
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(scene);
        stage.showAndWait();

    }
    public static void exitConfirm(Event e){
        Stage stage = new Stage();
        Button yes, no;

        VBox containerExitConfirm = new VBox(20);
        containerExitConfirm.setAlignment(Pos.CENTER);
        Text confirmationText = new Text("Do you want to exit?");
        yes = new Button("yes");
        no = new Button("No");
        HBox containerButton = new HBox(30);
        containerButton.setAlignment(Pos.CENTER);
        containerButton.getChildren().addAll(yes, no);
        containerExitConfirm.getChildren().addAll(confirmationText, containerButton);
        Scene scene = new Scene(containerExitConfirm, 200, 200);
        stage.setScene(scene);
        stage.setOnCloseRequest(ev -> {e.consume();});
        yes.setOnMouseClicked(ev -> {
            stage.close();
        });
        no.setOnMouseClicked(ev -> {
            e.consume();
            stage.close();

        });
        stage.setTitle("Exit ?");
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }
}
