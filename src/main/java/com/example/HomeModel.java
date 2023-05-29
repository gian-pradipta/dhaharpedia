package com.example;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class HomeModel {
    private Connection koneksi;

    public HomeModel() {
        try{
            koneksi = new Connection();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int insertRumahMakan(String nama, String kategori, String kontak,String alamat, String path)
    {
        try
        {
            String query = "INSERT INTO restoran (nama_restoran, kategori_restoran, alamat_restoran, no_telp, path )" +
                    "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = koneksi.getPreparedStatement(query);
            String[] array = {null, nama, kategori, alamat, kontak, path};
            for (int i = 1; i < array.length; i++) {
                preparedStatement.setString(i, array[i]);
            }
            preparedStatement.execute();
            preparedStatement = koneksi.getPreparedStatement("SELECT MAX(id) FROM restoran");
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getInt("id");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public ResultSet top10() {
        String sql = "SELECT * FROM `restoran` natural join user_rating natural join kategori order by rating_angka DESC limit 10;";
        try {
            return (koneksi.executeQuery(sql));
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
