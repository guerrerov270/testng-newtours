package scriptsSimples;

import org.testng.annotations.*;
import base.TestBase;
import static org.testng.Assert.*;
import org.openqa.selenium.*;

public class RegistroUsuario extends TestBase{

	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Test
	public void testRegistroUsuario() throws Exception {
		
		driver.findElement(By.linkText("REGISTER")).click();
		driver.findElement(By.name("firstName")).clear();
		driver.findElement(By.name("firstName")).sendKeys("Mi nombre");
		driver.findElement(By.name("lastName")).clear();
		driver.findElement(By.name("lastName")).sendKeys("Mi apellido");
		driver.findElement(By.name("phone")).clear();
		driver.findElement(By.name("phone")).sendKeys("123456");
		driver.findElement(By.id("userName")).clear();
		driver.findElement(By.id("userName")).sendKeys("mi@email.com");
		driver.findElement(By.name("address1")).clear();
		driver.findElement(By.name("address1")).sendKeys("Mi dirección");
		driver.findElement(By.name("city")).clear();
		driver.findElement(By.name("city")).sendKeys("Mi ciudad");
		driver.findElement(By.name("state")).clear();
		driver.findElement(By.name("state")).sendKeys("Mi estado");
		driver.findElement(By.name("postalCode")).clear();
		driver.findElement(By.name("postalCode")).sendKeys("057");
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("nombreusuario");
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("123456");
		driver.findElement(By.name("confirmPassword")).clear();
		driver.findElement(By.name("confirmPassword")).sendKeys("123456");
		driver.findElement(By.name("register")).click();
		try {
			assertEquals(driver.getTitle(), "Register: Mercury Tours");
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		assertEquals(driver.findElement(By.cssSelector("a > font > b")).getText(),
				"Note: Your user name is nombreusuario.");
	}

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

}
