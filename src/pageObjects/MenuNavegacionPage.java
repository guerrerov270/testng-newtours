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
public class MenuNavegacionPage extends PageBase {

	public MenuNavegacionPage(WebDriver driver, String pageTitle) {
		super(driver, pageTitle);
	}// Fin m�todo MenuNavegacionPage

	// WebElements men� superior
	@FindBy(how = How.LINK_TEXT, using = "SIGN-ON")
	private WebElement lnkSingOn;
	@FindBy(how = How.LINK_TEXT, using = "SIGN-OFF")
	private WebElement lnkSingOf;
	@FindBy(how = How.LINK_TEXT, using = "REGISTER")
	private WebElement lnkRegister;
	@FindBy(how = How.LINK_TEXT, using = "SUPPORT")
	private WebElement lnkSupport;
	@FindBy(how = How.LINK_TEXT, using = "CONTACT")
	private WebElement lnkContact;

	// WebElements men� lateral
	@FindBy(how = How.LINK_TEXT, using = "Home")
	private WebElement lnkHome;
	@FindBy(how = How.LINK_TEXT, using = "Flights")
	private WebElement lnkFlights;
	@FindBy(how = How.LINK_TEXT, using = "Hotels")
	private WebElement lnkHotels;
	@FindBy(how = How.LINK_TEXT, using = "Car Rentals")
	private WebElement lnkCarRentals;
	@FindBy(how = How.LINK_TEXT, using = "Cruises")
	private WebElement lnkCruises;
	@FindBy(how = How.LINK_TEXT, using = "Destinations")
	private WebElement lnkDestinations;
	@FindBy(how = How.LINK_TEXT, using = "Vacations")
	private WebElement lnkVacations;

	/**
	 * 
	 * @param element
	 */
	public void clickLink(WebElement element) {
		clickButtonLink(element);
	}

	// M�todos get para los elementos
	public WebElement getLnkSingOn() {
		return lnkSingOn;
	}

	public WebElement getLnkSingOf() {
		return lnkSingOf;
	}

	public WebElement getLnkRegister() {
		return lnkRegister;
	}

	public WebElement getLnkSupport() {
		return lnkSupport;
	}

	public WebElement getLnkContact() {
		return lnkContact;
	}

	public WebElement getLnkHome() {
		return lnkHome;
	}

	public WebElement getLnkFlights() {
		return lnkFlights;
	}

	public WebElement getLnkHotels() {
		return lnkHotels;
	}

	public WebElement getLnkCarRentals() {
		return lnkCarRentals;
	}

	public WebElement getLnkCruises() {
		return lnkCruises;
	}

	public WebElement getLnkDestinations() {
		return lnkDestinations;
	}

	public WebElement getLnkVacations() {
		return lnkVacations;
	}

	/**
	 * Verifica que el texto del enlace del webElement coincida con el recibido por parámetro
	 * @param elemento: el elemento que representa la etiqueta HTML
	 * @param textoEnlace: El texto del enlace 
	 * @return resultado: true or false
	 */
	public boolean getTextLink(WebElement elemento, String textoEnlace) {
		boolean resultado;
		if (elemento.getText().equals(textoEnlace)) {
			resultado= true;
		}else {
			resultado=false;
		}
		return resultado;
	}// Fin método getTextLink

}// Fin clase MenuNavegacionPage
