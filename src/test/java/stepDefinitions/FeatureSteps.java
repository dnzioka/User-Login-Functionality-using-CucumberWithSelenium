package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.LoginPage;

public class FeatureSteps {
	public WebDriver driver;
	public LoginPage lp;
	
	@Given("User launches Chrome browser")
	public void user_launches_chrome_browser() {
		System.setProperty("webdriver.chrome.drive", "user.dir" + "//Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		lp = new LoginPage(driver);
	    
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);
	    
	}

	@When("User enters Email as {string} and Password {string}")
	public void user_enters_email_as_and_password(String email, String password) {
		lp.setUsername(email);
		lp.setPassword(password);
	    
	}

	@When("Click on Login")
	public void click_on_login() {
		lp.clickLogin();
	    
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String title) throws InterruptedException {
		
		if(driver.getPageSource().contains("Login was unsuccessful.")) {
			driver.close();
			Assert.assertTrue(false);
		}
			else {
				Assert.assertEquals(title, driver.getTitle());
			}  
		Thread.sleep(1000);
	}

	@When("User click on log out link")
	public void user_click_on_log_out_link() throws InterruptedException {
		lp.clickLogout();
		Thread.sleep(1000);
	    
	}

	@Then("close browser")
	public void close_browser() {
		driver.close();
	   
	}
	

}
