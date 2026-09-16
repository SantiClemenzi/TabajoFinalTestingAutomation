package ar.org.icaro.pages;

import ar.org.icaro.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PimPage extends BasePage {

    // Localizadores
    private By employeeNameInput = By.xpath("//label[text()='Employee Name']/following::input[1]");
    private By searchButton = By.cssSelector("button[type='submit']");
    private By tableRows = By.cssSelector(".oxd-table-card");
    private By noRecordsFoundText = By.xpath("//*[contains(@class, 'oxd-text') and text()='No Records Found']");

    public PimPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Verifica si actualmente nos encontramos en la página del módulo PIM.
     *
     * @return true si la URL contiene '/pim'
     */
    public boolean isOnPimPage() {
        return waitForUrlContains("/pim");
    }

    /**
     * Busca un empleado ingresando su nombre en el campo de filtro y presionando Search.
     *
     * @param employeeName Nombre o fragmento del nombre del empleado a buscar
     * @return Instancia de PimPage (this)
     */
    public PimPage searchEmployeeByName(String employeeName) {
        type(employeeNameInput, employeeName);
        click(searchButton);
        return this;
    }

    /**
     * Verifica si la tabla de la búsqueda contiene al menos un resultado/registro.
     *
     * @return true si se encontró al menos una fila en la tabla de resultados
     */
    public boolean hasResults() {
        // Verifica si existe al menos un elemento de fila visible
        return driver.findElements(tableRows).size() > 0;
    }

    /**
     * Verifica si se muestra el mensaje 'No Records Found' cuando la búsqueda no trae datos.
     *
     * @return true si el aviso de sin resultados está visible
     */
    public boolean isNoRecordsDisplayed() {
        return isElementVisible(noRecordsFoundText);
    }
}