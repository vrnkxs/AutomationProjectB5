package io.loop.test.day3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Navigate to Google search
 * maximize the page
 * get title of the page
 * get url of the page
 * validate the title, expected title is "Google"
 * validate the url of the page, expected url is "https://www.google.com/"
 * close the browser
 */

/// in selenium 3 we had to set up the driver, for that we need webdriver manager libraries
// WebDriverManager.chromedriver().setup();

// create the driver object

public class GoogleSearch {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        //navigate to google
        //driver.get();
        driver.navigate().to("https://www.google.com");

        //maximize
        driver.manage().window().maximize();

        //expected
        String expectedTitle = "Google";

        //actual title
        String actualTitle = driver.getTitle();

        //validation
        if (actualTitle.contains(expectedTitle)) {
            System.out.println("Actual title: " + actualTitle + ", matches expected title: " + expectedTitle + ". => TEST PASS");
        } else {
            System.err.println("Actual title: " + actualTitle + ", DOES NOT match expected title: " + expectedTitle + ". => TEST FAIL");
        }

        //expected URL
        String expectedURL = "https://www.google.com";

        //actual URL
        String actualURL = driver.getCurrentUrl();

        if (actualURL.contains(expectedURL)) {
            System.out.println("Actual URL " + actualURL + ", matches expected URL: " + expectedURL + ". => TEST PASS");
        } else {
            System.err.println("Actual URL " + actualURL + ", DOES NOT match expected URL: " + expectedURL + ". => TEST FAIL");
        }

        driver.quit();
    }
}
