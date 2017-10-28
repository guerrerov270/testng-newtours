package scriptsSimples;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import base.TestBase;

/**
 * Esta clase realiza el proceso de login, ingreso a sección cruceros y reservar
 * un crucero en la página de pruebas http://newtours.demoaut.com/ Extiende de
 * la clase TestBase que provee lo necesario para la detección del sistema
 * operativo, su arquitectura, navegador a usar y los drivers para el mismo.
 * @author finguerrero
 * @version 26/10/2017
 * @see <a href = "https://github.com/guerrerov270/testng-newtours" />
 *      Repositorio del proyecto en Github </a>
 */
public class ReservaCruceroVariosMetodos extends TestBase {

	// Para almacenar texto de errores
	private StringBuffer verificationErrors = new StringBuffer();
	// Credenciales para ingresar al aplicativo
	String userName = "tutorial";
	String password = "tutorial";

	/**
	 * Método que realiza el proceso de login, lleva la anotación:
	 * 
	 * @Test indicando que es parte de un proceso de pruebas, su prioridad es 1
	 *       porque los demás métodos no se pueden ejecutar sin estar autenticado.
	 * @throws Exception
	 */
	@Test(priority = 1)
	public void login() {

		// Encuentra el campo de nombre de usuario y lo limpia
		driver.findElement(By.name("userName")).clear();
		// Encuentra el campo de nombre de usuario y lo rellena
		driver.findElement(By.name("userName")).sendKeys(userName);
		// Encuentra el campo de password y lo limpia
		driver.findElement(By.name("password")).clear();
		// Encuentra el campo de password y lo rellena
		driver.findElement(By.name("password")).sendKeys(password);
		// Hace click en el botón de login
		driver.findElement(By.name("login")).click();

		try {
			// Verifica el título para comprobar que ha ingresado
			assertEquals(driver.getTitle(), "Find a Flight: Mercury Tours:");
		} catch (Error e) {
			// Si hay un error agrega el texto como String al StringBuffer
			verificationErrors.append(e.toString());
		}
	}//Fin método

	/**
	 * Método que realiza el proceso de ingreso a la sección de cruceros, lleva la
	 * anotación:
	 * 
	 * @Test indicando que es parte de un proceso de pruebas, su prioridad es 2
	 *       porque requiere estar autenticado, por eso se indica que depende del
	 *       método de login.
	 * @throws Exception
	 */
	@Test(priority = 2, dependsOnMethods = { "login" })
	public void ingresoCruises() {

		try {
			// Verifica el título para comprobar que ha ingresado
			assertEquals(driver.getTitle(), "Find a Flight: Mercury Tours:");
		} catch (Error e) {
			// Si hay un error agrega el texto como String al StringBuffer
			verificationErrors.append(e.toString());
		}
		// Encuentra el enlace a la sección cruceros y hace click
		driver.findElement(By.linkText("Cruises")).click();
		// Encuentra un enlace a las reservaciones y hace click
		driver.findElement(By.cssSelector("img[alt=\"Reservations Open\"]")).click();
	}//Fin método

	/**
	 * Método que realiza el proceso de reservación, lleva la anotación:
	 * 
	 * @Test indicando que es parte de un proceso de pruebas, su prioridad es 3
	 *       porque requiere de los dos modos anteriores para ejecutarse, por eso se
	 *       especifica con la etiqueta dependsOnMethods.
	 * @throws Exception
	 */
	@Test(priority = 3, dependsOnMethods = { "login", "ingresoCruises" })
	public void reservar() {

		try {
			// Verifica el título para comprobar que ha ingresado
			assertEquals(driver.getTitle(), "Find a Flight: Mercury Tours:");
		} catch (Error e) {
			// Si hay un error agrega el texto como String al StringBuffer
			verificationErrors.append(e.toString());
		}
		// ERROR: Caught exception [Error: Dom locators are not implemented yet!]
		//Selecciono el número de pasajeros
		new Select(driver.findElement(By.name("passCount"))).selectByVisibleText("2");
		//Selecciono la ciudad de origen
		new Select(driver.findElement(By.name("fromPort"))).selectByVisibleText("Frankfurt");
		//Selecciono el día de partida
		new Select(driver.findElement(By.name("fromDay"))).selectByVisibleText("30");
		//Selecciono el destino
		new Select(driver.findElement(By.name("toPort"))).selectByVisibleText("New York");
		// ERROR: Caught exception [Error: Dom locators are not implemented yet!]
		//Selecciono aerolínea
		new Select(driver.findElement(By.name("airline"))).selectByVisibleText("Unified Airlines");
		//Encuentra el botoón de buscar vuelos y hace click
		driver.findElement(By.name("findFlights")).click();
		// ERROR: Caught exception [Error: Dom locators are not implemented yet!]
		//Encuentra el botoón de reservar vuelos y hace click
		driver.findElement(By.name("reserveFlights")).click();
		//Ecuentra el campo de nombre de primer pasajero y lo limpia
		driver.findElement(By.name("passFirst0")).clear();
		//Ecuentra el campo de nombre de primer pasajero y lo rellena
		driver.findElement(By.name("passFirst0")).sendKeys("Mi nombre");
		//Ecuentra el campo de apellido de primer pasajero y lo limpia
		driver.findElement(By.name("passLast0")).clear();
		//Ecuentra el campo de apellido de primer pasajero y lo rellena
		driver.findElement(By.name("passLast0")).sendKeys("Mi apellido");
		//Ecuentra el campo de nombre de segundo pasajero y lo limpia
		driver.findElement(By.name("passFirst1")).clear();
		//Ecuentra el campo de nombre de segundo pasajero y lo rellena
		driver.findElement(By.name("passFirst1")).sendKeys("Su nombre");
		//Ecuentra el campo de apellido de segundo pasajero y lo limpia
		driver.findElement(By.name("passLast1")).clear();
		//Ecuentra el campo de apellido de segundo pasajero y lo rellena
		driver.findElement(By.name("passLast1")).sendKeys("Su apellido");
		//Selecciona tipo de comida de pasajero 1
		new Select(driver.findElement(By.name("pass.0.meal"))).selectByVisibleText("Diabetic");
		//Selecciona tipo de comida de pasajero 2
		new Select(driver.findElement(By.name("pass.0.meal"))).selectByVisibleText("Bland");
		//Cambia el tipo de comida de pasajero 2
		new Select(driver.findElement(By.name("pass.1.meal"))).selectByVisibleText("Low Calorie");
		//Ecuentra el campo de nombre de número de tarjeta limpia
		driver.findElement(By.name("creditnumber")).clear();
		//Ecuentra el campo de nombre de número de tarjeta rellena
		driver.findElement(By.name("creditnumber")).sendKeys("545158485185");
		//Encuentra el enlace a comprar vuelo y hace click
		driver.findElement(By.name("buyFlights")).click();
		try {
			// Verifica el título para comprobar que está en la sección requerida
			assertEquals(driver.getTitle(), "Flight Confirmation: Mercury Tours");
		} catch (Error e) {
			// Si hay un error agrega el texto como String al StringBuffer
			verificationErrors.append(e.toString());
		}
	}//Fin método
}//Fin clase
