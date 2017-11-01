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
public class BookFlightPage extends PageBase {

	public BookFlightPage(WebDriver driver, String pageTitle) {
		super(driver, pageTitle);
	}// Fin constructor

	// WebElements Book a flight
	// Passengers
	@FindBy(how = How.NAME, using = "passFirst0")
	private WebElement inputFirstName0;
	@FindBy(how = How.NAME, using = "passLast0")
	private WebElement inputLastName0;
	@FindBy(how = How.NAME, using = "pass.0.meal")
	private WebElement selectMeal0;

	@FindBy(how = How.NAME, using = "passFirst1")
	private WebElement inputFirstName1;
	@FindBy(how = How.NAME, using = "passLast1")
	private WebElement inputLastName1;
	@FindBy(how = How.NAME, using = "pass.1.meal")
	private WebElement selectMeal1;

	// Credit card
	@FindBy(how = How.NAME, using = "creditCard")
	private WebElement selectCreditCard;
	@FindBy(how = How.NAME, using = "creditnumber")
	private WebElement inputCreditNumber;
	@FindBy(how = How.NAME, using = "cc_exp_dt_mn")
	private WebElement selectCcExpM;
	@FindBy(how = How.NAME, using = "cc_exp_dt_yr")
	private WebElement selectCcExpY;
	@FindBy(how = How.NAME, using = "cc_frst_name")
	private WebElement inputCcFirstName;
	@FindBy(how = How.NAME, using = "cc_mid_name")
	private WebElement inputCcMiddleName;
	@FindBy(how = How.NAME, using = "cc_last_name")
	private WebElement inputCcLastName;

	// Billing Address
	@FindBy(how = How.CSS, using = "[name='ticketLess'][value*='checkbox']")
	private WebElement checkTicketLess;
	@FindBy(how = How.NAME, using = "billAddress1")
	private WebElement inputBillAddress1;
	@FindBy(how = How.NAME, using = "billAddress2")
	private WebElement inputBillAddress2;
	@FindBy(how = How.NAME, using = "billCity")
	private WebElement inputBillCity;
	@FindBy(how = How.NAME, using = "billState")
	private WebElement inputBillState;
	@FindBy(how = How.NAME, using = "billZip")
	private WebElement inputBillZip;
	@FindBy(how = How.NAME, using = "billCountry")
	private WebElement selectBillCountry;

	// Delivery Address
	@FindBy(how = How.CSS, using = "[name='ticketLess'][value*='checkbox']")
	private WebElement checkBillingAddress;
	@FindBy(how = How.NAME, using = "delAddress1")
	private WebElement inputDelAddress1;
	@FindBy(how = How.NAME, using = "delAddress2")
	private WebElement inputDelAddress2;
	@FindBy(how = How.NAME, using = "delCity")
	private WebElement inputDelCity;
	@FindBy(how = How.NAME, using = "delState")
	private WebElement inputDelState;
	@FindBy(how = How.NAME, using = "delZip")
	private WebElement inputDelZip;
	@FindBy(how = How.NAME, using = "delCountry")
	private WebElement selectDelCountry;

	// Secure purchase
	@FindBy(how = How.NAME, using = "buyFlights")
	private WebElement buttonBuyFlights;

