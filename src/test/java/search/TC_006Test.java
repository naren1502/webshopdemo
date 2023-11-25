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

public class TC_006Test extends BaseUnit {
	@DataProvider(name="TC_006")
	public String[][] data() {
		return ReadData.readDataExcel("testData", 5);
	}

	@Test(dataProvider = "TC_006")
	public void filterByPrice(String data[]) {  
		ElectronicsPage electronics=new ElectronicsPage(driver);

		WebDriverWait explicitWait=new WebDriverWait(driver, 15);
		explicitWait.until(ExpectedConditions.elementToBeClickable(common.getLogoutLink()));

		//step 1:click on electronics Major tab
		electronics.getElectronicMajorTab().click();
		String actualElectonicsPage = electronics.getElectronicsPage().getText();
		String expectedElectonicsPage=data[0];
		Assert.assertEquals(actualElectonicsPage, expectedElectonicsPage, "Electronics page is not displayed");
		Reporter.log("Electronics page is displayed successfully",true);
		
		//step 2:click on camera,photo minor tab
		electronics.getCameraPhotoMinorTab().click();
		String actualCameraPhotoPage=electronics.getCameraPhotoPage().getText();
		String expectedCameraPhotoPage=data[1];
		Assert.assertEquals(actualCameraPhotoPage, expectedCameraPhotoPage, "Camera,photo page is not displayed");
		Reporter.log("Camera,photo page is displayed successfully",true);
		
		//step 3: click on under 500 filter price
		electronics.getUnder500FilterByPrice().click();

		//step 4:verifying the product is under 500.
		List<WebElement> prices = driver.findElements(By.xpath("//div[@class='prices']"));
		boolean check=true;

		for(WebElement price :prices) {
			int value = (int) Double.parseDouble(price.getText().replaceAll("[^0-9 .]",""));
			System.out.println(value);
			
			if(value>500)
				check=false;		
		}
		Assert.assertEquals(check, true, "the product value is more than 500");
		Reporter.log("The product is displayed displayed successfully under 500 price range",true);

	}
}
