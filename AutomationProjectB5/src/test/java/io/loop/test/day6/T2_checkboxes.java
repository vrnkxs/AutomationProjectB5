package io.loop.test.day6;

import io.loop.test.utilities.GeneralConstance;
import io.loop.test.utilities.LoopCampConstance;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class T2_checkboxes {
    public static void main(String[] args) {
        /*
        1. Go to http://the-internet.herokuapp.com/checkboxes
        2. Confirm checkbox #1 is NOT selected by default
        3. Confirm checkbox #2 is SELECTED by default.
        4. Click checkbox #1 to select it.
        5. Click checkbox #2 to deselect it.
        6. Confirm checkbox #1 is SELECTED.
        7. Confirm checkbox #2 is NOT selected.
         */

        //get the driver, navigate to the page
        WebDriver driver = WebDriverUtil.getDriver(GeneralConstance.CHROME);
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        driver.manage().window().maximize();

        //inplicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //creat a web element checkbox1
        WebElement checkbox1 = driver.findElement(By.xpath("//input/following-sibling::text()[contains(.,'checkbox 1')]/preceding-sibling::input"));
        //WebElement checkbox1 = driver.findElement(By.xpath("//input/following-sibling::text()[contains(.,'checkbox 1')]"));

        // //input[@type='checkbox' and following-sibling::text()[contains(.,'checkbox 1')]]
        // //input[@type='checkbox' and normalize-space(following-sibling::text())='checkbox 2']
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@type='checkbox' and normalize-space(following-sibling::text())='checkbox 2']"));

        // 2. Confirm checkbox #1 is NOT selected by default
        if (!checkbox1.isSelected()){
            System.out.println("Checkbox 1 is NOT selected");
        } else {
            System.out.println("Checkbox 1 is selected");
        }

        checkbox1.click();

        if (!checkbox1.isSelected()){
            System.out.println("Checkbox 1 is NOT selected");
        } else {
            System.out.println("Checkbox 1 is selected");
        }
    }
}
