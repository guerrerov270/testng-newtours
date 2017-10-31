package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import base.PageBase;

public class FindFlightPage extends PageBase {

	public FindFlightPage(WebDriver driver, String pageTitle) {
		super(driver, pageTitle);
	} // Fin constructor

	// Web elements flights details
	@FindBy(how = How.CSS, using = "[name='tripType'][value*='roundtrip']")
	private WebElement radioRoundTrip;
	@FindBy(how = How.CSS, using = "[name='tripType'][value*='oneway']")
	private WebElement radioOneWay;

	@FindBy(how = How.NAME, using = "passCount")
	private WebElement selectPassengers;
	@FindBy(how = How.NAME, using = "fromPort")
	private WebElement selectDepartingFrom;
	@FindBy(how = How.NAME, using = "fromMonth")
	private WebElement selectMonthIni;
	@FindBy(how = How.NAME, using = "fromDay")
	private WebElement selectDayIni;
	@FindBy(how = How.NAME, using = "toPort")
	private WebElement selectArrivingIn;
	@FindBy(how = How.NAME, using = "toMonth")
	private WebElement selectReturning;
	@FindBy(how = How.NAME, using = "toDay")
	private WebElement selectDayEnd;

	// Web elements preferences
	@FindBy(how = How.CSS, using = "[name='servClass'][value*='Coach']")
	private WebElement radioEconomyClass;
	@FindBy(how = How.CSS, using = "[name='servClass'][value*='Business']")
	private WebElement radioBussinessClass;
	@FindBy(how = How.CSS, using = "[name='servClass'][value*='First']")
	private WebElement radioFirstClass;

	@FindBy(how = How.NAME, using = "airline")
	private WebElement selectAirline;

	// Botón continue
	@FindBy(how = How.NAME, using = "findFlights")
	private WebElement buttonContinue;

	/**
	 * Método para seleccionar las opciones en la página de flight finder a
	 * partir de los parámetros recibidos
	 * @param tripType
	 * @param passengers
	 * @param departing
	 * @param monthIni
	 * @param dayIni
	 * @param arrivingIn
	 * @param monthEnd
	 * @param dayEnd
	 * @param serviceClass
	 * @param airline
	 */
	public void seleccionFindFlight(String tripType, String passengers,
			String departing, String monthIni, String dayIni,
			String arrivingIn, String monthEnd, String dayEnd,
			String serviceClass, String airline) {

		if (tripType.equals("Round trip"))
			selectRadioButton(radioRoundTrip);
		if (tripType.equals("One way"))
			selectRadioButton(radioOneWay);
		selectDropdownVisibleText(selectPassengers, passengers);
		selectDropdownVisibleText(selectDepartingFrom, departing);
		selectDropdownVisibleText(selectMonthIni, monthIni);
		selectDropdownVisibleText(selectDayIni, dayIni);
		selectDropdownVisibleText(selectArrivingIn, arrivingIn);
		selectDropdownVisibleText(selectReturning, monthEnd);
		selectDropdownVisibleText(selectDayEnd, dayEnd);
		if (serviceClass.equals("Economy class"))
			selectRadioButton(radioEconomyClass);
		if (serviceClass.equals("Business class"))
			selectRadioButton(radioBussinessClass);
		if (serviceClass.equals("First class"))
			selectRadioButton(radioFirstClass);
		selectDropdownVisibleText(selectAirline, airline);
		clickButtonLink(buttonContinue);
	}// Fin método seleccionFindFlight

	//Método get para cada elemento
	public WebElement getRadioRoundTrip() {
		return radioRoundTrip;
	}

	public WebElement getRadioOneWay() {
		return radioOneWay;
	}

	public WebElement getSelectPassengers() {
		return selectPassengers;
	}

	public WebElement getSelectDepartingFrom() {
		return selectDepartingFrom;
	}

	public WebElement getSelectMonthIni() {
		return selectMonthIni;
	}

	public WebElement getSelectDayIni() {
		return selectDayIni;
	}

	public WebElement getSelectArrivingIn() {
		return selectArrivingIn;
	}

	public WebElement getSelectReturning() {
		return selectReturning;
	}

	public WebElement getSelectDayEnd() {
		return selectDayEnd;
	}

	public WebElement getRadioEconomyClass() {
		return radioEconomyClass;
	}

	public WebElement getRadioBussinessClass() {
		return radioBussinessClass;
	}

	public WebElement getRadioFirstClass() {
		return radioFirstClass;
	}

	public WebElement getSelectAirline() {
		return selectAirline;
	}

	public WebElement getButtonContinue() {
		return buttonContinue;
	}
	

} // Fin clase FindFlightPage
