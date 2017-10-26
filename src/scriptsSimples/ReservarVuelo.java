package scriptsSimples;

import org.testng.annotations.*;

import base.TestBase;

import org.openqa.selenium.*;

public class ReservarVuelo extends TestBase {
  
  private boolean acceptNextAlert = true;
  @SuppressWarnings("unused")
private StringBuffer verificationErrors = new StringBuffer();

  @Test
  public void testReservarVuelo() throws Exception {
    
    driver.findElement(By.name("userName")).clear();
    driver.findElement(By.name("userName")).sendKeys("tutorial");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("tutorial");
    driver.findElement(By.name("login")).click();
    driver.findElement(By.name("findFlights")).click();
    driver.findElement(By.name("reserveFlights")).click();
    driver.findElement(By.name("passFirst0")).clear();
    driver.findElement(By.name("passFirst0")).sendKeys("Mi");
    driver.findElement(By.name("passLast0")).clear();
    driver.findElement(By.name("passLast0")).sendKeys("Nombre");
    driver.findElement(By.name("creditnumber")).clear();
    driver.findElement(By.name("creditnumber")).sendKeys("123456");
    driver.findElement(By.name("buyFlights")).click();
    driver.findElement(By.xpath("//td[3]/a/img")).click();
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
