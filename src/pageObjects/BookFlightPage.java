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
	//Passengers
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
	
	//Credit card
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
	
	//Billing Address
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
	
	//Delivery Address
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
	
	//Secure purchase 
	@FindBy(how = How.NAME, using = "buyFlights")
	private WebElement buttonBuyFlights;
	
}// Fin clase BookFlightPage
