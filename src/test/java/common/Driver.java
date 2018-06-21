package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    public static WebDriver driver;

    public static void initialiseDriver(){

        System.setProperty("webdriver.gecko.driver","src/test/java/drivers/geckodriver.exe");

        driver = new FirefoxDriver();
    }
}
