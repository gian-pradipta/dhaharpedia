package com.example;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RumahMakanModel {
    private Connection koneksi;

    public RumahMakanModel () {
        try {
            koneksi = new Connection();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
