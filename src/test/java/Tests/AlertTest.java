package Tests;

import Base.SharedData;
import Help.AlertMethods;
import Help.ElementMethods;
import Help.PageMethods;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AlertTest extends SharedData {

    public ElementMethods elementMethods;
    public PageMethods pageMethods;
    public AlertMethods alertMethods;

    @Test
    public void TestAutomat(){

        elementMethods = new ElementMethods(driver);
        pageMethods = new PageMethods(driver);
        alertMethods = new AlertMethods(driver);

        WebElement skipSignInElement = driver.findElement(By.id("btn2"));
        elementMethods.clickElement(skipSignInElement);

        WebElement switchToElement = driver.findElement(By.xpath("//a[text()='SwitchTo']"));
        elementMethods.moveToElement(switchToElement);

        WebElement alertsElement = driver.findElement(By.xpath("//a[text()='Alerts']"));
        elementMethods.clickElement(alertsElement);

        pageMethods.NavigateToURL("http://demo.automationtesting.in/Alerts.html");

        List<WebElement> alertOptions = driver.findElements(By.cssSelector(".nav-tabs>li>a"));
        alertOptions.get(0).click();
        WebElement alertOk = driver.findElement(By.cssSelector("#OKTab>button"));
        alertOk.click();

        alertMethods.acceptAlert();

        alertOptions.get(1).click();
        WebElement alertOkCancel = driver.findElement(By.cssSelector("#CancelTab>button"));
        alertOkCancel.click();
        alertMethods.cancelAlert();

        alertOptions.get(2).click();
        WebElement alertTextbox = driver.findElement(By.cssSelector("#Textbox>button"));
        alertTextbox.click();
        alertMethods.acceptFillAlert("Test");

    }


}
