package search;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import generic_Library.*;


public class TC_005Test extends BaseUnit{
	@DataProvider(name = "TC_005")
	public String[][] data() {
		return ReadData.readDataExcel("testData",4);
	}
	@Test(dataProvider = "TC_005")
	public void placeholder(String[] data) {
		//check the placeholder
		explicitWait.until(ExpectedConditions.elementToBeClickable(common.getSearchBar()));
		common.getSearchBar().sendKeys(data[0]);;
		String expectdData=data[0];
		String actualPlaceholder = common.getSearchBar().getAttribute("value");
		Assert.assertEquals(actualPlaceholder,expectdData, "Placeholder value is not disappeared");
		Reporter.log("Placeholder is disappeared",true);

	}
}
