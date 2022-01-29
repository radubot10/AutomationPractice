package Tests;

import Base.SharedData;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;

import java.util.ArrayList;
import java.util.List;

public class WindowTest extends SharedData {

    @Test
    public void windowTest(){

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

        System.out.println("Titlul paginii: "+driver.getTitle());
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        System.out.println("Titlul paginii 2: "+driver.getTitle());

        driver.close();
        driver.switchTo().window(tabs.get(0));
        System.out.println("Titlul paginii: "+driver.getTitle());

        windowOptions.get(1).click();
        WebElement newWindow = driver.findElement(By.cssSelector("#Seperate>button"));
        newWindow.click();

        System.out.println("Titlul paginii: "+driver.getTitle());
        List<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));
        System.out.println("Titlul ferestrei 2: "+driver.getTitle());

        driver.close();
        driver.switchTo().window(windows.get(0));
        System.out.println("Titlul paginii: "+driver.getTitle());

        windowOptions.get(2).click();
        WebElement newWindowAndTab = driver.findElement(By.cssSelector("#Multiple>button"));
        newWindowAndTab.click();

        System.out.println("Titlul paginii: "+driver.getTitle());
        List<String> multipleTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(multipleTabs.get(2));
        System.out.println("Titlul ferestrei 2: "+driver.getTitle());

        driver.close();
        driver.switchTo().window(multipleTabs.get(1));
        System.out.println("Titlul paginii: "+driver.getTitle());

        driver.close();
        driver.switchTo().window(multipleTabs.get(0));
        System.out.println("Titlul paginii: "+driver.getTitle());







    }

}
