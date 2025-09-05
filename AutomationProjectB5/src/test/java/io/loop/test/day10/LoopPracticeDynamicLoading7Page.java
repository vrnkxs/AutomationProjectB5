package io.loop.test.day10;

import io.loop.test.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoopPracticeDynamicLoading7Page {

    public LoopPracticeDynamicLoading7Page(){PageFactory.initElements(Driver.getDriver(),this);}
     /*
       1. go https://loopcamp.vercel.app/dynamic_loading/7.html
       2. Wait until title is “Dynamic title”
       3. Assert: Message “Done!” is displayed.
       4. Assert: Image is displayed.
     */
    @FindBy (id = "alert")
    public WebElement doneMessage;

    @FindBy (xpath = "//img[@src='/img/a-few-moments.jpg']")
    public WebElement image;

    @FindBy (xpath = "//a[@href='dynamic_loading/7.html']")
    public WebElement getDynamicLoading7;
}
