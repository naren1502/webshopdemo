package search;




import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import generic_Library.*;
import pom_Repo.*;

public class TC_009Test extends BaseUnit {
	@DataProvider(name="TC_009")
	public String[][] data() {
		return ReadData.readDataExcel("testData", 8);
	}

	@Test(dataProvider = "TC_009")
	public void addToCart(String[] data) { 
		
		JewelryPage jewelry=new JewelryPage(driver);

		WebDriverWait explicitWait=new WebDriverWait(driver, 15);
		explicitWait.until(ExpectedConditions.elementToBeClickable(common.getLogoutLink()));
		//step 1:move the cursor on jewelary Major tab
		jewelry.getJewelryMajorTab().click();
		explicitWait.until(ExpectedConditions.visibilityOf(common.getPageTitle()));
		String actualJewelryPage=common.getPageTitle().getText();
		String expectedJewelryPage=data[0];
		Assert.assertEquals(actualJewelryPage, expectedJewelryPage, "Jewelry page is not displayed");
		Reporter.log("Jewelry page is displayed successfully",true);
		int expectedProductDisplayeInpage = (int) Double.parseDouble(data[1]);
		
		//step 2:select display 4 product per page
		common.selectOptionDropDown(expectedProductDisplayeInpage+"");
	
		//step 3: checking how many product displayed in current page
		List<WebElement> products = driver.findElements(By.xpath("//div[@class='product-item']"));
		int actualProductDisplayeInpage=products.size();
		Assert.assertEquals(actualProductDisplayeInpage, expectedProductDisplayeInpage, "The product is not displayed as per display dropdown");
		Reporter.log("4 product is displayed as per the selection",true);

	}
}
