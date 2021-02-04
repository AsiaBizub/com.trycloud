package com.trycloud.tests;

import com.trycloud.tests.base.TestBase;
import com.trycloud.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class UserStory6 extends TestBase {

    //User Story 6: As a user, I should be able to access to Notes module.

    //6.1 :Set up chrome browser
    //6.2 : Get qa3
    //6.3: Login as a user



    @Test
    public void accessTalksModule () {
        // Successful Login

        //Test case #1 - verify users can access to Talks module
        //2. Click "Notes" module
        BrowserUtils.threadSleep(3);
        WebElement talkModule = driver.findElement(By.cssSelector("#appmenu > li:nth-child(4) > a"));
        talkModule.click();

        String expectedInTitle = "Talk - Trycloud";
        String actualInTitle = driver.getTitle();
        if (expectedInTitle.equals(actualInTitle)) {
            System.out.println("Title verification passed");
        } else {
            System.out.println("actualTitle = " + actualInTitle);
            System.out.println("expectedTitle = " + expectedInTitle);
        }
    }

}



/*
    @Test
    public void sendNotes () {
        //Test case #2 - verify users can send notes in the page

        //2. Click notes module
        //3. Click “New Note” button
        //4. Write a message/Note
        //5. Verify the note is added on the note list

    }

}
*/