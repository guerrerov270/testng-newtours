package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import pageObjects.LoginPage;
import pageObjects.MenuNavegacionPage;
import static org.testng.Assert.*;

public class LoginTest extends TestBase {

	protected MenuNavegacionPage menuNavegacion;
	protected LoginPage login;

	// Títulos de las páginas
	private String pageTitleIndex = "Welcome: Mercury Tours";
	private String pageFindFlight = "Find a Flight: Mercury Tours";

	// Credenciales de ingreso
	private String userName = "tutorial";
	private String password = "tutorial";

	/**
	 * Método para validar que el texto del enlace coincida con el que posee el
	 * webElement internamente, se está validando el menú de navegación superior,
	 * los enlaces que están visibles sin estar autenticado en el aplicativo
	 */
	@Test
	public void validarTextLinks() {
		menuNavegacion = new MenuNavegacionPage(driver, pageTitleIndex);
		if (!(menuNavegacion.getTextLink(menuNavegacion.getLnkSingOn(), "SIGN-ON"))) {
			Assert.fail("El link no contiene el texto esperado SIGN-ON");
		}
		if (!(menuNavegacion.getTextLink(menuNavegacion.getLnkRegister(), "REGISTER"))) {
			Assert.fail("El link no contiene el texto esperado REGISTER");
		}
		if (!(menuNavegacion.getTextLink(menuNavegacion.getLnkSupport(), "SUPPORT"))) {
			Assert.fail("El link no contiene el texto esperado SUPPORT");
		}
		if (!(menuNavegacion.getTextLink(menuNavegacion.getLnkContact(), "CONTACT"))) {
			Assert.fail("El link no contiene el texto esperado CONTACT");
		}
	}// Fin método validarTextLinks

	@Test(priority = 1)
	public void verificarCamposLogin() {
		login = new LoginPage(driver, pageTitleIndex);
		if (!(login.isElementPresentAndDisplay(login.getInputUserName()))) {
			Assert.fail("No se encontró el campo de UserName");
		}
		if (!(login.isElementPresentAndDisplay(login.getInputPassword()))) {
			Assert.fail("No se encontró el campo de password");
		}
		if (!(login.isElementPresentAndDisplay(login.getButtonSingIn()))) {
			Assert.fail("No se encontró el botón Sign-In");
		}
	}

	/**
	 * Método que realiza el proceso de autenticación, comprueba el resultado
	 * esperado buscando el enlace SIGN-OFF que se habilita únicamente cuando el
	 * usuario se encuentra autenticado.
	 */
	@Test(priority = 2)
	public void autenticarse() {

		login = new LoginPage(driver, pageFindFlight);
		menuNavegacion = new MenuNavegacionPage(driver, pageFindFlight);
		login.loginMercuryTours(userName, password);
		esperarAntesDeEjecutar(3);
		if (!(menuNavegacion.getTextLink(menuNavegacion.getLnkSingOf(), "SIGN-OFF"))) {
			Assert.fail("El link no contiene el texto esperado SIGN-OFF");
		}
	}// Fin método autenticarse

}
