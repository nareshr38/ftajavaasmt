package com.fta.javaasmt.question1;


public abstract class PhoneCameraApp {
    public String getSharePhotos(SharePhotosType sharePhotosType) {
        return (sharePhotosType.sharePhoto());
    }

    public static String capturePhotos() {
        return ("Capture Photo");

    }

    public static String savePhotos() {

        return ("Save Photo");
    }

    public abstract String editPhotos();
}






