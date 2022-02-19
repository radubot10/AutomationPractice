package Base;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import propertiesUtility.PropertiesObject;

import java.time.Duration;

public class SharedData {

    private WebDriver driver;

    public void InitializeDriver(){
        PropertiesObject driverResource = new PropertiesObject("driverResource/DriverResource");
        System.setProperty(driverResource.getValueByKey("browser"), driverResource.getValueByKey("browserPath"));
        driver = new ChromeDriver();
        driver.get(driverResource.getValueByKey("url"));
        driver.manage().window().maximize();

        // Wait implicit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    public void TearDown(){

        // driver.quit();
    }

    public WebDriver getDriver(){
        return driver;
    }

}
