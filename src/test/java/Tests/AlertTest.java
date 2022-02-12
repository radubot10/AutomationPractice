package Tests;

import Base.SharedData;
import Pages.AlertPage;
import Pages.IndexPage;
import Pages.RegisterPage;
import org.junit.Test;

public class AlertTest extends SharedData {

    public IndexPage indexPage;
    public RegisterPage registerPage;
    public AlertPage alertPage;

    @Test
    public void TestAutomat(){

        indexPage = new IndexPage(driver);
        registerPage = new RegisterPage(driver);
        alertPage = new AlertPage(driver);

        indexPage.clickSkipSignIn();

        registerPage.goToAlertPage();

        alertPage.alertOkProcess();
        alertPage.alertOkCancelProcess();
        alertPage.alertTextProcess("Alex");
    }
}
