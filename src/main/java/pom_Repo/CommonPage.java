package pom_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CommonPage {
	public WebDriver driver;
	public CommonPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	public WebElement getDisplayPageDropDown() {
		return displayPageDropDown;
	}

	public WebElement getRegisterLink() {
		return registerLink;
	}

	public WebElement getLoginLink() {
		return loginLink;
	}

	public WebElement getShoppingCartLink() {
		return shoppingCartLink;
	}

	public WebElement getWishListLink() {
		return wishListLink;
	}

	public WebElement getSearchBar() {
		return searchBar;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	@FindBy(linkText = "Register")
	private WebElement registerLink;
	@FindBy(linkText = "Log in")
	private WebElement loginLink;
	@FindBy(linkText = "Shopping cart")
	private WebElement shoppingCartLink;
	@FindBy(linkText = "Wishlist")
	private WebElement wishListLink;
	@FindBy(name = "q")
	private WebElement searchBar;
	@FindBy(xpath = "//input[@value='Search']")
	private WebElement searchButton;
	@FindBy(linkText = "Log out")
	private WebElement logoutLink;
	//new
	@FindBy(id = "bar-notification")private WebElement notificationForAddToCart;
	@FindBy(xpath = "(//input[@value='Add to cart'])[1]")private WebElement smartPhoneAddToCartbutton;
	@FindBy(id = "products-pagesize")private WebElement displayPageDropDown;
	@FindBy(xpath = "//div[@class='page-title']")private WebElement pageTitle;
	
	public WebElement getPageTitle() {
		return pageTitle;
	}

	public WebElement getSmartPhoneAddToCartbutton() {
		return smartPhoneAddToCartbutton;
	}

	public WebElement getNotificationForAddToCart() {
		return notificationForAddToCart;
	}

	public WebElement getLogoutLink() {
		return logoutLink;
	}
	public void selectOptionDropDown(String visbleText) {
		Select select=new Select(displayPageDropDown);
		select.selectByVisibleText(visbleText);
	}
	public void selectOptionDropDownByValue(String value) {
		Select select=new Select(displayPageDropDown);
		select.selectByVisibleText(value);
	}

}
