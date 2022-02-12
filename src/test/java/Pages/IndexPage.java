package Pages;

import Help.ElementMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {

    public WebDriver driver;
    public ElementMethods elementMethods;

    public IndexPage(WebDriver driver){
        this.driver=driver;
        elementMethods = new ElementMethods(driver);
        PageFactory.initElements(driver,this);
    }

    //elemente
    @FindBy(id = "btn1")
    public WebElement signInElement;
    @FindBy(id = "btn2")
    public WebElement skipSignInElement;

    //metode
    public void clickSignIn(){
        elementMethods.clickElement(signInElement);
    }

    public void clickSkipSignIn(){
        elementMethods.clickElement(skipSignInElement);
    }
}
