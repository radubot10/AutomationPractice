package Tests;

import Base.Hooks;
import Base.SharedData;
import Help.ElementMethods;
import Help.FrameMethods;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class FramesTest extends Hooks {

    public FrameMethods frameMethods;
    public ElementMethods elementMethods;

    @Test
    public void framesTest(){

        frameMethods = new FrameMethods(getDriver());
        elementMethods = new ElementMethods(getDriver());

        WebElement skipSignInElement = getDriver().findElement(By.id("btn2"));
        elementMethods.clickElement(skipSignInElement);

        WebElement switchToElement = getDriver().findElement(By.xpath("//a[text()='SwitchTo']"));
        Actions Action = new Actions(getDriver());
        Action.moveToElement(switchToElement).perform();

        WebElement framesElement = getDriver().findElement(By.xpath("//a[text()='Frames']"));
        elementMethods.clickElement(framesElement);

        getDriver().navigate().to("http://demo.automationtesting.in/Frames.html");

        frameMethods.switchToFrameById("singleframe");
        WebElement inputText = getDriver().findElement(By.cssSelector("div>input[type='text']"));
        inputText.sendKeys(inputData.get("singleIFrame"));

        frameMethods.switchToDefault();

        WebElement multipleIframe = getDriver().findElement(By.cssSelector("a[href='#Multiple']"));
        elementMethods.clickElement(multipleIframe);

        frameMethods.switchToFrameByElement(getDriver().findElement(By.cssSelector("iframe[src='MultipleFrames.html']")));
        frameMethods.switchToFrameByElement(getDriver().findElement(By.cssSelector("iframe[src='SingleFrame.html']")));
        WebElement inputText2 = getDriver().findElement(By.cssSelector("div>input[type='text']"));
        elementMethods.fillElement(inputText2, inputData.get("multipleIFrame"));

    }
}
