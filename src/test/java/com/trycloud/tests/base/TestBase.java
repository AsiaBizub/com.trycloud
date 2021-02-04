package com.trycloud.tests.base;

import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    public WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("url"));
        driver.findElement(By.linkText("Login")).click();
        WebElement userName = driver.findElement(By.id("user"));
        WebElement password = driver.findElement(By.id("password"));
        userName.click();
        userName.sendKeys(ConfigurationReader.getProperty("username1"));
        password.sendKeys(ConfigurationReader.getProperty("password"));
        driver.findElement(By.id("submit")).click();
    }
    @AfterMethod
    public void tearDown(){
        //  driver.close();
    }
}