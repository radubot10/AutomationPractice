package Pages;

import Help.ElementMethods;
import Help.PageMethods;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RegisterPage {

    public WebDriver driver;
    public ElementMethods elementMethods;
    public PageMethods pageMethods;

    public RegisterPage(WebDriver driver){
        this.driver = driver;
        elementMethods = new ElementMethods(driver);
        pageMethods = new PageMethods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()='SwitchTo']")
    public WebElement switchToElement;
    @FindBy(xpath = "//a[text()='Alerts']")
    public WebElement alertsElement;
    @FindBy(xpath = "//a[text()='Windows']")
    public WebElement windowsElement;
    @FindBy(css = "input[placeholder='First Name']")
    public WebElement firstNameElement;
    @FindBy(css = "input[placeholder='Last Name']")
    public WebElement lastNameElement;
    @FindBy(css = "textarea[rows='3']")
    public WebElement addressElement;
    @FindBy(css = "input[type='email']")
    public WebElement emailElement;
    @FindBy(css = "input[type='tel']")
    public WebElement phoneElement;
    @FindBy(css = "input[value='Male']")
    public WebElement genderElement;
    @FindBy(css = "input[value='Movies']")
    public WebElement hobbyElement;
    @FindBy(css = "div[id='msdd']")
    public WebElement languagesElement;
    @FindBy(css = ".ui-autocomplete.ui-front>li>a")
    public List<WebElement> languagesOptionsElement;
    @FindBy(id = "Skills")
    public WebElement skillsElement;
    @FindBy(css = "span[role='combobox']")
    public WebElement countryElement;
    @FindBy(className = "select2-search__field")
    public WebElement countryInputElement;
    @FindBy(id = "yearbox")
    public WebElement yearElement;
    @FindBy(css = "div>input[id='imagesrc']")
    public WebElement uploadElement;
    @FindBy(css = "input[id='firstpassword']")
    public WebElement passwordElement;
    @FindBy(css = "input[id='secondpassword']")
    public WebElement confirmPasswordElement;

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

    public void registerValidProcess(String firstName,String lastName, String address, String email,
                                     String phone, String language, String skill, String country,
                                     String year, String file, String password, String confirmP ){
        fillFirstName(firstName);
        fillLastName(lastName);
        fillAddress(address);
        fillEmail(email);
        fillPhone(phone);
        clickGender();
        clickHobby();
        chooseLanguages(language);
        selectSkill(skill);
        chooseCountry(country);
        selectYear(year);
        uploadFile(file);
        fillPassword(password);
        fillConfirmPassword(confirmP);
    }
}
