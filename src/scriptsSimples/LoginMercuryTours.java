package scriptsSimples;

import org.testng.annotations.*;
import base.TestBase;
import static org.testng.Assert.*;
import org.openqa.selenium.*;

public class LoginMercuryTours extends TestBase{
  
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Test
  public void testLoginMercuryTours() throws Exception {
    
    driver.findElement(By.name("userName")).clear();
    driver.findElement(By.name("userName")).sendKeys("tutorial");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("tutorial");
    driver.findElement(By.name("login")).click();
    try {
      assertEquals(driver.getTitle(), "Find a Flight: Mercury Tours:");
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.linkText("SIGN-OFF")).click();
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
