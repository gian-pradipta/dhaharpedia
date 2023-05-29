package com.example;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.util.ArrayList;

public class HomeController {

    private static SimpleStringProperty user = new SimpleStringProperty("Guest");
    private static HomeModel homeModel = new HomeModel();
    private static RumahMakanView[] rmv = {new RumahMakanView(1, "Halo", "western", "alamat", "02", "a.png", 4.5f),
            new RumahMakanView(2, "Halo2", "western", "alamat", "02", "a.png", 4.5f)};


    public static void tambahListener () {
        user.addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                System.out.println("Login berhasil");
                System.out.println(RumahMakanController.rmList.size());
                RumahMakanController.disableAllRMButton();
            }
        });
    }
    public static void top10ClickedHandler(HomeView homeView) {
        ResultSet resultSet = homeModel.top10();
        VBox vbox = new VBox(20);
        try {
            RumahMakanController.rmList = new ArrayList<>();
            while (resultSet.next()) {
                int id_restoran = resultSet.getInt("id_restoran");
                String nama_restoran = resultSet.getString("nama_restoran");
                String kategori = resultSet.getString("nama_kategori");
                String alamat_restoran = resultSet.getString("alamat_restoran");
                String no_telp = resultSet.getString("no_telp");
                String path = resultSet.getString("path");
                float rating = resultSet.getFloat("rating_angka");
                RumahMakanView rm = new RumahMakanView(id_restoran, nama_restoran, kategori, alamat_restoran, no_telp, path, rating);
                vbox.getChildren().add(rm.getUndetailedRoot());
                RumahMakanController.rmList.add(rm);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        homeView.getCenter().setContent(vbox);
    }

    public static void top10clickHandler(HomeView hm) {
        VBox vbox = new VBox();
        for (RumahMakanView rm : rmv ) {
            vbox.getChildren().add(rm.getUndetailedRoot());
        }
        hm.getCenter().setContent(vbox);

    }

    public static void login () {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HomeController.class.getResource("login.fxml"));
        try
        {
            Parent root = (Parent) fxmlLoader.load();
            TextField nama = ((TextField) root.lookup("#no_hp"));
            TextField password = ((TextField) root.lookup("#password"));
            Button signin = (Button) root.lookup("#signin");
            signin.setOnMouseClicked(e -> {
                boolean isValid = false;
                for (User user : Data.users) {
                    if (user.validation(nama.getText(), password.getText())) {
                        HomeController.user.set(nama.getText());
                        isValid = true;
                        stage.close();
                        break;
                    }
                }
                if (!isValid)
                    Util.alertMessage("Gagal", "Login gagal!");
            });
            Scene scene = new Scene(root, 700, 500);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
