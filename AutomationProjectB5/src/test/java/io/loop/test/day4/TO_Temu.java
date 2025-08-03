package io.loop.test.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.dnd.DragGestureEvent;

public class TO_Temu {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.etsy.com");

        WebElement searchBox = driver.findElement(By.id("global-enhancements-search-query"));
        String searchText = "wooden spoon";
        searchBox.sendKeys(searchText + Keys.ENTER);

        String expectedTitle = "Wooden spoon - Etsy";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitle)) {
            System.out.println("Actual URL " + actualTitle + ", matches expected URL: " + expectedTitle + ". => TEST PASS");
        } else {
            System.err.println("Actual URL " + actualTitle + ", DOES NOT match expected URL: " + expectedTitle + ". => TEST FAIL");
        }
    }
}
