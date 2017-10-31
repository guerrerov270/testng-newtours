package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import base.PageBase;

public class SelectFlightPage extends PageBase {

	public SelectFlightPage(WebDriver driver, String pageTitle) {
		super(driver, pageTitle);
	} // Fin constructor

	// Web elements select flight
	// Depart
	@FindBy(how = How.CSS, using = "[name='outFlight'][value*='Blue Skies Airlines$360$270$5:03']")
	private WebElement radioFlight0D;
	@FindBy(how = How.CSS, using = "[name='outFlight'][value*='Blue Skies Airlines$361$271$7:10']")
	private WebElement radioFlight1D;
	@FindBy(how = How.CSS, using = "[name='outFlight'][value*='Pangea Airlines$362$274$9:17']")
	private WebElement radioFlight2D;
	@FindBy(how = How.CSS, using = "[name='outFlight'][value*='Unified Airlines$363$281$11:24']")
	private WebElement radioFlight3D;

	// Return
	@FindBy(how = How.CSS, using = "[name='inFlight'][value*='Blue Skies Airlines$630$270$12:23']")
	private WebElement radioFlight0R;
	@FindBy(how = How.CSS, using = "[name='inFlight'][value*='Blue Skies Airlines$631$273$14:30']")
	private WebElement radioFlight1R;
	@FindBy(how = How.CSS, using = "[name='inFlight'][value*='Pangea Airlines$632$282$16:37']")
	private WebElement radioFlight2R;
	@FindBy(how = How.CSS, using = "[name='inFlight'][value*='Unified Airlines$633$303$18:44']")
	private WebElement radioFlight3R;

	// Continue
	@FindBy(how = How.NAME, using = "reserveFlights")
	private WebElement buttonContinue;

	/**
	 * Método que selecciona las opciones de la página select flight a partir de
	 * los parámetros recibidos
	 * 
	 * @param departing
	 * @param returning
	 */
	public void seleccionSelectFlight(String departing, String returning) {

		// Seleccionar depart
		switch (departing) {
		case "Flight 360":
			selectRadioButton(radioFlight0D);
			break;
		case "Flight 361":
			selectRadioButton(radioFlight1D);
			break;
		case "Flight 362":
			selectRadioButton(radioFlight2D);
			break;
		case "Flight 363":
			selectRadioButton(radioFlight3D);
			break;

		default:
			Assert.fail("Vuelo no encontrado");
			break;
		} // Fin switch departing

		// Seleccionar return
		switch (returning) {
		case "Flight 630":
			selectRadioButton(radioFlight0R);
			break;
		case "Flight 631":
			selectRadioButton(radioFlight1R);
			break;
		case "Flight 632":
			selectRadioButton(radioFlight2R);
			break;
		case "Flight 633":
			selectRadioButton(radioFlight3R);
			break;

		default:
			Assert.fail("Vuelo no encontrado");
			break;
		} // Fin switch departing
		
		//Click en continuar
		clickButtonLink(buttonContinue);

	}// Fin método seleccionSelectFlight

	// Método get para cada elemento
	public WebElement getRadioFlight0D() {
		return radioFlight0D;
	}

	public WebElement getRadioFlight1D() {
		return radioFlight1D;
	}

	public WebElement getRadioFlight2D() {
		return radioFlight2D;
	}

	public WebElement getRadioFlight3D() {
		return radioFlight3D;
	}

	public WebElement getRadioFlight0R() {
		return radioFlight0R;
	}

	public WebElement getRadioFlight1R() {
		return radioFlight1R;
	}

	public WebElement getRadioFlight2R() {
		return radioFlight2R;
	}

	public WebElement getRadioFlight3R() {
		return radioFlight3R;
	}

	public WebElement getButtonContinue() {
		return buttonContinue;
	}

}
