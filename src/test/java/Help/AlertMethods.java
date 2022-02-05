package Help;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertMethods {

    public WebDriver driver;

    public AlertMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void waitAlert(){
        WebDriverWait waitExplicit = new WebDriverWait(driver, Duration.ofSeconds(20));
        waitExplicit.until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert(){
        waitAlert();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void cancelAlert(){
        waitAlert();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public void acceptFillAlert(String value){
        waitAlert();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(value);
        alert.accept();
    }
}
