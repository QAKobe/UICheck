package com.solvd_ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class MainPage {



    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(.,'Facebook')]")
    WebElement metaLogo;

    @FindBy(xpath = "//a[contains(.,'Instagram')]")
    WebElement instagramLogo;

    @FindBy(xpath = "//a[contains(.,'Twitter')]")
    WebElement twitterLogo;

    @FindBy(xpath = "//a[contains(.,'Pinterest')]")
    WebElement pinterestLogo;

    @FindBy(xpath = "//a[contains(.,'Youtube')]")
    WebElement youTubeLogo;

    @FindBy(css = "input[id='email-list-signup-email-input']")
    WebElement inputFieldSubscribe;

    @FindBy(xpath = "//button[contains(.,'Subscribe')]")
    WebElement subscribeBtn;

    @FindBy(xpath = "//div[contains(.,'successfully signed up!')]")
    List<WebElement> allTexts;

    public void validateSocialTexts(WebDriver driver, String metaLogo, String instagramLogo, String twitterLogo,
                                    String pinterestLogo, String youTubeLogo) throws InterruptedException {
        Thread.sleep(4000);
        Actions actions = new Actions(driver);
        actions.scrollByAmount(3000, 3000).build().perform();
        Assert.assertEquals(this.metaLogo.getText(), metaLogo);
        Assert.assertEquals(this.instagramLogo.getText(), instagramLogo);
        Assert.assertEquals(this.twitterLogo.getText(), twitterLogo);
        Assert.assertEquals(this.pinterestLogo.getText(), pinterestLogo);
        Assert.assertEquals(this.youTubeLogo.getText(), youTubeLogo);
    }

    public void validateInputField(WebDriver driver, String email, String successText) throws InterruptedException {

        Actions actions = new Actions(driver);
        actions.scrollByAmount(3000, 3000).build().perform();
        inputFieldSubscribe.sendKeys(email);
        subscribeBtn.click();
        Thread.sleep(3000);
        for (int i = 0; i < allTexts.size(); i++) {

            if (allTexts.get(i).getText().equalsIgnoreCase(successText)){
                Assert.assertEquals(allTexts.get(i).getText().trim(), successText);
                System.out.println(allTexts.get(i).getText()); // for debugging purpose
                break;
            }

        }
    }



}
