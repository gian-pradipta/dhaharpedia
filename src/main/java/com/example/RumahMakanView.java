package com.example;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class RumahMakanView {
    private int id;
    private String kategori, nama, kontak, alamat, path;
    private float rating;
    private Scene scene, undetailedScene;
    private Button rate, update, delete, body;
    private Parent root;
    private Parent undetailedRoot;


    public RumahMakanView(int id, String nama, String kategori, String kontak, String alamat, String path, float rating)
    {       this.rating = rating;
            this.id = id;
            this.nama = nama;
            this.kategori = kategori;
            this.kontak = kontak;
            this.alamat = alamat;
            this.path = path;
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("resto.fxml"));
                root = (Parent) fxmlLoader.load();
                fxmlLoader = new FXMLLoader(getClass().getResource("undetailedResto.fxml"));
                this.undetailedRoot = (AnchorPane) fxmlLoader.load();
                this.body = ((Button) undetailedRoot.lookup("#body"));
                this.rate = ((Button) root.lookup("#rate"));
                this.update = ((Button) root.lookup("#update"));
                this.delete = ((Button) root.lookup("#delete"));
                this.buildScene();
                this.buildUndetailedScene();
            }
            catch (Exception e) {
                e.printStackTrace();
            }


    }
    private void buildScene() {
            scene = new Scene(root, 500, 500);
            ((Text) root.lookup("#nama")).setText(this.nama);
            ((Text) root.lookup("#kategori")).setText(this.kategori);
            ((Text) root.lookup("#alamat")).setText(this.alamat);
            ((Text) root.lookup("#noTelp")).setText(this.kontak);
            ((Text) root.lookup("#rating")).setText(Float.toString(this.rating));
            rate.setOnMouseClicked(e -> {RumahMakanController.ulasanClickedHandler(this);});
            delete.setOnMouseClicked(e -> {RumahMakanController.deleteClickedHandler(this);});
            update.setOnMouseClicked(e -> {RumahMakanController.updateClickedHandler(this);});
    }
    public Scene getScene() {
        return scene;
    }
    public void buildUndetailedScene () {
        undetailedScene = new Scene(undetailedRoot, 500, 500);
        ((Text) undetailedRoot.lookup("#nama")).setText(this.nama);
        ((Text) undetailedRoot.lookup("#kategori")).setText(this.kategori);
        ((Text) undetailedRoot.lookup("#rating")).setText(Float.toString(this.rating));
        this.body.setOnMouseClicked(e -> {this.display();});
    }

    public void display() {
        Stage stage = new Stage();
        stage.setTitle(this.nama);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setMaximized(false);
        stage.setScene(scene);
        stage.showAndWait();
    }
    public Button getDelete() {
        return delete;
    }

    public Button getRate() {
        return rate;
    }

    public Button getUpdate() {
        return update;
    }
    public Parent getRoot() {
        return root;
    }
    public Parent getUndetailedRoot() {return undetailedRoot;}
}
