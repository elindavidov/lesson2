package pages;

import helpers.WaitTool;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import static glue.steps.Browser.driver;

public class Partners {
    public void clickOnPartners() throws InterruptedException {
        driver.findElement(By.cssSelector("#menu-item-8581 > a")).click();
    }
       public void findPartnersUrl(String urlParam){
        WebElement url = driver.findElement(By.cssSelector("#post-8576 > article > div.entry-content > div > p:nth-child(3) > a:nth-child(2)"));
        String text = url.getText();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(text,urlParam);

    }
}
