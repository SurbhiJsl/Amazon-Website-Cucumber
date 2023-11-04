package stepdef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateAccountStepdef {
	WebDriver driver;
	
	@Given("Amazon website should be open on the browser by clicking url {string}.")
	public void amazon_website_should_be_open_on_the_browser_by_clicking_url(String string) {
		
		  System.setProperty("webdriver.gecko.driver", "geckodriver.exe"); 
		  driver= new  FirefoxDriver(); 
		  driver.get(string);
		 
	}

	
	@When("Go to hello,Sign in and then click on Start here link.")
	public void go_to_hello_sign_in_and_then_click_on_start_here_link() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(By.linkText("Start here.")).click();
		
			
	}
	

	@Then("User must able to click on the link and moved to Create Account page.")
	public void user_must_able_to_click_on_the_link_and_moved_to_create_account_page() {
		String expectedResult1="Create account"; 
		WebElement createaccounttext= driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/form/div/div/h1")); 
		String actualResult1= createaccounttext.getText();
		Assert.assertEquals(actualResult1, expectedResult1);
			driver.close();
	}
	
	
	
	
	@When("Enter valid name in Your Name field.")
	public void enter_valid_name_in_your_name_field() {
	   driver.findElement(By.id("ap_customer_name")).sendKeys("Allen");
	}

	@When("Enter valid emailid or mobile number in Mobile number or email field.")
	public void enter_valid_emailid_or_mobile_number_in_mobile_number_or_email_field() {
	    driver.findElement(By.id("ap_email")).sendKeys("wejat25421@monutri.com");
	}

	@When("Enter valid password of six characters in Password field.")
	public void enter_valid_password_of_six_characters_in_password_field() {
	    driver.findElement(By.id("ap_password")).sendKeys("aln&1234");
	}
	
	@When("Enter same password as Password field in Again Password field.")
	public void enter_same_password_as_password_field_in_again_password_field() {
	    driver.findElement(By.id("ap_password_check")).sendKeys("aln&1234");
	}

	@When("Click on Verify email.")
	public void click_on_verify_email() throws InterruptedException {
		Thread.sleep(2000);
	    driver.findElement(By.id("continue")).click();
	    Thread.sleep(10000);
	}

	@Then("All the valid input data must be accepted and account of the user must be created..")
	public void all_the_valid_input_data_must_be_accepted_and_account_of_the_user_must_be_created() throws InterruptedException {
		  String expectedResult1="Enter OTP";
		  		  
		  Thread.sleep(10000);
		  WebElement otp1= driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div/div[1]/form/div[2]/div[1]"));
		  String actualResult1= otp1.getText();
		 
		  Assert.assertEquals(actualResult1, expectedResult1);
		  driver.close();
	}
	

@When("Leave name as blank in Your Name field.")
public void leave_name_as_blank_in_your_name_field() {
	driver.findElement(By.id("ap_customer_name")).sendKeys("");
}

@When("Leave emailid or mobile number as blank in Mobile number or email field.")
public void leave_emailid_or_mobile_number_as_blank_in_mobile_number_or_email_field() {
	driver.findElement(By.id("ap_email")).sendKeys("");
}

@When("Leave password as blank in Password field.")
public void leave_password_as_blank_in_password_field() {
	driver.findElement(By.id("ap_password")).sendKeys("");
}

@When("Leave Password field as blank in Again Password field.")
public void leave_password_field_as_blank_in_again_password_field() {
	driver.findElement(By.id("ap_password_check")).sendKeys("");
}

@When("Click on Continue button.")
public void click_on_continue_button() {
	driver.findElement(By.id("continue")).click();
}

@Then("User must be on the same page.")
public void user_must_be_on_the_same_page() {
    String expectedTitle= "Amazon Registration";
    String actualTitle= driver.getTitle();
    System.out.println(actualTitle);
    Assert.assertEquals(actualTitle, expectedTitle);
    driver.close();
}


	
}
