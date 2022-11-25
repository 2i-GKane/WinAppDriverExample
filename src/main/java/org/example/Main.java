package org.example;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Main {

    public WindowsDriver createCapabilities() {
        WindowsDriver driver = null;

        try{
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("app", "C:/Program Files/Google/Chrome/Application/chrome.exe");
            capabilities.setCapability("platformName", "Windows");
            capabilities.setCapability("deviceName", "DESKTOP-RPT5QVU");

            driver =  new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        }catch (MalformedURLException ex){
            ex.printStackTrace();
        }

        return driver;
    }

    public static void main(String[] args) {
        WindowsDriver driver = new Main().createCapabilities();

        WebElement element = driver.findElementByName("Address and search bar");
        element.sendKeys("amazon" + Keys.ENTER);
    }
}
