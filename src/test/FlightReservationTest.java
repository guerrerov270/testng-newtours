package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import pageObjects.FindFlightPage;
import pageObjects.LoginPage;
import pageObjects.MenuNavegacionPage;

public class FlightReservationTest extends TestBase {

	protected MenuNavegacionPage menuNavegacion;
	protected FindFlightPage flightP;
	protected LoginPage login;

	// Títulos de las páginas
	private String pageTitleIndex = "Welcome: Mercury Tours";
	private String pageTitleFindFlight = "Find a Flight: Mercury Tours";

	// Valores para seleccionar las opciones en la página
	private String tripType = "One way";
	private String passengers = "2";
	private String departing = "London";
	private String monthIni = "November";
	private String dayIni = "24";
	private String arrivingIn = "Sydney";
	private String monthEnd = "January";
	private String dayEnd = "10";
	private String serviceClass = "First class";
	private String airline = "Unified Airlines";
	private String userName = "tutorial";
	private String password = "tutorial";

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
	}// Fin método validarTextLinks

	@Test(priority = 1)
	public void verificarElementosFindFlight() {
		flightP = new FindFlightPage(driver, pageTitleFindFlight);

		// verifico los elementos en la página
		if (!(flightP.isElementPresentAndDisplay(flightP.getRadioRoundTrip()))) {
			Assert.fail("No se encontró el radio button Round trip");
		}
		if (!(flightP.isElementPresentAndDisplay(flightP.getRadioOneWay()))) {
			Assert.fail("No se encontró el radio button One way");
		}
		if (!(flightP.isElementPresentAndDisplay(flightP.getSelectPassengers()))) {
			Assert.fail("No se encontró el select Passengers");
		}
		if (!(flightP.isElementPresentAndDisplay(flightP
				.getSelectDepartingFrom()))) {
			Assert.fail("No se encontró el select Departing from");
		}
		if (!(flightP.isElementPresentAndDisplay(flightP.getSelectMonthIni()))) {
			Assert.fail("No se encontró el select On");
		}
		if (!(flightP.isElementPresentAndDisplay(flightP.getSelectDayIni()))) {
			Assert.fail("No se encontró el select para el día de inicio");
		}
		if (!(flightP.isElementPresentAndDisplay(flightP.getSelectArrivingIn()))) {
			Assert.fail("No se encontró el select Arriving in");
		}
		if (!(flightP.isElementPresentAndDisplay(flightP.getSelectReturning()))) {
			Assert.fail("No se encontró el select Returning");
		}
		if (!(flightP.isElementPresentAndDisplay(flightP.getRadioRoundTrip()))) {
			Assert.fail("No se encontró el radio button Round trip");
		}
		if (!(flightP.isElementPresentAndDisplay(flightP.getSelectDayEnd()))) {
			Assert.fail("No se encontró el select para el día de llegada");
		}
		if (!(flightP
				.isElementPresentAndDisplay(flightP.getRadioEconomyClass()))) {
			Assert.fail("No se encontró el radio button Economy class");
		}
		if (!(flightP.isElementPresentAndDisplay(flightP
				.getRadioBussinessClass()))) {
			Assert.fail("No se encontró el radio button Business class");
		}
		if (!(flightP.isElementPresentAndDisplay(flightP.getRadioFirstClass()))) {
			Assert.fail("No se encontró el radio button First class");
		}
		if (!(flightP.isElementPresentAndDisplay(flightP.getSelectAirline()))) {
			Assert.fail("No se encontró el select Airline");
		}
		if (!(flightP.isElementPresentAndDisplay(flightP.getButtonContinue()))) {
			Assert.fail("No se encontró el botón Continue");
		}

	}// Fin método verificarElementosFindFlight

	/**
	 * Método para realizar la prueba de selección de opciones de vuelo en la
	 * página
	 */
	@Test(priority=2)
	public void seleccionarOpcionesVuelo() {
		flightP = new FindFlightPage(driver, pageTitleFindFlight);
		flightP.seleccionFindFlight(tripType, passengers, departing, monthIni,
				dayIni, arrivingIn, monthEnd, dayEnd, serviceClass, airline);
		
		//Falta verificar la operación

	}

}// Fin clase FlightReservationTest
