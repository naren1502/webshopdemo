package search;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import generic_Library.BaseUnit;
import generic_Library.ReadData;

public class TC_004Test extends BaseUnit{

	@DataProvider(name = "TC_004")
	public String[][] data() {
		return ReadData.readDataExcel("testData",3);
	}
	@Test(dataProvider = "TC_004")
	public void placeholder(String[] data) {
		//check the placeholder
		explicitWait.until(ExpectedConditions.elementToBeClickable(common.getLogoutLink()));
		String actualPlaceholder = common.getSearchBar().getAttribute("value");
		String expectedPlaceholder=data[0];
		Assert.assertEquals(actualPlaceholder,expectedPlaceholder , "Placeholder value is not displayed");
		Reporter.log("Placeholder is displayed",true);

	}
}
