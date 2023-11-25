package search;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import generic_Library.*;
import pom_Repo.*;

public class TC_002Test extends BaseUnit {
	@DataProvider(name = "TC_002")
	public String[][] data() {
		return ReadData.readDataExcel("testData", 1);
	}
	@Test(dataProvider = "TC_002")
	public void addToTheProductToCart(String data[]) {

		String product=data[0];
		String expectedResult=data[1];
		//Step 1:enter the product name in the searchbar
		explicitWait.until(ExpectedConditions.elementToBeClickable(common.getLogoutLink()));
		SearchPage search=new SearchPage(driver);
		common.getSearchBar().clear();
		common.getSearchBar().sendKeys(product);
		Assert.assertEquals(common.getSearchBar().getAttribute("value"),product,"product name is not entered properly");
		Reporter.log("Product name is entered successfully",true);
		//step 2:click on search button
		common.getSearchButton().click();

		String actualResult=search.getInvalidResult().getText();
		//step 3:verify the product is displayed or not
		Assert.assertEquals(actualResult, expectedResult,"invalid product is visible in the search area");
		Reporter.log("Invalid products are not displayed",true);


	}
}
