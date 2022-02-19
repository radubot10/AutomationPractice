package Tests;

import Base.Hooks;
import Base.SharedData;
import Pages.AlertPage;
import Pages.IndexPage;
import Pages.RegisterPage;
import org.junit.Test;

public class AlertTest extends Hooks {

    public IndexPage indexPage;
    public RegisterPage registerPage;
    public AlertPage alertPage;

    @Test
    public void TestAutomat(){

        indexPage = new IndexPage(getDriver());
        registerPage = new RegisterPage(getDriver());
        alertPage = new AlertPage(getDriver());

        indexPage.clickSkipSignIn();

        registerPage.goToAlertPage();

        alertPage.alertOkProcess();
        alertPage.alertOkCancelProcess();
        alertPage.alertTextProcess(inputData);
    }
}
