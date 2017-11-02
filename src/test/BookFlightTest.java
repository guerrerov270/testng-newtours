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
	}// Fin método validarTextLinks

	@Test(priority = 1)
	public void verificarElementosBookFlight() {

		bookFlightP = new BookFlightPage(driver, pageTitleBookFlight);

		// verifico los elementos en la página
		if (!(bookFlightP.isElementPresentAndDisplay(bookFlightP.getInputFirstName0()))) {
			Assert.fail("No se encontró el input first name 0");
		}

	}

}
