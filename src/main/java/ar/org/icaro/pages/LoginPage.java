package ar.org.icaro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class LoginPage extends BasePage {
    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton = By.cssSelector("button[type='submit']");
    private By errorMessage = By.className("oxd-alert");
    private static final String URL_BASE = "https://opensource-demo.orangehrmlive.com/";

    //Constructor
    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public LoginPage goTo(){
        driver.get(URL_BASE);
        return this;
    }

    public LoginPage enterUsername(String username) {
        type(usernameField, username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        type(passwordField, password);
        return this;
    }

    public DashboardPage clickLogin() {
        click(loginButton);
        return new DashboardPage(driver);
    }

    public DashboardPage loginAs(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        return clickLogin();
    }

    public boolean isErrorDisplayed(){
        return isElementVisible(errorMessage);
    }

    public boolean isOnLoginPage() {
        //Validamos mediante la URL esperada
        return waitForUrlContains("opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
}
