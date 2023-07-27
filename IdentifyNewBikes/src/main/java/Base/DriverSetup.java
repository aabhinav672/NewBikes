package Base;

//import java.io.File;
import java.io.FileInputStream;
//import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.OutputType;
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
//import com.google.common.io.Files;

import utils.ExtentReportManager;

public class DriverSetup {
	public static WebDriver driver;
	public static Properties prop;

	public ExtentReports report = ExtentReportManager.getReportInstance();
	public ExtentTest logger;

	@BeforeSuite
	public void driverSetup() {
		prop = new Properties();
		try {
			prop.load(new FileInputStream("src/main/java/Config/Config.properties")); // Loading the properties
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (prop.getProperty("browserName").matches("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\browserdrivers\\chromedriver.exe");
			ChromeOptions option = new ChromeOptions();
			option.addArguments("start-maximized");
		     option.addArguments("--disable-blink-features=AutomationControlled");
		     option.addArguments("--disable-notifications");// Disabling any notifications
		        driver = new ChromeDriver(option);
			 // Initializing the new chrome driver
		}
		if (prop.getProperty("browserName").matches("firefox")) {
			driver = new FirefoxDriver(); // Initializing the new firefox driver
		}
		driver.manage().window().maximize(); // To maximize the window
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS); // Waiting time to load the page completely
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // Adding driver waits to timeouts

	}

	public void openUrl() // Method to open URL for smoke test
	{
		logger = report.createTest("Opening Url");
		try {
			driver.get(prop.getProperty("url"));
			reportPass("URL opened, URL is :" + prop.getProperty("url"));
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}
	// Function to show the failed test cases in the report
	public void reportFail(String report) {
		logger.log(Status.FAIL, report);
		
	}

	// Function to show the passed test cases in the report
	public void reportPass(String report) {
		logger.log(Status.PASS, report);
	}


	@AfterSuite
	public void closeBrowser() // method to close the browser
	{
		driver.quit(); // To close the browser
		report.flush(); // To save the reports
		try {
			Runtime.getRuntime().exec("taskkill /f /im chromedriver.exe");
			Runtime.getRuntime().exec("taskkill /f /im geckodriver.exe");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}
}
