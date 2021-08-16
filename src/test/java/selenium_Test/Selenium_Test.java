package selenium_Test;

import selenium_Test.*;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class Selenium_Test {

    WebDriver driver;

    @Test
    public void Test1() throws InterruptedException {

        String place = "Southbank, Melbourne, Victoria, Australia";
        String Selectedmonth = "October";
        String Selectedyear = "2021";

        WebElement hplace = driver.findElement(By.xpath("//input[@class='c-autocomplete__input sb-searchbox__input sb-destination__input']"));
        WebElement month_year = driver.findElement(By.xpath("//div[@class='bui-calendar__content']/div[2]"));
        WebElement NextButton = driver.findElement(By.xpath("//div[@class='bui-calendar__control bui-calendar__control--next']"));

        hplace.sendKeys(place);

        //Looking for the calender
        driver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[2]/div[1]/div[2]/div/div/div/div/span"));

        //Validating the month and year
        String monthYearval = month_year.getText();
        System.out.println(monthYearval);

        //Splitting month and year and storing them into 2 different variables
        String month = monthYearval.split(" ")[0].trim();
        String year = monthYearval.split(" ")[1].trim();

        //Checking if month nd year are equals to the expected month and year
        while (!(month.equalsIgnoreCase(Selectedmonth) && year.equals(Selectedyear))) {

            //Click next button to get expected month and year
            NextButton.click();

            //Get month and year
            monthYearval = driver.findElement(By.xpath("//div[@class='bui-calendar__content']/div/div[@class='bui-calendar__month']")).getText();
            System.out.println(monthYearval);

            month = monthYearval.split(" ")[0].trim();
            year = monthYearval.split(" ")[1].trim();
        }

        //Getting the check-in date
        driver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[2]/div[2]/div/div/div[3]/div[1]/table/tbody/tr[3]/td[2]/span")).click();
        Thread.sleep(1000);

        //Getting the checkout date
        driver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[2]/div[2]/div/div/div[3]/div[1]/table/tbody/tr[3]/td[4]")).click();

        //Click to update the business Trip
        driver.findElement(By.xpath("//form[@id=\"frm\"]/div[2]/label")).click();

        //Submit the request
        driver.findElement(By.xpath("//button[@class='sb-searchbox__button ']")).click();

        //Getting the room price
        String price = driver.findElement(By.xpath("//*[@id=\"hotellist_inner\"]/div[1]/div[2]/div[3]/div/div/div/div/div[2]/div[1]/div[2]/div/span")).getText();
        System.out.println("The Room is for : " + price);

        //Reserve the room
        driver.findElement(By.xpath("//*[@id=\"hotellist_inner\"]/div[1]/div[2]/div[3]/div/div/div/div/div[2]/div[2]/div/div/div/a/span")).click();


    }

	@BeforeMethod

    public void setUp() {
        driver = Utils.Utilities.browser("chrome");
        driver.get("https://www.booking.com/district/au/melbourne/cbd.en-gb.html");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
