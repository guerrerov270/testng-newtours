package scriptsSimples;

import org.testng.annotations.*;
import base.TestBase;
import static org.testng.Assert.*;
import org.openqa.selenium.*;

/**
 * Esta clase realiza el proceso de registrar un nuevo usuario en la página de
 * pruebas http://newtours.demoaut.com/ y verifica el poroceso buscando un texto
 * de la página en el que aparece el nombre del nuevo usuario. Extiende de la
 * clase TestBase que provee lo necesario para la detección del sistema
 * operativo, su arquitectura, navegador a usar y los drivers para el mismo.
 * @author finguerrero
 * @version 26/10/2017
 * @see <a href = "https://github.com/guerrerov270/testng-newtours" />
 *      Repositorio del proyecto en Github </a>
 */
public class RegistroUsuario extends TestBase {

	// Para aceptar alertas y obtener su texto, pendiente consulta
	private boolean acceptNextAlert = true;
	// Para agregar texto de los errores
	private StringBuffer verificationErrors = new StringBuffer();

	/**
	 * Método que realiza el proceso de registro de usuario, lleva la anotación:
	 * @Test indicando que es parte de un proceso de pruebas
	 * @throws Exception
	 */
	@Test
	public void testRegistroUsuario() throws Exception {

		// Encuentra el botón de registro
		driver.findElement(By.linkText("REGISTER")).click();
		// Encuentra el campo de nombre y lo limpia
		driver.findElement(By.name("firstName")).clear();
		// Encuentra el campo de nombre y lo rellena
		driver.findElement(By.name("firstName")).sendKeys("Mi nombre");
		// Encuentra el campo de apellido y lo limpia
		driver.findElement(By.name("lastName")).clear();
		// Encuentra el campo de apellido y lo rellena
		driver.findElement(By.name("lastName")).sendKeys("Mi apellido");
		// Encuentra el campo de telefóno y lo limpia
		driver.findElement(By.name("phone")).clear();
		// Encuentra el campo de telefóno y lo rellena
		driver.findElement(By.name("phone")).sendKeys("123456");
		// Encuentra el campo de nombre de usuario y lo limpia
		driver.findElement(By.id("userName")).clear();
		// Encuentra el campo de nombre de usuario y lo rellena
		driver.findElement(By.id("userName")).sendKeys("mi@email.com");
		// Encuentra el campo de dirección y lo limpia
		driver.findElement(By.name("address1")).clear();
		// Encuentra el campo de dirección y lo rellena
		driver.findElement(By.name("address1")).sendKeys("Mi direcci�n");
		// Encuentra el campo de ciudad y lo limpia
		driver.findElement(By.name("city")).clear();
		// Encuentra el campo de ciudad y lo rellena
		driver.findElement(By.name("city")).sendKeys("Mi ciudad");
		// Encuentra el campo de estado y lo limpia
		driver.findElement(By.name("state")).clear();
		// Encuentra el campo de estado y lo rellena
		driver.findElement(By.name("state")).sendKeys("Mi estado");
		// Encuentra el campo de código postal y lo limpia
		driver.findElement(By.name("postalCode")).clear();
		// Encuentra el campo de código postal y lo rellena
		driver.findElement(By.name("postalCode")).sendKeys("057");
		// Encuentra el campo de email y lo limpia
		driver.findElement(By.id("email")).clear();
		// Encuentra el campo de email y lo rellena
		driver.findElement(By.id("email")).sendKeys("nombreusuario");
		// Encuentra el campo de password y lo limpia
		driver.findElement(By.name("password")).clear();
		// Encuentra el campo de password y lo rellena
		driver.findElement(By.name("password")).sendKeys("123456");
		// Encuentra el campo de confirmar password y lo limpia
		driver.findElement(By.name("confirmPassword")).clear();
		// Encuentra el campo de confirmar password y lo rellena
		driver.findElement(By.name("confirmPassword")).sendKeys("123456");
		// Encuentra el botoón de submit y hace click
		driver.findElement(By.name("register")).click();
		try {
			// Verifica el título de la página de registro
			assertEquals(driver.getTitle(), "Register: Mercury Tours");
		} catch (Error e) {
			// Si hay un error guarda el texto del mismo en el StringBuffer
			verificationErrors.append(e.toString());
		}
		// Verifica un campo en le página en donde debe aparecer el nombre del nuevo
		// usuario
		assertEquals(driver.findElement(By.cssSelector("a > font > b")).getText(),
				"Note: Your user name is nombreusuario.");
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
	}// Fin clase

}
