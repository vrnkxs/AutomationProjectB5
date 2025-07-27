package io.loop.test.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllLocatorsPractice {
    public static void main(String[] args) {

        //create driver object
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //navigate to loopcamp practice page
        driver.get("https://loopcamp.vercel.app/registration_form.html");

        //locate the first name
        WebElement firstName = driver.findElement(By.name("firstname"));
        //WebElement firstName = driver.findElement(By.className("form-control"));

        //first name to send
        String firstname = "Loop";
        String lastname = "Camp";

        //send keys firstname
        firstName.sendKeys(firstname);

        //send keys lastname
        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys(lastname);

        //send gender
        WebElement female = driver.findElement(By.name("gender"));
        female.click();
    }
}
