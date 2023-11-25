package search;



import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import generic_Library.*;

public class TC_010Test extends BaseUnit {
	@DataProvider(name = "TC_010")
	public String[][] data() {
		return ReadData.readDataExcel("testData", 9);
	}
	@Test(dataProvider = "TC_010")
	public void addToTheProductToCart(String data[]) {
		String expectedResult=data[0];
		explicitWait.until(ExpectedConditions.elementToBeClickable(common.getLogoutLink()));
		
		//step 1: click on searchbutton without entering the data
		common.getSearchButton().click();
		
		//step 2:get the error message from the alert popup
		Alert alertPopUp = driver.switchTo().alert();
		String ActualResult = alertPopUp.getText();
		alertPopUp.accept();
		Assert.assertEquals(ActualResult,expectedResult,"Proper error message is not displayed");
		Reporter.log("Proper error message is displayed successfully",true);
		


	}
}
