package com.trycloud.utilities;

public class BrowserUtils {
    public static void threadSleep (int second){
        second *= 1000;
        try{
            Thread.sleep(second);
        }catch(InterruptedException e){
            System.out.println("Sleep method working");
        }
    }
}
