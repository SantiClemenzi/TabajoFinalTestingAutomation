package ar.org.icaro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage{

    // Localizadores
    private By headerText = By.cssSelector(".oxd-topbar-header-breadcrumb-module");
    private By pimMenuItem = By.xpath("//span[text()='PIM']");
    private By userProfileDropdown = By.cssSelector(".oxd-userdropdown-tab");
    private By logoutOption = By.xpath("//a[text()='Logout']");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Verifica si actualmente nos encontramos en la página del Dashboard.
     *
     * @return true si la URL contiene '/dashboard'
     */
    public boolean isOnDashboard() {
        return waitForUrlContains("/dashboard");
    }

    /**
     * Obtiene el texto del encabezado principal (Header).
     *
     * @return Texto del header (ej. "Dashboard")
     */
    public String getHeaderText() {
        return getText(headerText);
    }

    /**
     * Navega al módulo PIM mediante el menú lateral.
     *
     * @return Instancia de PimPage
     */
    public PimPage goToPIM() {
        click(pimMenuItem);
        return new PimPage(driver);
    }

    /**
     * Cierra la sesión del usuario actual desplegando el menú del perfil.
     *
     * @return Instancia de LoginPage
     */
    public LoginPage logout() {
        click(userProfileDropdown);
        click(logoutOption);
        return new LoginPage(driver);
    }
    public boolean isOnDashboardPage() {
        return waitForUrlContains("dashboard");
    }
}
