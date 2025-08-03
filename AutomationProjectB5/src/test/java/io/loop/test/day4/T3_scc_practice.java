package io.loop.test.day4;

import io.loop.test.utilities.DocuportConstance;
import io.loop.test.utilities.GeneralConstance;
import io.loop.test.utilities.LoopCampConstance;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
    go to docuport app
    identify docuport with css
    get value of the attribute
    validate if it is "Docuport"

    the rest is home work
    locate:
    username
    password
    login
        with css
    login to docuport
    locate home icon of docuport after login or any other element after login
    validated that you logged in
     */
public class T3_scc_practice {
    public static void main(String[] args) {

        //go to the docuport url
        WebDriver driver = WebDriverUtil.getDriver(GeneralConstance.CHROME);
        driver.manage().window().maximize();
        driver.navigate().to(DocuportConstance.DOCUPORT_TEST);

        //locate the element with css
        WebElement logo = driver.findElement(By.cssSelector("img[src='/img/logo.d7557277.svg']"));

        //get value of the attribute
        String actualLogoDocuport = logo.getDomAttribute("alt");
        //String actualLogoDocuport = logo.getAttribute("alt"); - the same outcome

        System.out.println("docuport = " + actualLogoDocuport);

        //validation
        if (DocuportConstance.EXPECTED_LOGO_DOCUPORT.equals(actualLogoDocuport)) {
            System.out.println("Expected logo: \"" + DocuportConstance.EXPECTED_LOGO_DOCUPORT + "\", matches actual logo: \"" + actualLogoDocuport + "\" => TEST PASS");
        } else {
            System.out.println("Expected logo: \"" + DocuportConstance.EXPECTED_LOGO_DOCUPORT + "\", does NOT match actual logo: \"" + actualLogoDocuport + "\" => TEST FAIL");
        }

    }
}
