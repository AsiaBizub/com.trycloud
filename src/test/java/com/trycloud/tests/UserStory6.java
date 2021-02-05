package com.trycloud.tests;

import com.trycloud.tests.base.TestBase;
import com.trycloud.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class UserStory6 extends TestBase {

    //User Story 6: As a user, I should be able to access to Talks module.

    //6.1 :Set up chrome browser
    //6.2 : Get qa3
    //6.3: Login as a user



    @Test
    public void accessTalksModule () {
        // Successful Login

        //Test case #1 - verify users can access to Talks module
        //2. Click "Notes" module
        BrowserUtils.threadSleep(3);
        WebElement talkModule = driver.findElement(By.cssSelector("#appmenu > li:nth-child(5) > a"));
        talkModule.click();

        String expectedInTitle = "Talk";
        String actualInTitle = driver.getTitle();
        if (expectedInTitle.contains(actualInTitle)) {
            System.out.println("Title verification passed");
        } else {
            System.out.println("actualTitle = " + actualInTitle);
            System.out.println("expectedTitle = " + expectedInTitle);
        }
    }

}



/*
    @Test
    public void createNewConversation () {
        //Test case #2 - verify users can send star a new conversation from the Talk module

        //2. Click Talk module
        //3. Press “+” button below Talk module
        //4. Enter conversation name in the input box
        //5. Click "Add participants"
        //6. Search participants
        //7. Add participants from the list
        //8. Press "create conversation" button
        //9. Verify conversation name is in the page title
        //10. To start the call, press "Start call" button
        //11. To end the call, press "Leave call" button

    }

}
*/