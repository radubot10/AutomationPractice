package Pages;

import Help.ElementMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public WebDriver driver;
    public ElementMethods elementMethods;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        elementMethods = new ElementMethods(driver);
        PageFactory.initElements(driver,this);
    }

    //elemente
    @FindBy(css = "input[placeholder='E mail']")
    public WebElement emailElement;
    @FindBy(css = "input[placeholder='Password']")
    public WebElement passwordElement;
    @FindBy(id = "enterbtn")
    public WebElement enterElement;
    @FindBy(css = "label[id='errormsg']")
    public WebElement errorMessageElement;

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

    public void loginInvalidProcess(String email, String password, String error){
        fillEmail(email);
        fillPassword(password);
        clickEnter();
        elementMethods.validateElementText(errorMessageElement, error);
    }
}
