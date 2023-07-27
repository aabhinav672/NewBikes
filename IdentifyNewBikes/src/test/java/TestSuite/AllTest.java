package TestSuite;

import org.testng.annotations.Test;

import Base.DriverSetup;
import Pages.ChennaiUsedCars;
import Pages.HondaDetails;
import Pages.LoginPage;

 class AllTest extends DriverSetup{
	HondaDetails hd= new HondaDetails(); 
	ChennaiUsedCars cu = new ChennaiUsedCars();
	LoginPage l= new LoginPage();
	@Test
	public void test() throws InterruptedException {
		hd.openUrl();
		hd.closeLoginPopUp();
		hd.clickUpcomingBikes();
		hd.selectManufacturer();
		hd.viewMore();
		hd.printDetails();
		cu.openUrl();
		cu.clickUsedCars();
		cu.clickPopularModels();
	    l.openUrl();
		l.clickLogin();
		l.clickGoogleSignIn();
		l.captureErrorMessage();
		hd.closeBrowser();
	}
}
