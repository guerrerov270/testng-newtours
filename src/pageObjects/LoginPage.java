package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import base.PageBase;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver driver, String pageTitle) {
		super(driver, pageTitle);
	}

	// WebElements para submit
	@FindBy(how = How.NAME, using = "userName")
	private WebElement inputUserName;
	@FindBy(how = How.NAME, using = "password")
	private WebElement inputPassword;
	@FindBy(how = How.NAME, using = "login")
	private WebElement buttonSingIn;

	// WebElements debajo del login
	@FindBy(how = How.LINK_TEXT, using = "your destination")
	private WebElement lnkYourDestination;
	@FindBy(how = How.LINK_TEXT, using = "featured vacation destinations")
	private WebElement lnkFeaturedVacationDestinations;
	@FindBy(how = How.LINK_TEXT, using = "Register here")
	private WebElement lnkRegisterHere;

	public void loginMercuryTours(String userName, String password) {
		sendText(inputUserName, userName);
		sendText(inputPassword, password);
		clickButtonLink(buttonSingIn);
	}

	public boolean elementPresent(By element) {
		return isElementPresentAndDisplay(driver.findElement(element));
	}

	// Métodos get para los elementos
	public WebElement getInputUserName() {
		return inputUserName;
	}

	public WebElement getInputPassword() {
		return inputPassword;
	}

	public WebElement getButtonSingIn() {
		return buttonSingIn;
	}

	public WebElement getLnkYourDestination() {
		return lnkYourDestination;
	}

	public WebElement getLnkFeaturedVacationDestinations() {
		return lnkFeaturedVacationDestinations;
	}

	public WebElement getLnkRegisterHere() {
		return lnkRegisterHere;
	}

}// Fin clase LoginPage