	public void seleccionBookAFlight(String firstName0, String lastName0,
			String meal0, String firstName1, String lastName1, String meal1,
			String cardType, String cardNumber, String expCMonth,
			String expCYear, String cardFirstName, String cardMiddleNane,
			String cardLastName, boolean ticketless, String address1Bill,
			String address2Bill, String cityBill, String stateBill,
			String postalCodeBill, String countryBill,
			boolean sameAsBillingAddress, String address1Del,
			String address2Del, String cityDel, String stateDel,
			String postalCodeDel, String countryDel) {

		sendText(inputFirstName0, firstName0);
		sendText(inputLastName0, lastName0);
		selectDropdownVisibleText(selectMeal0, meal0);

		sendText(inputFirstName1, firstName1);
		sendText(inputLastName1, lastName1);
		selectDropdownVisibleText(selectMeal1, meal1);

		selectDropdownVisibleText(selectCreditCard, cardType);
		sendText(inputCreditNumber, cardNumber);
		selectDropdownVisibleText(selectCcExpM, expCMonth);
		selectDropdownVisibleText(selectCcExpY, expCYear);
		sendText(inputCcFirstName, cardFirstName);
		sendText(inputCcMiddleName, cardMiddleNane);
		sendText(inputCcLastName, cardLastName);

		if (ticketless) {
			// Selecciono el check
			checkTicketLess.click();
		}

		inputBillAddress1.clear();
		sendText(inputBillAddress1, address1Bill);
		sendText(inputBillAddress2, address2Bill);
		inputBillCity.clear();
		sendText(inputBillCity, cityBill);
		inputBillState.clear();
		sendText(inputBillState, stateBill);
		inputBillZip.clear();
		sendText(inputBillZip, postalCodeBill);
		selectDropdownVisibleText(selectBillCountry, countryBill);

		if (sameAsBillingAddress) {
			// Selecciono el check
			checkBillingAddress.click();
		}

		inputDelAddress1.clear();
		sendText(inputDelAddress1, address1Del);
		sendText(inputDelAddress2, address2Del);
		inputDelCity.clear();
		sendText(inputDelCity, cityDel);
		inputDelState.clear();
		sendText(inputDelState, stateDel);
		inputDelZip.clear();
		sendText(inputDelZip, postalCodeDel);
		selectDropdownVisibleText(selectDelCountry, countryDel);

		clickButtonLink(buttonBuyFlights);

	}// Fin método seleccionBookAFlight

	// Métodos get para los elementos
	public WebElement getInputFirstName0() {
		return inputFirstName0;
	}

	public WebElement getInputLastName0() {
		return inputLastName0;
	}

	public WebElement getSelectMeal0() {
		return selectMeal0;
	}

	public WebElement getInputFirstName1() {
		return inputFirstName1;
	}

	public WebElement getInputLastName1() {
		return inputLastName1;
	}

	public WebElement getSelectMeal1() {
		return selectMeal1;
	}

	public WebElement getSelectCreditCard() {
		return selectCreditCard;
	}

	public WebElement getInputCreditNumber() {
		return inputCreditNumber;
	}

	public WebElement getSelectCcExpM() {
		return selectCcExpM;
	}

	public WebElement getSelectCcExpY() {
		return selectCcExpY;
	}

	public WebElement getInputCcFirstName() {
		return inputCcFirstName;
	}

	public WebElement getInputCcMiddleName() {
		return inputCcMiddleName;
	}

	public WebElement getInputCcLastName() {
		return inputCcLastName;
	}

	public WebElement getCheckTicketLess() {
		return checkTicketLess;
	}

	public WebElement getInputBillAddress1() {
		return inputBillAddress1;
	}

	public WebElement getInputBillAddress2() {
		return inputBillAddress2;
	}

	public WebElement getInputBillCity() {
		return inputBillCity;
	}

	public WebElement getInputBillState() {
		return inputBillState;
	}

	public WebElement getInputBillZip() {
		return inputBillZip;
	}

	public WebElement getSelectBillCountry() {
		return selectBillCountry;
	}

	public WebElement getCheckBillingAddress() {
		return checkBillingAddress;
	}

	public WebElement getInputDelAddress1() {
		return inputDelAddress1;
	}

	public WebElement getInputDelAddress2() {
		return inputDelAddress2;
	}

	public WebElement getInputDelCity() {
		return inputDelCity;
	}

	public WebElement getInputDelState() {
		return inputDelState;
	}

	public WebElement getInputDelZip() {
		return inputDelZip;
	}

	public WebElement getSelectDelCountry() {
		return selectDelCountry;
	}

	public WebElement getButtonBuyFlights() {
		return buttonBuyFlights;
	}

}// Fin clase BookFlightPage
