package search;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import generic_Library.*;
import pom_Repo.SearchPage;

public class TC_003Test extends BaseUnit {
	@DataProvider(name="TC_003")
	public String[][] data() {
		return ReadData.readDataExcel("testData", 2);
	}
	@Test(dataProvider = "TC_003")
	public void sortByDropDown(String data[]) {  
		SearchPage seap=new SearchPage(driver);
		String product=data[0];
		//Step1:enter the product name in the searchbar
		explicitWait.until(ExpectedConditions.elementToBeClickable(common.getLogoutLink()));
		common.getSearchBar().clear();
		common.getSearchBar().sendKeys(product);
		Assert.assertEquals(common.getSearchBar().getAttribute("value"), product,"the given product is not entered properly");
		
		//Step 2:click on search button
		
		
		common.getSearchButton().click();
		
		//Step 3:Check the sortBy dropdown and values
		Select dropDown=new Select(seap.getSortByDropDown());
		List<WebElement> options = dropDown.getOptions();
		boolean alloptions=true;
		for(int i=1;i<data.length;i++) {
			for(WebElement dropdownData : options) {
				if(dropdownData.getText().equalsIgnoreCase(data[i])) {
					alloptions=true;
					break;
				}
				else 
					alloptions=false;
			}
		}
		Assert.assertEquals(alloptions,true,"All options are not displayed");	
	}
}
