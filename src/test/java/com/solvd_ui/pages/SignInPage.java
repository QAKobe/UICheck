package com.solvd_ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

    public SignInPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//li//button[contains(.,'Sign in')]")
    WebElement signInOnMainPage;

    @FindBy(xpath = "//input[@id='join_neu_email_field']")
    WebElement emailInputField;

    @FindBy(xpath = "//input[@id='join_neu_password_field']")
    WebElement passwordField;

    @FindBy(xpath = "//div[@class='wt-validation']//button[@type='submit']")
    WebElement signInBtn;

    public void signInFeature(String email, String password){
        signInOnMainPage.click();
        emailInputField.sendKeys(email);
        passwordField.sendKeys(password);
        signInBtn.click();
    }
}
