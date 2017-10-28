package base;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {

	/**
	 * Crear el driver
	 */
	protected WebDriver driver;
	/**
	 * Título de página esperado. Será usuado en isPageLoad () para comprobar si la
	 * página está cargada.
	 */
	protected String pageTitle;

	public PageBase(WebDriver driver, String pageTitle) {
		this.driver = driver;
		this.pageTitle = pageTitle;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Comprueba si la página se carga comparando el título de página esperado con
	 * un título de página real.
	 **/
	public boolean isPageLoad() {
		return (driver.getTitle().contains(pageTitle));
	}

	/**
	 * Retorna el título de la página
	 */
	public String getTitle() {
		return pageTitle;
	}

	/**
	 * Envía el texto recibido al elemento que recibe por parámetro
	 * 
	 * @param element
	 * @param text
	 * @return
	 */
	public boolean sendText(WebElement element, String text) {
		boolean result = true;
		if (isElementPresentAndDisplay(element)) {
			element.sendKeys(text);
		} else {
			result = false;
		}
		return result;
	}

	/**
	 * Hace clic sobre el elemento que recibe por parámetro
	 * 
	 * @param element
	 * @return
	 */
	public boolean clickButtonLink(WebElement element) {
		boolean result = true;
		if (isElementPresentAndDisplay(element)) {
			element.click();
		} else {
			result = false;
		}
		return result;
	}

	/**
	 * Verifica si el texto esta presente en la página
	 */
	public boolean isTextPresent(String text) {
		return driver.getPageSource().contains(text);
	}

	/**
	 * Verifica si el elemento esta presente en la página
	 */
	public boolean isElementPresentAndDisplay(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/**
	 * Método para seleccionar un valor de un comboBox
	 * @param element, es el tipo select
	 * @param text, es el texto de la opción
	 * @return
	 */
	public boolean selectDropdownVisibleText(WebElement element, String text) {
		//Variable para definir la resouesta del método
		boolean result = true;
		
		//Tipo select gráfico de selenium para hacer el cast del elemento recibido
		Select listBox;
		
		//Si el elemento está presente y visible
		if (isElementPresentAndDisplay(element)) {
			//Lo almaceno en el listBox
			listBox= new Select(element);
			//Tomo el texto seleccionado
			listBox.selectByVisibleText(text);
		}else {
			result=false;
		}

		return result;
	}// Fin método selectDropdownVisibleText

}// Fin clase PageBase
