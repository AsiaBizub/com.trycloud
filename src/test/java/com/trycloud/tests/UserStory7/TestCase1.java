package com.trycloud.tests.UserStory7;

import com.trycloud.test.base.TestBase;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestCase1 extends TestBase {

    @Test
    public void SearchBar(){
        WebElement searchBar = driver.findElement(By.xpath("//input[@id='searchbox']"));
        searchBar.click();
        searchBar.sendKeys("Investor Factors Agent");
        searchBar.sendKeys(Keys.ENTER);
        WebElement searchResult = driver.findElement(By.xpath("//input[@class='innernametext']"));
        System.out.println(searchResult.getText());
    }



}
