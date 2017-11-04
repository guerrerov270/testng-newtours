package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import pageObjects.BookFlightPage;
import pageObjects.FindFlightPage;
import pageObjects.FlightConfirmationPage;
import pageObjects.LoginPage;
import pageObjects.MenuNavegacionPage;

public class FlightConfirmationTest extends TestBase {

	protected MenuNavegacionPage menuNavegacion;
	protected FindFlightPage flightP;
	protected LoginPage login;
	protected BookFlightPage bookFlightP;
	protected FindFlightTest findFlight;
	protected SelectFlightTest selectflight;
	protected BookFlightTest bookFlightT;
	protected FlightConfirmationPage flightConfirmation;

	// Títulos de las páginas
	private String pageTitleIndex = "Welcome: Mercury Tours";
	private String pageTitleFindFlight = "Find a Flight: Mercury Tours";
	private String pageTitleSelectFlight = "Select a Flight: Mercury Tours";
	private String pageTitleBookFlight = "Book a Flight: Mercury Tours";
	private String pageTitleConfirmationFlight = "Flight Confirmation: Mercury Tours";

	// Valores para seleccion
	private String eleccion = "home";
	private String userName = "tutorial";
	private String password = "tutorial";

	/**
	 * Método para válidar el enlace sign off, como el menú aparece en varias
	 * pantallas del aplicativo este método lo voy a declarar en la clase padre
	 * en un próximo refactor
	 */
	@Test
	public void validarTextLinks() {
		menuNavegacion = new MenuNavegacionPage(driver, pageTitleBookFlight);

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

		// Luego book a flight
		bookFlightT = new BookFlightTest();
		bookFlightT.seleccionarOpcionesBookFlight();

	}// Fin método validarTextLinks

	@Test(priority = 1)
	public void verificarElementosFlightConfirmation() {

		flightConfirmation = new FlightConfirmationPage(driver,
				pageTitleBookFlight);

		// verifico los elementos en la página
		if (!(flightConfirmation.isElementPresentAndDisplay(flightConfirmation
				.getButtonBackToFlights()))) {
			Assert.fail("No se encontró el botón back to flights");
		}
		if (!(flightConfirmation.isElementPresentAndDisplay(flightConfirmation
				.getButtonBackToHome()))) {
			Assert.fail("No se encontró el botón back to home");
		}
		if (!(flightConfirmation.isElementPresentAndDisplay(flightConfirmation
				.getButtonLogOut()))) {
			Assert.fail("No se encontró el botón log out");
		}

	}// Fin método verificarElementosBookFlight

	@Test(priority = 2)
	public void seleccionarOpcionesConfirmationFlight() {

		flightConfirmation.seleccionarBotonFlightConfirmation(eleccion);

		// Falta verificar la operación

	}// Fin método seleccionarOpcionesConfirmationFlight

}// Fin clase FlightConfirmationTest
