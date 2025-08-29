package io.loop.test.day8;

import io.loop.test.base.TestBase;
import io.loop.test.utilities.DocuportConstance;
import io.loop.test.utilities.DocuportUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.time.Duration;
import static org.testng.Assert.assertEquals;

public class T5_webTables extends TestBase {
 /*
    1. login as an advisor
    2. go to users
    3. validate that full name for alex.de.souza@gmail.com is Alex De Souza
    4. validate that user name for alex.de.souza@gmail.com is alexdesouze
    5. validate that phone number for alex.de.souza@gmail.com is +994512060042
    6. validate that role for alex.de.souza@gmail.com is client
    7. validate that advisor for alex.de.souza@gmail.com is  Batch1 Group1
 */

    @Test
    public void test_webTables() throws InterruptedException {
        DocuportUtils.login(driver, DocuportConstance.ADVISOR);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement users = driver.findElement(By.xpath("//span[contains(text(),'Users')]"));
        users.click();

        String expectedFullName = "AAlex De Souza";
        String actualFullName = DocuportUtils.returnAnyFieldFromTable(driver, "alex.de.souza@gmail.com", "Full name");
        assertEquals(actualFullName, expectedFullName, "Actual does not match expected");

        String expectedUsername = "alexdesouze";
        String actualUsername = DocuportUtils.returnAnyFieldFromTable(driver, "alex.de.souza@gmail.com", "Username");
        assertEquals(actualUsername, expectedUsername, "Actual does not match expected");

        String expectedInviter = "";
        String actualInviter = DocuportUtils.returnAnyFieldFromTable(driver, "alex.de.souza@gmail.com", "Inviter");
        assertEquals(actualInviter, expectedInviter, "Actual does not match expected");

        String expectedPhoneNumber = "+994512060042";
        String actualPhoneNumber = DocuportUtils.returnAnyFieldFromTable(driver, "alex.de.souza@gmail.com", "Phone number");
        assertEquals(actualPhoneNumber, expectedPhoneNumber, "Actual does not match expected");

        String expectedRole = "Client";
        String actualRole = DocuportUtils.returnAnyFieldFromTable(driver, "alex.de.souza@gmail.com", "Role");
        assertEquals(actualRole, expectedRole, "Actual does not match expected");

        String expectedAdvisor = "advisor advisor";
        String actualAdvisor = DocuportUtils.returnAnyFieldFromTable(driver, "alex.de.souza@gmail.com", "Advisor");
        assertEquals(actualAdvisor, expectedAdvisor, "Actual does not match expected");

        System.out.println("actualFullName: " + actualFullName);
    }
}
