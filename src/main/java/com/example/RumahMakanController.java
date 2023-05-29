package com.example;


public class RumahMakanController {
    private static RumahMakanModel model = new RumahMakanModel();


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

    public static void getTop10 () {

    }
}
