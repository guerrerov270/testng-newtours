package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import base.PageBase;

/**
 * @author finguerrero
 * @version 26/10/2017
 * @see <a href = "https://github.com/guerrerov270/testng-newtours" />
 *      Repositorio del proyecto en Github </a>
 */
public class FlightConfirmationPage extends PageBase {

	public FlightConfirmationPage(WebDriver driver, String pageTitle) {
		super(driver, pageTitle);
	}// Fin constructor

	@FindBy(how = How.CSS, using = "img[src='/images/forms/backtoflights.gif']")
	private WebElement buttonBackToFlights;
	@FindBy(how = How.CSS, using = "img[src='/images/forms/home.gif']")
	private WebElement buttonBackToHome;
	@FindBy(how = How.CSS, using = "img[src='/images/forms/Logout.gif']")
	private WebElement buttonLogOut;

	public void seleccionarBotonFlightConfirmation(String eleccion) {

		switch (eleccion) {
		case "vuelos":
			clickButtonLink(buttonBackToFlights);
			break;
		case "home":
			clickButtonLink(buttonBackToHome);
			break;
		case "salir":
			clickButtonLink(buttonLogOut);
			break;

		default:
			break;
		}

	}// Fin método seleccionarBotonFlightConfirmation

	// Método get para cada elemento
	public WebElement getButtonBackToFlights() {
		return buttonBackToFlights;
	}

	public WebElement getButtonBackToHome() {
		return buttonBackToHome;
	}

	public WebElement getButtonLogOut() {
		return buttonLogOut;
	}

} // Fin clase FlightConfirmationPage
