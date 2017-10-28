package scriptsSimples;

import org.testng.annotations.*;

import base.TestBase;

import org.openqa.selenium.*;

/**
 * Esta clase realiza el proceso de reservar un vuelo en la página de pruebas
 * http://newtours.demoaut.com/ y verifica el poroceso buscando un texto de la
 * página en el que aparece el nombre del nuevo usuario. Extiende de la clase
 * TestBase que provee lo necesario para la detección del sistema operativo, su
 * arquitectura, navegador a usar y los drivers para el mismo.
 * @author finguerrero
 * @version 26/10/2017
 * @see <a href = "https://github.com/guerrerov270/testng-newtours" />
 *      Repositorio del proyecto en Github </a>
 */
public class ReservarVuelo extends TestBase {

	private boolean acceptNextAlert = true;
	@SuppressWarnings("unused")
	private StringBuffer verificationErrors = new StringBuffer();

	/**
	 * Método que realiza el proceso de reservar un vuelo, lleva la anotación:
	 * @Test indicando que es parte de un proceso de pruebas
	 * @throws Exception
	 */
	@Test
	public void testReservarVuelo() throws Exception {

		// Encuentra el campo de nombre de usuario y lo limpia
		driver.findElement(By.name("userName")).clear();
		// Encuentra el campo de nombre de usuario y lo rellena
		driver.findElement(By.name("userName")).sendKeys("tutorial");
		// Encuentra el campo de password y lo limpia
		driver.findElement(By.name("password")).clear();
		// Encuentra el campo de password y lo rellena
		driver.findElement(By.name("password")).sendKeys("tutorial");
		//Encuentra el botoón de submit y hace click
		driver.findElement(By.name("login")).click();
		//Encuentra el botoón de buscar vuelos y hace click
		driver.findElement(By.name("findFlights")).click();
		//Encuentra el botoón de reservar vuelos y hace click
		driver.findElement(By.name("reserveFlights")).click();
		// Encuentra el campo de nombre y lo limpia
		driver.findElement(By.name("passFirst0")).clear();
		// Encuentra el campo de nombre y lo rellena
		driver.findElement(By.name("passFirst0")).sendKeys("Mi");
		// Encuentra el campo de apellido y lo limpia
		driver.findElement(By.name("passLast0")).clear();
		// Encuentra el campo de apellido y lo rellena
		driver.findElement(By.name("passLast0")).sendKeys("Nombre");
		// Encuentra el campo para número de tarjeta y lo limpia
		driver.findElement(By.name("creditnumber")).clear();
		// Encuentra el campo para número de tarjeta y lo rellena
		driver.findElement(By.name("creditnumber")).sendKeys("123456");
		//Encuentra el botoón de comprar vuelo y hace click
		driver.findElement(By.name("buyFlights")).click();
		//Encuentra una imágen que contiene un enlace al home y hace click
		driver.findElement(By.xpath("//td[3]/a/img")).click();
	}//Fin método

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
}//Fin clase
