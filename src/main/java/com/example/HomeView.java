package com.example;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class HomeView {
    private ImageView user;
    private Scene scene;
    private ScrollPane center;
    private Button tambah;
    private Button top10;
    private Button kategori;
    private Parent root;

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public ScrollPane getCenter() {
        return center;
    }

    public void setCenter(ScrollPane center) {
        this.center = center;
    }

    public Button getTambah() {
        return tambah;
    }

    public void setTambah(Button tambah) {
        this.tambah = tambah;
    }

    public Button getTop10() {
        return top10;
    }

    public void setTop10(Button top10) {
        this.top10 = top10;
    }

    public Button getKategori() {
        return kategori;
    }

    public void setKategori(Button kategori) {
        this.kategori = kategori;
    }

    public Parent getRoot() {
        return root;
    }

    public void setRoot(Parent root) {
        this.root = root;
    }

    public HomeView() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("home.fxml"));
            this.root = (Parent) fxmlLoader.load();
            scene = new Scene(root, 300, 300);
            this.tambah = (Button) root.lookup("#tambah");
            this.kategori = (Button) root.lookup("#kategori");
            this.top10 = (Button) root.lookup("#top10");
            top10.setOnMouseClicked((e) -> {HomeController.top10ClickedHandler(this);});
            this.center = (ScrollPane) root.lookup("#center");
            this.user = (ImageView) root.lookup("#login");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void display() {
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.showAndWait();
    }
}
