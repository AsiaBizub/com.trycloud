package com.trycloud.tests;

import com.trycloud.test.base.TestBase;
import com.trycloud.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UserStory7 extends TestBase {

    //  Test case #7 - verify users can upload a file inside a folder

    //   1.Login as a valid user
    @Test
    public void login() {

        driver.get(ConfigurationReader.getProperty("url"));
        driver.findElement(By.linkText("Login")).click();
        WebElement userName = driver.findElement(By.id("user"));
        WebElement password = driver.findElement(By.id("password"));
        userName.sendKeys(ConfigurationReader.getProperty("username1"));
        password.sendKeys(ConfigurationReader.getProperty("password"));
        driver.findElement(By.id("submit")).click();


    }

    @Test
    public void uploadFile() throws InterruptedException {
        login();

        //   2. Choose a folder from the page

        WebElement folder = driver.findElement(By.linkText("User story 7"));
        folder.click();

        //   3.Click the “+” icon on top

        driver.findElement(By.xpath("//a[@class='button new']")).click();

        // 4.Click “upload file”

//WebElement upload =driver.findElement(By.xpath("//label[@class='menuitem']//span[2]"));
//upload.click();
//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//upload.sendKeys("/Users/newuser/Downloads/13 - Exit Ticket 5 English.pdf");
////upload.click();

     //   NOT UPLOADING THE FILE

//    WebDriverWait wait = new WebDriverWait(driver, 15, 100);
//    upload = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"controls\"]/div[2]/div[2]/ul/li[1]/label")));
//    upload.sendKeys("/Users/newuser/Downloads/13 - Exit Ticket 5 English.pdf");

      // Tried adding text file

//WebElement text= driver.findElement(By.xpath("//*[@id=\"controls\"]/div[2]/div[2]/ul/li[3]/a/span[2]"));
//text.click();
//driver.findElement(By.xpath("//input[@id='view29-input-file']")).sendKeys("Asta's folder",Keys.ENTER);
//Thread.sleep(4000);
//WebElement writing = driver.findElement(By.xpath("//*[@id=\"editor\"]"));
//writing.click();

    //  Failing when trying to write the text

//writing.sendKeys("testing 1..2..3");
//    Thread.sleep(4000);
//    driver.findElement(By.xpath("//button[@id='editor_close']")).click();

     //  Adding new Folder

        WebElement newFolder = driver.findElement(By.xpath("//*[@id=\"controls\"]/div[2]/div[2]/ul/li[2]/a/span[2]"));
        newFolder.click();
        driver.findElement(By.xpath("//*[@id=\"view29-input-folder\"]")).sendKeys("1111", Keys.ENTER);
    }

  /*






    5.Upload a file
    6.Verify the file is displayed on the page
   */
}
