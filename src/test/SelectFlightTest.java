package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import pageObjects.LoginPage;
import pageObjects.MenuNavegacionPage;
import pageObjects.SelectFlightPage;

public class SelectFlightTest extends TestBase {

	protected MenuNavegacionPage menuNavegacion;
	protected SelectFlightPage selectFlightP;
	protected LoginPage login;
	protected FindFlightTest findFlight;

	// Títulos de las páginas
	private String pageTitleIndex = "Welcome: Mercury Tours";
	private String pageTitleFindFlight = "Find a Flight: Mercury Tours";
	private String pageTitleSelectFlight = "Select a Flight: Mercury Tours";

	// Valores para seleccionar las opciones en la página
	private String departing = "Flight 363";
	private String returning = "Flight 633";
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

		// Luego relleno el formulario de Find Flight
		findFlight = new FindFlightTest();
		findFlight.seleccionarOpcionesVuelo();

	}// Fin método validarTextLinks

	@Test(priority = 1)
	public void verificarElementosFindFlight() {
		selectFlightP = new SelectFlightPage(driver, pageTitleFindFlight);

		// verifico los elementos en la página
		if (!(selectFlightP.isElementPresentAndDisplay(selectFlightP
				.getRadioFlight0D()))) {
			Assert.fail("No se encontró el radio button Blue Skies Airlines 360");
		}
		if (!(selectFlightP.isElementPresentAndDisplay(selectFlightP
				.getRadioFlight1D()))) {
			Assert.fail("No se encontró el radio button Blue Skies Airlines 361");
		}
		if (!(selectFlightP.isElementPresentAndDisplay(selectFlightP
				.getRadioFlight2D()))) {
			Assert.fail("No se encontró el radio button Pangaea Airlines 362");
		}
		if (!(selectFlightP.isElementPresentAndDisplay(selectFlightP
				.getRadioFlight3D()))) {
			Assert.fail("No se encontró el radio button Unified Airlines 363");
		}
		if (!(selectFlightP.isElementPresentAndDisplay(selectFlightP
				.getRadioFlight0R()))) {
			Assert.fail("No se encontró el radio button Blue Skies Airlines 630");
		}
		if (!(selectFlightP.isElementPresentAndDisplay(selectFlightP
				.getRadioFlight1R()))) {
			Assert.fail("No se encontró el radio button Blue Skies Airlines 631");
		}
		if (!(selectFlightP.isElementPresentAndDisplay(selectFlightP
				.getRadioFlight2R()))) {
			Assert.fail("No se encontró el radio button Pangaea Airlines 632");
		}
		if (!(selectFlightP.isElementPresentAndDisplay(selectFlightP
				.getRadioFlight3R()))) {
			Assert.fail("No se encontró el radio button Unified Airlines 633");
		}
		if (!(selectFlightP.isElementPresentAndDisplay(selectFlightP
				.getButtonContinue()))) {
			Assert.fail("No se encontró el botón Continue");
		}

	}// Fin método verificarElementosFindFlight

	@Test(priority = 2)
	public void seleccionarDepartAndReturn() {

		selectFlightP = new SelectFlightPage(driver, pageTitleSelectFlight);
		selectFlightP.seleccionSelectFlight(departing, returning);

		// Falta verificar la operación

	}

}
