package com.nopcommerce.tests;

import base.BasePage;
import com.nopcommerce.demo.RegisterPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.Properties;

public class RegisterPageTest {
    WebDriver driver;
    BasePage basePage;
    Properties prop;
    RegisterPage registerPage;


    @BeforeMethod
    public void launchBrowser() throws IOException {
         basePage = new BasePage();// to initialise properties created base page object

       prop = basePage.initialiseProperties(); // returning to prop class reference

       String browser =  prop.getProperty("browser"); // created veriable
       driver =  basePage.initialiseDriver(browser);

      driver.get(prop.getProperty("url"));

        registerPage = new RegisterPage(driver);
    }

//    @Test (priority = 1)
//    public void getPageTitle(){
//        Assert.assertArrayEquals(registerPage.getPageTitle(), new String[]{"nopCommerce demo store. Register"} , new String[]{"Register page title not correct"});
//
//    }
//    @Test(priority = 2)
//    public boolean verifyContinueButton(){
//     Assert.assertTrue("continue button is not display", registerPage.verifyContinueButton());
//        return false;
//    }

  @Test(priority = 1)
    public void registerPageTest(){
       registerPage.doRegister(prop.getProperty("female"), "select female radio button");
       registerPage.doRegister(prop.getProperty("name"),prop.getProperty("lname"));
       registerPage.doRegister(prop.getProperty("day"), prop.getProperty("month"));
       registerPage.doRegister(prop.getProperty("year"), prop.getProperty("newsletter") );
      registerPage.doRegister(prop.getProperty("email"), prop.getProperty("comp"));
      registerPage.doRegister(prop.getProperty("pwd"), prop.getProperty("conf"));
    }
    @AfterMethod
    public void tearDown(){

        driver.quit();
    }

}
