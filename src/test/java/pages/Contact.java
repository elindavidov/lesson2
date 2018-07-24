package pages;

import helpers.WaitTool;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import static glue.steps.Browser.driver;

public class Contact {

    public void verifyContact() throws InterruptedException {
        driver.findElement(By.cssSelector("#page-title > span"));
//        WaitTool.waitForElement(driver, By.cssSelector("");
        boolean isDisplayed = driver.findElement(By.cssSelector("#page-title > span")).isDisplayed();
        System.out.println("Contatcts is displayed properly");


//        Assert.assertTrue(isDisplayed);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(isDisplayed);
        softAssert.assertAll();
    }

}