package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import pageObjects.LoginPage;
import pageObjects.MenuNavegacionPage;
import pageObjects.RegistroPage;

public class RegisterTest extends TestBase {

	protected MenuNavegacionPage menuNavegacion;
	protected RegistroPage register;

	// Títulos de las páginas
	private String pageTitleIndex = "Welcome: Mercury Tours";
	private String pageTitleRegister = "Register: Mercury Tours";

	// Valores para realizar el registro
	private String firstName = "Mi nombre";
	private String lastName = "Mi apellido";
	private String phone = "555-789643";
	private String email = "mi@email.com";
	private String address1 = "Mi dirección 1";
	private String address2 = "Mi dirección 2";
	private String city = "Mi ciudad";
	private String state = "Mi estado";
	private String postalCode = "057";
	private String country = "BRAZIL";
	private String userName = "nombreUsuario";
	private String password = "12345";
	private String confirmPassword = "12345";

	/**
	 * Método para válidar el enlace de Register, como el menú aparece en varias
	 * pantallas del aplicativo este método lo voy a declarar en la clase padre en
	 * un próximo refactor
	 */
	@Test
	public void validarTextLinks() {
		menuNavegacion = new MenuNavegacionPage(driver, pageTitleIndex);

		if (!(menuNavegacion.getTextLink(menuNavegacion.getLnkRegister(), "REGISTER"))) {
			Assert.fail("El link no contiene el texto esperado REGISTER");
		}
	}// Fin método validarTextLinks

	@Test(priority = 1)
	public void verificarCamposRegister() {
		register = new RegistroPage(driver, pageTitleRegister);

		// Voy a la página de registro
		menuNavegacion.clickButtonLink(menuNavegacion.getLnkRegister());

		if (!(register.isElementPresentAndDisplay(register.getInputFirstName()))) {
			Assert.fail("No se encontró el campo de first name");
		}
		if (!(register.isElementPresentAndDisplay(register.getInputLastName()))) {
			Assert.fail("No se encontró el campo de last name");
		}
		if (!(register.isElementPresentAndDisplay(register.getInputPhone()))) {
			Assert.fail("No se encontró el campo de phone");
		}
		if (!(register.isElementPresentAndDisplay(register.getInputEmail()))) {
			Assert.fail("No se encontró el campo de e-mail");
		}
		if (!(register.isElementPresentAndDisplay(register.getInputAddress1()))) {
			Assert.fail("No se encontró el campo de address 1");
		}
		if (!(register.isElementPresentAndDisplay(register.getInputAddres2()))) {
			Assert.fail("No se encontró el campo de address 2");
		}
		if (!(register.isElementPresentAndDisplay(register.getInputCity()))) {
			Assert.fail("No se encontró el campo de city");
		}
		if (!(register.isElementPresentAndDisplay(register.getInputState()))) {
			Assert.fail("No se encontró el campo de state");
		}
		if (!(register.isElementPresentAndDisplay(register.getInputPostalCode()))) {
			Assert.fail("No se encontró el campo de postal code");
		}
		if (!(register.isElementPresentAndDisplay(register.getSelectCountry()))) {
			Assert.fail("No se encontró el select de country");
		}
		if (!(register.isElementPresentAndDisplay(register.getInputEmailUser()))) {
			Assert.fail("No se encontró el campo de user name");
		}
		if (!(register.isElementPresentAndDisplay(register.getInputPassword()))) {
			Assert.fail("No se encontró el campo de password");
		}
		if (!(register.isElementPresentAndDisplay(register.getInputConfirmPassword()))) {
			Assert.fail("No se encontró el campo de confirm password");
		}
		if (!(register.isElementPresentAndDisplay(register.getButtonRegister()))) {
			Assert.fail("No se encontró el botón Submit");
		}
	}// Fin método verificarCamposRegister

	/**
	 * Método que realiza el proceso de registro, comprueba el resultado esperado
	 * buscando el enlace SIGN-OFF que se habilita luego de que el usuario se
	 * encuentra registrado.
	 */
	@Test(priority = 2)
	public void registrarse() {

		register = new RegistroPage(driver, pageTitleRegister);
		menuNavegacion = new MenuNavegacionPage(driver, pageTitleRegister);
		register.registroMercuryTours(firstName, lastName, phone, email, address1, address2, city, state, postalCode,
				country, userName, password, confirmPassword);
		esperarAntesDeEjecutar(3);
		if (!(menuNavegacion.getTextLink(menuNavegacion.getLnkSingOf(), "SIGN-OFF"))) {
			Assert.fail("El link no contiene el texto SIGN-OFF, no está registrado");
		}

	}// Fin método registrarse

}
