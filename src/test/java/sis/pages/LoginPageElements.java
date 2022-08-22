package sis.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sis.utils.CommonMethods;
import sis.utils.ConfigsReader;

public class LoginPageElements extends CommonMethods {

	@FindBy(id = "logoTop")
	public WebElement logo;

	@FindBy(id = "tUsername")
	public WebElement username;

	@FindBy(css = "#tPassword")
	public WebElement password;

	@FindBy(css = "#dAcademicYear_list")
	public WebElement aYear;

	@FindBy(css = "#bLogin")
	public WebElement login;

	@FindBy(xpath = "//a[@onclick='OpenForgotPassword();']")
	public WebElement forgotPass;

	@FindBy(xpath = "//font[@class='headerMid']")
	public WebElement headerMid;

	public LoginPageElements() {
		PageFactory.initElements(driver, this);
	}

	public void signIn() {

		sendKeys(username, ConfigsReader.getProperty("username"));
		wait(1);
		sendKeys(password, ConfigsReader.getProperty("password"));
		wait(1);
		login.click();

	}

}
