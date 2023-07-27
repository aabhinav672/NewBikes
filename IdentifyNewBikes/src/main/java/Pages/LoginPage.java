package Pages;

import org.openqa.selenium.By;


import Base.DriverSetup;

public class LoginPage extends DriverSetup {
	By lclose = By.id("alternate-login-close");
	By login = By.id("des_lIcon");
	By googleSignIn = By.xpath("(//span[text()='Google'])");
	By email = By.xpath("(//input[@type='email'])");
	By submit = By.xpath("//span[text()='Next']");
	By error = By.xpath("(//div[@class='o6cuMc Jj6Lae'])");

	public void clickLogin() // Method to click Login
	{
		logger = report.createTest("Clicking on login/signup");
		try {
			driver.findElement(login).click();
			Thread.sleep(5000);
			String login1 = "Login/Register to";
			String ver = driver.findElement(By.xpath(
					"//span[text()='Google']"))
					.getText();
			if (ver.contains(login1))
				reportPass("Login/Signup button is clicked");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	public void clickGoogleSignIn() throws InterruptedException // Method to sign up with wrong email
	{
		logger = report.createTest("Error Checking after signup");
		try {
		driver.findElement(googleSignIn).click();
		for (String window : driver.getWindowHandles()) {
			driver.switchTo().window(window);
		}
		driver.findElement(email).sendKeys("Abhinav556@gml.com");
		driver.findElement(submit).click();
		String errorMessage = driver.findElement(error).getText();
		if (errorMessage.contains("Couldn't find your Google Account")) 
			reportPass("Error msg displayed after signup with wrong email");
		Thread.sleep(2000);
		}catch (Exception e) {
			reportFail(e.getMessage());
			}
		
	}

	public void captureErrorMessage() // Method to capture error message
	{
		System.out.println("*******************************************************");
		System.out.println("              Error Obtained during Signup:");
		System.out.println("*******************************************************");
		String errorMessage = driver.findElement(error).getText();
		System.out.println("Error Message = " + errorMessage);
	}

}

