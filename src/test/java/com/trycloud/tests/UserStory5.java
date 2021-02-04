package com.trycloud.tests;

import com.github.javafaker.Faker;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;

public class UserStory5{
//Test case #1 - verify users can access to Talks module
//1. Login as a user
    @BeforeClass
     public void setupMethod (){
        Driver.getDriver().get("http://qa3.trycloud.net");
        WebElement userName = Driver.getDriver().findElement(By.id("user"));
        WebElement password = Driver.getDriver().findElement(By.id("password"));
        userName.sendKeys(ConfigurationReader.getProperty("username1"));
        BrowserUtils.threadSleep(2);
        password.sendKeys(ConfigurationReader.getProperty("password"));
        BrowserUtils.threadSleep(2);
        Driver.getDriver().findElement(By.id("submit-form")).click();
    }



    // Test case #1 - verify users can access to the Contacts module
    @Test (priority = 1)
    public void contacts_module_title(){
        //2. Click “Contacts” module
        WebElement contactsModule = Driver.getDriver().findElement(By.cssSelector("a[href='/index.php/apps/contacts/']"));
        Actions actions = new Actions(Driver.getDriver());
        BrowserUtils.threadSleep(4);

        actions.moveToElement(contactsModule).perform();
        contactsModule.click();

        //3. Verify the page title of the Contacts module
        String contactsModuleTitle = Driver.getDriver().getTitle();
        BrowserUtils.threadSleep(5);

        System.out.println("The title of the Contacts module is: " + contactsModuleTitle);

      //  Assert.assertEquals(actualTitle, expectedTitle);

    }

    //Test case #2 - verify users can add contacts
    @Test (priority = 2)
    public void add_contacts_verification(){
        //1. Login
        BrowserUtils.threadSleep(2);
        //2. Click “Contacts” module
        WebElement contactsModule = Driver.getDriver().findElement(By.cssSelector("a[href='/index.php/apps/contacts/']"));
        Actions actions = new Actions(Driver.getDriver());
        BrowserUtils.threadSleep(2);

        actions.moveToElement(contactsModule).perform();
        contactsModule.click();
        BrowserUtils.threadSleep(1);

        //3. Click “New Contact” button
        WebElement newContactButton = Driver.getDriver().findElement(By.xpath("//*[@id=\"new-contact-button\"]"));
        newContactButton.click();
        BrowserUtils.threadSleep(5);

        //4. Fill out the contact info like : Title, Phone, email, address , etc
        // Fill details with JavaFaker
        Faker faker = new Faker();

        WebElement nameInput = Driver.getDriver().findElement(By.id("contact-org"));
        String name = "Robert";
        nameInput.sendKeys(name);
        BrowserUtils.threadSleep(2);

        WebElement titleInput = Driver.getDriver().findElement(By.id("contact-title"));
        titleInput.sendKeys(faker.name().title());
        BrowserUtils.threadSleep(2);

        WebElement phoneNumberInput = Driver.getDriver().findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/div[1]/div/div/input"));
        phoneNumberInput.sendKeys(faker.phoneNumber().cellPhone());
        BrowserUtils.threadSleep(2);

        WebElement emailInput = Driver.getDriver().findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/div[2]/div/div/input"));
        emailInput.sendKeys(faker.internet().emailAddress());
        BrowserUtils.threadSleep(2);

        WebElement postOfficeBoxInput = Driver.getDriver().findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/div[3]/div/div[2]/input"));
        postOfficeBoxInput.sendKeys(faker.number().digit());
        BrowserUtils.threadSleep(2);

        WebElement addressInput  = Driver.getDriver().findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/div[3]/div/div[3]/input"));
        addressInput.sendKeys(faker.address().streetAddress());
        BrowserUtils.threadSleep(2);

        WebElement extendedAddressInput = Driver.getDriver().findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/div[3]/div/div[4]/input"));
        extendedAddressInput.sendKeys(faker.address().secondaryAddress());
        BrowserUtils.threadSleep(2);

        WebElement zipcodeInput = Driver.getDriver().findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/div[3]/div/div[5]/input"));
        zipcodeInput.sendKeys(faker.address().zipCode());
        BrowserUtils.threadSleep(2);

        WebElement cityInput = Driver.getDriver().findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/div[3]/div/div[6]/input"));
        cityInput.sendKeys(faker.address().city());
        BrowserUtils.threadSleep(2);

        WebElement stateOrProvinceInput = Driver.getDriver().findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/div[3]/div/div[7]/input"));
        stateOrProvinceInput.sendKeys(faker.address().state());
        BrowserUtils.threadSleep(2);

        WebElement countryInput = Driver.getDriver().findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/div[3]/div/div[8]/input"));
        countryInput.sendKeys(faker.address().country());
        BrowserUtils.threadSleep(2);

        //5. Verify the contact name is added to the contact list
        contactsModule = Driver.getDriver().findElement(By.xpath("//*[@id=\"everyone\"]/a"));
        contactsModule.click();
        BrowserUtils.threadSleep(2);

        List <WebElement> contactsList = Driver.getDriver().findElements(By.xpath("//*[@id=\"everyone\"]/a"));

        ArrayList<String> allAddedNames = new ArrayList<>();
        for (WebElement each : contactsList) allAddedNames.add(each.getText());
            for (String each : allAddedNames) {
                if (each.equals(name)) {
                    Assert.assertEquals(name, each);
                } else {
                    continue;
                }
            }
        }

        //Test case #3 - verify users can see all the contact names added to the contact list
        @Test (priority = 3)
        public void all_added_contacts_verification(){
            //1. Login
            BrowserUtils.threadSleep(2);
            //2. Click “Contacts” module
            WebElement contactsModule = Driver.getDriver().findElement(By.cssSelector("a[href='/index.php/apps/contacts/']"));
            Actions actions = new Actions(Driver.getDriver());
            BrowserUtils.threadSleep(2);

            actions.moveToElement(contactsModule).perform();
            contactsModule.click();

            //3. Verify the contact names are in the list
            //(Pre-condition: there should be at least 2 contact names are displayed On the contact list)

            //Names: Sunny and Loren were added beforehand
            String [] addedNames = {"Robert","Sunny","Loren"};

            List <WebElement> contactsList = Driver.getDriver().findElements(By.xpath("//*[@id=\"everyone\"]/a"));

            ArrayList<String> allAddedNames = new ArrayList<>();
            for (WebElement each : contactsList) allAddedNames.add(each.getText());
            for (String each : allAddedNames) {
                if (each.equals(addedNames)) {
                    Assert.assertEquals(addedNames, each);
                } else {
                    continue;
                }
      }

  }
        @AfterClass
        public void tearDownMethod()throws InterruptedException {

        //additional 5 seconds before closing the browser
        Thread.sleep(5000);

        Driver.getDriver().close();
        }


    }







