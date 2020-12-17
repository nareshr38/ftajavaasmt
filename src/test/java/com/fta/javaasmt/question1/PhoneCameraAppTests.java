package com.fta.javaasmt.question1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PhoneCameraAppTests {


    private static final Logger logger = LogManager.getLogger(PhoneCameraAppTests.class.getName());
    PhoneCameraApp basicCameraApp = new BasicCameraApp();
    PhoneCameraApp cameraPlusApp = new CameraPlusApp();


    @Test
    public void basicCameraTests() {
        String BasicCameraAppShareTextExpectedResult = "Share Photo By Text";
        String BasicCameraAppShareEmailExpectedResult = "Share Photos By Email";
        String basicCameraAppShareTextActualResult = basicCameraApp.getSharePhotos(new SharePhotosByText());
        String basicCameraAppEmailActualResult = basicCameraApp.getSharePhotos(new SharePhotosByEmail());

        Assert.assertEquals(basicCameraAppShareTextActualResult, BasicCameraAppShareTextExpectedResult);
        Assert.assertEquals(basicCameraAppEmailActualResult, BasicCameraAppShareEmailExpectedResult);
        logger.info("Expected Result of Basic Camera Application Text--> {}", BasicCameraAppShareTextExpectedResult);
        logger.info("Actual Result  of Basic Camera Application Text --> {}", basicCameraAppShareTextActualResult);

        Assert.assertEquals(basicCameraAppEmailActualResult, BasicCameraAppShareEmailExpectedResult);
        logger.info("Expected Result of Basic Camera Application Email--> {}", BasicCameraAppShareEmailExpectedResult);
        logger.info("Actual Result of Basic Camera Application Email -->{}", basicCameraAppEmailActualResult);
    }

    @Test
    public void cameraPlusAppTests() {
        String cameraPlusAppShareTextExpectedResult = "Share Photo By Text";
        String cameraPlusAppShareEmailExpectedResult = "Share Photos By Email";

        String cameraPlusAppShareTextActualResult = cameraPlusApp.getSharePhotos(new SharePhotosByText());
        String cameraPlusAppShareEmailActualResult = cameraPlusApp.getSharePhotos(new SharePhotosByEmail());

        Assert.assertEquals(cameraPlusAppShareTextActualResult, cameraPlusAppShareTextExpectedResult);
        Assert.assertEquals(cameraPlusAppShareEmailActualResult, cameraPlusAppShareEmailExpectedResult);

        logger.info("Expected Result of Camera Plus Application Text--> {}", cameraPlusAppShareTextExpectedResult);
        logger.info("Actual Result  of Camera Plus Application Text -->{}", cameraPlusAppShareTextActualResult);

        logger.info("Expected Result of Camera Plus Application Email-->{}", cameraPlusAppShareEmailExpectedResult);
        logger.info("Actual Result of Camera Plus Application Email -->{}", cameraPlusAppShareEmailActualResult);

    }

}