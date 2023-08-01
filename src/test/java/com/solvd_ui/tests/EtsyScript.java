package com.solvd_ui.tests;

import com.solvd_ui.pages.MainPage;
import com.solvd_ui.pages.SignInPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class EtsyScript extends EtsyBase {



    @Test
    public void validateLandingPage() {

        String expectedTitle = "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";
        String actualTitle = driver.getTitle();

        String expectedURL = "https://www.etsy.com/?ref=lgo";
        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(expectedTitle, actualTitle);
        Assert.assertEquals(expectedURL, actualURL);

    }

    @Parameters({"metaText", "instagramText", "twitterText", "pinterestText", "youTubeText"})
    @Test
    public void validateSocialMediaTexts(String metaText, String instagramText, String twitterText,
                                         String pinterestText, String youTubeText) throws InterruptedException {
        MainPage mainPage = new MainPage(driver);

        mainPage.validateSocialTexts(driver, metaText, instagramText, twitterText, pinterestText, youTubeText);

    }

    @Parameters({"email", "successText"})
    @Test
    public void validateSubscribeFunctionality(String email, String successText) throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.validateInputField(driver, email, successText);

    }

    @Test(dataProvider = "testData", dataProviderClass = DataProviders.class)
    public void negativeTestCaseSignIn(String email, String password){

        SignInPage signInPage = new SignInPage(driver);
        signInPage.signInFeature(email, password);

    }
}
