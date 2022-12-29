package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.AbstractPage;

public class WaitUtils {

    public static void waitForPresenceOfAllElementsLocatedByXpath(String webElementXpath, WebDriver driver) {
        new WebDriverWait(driver, AbstractPage.WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(webElementXpath)));
    }

    public static void waitForElementToBeClickable(String webElementXpath, WebDriver driver) {
        new WebDriverWait(driver, AbstractPage.WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(webElementXpath)));
    }

}
