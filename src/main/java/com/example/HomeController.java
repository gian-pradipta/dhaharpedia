package com.example;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;

import java.sql.ResultSet;
import java.util.ArrayList;

public class HomeController {
    private static HomeModel homeModel = new HomeModel();
    private static RumahMakanView[] rmv = {new RumahMakanView(1, "Halo", "western", "alamat", "02", "a.png", 4.5f),
            new RumahMakanView(2, "Halo2", "western", "alamat", "02", "a.png", 4.5f)};


    public static void top10ClickedHandler(HomeView homeView) {
        ResultSet resultSet = homeModel.top10();
        VBox vbox = new VBox(20);
        try {
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
}
