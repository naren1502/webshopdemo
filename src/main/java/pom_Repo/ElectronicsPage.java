package pom_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElectronicsPage {
	public WebDriver driver;
	public ElectronicsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	@FindBy(xpath = "(//a[contains(text(),'Electronics')])[1]")private WebElement electronicMajorTab;
	
	@FindBy(partialLinkText = "Camera, photo")private WebElement cameraPhotoMinorTab;
	
	@FindBy(partialLinkText = "Cell phones")private WebElement cellPhonesMinorTab;
	
	@FindBy(partialLinkText = "Handycam")private WebElement handyCamProduct;
	
	@FindBy (linkText = "Camcorder")private WebElement camcorderProduct;
	
	@FindBy(partialLinkText = "Digital SLR")private WebElement digitalSlrCamProduct;
	
	@FindBy(partialLinkText = "High Definition")private WebElement highDefinitionCamProduct;
	
	@FindBy(partialLinkText = "Under") private WebElement under500FilterByPrice;
	
	@FindBy(linkText = "Smartphone")private WebElement smartphoneProduct;
	
	@FindBy(xpath = "//h1[text()='Cell phones']")private WebElement cellphonePage;
	
	@FindBy(xpath = "//h1[text()='Camera, photo']")private WebElement cameraPhotoPage;
	
	@FindBy(xpath = "//h1[text()='Electronics']")private WebElement electronicsPage;
	
	@FindBy(linkText = "Remove Filter")private WebElement removeFliterLink;
	
	public WebElement getRemoveFliterLink() {
		return removeFliterLink;
	}

	public WebElement getSmartphoneProduct() {
		return smartphoneProduct;
	}

	public WebElement getCellphonePage() {
		return cellphonePage;
	}

	public WebElement getCameraPhotoPage() {
		return cameraPhotoPage;
	}

	public WebElement getElectronicsPage() {
		return electronicsPage;
	}

	public WebElement getElectronicMajorTab() {
		return electronicMajorTab;
	}

	public WebElement getCameraPhotoMinorTab() {
		return cameraPhotoMinorTab;
	}

	public WebElement getCellPhonesMinorTab() {
		return cellPhonesMinorTab;
	}

	public WebElement getHandyCamProduct() {
		return handyCamProduct;
	}

	public WebElement getCamcorderProduct() {
		return camcorderProduct;
	}

	public WebElement getDigitalSlrCamProduct() {
		return digitalSlrCamProduct;
	}

	public WebElement getHighDefinitionCamProduct() {
		return highDefinitionCamProduct;
	}

	public WebElement getUnder500FilterByPrice() {
		return under500FilterByPrice;
	}

	public WebElement getOver500FilterByPrice() {
		return over500FilterByPrice;
	}
	@FindBy(partialLinkText = "Over") private WebElement over500FilterByPrice;
}
