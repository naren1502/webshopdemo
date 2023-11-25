package search;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import generic_Library.*;

public class TC_001Test extends BaseUnit {
	@DataProvider(name = "TC_001")
	public String[][] data() {
		return ReadData.readDataExcel("testData", 0);
	}
	@Test(dataProvider ="TC_001" )
	public void addToTheProductToCart(String[] data) {
		String product=data[0];
		//Step 1:enter the product name in the searchbar
		explicitWait.until(ExpectedConditions.elementToBeClickable(common.getLogoutLink()));
		common.getSearchBar().clear();
		common.getSearchBar().sendKeys(product);
		Assert.assertEquals(common.getSearchBar().getAttribute("value"), product,"the given product is not entered properly");
		
		//step 2:click on search button
		common.getSearchButton().click();
		
		List<WebElement> productTitles = driver.findElements(By.xpath("//h2[@class='product-title']"));
		
		String productName = null;
		for(WebElement productTitle : productTitles) {
			String actualProductName = productTitle.getText();
			if(product.equalsIgnoreCase(actualProductName))
				productName=actualProductName;
		}
		
		//Step 3:verify the product is displayed or not
		Assert.assertEquals(productName, product,"Product is not visible");
		Reporter.log("searched product is displayed successfully",true);
		
		
	}
}
