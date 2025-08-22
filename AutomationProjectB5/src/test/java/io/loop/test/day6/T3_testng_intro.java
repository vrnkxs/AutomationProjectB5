package io.loop.test.day6;

import org.testng.Assert;
import org.testng.annotations.*;
import static org.testng.Assert.*;

public class T3_testng_intro {

    //runs in alphabetic order (unless we put priority)
    @Test(priority = 1)
    public void test2(){
        System.out.println("Test 2 is running");
        String actual = "Nina";
        String expected = "Nina";
        assertEquals(actual,expected, "Actual does NOT match expected");
    }

    @Test (priority = 2)
    public void test1(){
        System.out.println("Test 1 is running");
        String actual = "Feyruz";
        String expected = "Nadir";
        assertEquals(actual,expected, "This message will show only if test fails");
    }

    @BeforeMethod
    public void setUpMethod(){
        System.out.println("Before method is running");
    }

    @AfterMethod
    public void tearDownMethod(){
        System.out.println("After method is running");
    }

    @BeforeClass
    public void setUp(){
        System.out.println("Before class is running");
    }

    @AfterClass
    public void tearDown(){
        System.out.println("After class is running");
    }
}
