package sis.steps;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import sis.utils.CommonMethods;

public class LoginPageLanding extends CommonMethods {

	@And("I validated that the logo is visible")
	public void i_validated_that_the_logo_is_visible() {
		Assert.assertTrue(login.logo.isDisplayed());
	}

	@Then("I validated that the SIS Login text is visible")
	public void i_validated_that_the_sis_login_text_is_visible() {
		String text = "Student Information System© Login";
		String actualText = login.headerMid.getText();
		Assert.assertEquals(text, actualText);
	}

	@Then("I validated that username box is visible")
	public void i_validated_that_username_box_is_visible() {
		Assert.assertTrue(login.username.isDisplayed());
	}

	@Then("I validated that pasword box is visible")
	public void i_validated_that_pasword_box_is_visible() {
		Assert.assertTrue(login.password.isDisplayed());
	}

	@Then("I validated that academic year box is visible")
	public void i_validated_that_academic_year_box_is_visible() {
		Assert.assertTrue(login.aYear.isDisplayed());
	}

	@Then("I validated that login button is visible")
	public void i_validated_that_login_button_is_visible() {
		Assert.assertTrue(login.login.isDisplayed());
	}

	@Then("I validated that forgot password link is visible")
	public void i_validated_that_forgot_password_link_is_visible() {
		Assert.assertTrue(login.forgotPass.isEnabled());
	}

}
