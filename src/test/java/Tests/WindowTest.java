package Tests;

import Base.SharedData;
import Help.TabWindowMethods;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;

import java.util.ArrayList;
import java.util.List;

public class WindowTest extends SharedData {

    public TabWindowMethods tabWindowMethods;

    @Test
    public void windowTest(){

        tabWindowMethods = new TabWindowMethods(driver);

        WebElement skipSignInElement = driver.findElement(By.id("btn2"));
        skipSignInElement.click();

        WebElement switchToElement = driver.findElement(By.xpath("//a[text()='SwitchTo']"));
        Actions Action = new Actions(driver);
        Action.moveToElement(switchToElement).perform();

        WebElement windowsElement = driver.findElement(By.xpath("//a[text()='Windows']"));
        windowsElement.click();

        driver.navigate().to("http://demo.automationtesting.in/Windows.html");

        List<WebElement> windowOptions = driver.findElements(By.cssSelector(".nav-tabs>li>a"));
        windowOptions.get(0).click();
        WebElement newTabOk = driver.findElement(By.cssSelector("#Tabbed>a>button"));
        newTabOk.click();

        tabWindowMethods.switchToTab(1);

        tabWindowMethods.closeCurrentTab();

        tabWindowMethods.switchToTab(0);

        windowOptions.get(1).click();
        WebElement newWindow = driver.findElement(By.cssSelector("#Seperate>button"));
        newWindow.click();

        tabWindowMethods.switchToTab(1);

        tabWindowMethods.closeCurrentTab();

        tabWindowMethods.switchToTab(0);

        windowOptions.get(2).click();
        WebElement newWindowAndTab = driver.findElement(By.cssSelector("#Multiple>button"));
        newWindowAndTab.click();

        tabWindowMethods.switchToTab(2);

        tabWindowMethods.closeCurrentTab();

        tabWindowMethods.switchToTab(1);

        tabWindowMethods.closeCurrentTab();

        tabWindowMethods.switchToTab(0);







    }

}
