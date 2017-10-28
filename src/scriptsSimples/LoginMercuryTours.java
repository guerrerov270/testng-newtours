package scriptsSimples;

import org.testng.annotations.*;
import base.TestBase;
import static org.testng.Assert.*;
import org.openqa.selenium.*;

/**
 * Esta clase realiza el proceso de login en la página de pruebas
 * http://newtours.demoaut.com/ y verifica que se encuentra autenticado buscando
 * el botón Sign-off en el aplicativo. Extiende de la clase TestBase que provee
 * lo necesario para la detección del sistema operativo, su arquitectura,
 * navegador a usar y los drivers para el mismo.
 * @author finguerrero
 * @version 26/10/2017
 * @see <a href = "https://github.com/guerrerov270/testng-newtours" />
 *      Repositorio del proyecto en Github </a>
 */
public class LoginMercuryTours extends TestBase {

	// Para aceptar alertas y obtener texto, pendiente consulta
	private boolean acceptNextAlert = true;
	// Para agregar texto de los errores
	private StringBuffer verificationErrors = new StringBuffer();

	/**
	 * Método que realiza el proceso de login, lleva la anotación:
	 * @Test indicando que es parte de un proceso de pruebas
	 * @throws Exception
	 */
	@Test
	public void testLoginMercuryTours() throws Exception {

		// Encuentra el campo de nombre de usuario y lo limpia
		driver.findElement(By.name("userName")).clear();
		// Encuentra el campo de nombre de usuario y lo rellena
		driver.findElement(By.name("userName")).sendKeys("tutorial");
		// Encuentra el campo de password y lo limpia
		driver.findElement(By.name("password")).clear();
		// Encuentra el campo de password y lo rellena
		driver.findElement(By.name("password")).sendKeys("tutorial");
		// Hace click en el botón de login
		driver.findElement(By.name("login")).click();
		try {
			// Verifica el título para comprobar que ha ingresado
			assertEquals(driver.getTitle(), "Find a Flight: Mercury Tours:");
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		// Verifica que esté el enlace de cerrar sesión
		driver.findElement(By.linkText("SIGN-OFF")).click();
	}// Fin método

	@SuppressWarnings("unused")
	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	@SuppressWarnings("unused")
	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	@SuppressWarnings("unused")
	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}// Fin clase
