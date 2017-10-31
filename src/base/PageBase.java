package base;

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
	 * T�tulo de p�gina esperado. Ser� usuado en isPageLoad () para comprobar si
	 * la p�gina est� cargada.
	 */
	protected String pageTitle;

	public PageBase(WebDriver driver, String pageTitle) {
		this.driver = driver;
		this.pageTitle = pageTitle;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Comprueba si la p�gina se carga comparando el t�tulo de p�gina esperado
	 * con un t�tulo de p�gina real.
	 **/
	public boolean isPageLoad() {
		return (driver.getTitle().contains(pageTitle));
	}

	/**
	 * Retorna el t�tulo de la p�gina
	 */
	public String getTitle() {
		return pageTitle;
	}

	/**
	 * Env�a el texto recibido al elemento que recibe por par�metro
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
	 * Hace clic sobre el elemento que recibe por par�metro
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
	 * Verifica si el texto esta presente en la p�gina
	 */
	public boolean isTextPresent(String text) {
		return driver.getPageSource().contains(text);
	}

	/**
	 * Verifica si el elemento esta presente en la p�gina
	 */
	public boolean isElementPresentAndDisplay(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/**
	 * M�todo para seleccionar un valor de un comboBox
	 * 
	 * @param element
	 *            , es el tipo select
	 * @param text
	 *            , es el texto de la opci�n
	 * @return
	 */
	public boolean selectDropdownVisibleText(WebElement element, String text) {
		// Variable para definir la resouesta del m�todo
		boolean result = true;

		// Tipo select gr�fico de selenium para hacer el cast del elemento
		// recibido
		Select listBox;

		// Si el elemento est� presente y visible
		if (isElementPresentAndDisplay(element)) {
			// Lo almaceno en el listBox
			listBox = new Select(element);
			// Tomo el texto seleccionado
			listBox.selectByVisibleText(text);
		} else {
			result = false;
		}

		return result;
	}// Fin m�todo selectDropdownVisibleText

	/**
	 * Método que permite realizar una selección en un radio button
	 * @param elemento
	 * @return true o false
	 */
	public boolean selectRadioButton(WebElement elemento) {
		// Variable para definir la resouesta del método
		boolean result = true;
		if(isElementPresentAndDisplay(elemento)){
			clickButtonLink(elemento);
		}else{
			result = false;
		}
		return result;
	}// Fin método selectRadioButton

}// Fin clase PageBase
