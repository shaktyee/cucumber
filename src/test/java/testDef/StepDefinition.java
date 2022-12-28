package testDef;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;

public class StepDefinition extends BaseTest{
	
//	WebDriver driver;
//	LoginPage lp;
	
	@Before
	public void setUp() throws Exception {
		FileInputStream fis = new FileInputStream("./TestData/config.properties");
		prop = new Properties();
		prop.load(fis);
		
		String brow = prop.getProperty("browser");
		
		if(brow.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		}
		
	}
	
	@Given("user launch chrome browser")
	public void user_launch_chrome_browser() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	    lp = new LoginPage(driver);
	}

	@When("user open app {string}")
	public void user_open_app(String url) {
	   driver.get(url);
	}

	@When("user enter email as {string} and password as {string}")
	public void user_enter_email_as_and_password_as(String email, String pwd) {
		lp.enterEmail(email);
		lp.enterPassword(pwd);
	}

	@When("user click on Login")
	public void user_click_on_Login() {
		lp.clickOnLogin();
	   
	}

	@Then("page Title should be {string}")
	public void page_Title_should_be(String expTitle) {
		lp.validateTitle(expTitle);

	}

	@When("user click on Logout link")
	public void user_click_on_Logout_link() {
		lp.clickOnLogout();
	 
	}

	@Then("close the browser")
	public void close_the_browser() {
		driver.close();

	}	

}
