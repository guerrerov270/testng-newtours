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
	@FindBy(how = How.XPATH, using = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/b/font/input[1]")
	private WebElement radioRoundTrip;
	@FindBy(how = How.XPATH, using = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/b/font/input[2]")
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
	@FindBy(how = How.XPATH, using = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/font/input")
	private WebElement radioEconomyClass;
	@FindBy(how = How.XPATH, using = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/font/font/input[1]")
	private WebElement radioBussinessClass;
	@FindBy(how = How.XPATH, using = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/font/font/input[2]")
	private WebElement radioFirstClass;
	
	@FindBy(how = How.NAME, using = "airline")
	private WebElement selectAirline;
	
	// Botón continue
	@FindBy(how = How.NAME, using = "findFlights")
	private WebElement buttonContinue;
	
	public void seleccionFindFlight(){
		
	}// Fin método seleccionFindFlight
	
	
	
} //Fin clase FindFlightPage
