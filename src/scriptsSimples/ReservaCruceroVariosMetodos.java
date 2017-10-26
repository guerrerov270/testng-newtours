package scriptsSimples;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import base.TestBase;

public class ReservaCruceroVariosMetodos extends TestBase{
	
	private StringBuffer verificationErrors = new StringBuffer();
	String userName="tutorial";
	String password="tutorial";
	
	@Test
	public void login() {
		
		driver.findElement(By.name("userName")).clear();
		driver.findElement(By.name("userName")).sendKeys(userName);
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("login")).click();	
		
		try {
			assertEquals(driver.getTitle(), "Find a Flight: Mercury Tours:");
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	}

	@Test(dependsOnMethods = { "login" })
	public void ingresoCruises() {
		
		try {
			assertEquals(driver.getTitle(), "Find a Flight: Mercury Tours:");
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.linkText("Cruises")).click();
		driver.findElement(By.cssSelector("img[alt=\"Reservations Open\"]")).click();
	}
	
	@Test(dependsOnMethods = { "ingresoCruises" })
	public void reservar() {
		
		try {
			assertEquals(driver.getTitle(), "Find a Flight: Mercury Tours:");
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		// ERROR: Caught exception [Error: Dom locators are not implemented yet!]
		new Select(driver.findElement(By.name("passCount"))).selectByVisibleText("2");
		new Select(driver.findElement(By.name("fromPort"))).selectByVisibleText("Frankfurt");
		new Select(driver.findElement(By.name("fromDay"))).selectByVisibleText("30");
		new Select(driver.findElement(By.name("toPort"))).selectByVisibleText("New York");
		// ERROR: Caught exception [Error: Dom locators are not implemented yet!]
		new Select(driver.findElement(By.name("airline"))).selectByVisibleText("Unified Airlines");
		driver.findElement(By.name("findFlights")).click();
		// ERROR: Caught exception [Error: Dom locators are not implemented yet!]
		driver.findElement(By.name("reserveFlights")).click();
		driver.findElement(By.name("passFirst0")).clear();
		driver.findElement(By.name("passFirst0")).sendKeys("Mi nombre");
		driver.findElement(By.name("passLast0")).clear();
		driver.findElement(By.name("passLast0")).sendKeys("Mi apellido");
		driver.findElement(By.name("passFirst1")).clear();
		driver.findElement(By.name("passFirst1")).sendKeys("Su nombre");
		driver.findElement(By.name("passLast1")).clear();
		driver.findElement(By.name("passLast1")).sendKeys("Su apellido");
		new Select(driver.findElement(By.name("pass.0.meal"))).selectByVisibleText("Diabetic");
		new Select(driver.findElement(By.name("pass.0.meal"))).selectByVisibleText("Bland");
		new Select(driver.findElement(By.name("pass.1.meal"))).selectByVisibleText("Low Calorie");
		driver.findElement(By.name("creditnumber")).clear();
		driver.findElement(By.name("creditnumber")).sendKeys("545158485185");
		driver.findElement(By.name("buyFlights")).click();
		try {
			assertEquals(driver.getTitle(), "Flight Confirmation: Mercury Tours");
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	}
}
