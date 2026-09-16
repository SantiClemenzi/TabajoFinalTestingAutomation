package ar.org.icaro.test;

import ar.org.icaro.pages.DashboardPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
public class FlujoCompletoTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private LoginPage  loginPage;


    @BeforeMethod
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // SOLUCIÓN: Instanciamos la página pasándole el driver recién creado
        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void TearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test(priority=1, description="FLUJO COMPLETO")
    public void completoTest() {
        System.out.println("1: Vamos al Login");
        DashboardPage dashboard = loginPage.goTo().loginAs("Admin","admin123");
        Assert.assertTrue(dashboard.isOnDashboardPage(), "deberia estar en el Dashboard");
    }
}
