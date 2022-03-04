package com.nopcommerce.demo;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Utils;


public class RegisterPage extends BasePage {

  WebDriver driver;
    Utils  utils;


  By female = By.className("forcheckbox");
  By firstname = By.id("FirstName");
  By lastname = By.id("LastName");
   By day = By.name("DateOfBirthDay");
   By month = By.name("DateOfBirthMonth");
   By year = By.name("DateOfBirthYear");
  By emailID = By.id("Email");
  By companyName = By.id("Company");
  By newsletter = By.id("Newsletter");
  By password = By.id("Password");
  By confirmPassword = By.id("ConfirmPassword");
  By registerButton  = By.id("register-button");
 By messageVerificationForRegistration = By.className("result");
 By isContinueButtonPresent = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[2]/a");

 public RegisterPage(WebDriver driver) {

     this.driver = driver;
     utils = new Utils(driver);
 }

 public boolean verifyContinueButton(){
     By continueButton = null;
     return driver.findElement(continueButton).isDisplayed();
 }

  public void doRegister(String name, String lname) {

      Utils.waitForElementToBeVisible(name,10);
      Utils.doClick(female);
      Utils.doSendKeys(firstname, name);
      Utils.doSendKeys(lastname, lname);
      Utils.selectValueFromDropDown((WebElement) day, "16");
      Utils.selectValueFromDropDown((WebElement) month, "September");
      Utils.selectValueFromDropDown((WebElement) year, "2000");

      String email = null;
      Utils.doSendKeys(emailID, email);
      String comp = null;
      Utils.doSendKeys(companyName, comp);
      Utils.doClick(newsletter);
      String pwd = null;
      Utils.doSendKeys(password, pwd);
      String conf = null;
      Utils.doSendKeys(confirmPassword, conf);
      Utils.doClick(registerButton);
      Utils.waitForElementToBeVisible(messageVerificationForRegistration);
      Utils.doClick(isContinueButtonPresent);


  }

}

