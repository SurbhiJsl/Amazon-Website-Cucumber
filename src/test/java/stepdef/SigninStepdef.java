package stepdef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;


public class SigninStepdef {
	WebDriver driver;
	
 
	@Given("User must be open the website by clicking url {string}.")
	public void user_must_be_open_the_website_by_clicking_url(String string) {
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe"); 
		  driver= new  FirefoxDriver(); 
		  driver.get(string);
	}
	 
	
	@When("Go to Hello, Sign in and then Click on Sign in button.")
	public void go_to_hello_sign_in_and_then_click_on_sign_in_button() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.linkText("Sign in")).click();
	}
	

	@When("Enter valid email id in Mobile number or email field.")
	public void enter_valid_email_id_in_mobile_number_or_email_field() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(By.id("ap_email")).sendKeys("vebeti5990@zamaneta.com");
	}
	
	@When("Click on Continue button to enter password.")
	public void click_on_continue_button_to_enter_password() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.id("continue")).click();
	}
		

	@When("Enter valid password in Password field.")
	public void enter_valid_password_in_password_field() {
	    driver.findElement(By.id("ap_password")).sendKeys("Veb&90");
	}

	@When("Click on Sign in button.")
	public void click_on_sign_in_button() {
	  driver.findElement(By.id("signInSubmit")).click();
	}

	@Then("User is navigated to his or her account.")
	public void user_is_navigated_to_his_or_her_account() {
		String expectedTitle= "Amazon.ca: Low Prices – Fast Shipping – Millions of Items";
		String actualTitle= driver.getTitle();
		System.out.println(actualTitle);
		Assert.assertEquals(expectedTitle, actualTitle);
		driver.close();
	}
	
	@When("Enter valid mobile number in Mobile number or email.")
	public void enter_valid_mobile_number_in_mobile_number_or_email() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(By.id("ap_email")).sendKeys("2192378825");
	}
	
	@When("^Enter (.*) in Mobile number or email id.$")
	public void enter_email_in_mobile_number_or_email_id(String emailid) {
		driver.findElement(By.id("ap_email")).sendKeys(emailid);
	}

	@When("^Enter invalid (.*) in Password field.$")
	public void enter_invalid_in_password_field(String pwd) {
		driver.findElement(By.id("ap_password")).sendKeys(pwd);
	}

	@Then("User must not be able to login with invalid password.")
	public void user_must_not_be_able_to_login_with_invalid_password() {
	  
	String expectedText1= "Sign in";
		WebElement invalidPassword= driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div[2]/div/h1"));
		String actualText1= invalidPassword.getText();
		Assert.assertEquals(actualText1, expectedText1);
		driver.close();
	}  
	

	@When("Leave email or mobile number in email or Mobile number field as blank.")
	public void leave_email_or_mobile_number_in_email_or_mobile_number_field_as_blank() {
		driver.findElement(By.id("ap_email")).sendKeys("");
	}

	@Then("User must not be able to login with invalid blank email id.")
	public void user_must_not_be_able_to_login_with_invalid_blank_email_id() {
		String expectedText2= "Sign in";
	 WebElement blankEmail = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[1]/form/div/div/div/h1"));
	 String actualText2= blankEmail.getText();
	 Assert.assertEquals(actualText2, expectedText2);
	 driver.close();
	
	}

	
	
	
}
