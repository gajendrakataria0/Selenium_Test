package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Utilities {

    public static WebDriver browser(String browserName) {
        WebDriver driver;

        //Calling the chrome webdriver
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Gajendra Kataria\\eclipse-java-2021-06-R-win32-x86_64\\Selenium stuff\\chromedriver.exe");
            driver = new ChromeDriver();

            return driver;

            //Calling the Firefox webdriver
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\Gajendra Kataria\\eclipse-java-2021-06-R-win32-x86_64\\Selenium stuff\\drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
            return driver;

            //Else condition(Currently calling the chrome webdriver)
        } else {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Gajendra Kataria\\eclipse-java-2021-06-R-win32-x86_64\\Selenium stuff\\chromedriver.exe");
            driver = new ChromeDriver();
            return driver;
        }

    }
}
