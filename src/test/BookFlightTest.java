package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BookFlightPage;
import pageObjects.FindFlightPage;
import pageObjects.LoginPage;
import pageObjects.MenuNavegacionPage;
import base.TestBase;

/**
 * @author finguerrero
 * @version 26/10/2017
 * @see <a href = "https://github.com/guerrerov270/testng-newtours" />
 *      Repositorio del proyecto en Github </a>
 */
public class BookFlightTest extends TestBase {

	protected MenuNavegacionPage menuNavegacion;
	protected FindFlightPage flightP;
	protected LoginPage login;
	protected BookFlightPage bookFlightP;
	protected FindFlightTest findFlight;
	protected SelectFlightTest selectflight;

	// Valores para seleccionar las opciones en la página

	private String userName = "tutorial";
	private String password = "tutorial";

	// Títulos de las páginas
	private String pageTitleIndex = "Welcome: Mercury Tours";
	private String pageTitleFindFlight = "Find a Flight: Mercury Tours";
	private String pageTitleBookFlight = "Book a Flight: Mercury Tours";

	/**
	 * Método para válidar el enlace sign off, como el menú aparece en varias
	 * pantallas del aplicativo este método lo voy a declarar en la clase padre
	 * en un próximo refactor
	 */
	@Test
	public void validarTextLinks() {
		menuNavegacion = new MenuNavegacionPage(driver, pageTitleFindFlight);

		// Debo ingresar primero
		login = new LoginPage(driver, pageTitleIndex);
		login.loginMercuryTours(userName, password);

		if (!(menuNavegacion.getTextLink(menuNavegacion.getLnkSingOf(),
				"SIGN-OFF"))) {
			Assert.fail("El link no contiene el texto esperado SIGN-OFF");
		}

		// Luego relleno el formulario de Find Flight
		findFlight = new FindFlightTest();
		findFlight.seleccionarOpcionesVuelo();

		// Luego selecciono depart y return en select flight
		selectflight = new SelectFlightTest();
		selectflight.seleccionarDepartAndReturn();

	}// Fin método validarTextLinks

	@Test(priority = 1)
	public void verificarElementosBookFlight() {

		bookFlightP = new BookFlightPage(driver, pageTitleBookFlight);

		// verifico los elementos en la página
		if (!(bookFlightP.isElementPresentAndDisplay(bookFlightP
				.getInputFirstName0()))) {
			Assert.fail("No se encontró el input first name 0");
		}
		if (!(bookFlightP.isElementPresentAndDisplay(bookFlightP
				.getInputLastName0()))) {
			Assert.fail("No se encontró el input last name 0");
		}
		if (!(bookFlightP.isElementPresentAndDisplay(bookFlightP
				.getSelectMeal0()))) {
			Assert.fail("No se encontró el select meal 0");
		}
		if (!(bookFlightP.isElementPresentAndDisplay(bookFlightP
				.getInputFirstName1()))) {
			Assert.fail("No se encontró el input first name 1");
		}
		if (!(bookFlightP.isElementPresentAndDisplay(bookFlightP
				.getInputLastName1()))) {
			Assert.fail("No se encontró el input last name 1");
		}
		if (!(bookFlightP.isElementPresentAndDisplay(bookFlightP
				.getSelectMeal1()))) {
			Assert.fail("No se encontró el select meal 1");
		}
		if (!(bookFlightP.isElementPresentAndDisplay(bookFlightP
				.getSelectCreditCard()))) {
			Assert.fail("No se encontró el seelect credit card");
		}
		if (!(bookFlightP.isElementPresentAndDisplay(bookFlightP
				.getInputCreditNumber()))) {
			Assert.fail("No se encontró el input credit number");
		}
		if (!(bookFlightP.isElementPresentAndDisplay(bookFlightP
				.getSelectCcExpM()))) {
			Assert.fail("No se encontró el select expirate month cc");
		}
		if (!(bookFlightP.isElementPresentAndDisplay(bookFlightP
				.getSelectCcExpY()))) {
			Assert.fail("No se encontró el select expirate year cc");
		}
		if (!(bookFlightP.isElementPresentAndDisplay(bookFlightP
				.getInputCcFirstName()))) {
			Assert.fail("No se encontró el input first name cc");
		}
		if (!(bookFlightP.isElementPresentAndDisplay(bookFlightP
				.getInputCcMiddleName()))) {
			Assert.fail("No se encontró el input middle name cc");
		}
		if (!(bookFlightP.isElementPresentAndDisplay(bookFlightP
				.getInputCcLastName()))) {
			Assert.fail("No se encontró el input last name cc");
		}
		if (!(bookFlightP.isElementPresentAndDisplay(bookFlightP
				.getCheckTicketLess()))) {
			Assert.fail("No se encontró el check ticket less");
		}
		if (!(bookFlightP.isElementPresentAndDisplay(bookFlightP
				.getInputBillAddress1()))) {
			Assert.fail("No se encontró el input bill address 1");
		}
		if (!(bookFlightP.isElementPresentAndDisplay(bookFlightP
				.getInputBillAddress2()))) {
			Assert.fail("No se encontró el input bill address 2");
		}
		if (!(bookFlightP.isElementPresentAndDisplay(bookFlightP
				.getInputBillCity()))) {
			Assert.fail("No se encontró el input bill city");
		}
		if (!(bookFlightP.isElementPresentAndDisplay(bookFlightP
				.getInputBillState()))) {
			Assert.fail("No se encontró el input bill state");
		}
		if (!(bookFlightP.isElementPresentAndDisplay(bookFlightP
				.getInputBillZip()))) {
			Assert.fail("No se encontró el input bill postal code");
		}
		if (!(bookFlightP.isElementPresentAndDisplay(bookFlightP
				.getSelectBillCountry()))) {
			Assert.fail("No se encontró el select bill country");
		}
		if (!(bookFlightP.isElementPresentAndDisplay(bookFlightP
				.getCheckBillingAddress()))) {
			Assert.fail("No se encontró el check billing address");
		}
		if (!(bookFlightP.isElementPresentAndDisplay(bookFlightP
				.getInputDelAddress1()))) {
			Assert.fail("No se encontró el input del address 1");
		}
		if (!(bookFlightP.isElementPresentAndDisplay(bookFlightP
				.getInputDelAddress2()))) {
			Assert.fail("No se encontró el input del address 2");
		}
		if (!(bookFlightP.isElementPresentAndDisplay(bookFlightP
				.getInputDelCity()))) {
			Assert.fail("No se encontró el input del city");
		}
		if (!(bookFlightP.isElementPresentAndDisplay(bookFlightP
				.getInputDelState()))) {
			Assert.fail("No se encontró el input del state");
		}
		if (!(bookFlightP.isElementPresentAndDisplay(bookFlightP
				.getInputDelZip()))) {
			Assert.fail("No se encontró el input del postal code");
		}
		if (!(bookFlightP.isElementPresentAndDisplay(bookFlightP
				.getSelectDelCountry()))) {
			Assert.fail("No se encontró el select del country");
		}
		if (!(bookFlightP.isElementPresentAndDisplay(bookFlightP
				.getButtonBuyFlights()))) {
			Assert.fail("No se encontró el button buy flights");
		}

	}// Fin método verificarElementosBookFlight

}// Fin clase BookFlightTest
