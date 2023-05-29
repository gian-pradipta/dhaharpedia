package com.example;


import java.util.ArrayList;

public class RumahMakanController {
    private static RumahMakanModel model = new RumahMakanModel();
    public static ArrayList<RumahMakanView> rmList = new ArrayList<>();

    public static void disableButton() {

    }

    public static void ulasanClickedHandler(RumahMakanView rm) {
        System.out.println("Ulasan clicked");
        rm.getRate().setDisable(true);
    }
    public static void deleteClickedHandler(RumahMakanView rm) {
        System.out.println("Delete Clicked");
        rm.getDelete().setDisable(true);
    }
    public static void updateClickedHandler(RumahMakanView rm) {
        System.out.println("Update clicked");
        rm.getUpdate().setDisable(true);
    }

    public static void disableAllRMButton () {
        for (int i = 0; i < rmList.size(); i++) {
            rmList.get(i).getUpdate().setDisable(true);
            rmList.get(i).getDelete().setDisable(true);
            rmList.get(i).getRate().setDisable(true);
        }
    }
}
