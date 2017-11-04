package test;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.PageBase;
import base.TestBase;
import pageObjects.LoginPage;
import utils.ExcelUtils;
import utils.ExcelUtils.ExcelType;

public class cp001ValidarCampos extends TestBase {

	// Utilidad para el manejo de excel
	static ExcelUtils excelCamposLogin;
	private String nomCampoUser = "";
	private String nomCampoPass = "";
	private String nomBotonSing = "";
	PageBase pageB;

	// Credenciales de autenticación
	private String nombreUsuario = "";
	private String contraseña = "";

	protected LoginPage login;
	private String pageTitleIndex = "Welcome: Mercury Tours";

	@Test
	public void verificarCamposLogin() throws FileNotFoundException,
			IOException {
		login = new LoginPage(driver, pageTitleIndex);

		// Se crea la instancia para manejar el archivo
		// CamposLogin.xlsx
		excelCamposLogin = new ExcelUtils("CamposLogin.xlsx", ExcelType.XLSX);
		nomCampoUser = excelCamposLogin.getCellData(1, 0);
		nomCampoPass = excelCamposLogin.getCellData(1, 1);
		nomBotonSing = excelCamposLogin.getCellData(1, 2);

		if (!(login.isElementPresentAndDisplay(login.getInputUserName()))) {
			Assert.fail("No se encontró el campo " + nomCampoUser);
		}
		if (!(login.isElementPresentAndDisplay(login.getInputPassword()))) {
			Assert.fail("No se encontró el campo" + nomCampoPass);
		}
		if (!(login.isElementPresentAndDisplay(login.getButtonSingIn()))) {
			Assert.fail("No se encontró el botón" + nomBotonSing);
		}
	} // Fin método verificarCamposLogin

	@Test(priority = 1)
	public void autenticarse() throws FileNotFoundException, IOException {

		pageB=new PageBase(driver, pageTitleIndex);
		// credenciales.xlsx
		excelCamposLogin = new ExcelUtils("credenciales.xlsx", ExcelType.XLSX);
		nombreUsuario = excelCamposLogin.getCellData(1, 0);
		contraseña = excelCamposLogin.getCellData(1, 1);

		pageB.sendText(login.getInputUserName(), nombreUsuario);
		pageB.sendText(login.getInputPassword(), contraseña);
		pageB.clickButtonLink(login.getButtonSingIn());
	}

}
