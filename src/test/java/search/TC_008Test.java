package search;




import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import generic_Library.*;
import pom_Repo.*;

public class TC_008Test extends BaseUnit {
	@DataProvider(name="TC_008")
	public String[][] data() {
		return ReadData.readDataExcel("testData", 7);
	}

	@Test(dataProvider = "TC_008")
	public void addToCart(String[] data) { 
		Actions action=new Actions(driver);
		ElectronicsPage electronics=new ElectronicsPage(driver);
		WebDriverWait explicitWait=new WebDriverWait(driver, 15);
		explicitWait.until(ExpectedConditions.elementToBeClickable(common.getLogoutLink()));
		
		Point electronicsMajorTabPosition = electronics.getElectronicMajorTab().getLocation();
		//step 1:move the cursor on electronics Major tab
		action.moveByOffset(electronicsMajorTabPosition.getX(),electronicsMajorTabPosition.getY()).perform();

		//step 2:click on cellphones minor tab
		explicitWait.until(ExpectedConditions.visibilityOf(electronics.getCellPhonesMinorTab()));
		electronics.getCellPhonesMinorTab().click();
		String actualCellphonePage=electronics.getCellphonePage().getText();
		String expectedCellphonePage=data[0];
		Assert.assertEquals(actualCellphonePage, expectedCellphonePage, "Cellphone page is not displayed");
		Reporter.log("Cellphone page is displayed successfully",true);
		//step 3: click on under 500 filter price
		common.getSmartPhoneAddToCartbutton().click();

		//step 4:verifying the product is over 500.
		explicitWait.until(ExpectedConditions.visibilityOf(common.getNotificationForAddToCart()));
		boolean check=common.getNotificationForAddToCart().isDisplayed();
		
		Assert.assertEquals(check, true, "the smartphone is not added to cart");
		Reporter.log("The smartphone is added successfully to cart",true);

	}
}
