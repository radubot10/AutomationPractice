package Pages;

import Help.ElementMethods;
import Help.PageMethods;
import Help.TabWindowMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WindowPage {

    public WebDriver driver;
    public ElementMethods elementMethods;
    public TabWindowMethods tabWindowMethods;

    public WindowPage(WebDriver driver){
        this.driver = driver;
        elementMethods = new ElementMethods(driver);
        tabWindowMethods = new TabWindowMethods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".nav-tabs>li>a")
    public List<WebElement> windowOptionsElement;
    @FindBy(css = "#Tabbed>a>button")
    public WebElement newTabElement;
    @FindBy(css = "#Seperate>button")
    public WebElement newWindowElement;
    @FindBy(css = "#Multiple>button")
    public WebElement newWindowTabElement;

    public void newTabProcess(){
        windowOptionsElement.get(0).click();
        elementMethods.clickElement(newTabElement);

        tabWindowMethods.switchToTab(1);
        tabWindowMethods.closeCurrentTab();
        tabWindowMethods.switchToTab(0);
    }

    public void newWindowProcess(){
        windowOptionsElement.get(1).click();
        elementMethods.clickElement(newWindowElement);

        tabWindowMethods.switchToTab(1);
        tabWindowMethods.closeCurrentTab();
        tabWindowMethods.switchToTab(0);
    }

    public void multipleTabsProcess(){
        windowOptionsElement.get(2).click();
        elementMethods.clickElement(newWindowTabElement);

        tabWindowMethods.switchToTab(2);
        tabWindowMethods.closeCurrentTab();
        tabWindowMethods.switchToTab(1);
        tabWindowMethods.closeCurrentTab();
        tabWindowMethods.switchToTab(0);
    }
}
