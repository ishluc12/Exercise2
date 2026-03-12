package DriverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static WebDriver initializeDriver(){
        String browser = System.getProperty("browser", "edge").toLowerCase();
        WebDriver webDriver;
        switch (browser){
            case "chrome":
                webDriver = WebDriverManager.chromedriver().create();
                break;
            case "firefox":
                webDriver = WebDriverManager.firefoxdriver().create();
                break;
            case "edge":
                webDriver = WebDriverManager.edgedriver().create();
                break;
            default:
                throw new IllegalArgumentException("Unknown browser: " + browser);
        }
        webDriver.manage().window().maximize();
        driver.set(webDriver);
        return webDriver;
    }


    public static WebDriver getDriver(){
        return driver.get();
    }
    public static void quitDriver(){
        if (driver.get()!=null){
            driver.get().quit();
            driver.remove();
        }
    }
}
