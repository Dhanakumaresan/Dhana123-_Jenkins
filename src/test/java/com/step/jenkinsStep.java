package com.step;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class jenkinsStep {
      WebDriver driver;
	@Given("User is on the registration form")
	public void user_is_on_the_registration_form() {
		driver=new ChromeDriver();
		driver.get("http://192.168.1.3:8080/register/");
	}
	@When("User login {string},{string},{string},{string}")
	public void user_login(String userName, String email, String pass, String confirmPass) {
		driver.findElement(By.id("username")).sendKeys(userName);
		
		driver.findElement(By.id("email")).sendKeys(email);

		driver.findElement(By.id("password")).sendKeys(pass);

		driver.findElement(By.id("confirmPassword")).sendKeys(confirmPass);
		
		driver.findElement(By.xpath("//button[text()='Register']")).click();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
	}
	@Then("User should verify success message after login {string}")
	public void user_should_verify_success_message_after_login(String expmsg) {
		WebElement text = driver.findElement(By.xpath("//p[text()='Thank you for registering!']"));
		String text2 = text.getText();
		Assert.assertEquals("Resister success msg",expmsg,text2);
	}



}
