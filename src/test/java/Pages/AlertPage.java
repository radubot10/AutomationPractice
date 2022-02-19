package Pages;

import Help.AlertMethods;
import Help.ElementMethods;
import Help.PageMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.List;

public class AlertPage extends BasePage {

    public AlertPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".nav-tabs>li>a")
    private List<WebElement> alertOptionsElement;
    @FindBy(css = "#OKTab>button")
    private WebElement alertOkElement;
    @FindBy(css = "#CancelTab>button")
    private WebElement alertOkCancelElement;
    @FindBy(css = "#Textbox>button")
    private WebElement alertTextBoxElement;

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

    public void alertTextProcess(HashMap<String, String> inputData){
        elementMethods.clickElement(alertOptionsElement.get(2));
        elementMethods.clickElement(alertTextBoxElement);
        alertMethods.acceptFillAlert(inputData.get("alertText"));
    }
}
