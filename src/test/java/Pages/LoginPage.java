package Pages;

import Help.ElementMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //elemente
    @FindBy(css = "input[placeholder='E mail']")
    private WebElement emailElement;
    @FindBy(css = "input[placeholder='Password']")
    private WebElement passwordElement;
    @FindBy(id = "enterbtn")
    private WebElement enterElement;
    @FindBy(css = "label[id='errormsg']")
    private WebElement errorMessageElement;

    //metode
    public void fillEmail(String value){
        elementMethods.fillElement(emailElement, value);
    }

    public void fillPassword(String value){
        elementMethods.fillElement(passwordElement, value);
    }

    public void clickEnter(){
        elementMethods.clickElement(enterElement);
    }

    public void loginInvalidProcess(HashMap<String, String> inputData){
        fillEmail(inputData.get("email"));
        fillPassword(inputData.get("password"));
        clickEnter();
        elementMethods.validateElementText(errorMessageElement, inputData.get("message"));
    }
}
