package io.loop.test.day2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumTest {
    public static void main(String[] args) throws InterruptedException {

        //Older version of Selenium you need to set up web driver manager
        //WebDriverManager.chromedriver().setup(); - this is coming from boni garcia

        //Setting up the driver
        WebDriver driver = new ChromeDriver();

        //maximize the window
        driver.manage().window().maximize();

        //just wait
        Thread.sleep(3000);

        //navigate the page
        driver.get("https://www.loopcamp.io");

        //just wait
        Thread.sleep(3000);

        //navigate to the page
        driver.navigate().to("https://www.google.com");

        //just wait
        Thread.sleep(3000);

        //navigate back to page
        driver.navigate().back();

        //navigate forward
        driver.navigate().forward();

        //refresh
        driver.navigate().refresh();

        //quiting the browser
        driver.quit();
    }
}
