package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "Email")
	WebElement email_txt;
	
	@FindBy(id = "Password")
	WebElement pwd_txt;
	
	@FindBy(tagName = "button")
	WebElement login_btn;
	
	@FindBy(linkText = "Logout")
	WebElement logout_btn;
	
	public void enterEmail(String email) {
		email_txt.clear();;
		email_txt.sendKeys(email);
	}
	
	public void enterPassword(String pwd) {
		pwd_txt.clear();
		pwd_txt.sendKeys(pwd);
	}
	
	public void clickOnLogin() {
		login_btn.click();
	}
	
	public void clickOnLogout() {
		logout_btn.click();
	}
	
	public void validateTitle(String title) {
		Assert.assertEquals(title, driver.getTitle());
	}
}
