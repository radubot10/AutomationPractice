package Tests;

import Base.SharedData;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class AlertTest extends SharedData {

    @Test
    public void TestAutomat(){

        WebElement skipSignInElement = driver.findElement(By.id("btn2"));
        skipSignInElement.click();

        WebElement switchToElement = driver.findElement(By.xpath("//a[text()='SwitchTo']"));
        Actions Action = new Actions(driver);
        Action.moveToElement(switchToElement).perform();

        WebElement alertsElement = driver.findElement(By.xpath("//a[text()='Alerts']"));
        alertsElement.click();

        driver.navigate().to("http://demo.automationtesting.in/Alerts.html");

        List<WebElement> alertOptions = driver.findElements(By.cssSelector(".nav-tabs>li>a"));
        alertOptions.get(0).click();
        WebElement alertOk = driver.findElement(By.cssSelector("#OKTab>button"));
        alertOk.click();

        Alert Ok = driver.switchTo().alert();
        Ok.accept();

        alertOptions.get(1).click();
        WebElement alertOkCancel = driver.findElement(By.cssSelector("#CancelTab>button"));
        alertOkCancel.click();
        Alert OkCancel = driver.switchTo().alert();
        OkCancel.dismiss();

        alertOptions.get(2).click();
        WebElement alertTextbox = driver.findElement(By.cssSelector("#Textbox>button"));
        alertTextbox.click();
        Alert Textbox = driver.switchTo().alert();
        Textbox.sendKeys("Cand e pauza?");
        Textbox.accept();

    }


}
