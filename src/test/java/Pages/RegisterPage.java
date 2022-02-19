package Pages;

import Help.ElementMethods;
import Help.PageMethods;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.List;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[text()='SwitchTo']")
    private WebElement switchToElement;
    @FindBy(xpath = "//a[text()='Alerts']")
    private WebElement alertsElement;
    @FindBy(xpath = "//a[text()='Windows']")
    private WebElement windowsElement;
    @FindBy(css = "input[placeholder='First Name']")
    private WebElement firstNameElement;
    @FindBy(css = "input[placeholder='Last Name']")
    private WebElement lastNameElement;
    @FindBy(css = "textarea[rows='3']")
    private WebElement addressElement;
    @FindBy(css = "input[type='email']")
    private WebElement emailElement;
    @FindBy(css = "input[type='tel']")
    private WebElement phoneElement;
    @FindBy(css = "input[value='Male']")
    private WebElement genderElement;
    @FindBy(css = "input[value='Movies']")
    private WebElement hobbyElement;
    @FindBy(css = "div[id='msdd']")
    private WebElement languagesElement;
    @FindBy(css = ".ui-autocomplete.ui-front>li>a")
    private List<WebElement> languagesOptionsElement;
    @FindBy(id = "Skills")
    private WebElement skillsElement;
    @FindBy(css = "span[role='combobox']")
    private WebElement countryElement;
    @FindBy(className = "select2-search__field")
    private WebElement countryInputElement;
    @FindBy(id = "yearbox")
    private WebElement yearElement;
    @FindBy(css = "div>input[id='imagesrc']")
    private WebElement uploadElement;
    @FindBy(css = "input[id='firstpassword']")
    private WebElement passwordElement;
    @FindBy(css = "input[id='secondpassword']")
    private WebElement confirmPasswordElement;

    public void goToAlertPage(){
        elementMethods.moveToElement(switchToElement);
        elementMethods.clickElement(alertsElement);
        pageMethods.NavigateToURL("http://demo.automationtesting.in/Alerts.html");
    }

    public void goToWindowPage(){
        elementMethods.moveToElement(switchToElement);
        elementMethods.clickElement(windowsElement);
        pageMethods.NavigateToURL("http://demo.automationtesting.in/Windows.html");
    }

    public void fillFirstName(String value){
        elementMethods.fillElement(firstNameElement, value);
    }

    public void fillLastName(String value){
        elementMethods.fillElement(lastNameElement, value);
    }

    public void fillAddress(String value){
        elementMethods.fillElement(addressElement, value);
    }

    public void fillEmail(String value){
        elementMethods.fillElement(emailElement, value);
    }

    public void fillPhone(String value){
        elementMethods.fillElement(phoneElement, value);
    }

    public void clickGender(){
        elementMethods.clickElement(genderElement);
    }

    public void clickHobby(){
        elementMethods.clickElement(hobbyElement);
    }

    public void chooseLanguages(String value){
        elementMethods.clickElement(languagesElement);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");
        for (int index = 0;index < languagesOptionsElement.size();index++){
            if (languagesOptionsElement.get(index).getText().equals(value)){
                languagesOptionsElement.get(index).click();
            }
        }
    }

    public void chooseLanguages(List<String> values){
        elementMethods.clickElement(languagesElement);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");
        for (int index = 0;index < languagesOptionsElement.size();index++){
            if (values.contains(languagesOptionsElement.get(index).getText())){
                languagesOptionsElement.get(index).click();
            }
        }
    }

    public void selectSkill(String value){
        elementMethods.selectElementByText(skillsElement, value);
    }

    public void chooseCountry(String value){
        elementMethods.clickElement(countryElement);
        countryInputElement.sendKeys(value);
        countryInputElement.sendKeys(Keys.ENTER);
    }

    public void selectYear(String value){
        elementMethods.selectElementByValue(yearElement, value);
    }

    public void uploadFile(String value){
        elementMethods.fillElement(uploadElement, value);
    }

    public void fillPassword(String value){
        elementMethods.fillElement(passwordElement, value);
    }

    public void fillConfirmPassword(String value){
        elementMethods.fillElement(confirmPasswordElement, value);
    }

    public void registerValidProcess(HashMap<String, String> inputData){
        fillFirstName(inputData.get("firstName"));
        fillLastName(inputData.get("lastName"));
        fillAddress(inputData.get("street"));
        fillEmail(inputData.get("email"));
        fillPhone(inputData.get("phone"));
        clickGender();
        clickHobby();
        chooseLanguages(inputData.get("language"));
        selectSkill(inputData.get("skill"));
        chooseCountry(inputData.get("country"));
        selectYear(inputData.get("year"));
        uploadFile(inputData.get("file"));
        fillPassword(inputData.get("password"));
        fillConfirmPassword(inputData.get("confirmPassword"));
    }
}
