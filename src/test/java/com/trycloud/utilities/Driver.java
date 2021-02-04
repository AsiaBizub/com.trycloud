package com.trycloud.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

        private Driver(){}

        private static WebDriver driver;

        public static WebDriver getDriver(){

            if (driver == null){

                String browser = ConfigurationReader.getProperty("browser");

                switch (browser){
                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver();
                        driver.manage().window().maximize();
                        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                        break;
                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        driver = new FirefoxDriver();
                        driver.manage().window().maximize();
                        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                        break;
                    default:
                        WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver();
                        driver.manage().window().maximize();
                        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                        break;
                }
            }

            //This same driver will be returned every time we call Driver.getDriver() method
            return driver;

        }

        public static void closeDriver(){
            if (driver != null){
                driver.quit();
                driver = null;
            }
        }




    }

