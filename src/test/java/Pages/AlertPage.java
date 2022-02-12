package Pages;

import Help.AlertMethods;
import Help.ElementMethods;
import Help.PageMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AlertPage {

    public WebDriver driver;
    public ElementMethods elementMethods;
    public AlertMethods alertMethods;

    public AlertPage(WebDriver driver){
        this.driver = driver;
        elementMethods = new ElementMethods(driver);
        alertMethods = new AlertMethods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".nav-tabs>li>a")
    public List<WebElement> alertOptionsElement;
    @FindBy(css = "#OKTab>button")
    public WebElement alertOkElement;
    @FindBy(css = "#CancelTab>button")
    public WebElement alertOkCancelElement;
    @FindBy(css = "#Textbox>button")
    public WebElement alertTextBoxElement;

    public void alertOkProcess(){
        elementMethods.clickElement(alertOptionsElement.get(0));
        elementMethods.clickElement(alertOkElement);
        alertMethods.acceptAlert();
    }

    public void alertOkCancelProcess(){
        elementMethods.clickElement(alertOptionsElement.get(1));
        elementMethods.clickElement(alertOkCancelElement);
        alertMethods.cancelAlert();
    }

    public void alertTextProcess(String value){
        elementMethods.clickElement(alertOptionsElement.get(2));
        elementMethods.clickElement(alertTextBoxElement);
        alertMethods.acceptFillAlert(value);
    }
}
