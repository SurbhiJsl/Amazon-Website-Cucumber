package stepdef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class AddAddressStepdef {
	WebDriver driver;
	
	@Given("Amazon website is opened by the user on the browser by clicking url {string}.")
	public void amazon_website_is_opened_by_the_user_on_the_browser_by_clicking_url(String string) {
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe"); 
		  driver= new  FirefoxDriver(); 
		  driver.get(string);
	}

	@Given("User must be Signedin.")
	public void user_must_be_signedin() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.id("ap_email")).sendKeys("vebeti5990@zamaneta.com");
		Thread.sleep(3000);
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys("Veb&90");
		 driver.findElement(By.id("signInSubmit")).click();
	}

	@When("Click on Account & lists.")
	public void click_on_account_lists() throws InterruptedException {
		Thread.sleep(3000);
	    driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
	}

	@When("Click on Your Addresses.")
	public void click_on_your_addresses() throws InterruptedException {
		Thread.sleep(3000);
	    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[3]/div[1]/a/div")).click();
	}

	@Then("User must navigate to Add Address page.")
	public void user_must_navigate_to_add_address_page() {
	    String expectedTitle= "Your Addresses";
	    String actualTitle= driver.getTitle();
	    System.out.println(actualTitle);
	    Assert.assertEquals(expectedTitle, actualTitle);
	    driver.close();
	}

	@When("Click on Add Address.")
	public void click_on_add_address() {
	    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/div/div/a/div")).click();
	}

	@When("Select country as Canada.")
	public void select_country_as_canada() throws InterruptedException {
		 Thread.sleep(4000);
	    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/form/span/div/div[1]/div/div[2]/span/span/span/span")).click();
	  
	    driver.findElement(By.id("address-ui-widgets-countryCode-dropdown-nativeId_37")).click();
	    
	}

	@When("Enter Valid Full Name in Full Name field.")
	public void enter_valid_full_name_in_full_name_field() {
	    driver.findElement(By.id("address-ui-widgets-enterAddressFullName")).sendKeys("Jenny");
	}

	@When("Enter Valid Phone Number in Phone Number field.")
	public void enter_valid_phone_number_in_phone_number_field() {
	    driver.findElement(By.id("address-ui-widgets-enterAddressPhoneNumber")).sendKeys("2192378825");
	}

	@When("Enter Valid Address in Address first field.")
	public void enter_valid_address_in_address_first_field() {
	    driver.findElement(By.id("address-ui-widgets-enterAddressLine1")).sendKeys("Apt. 112,");
	}
	
	@When("Enter Valid Address in Address second field.")
	public void enter_valid_address_in_address_second_field() {
	    driver.findElement(By.id("address-ui-widgets-enterAddressLine2")).sendKeys("King Street");
	}

	@When("Enter a city of Canada")
	public void enter_a_city_of_canada() {
	    driver.findElement(By.id("address-ui-widgets-enterAddressCity")).sendKeys("Brampton");
	}

	@When("Select an option from drop down list of Province.")
	public void select_an_option_from_drop_down_list_of_province() {
	    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/form/span/div/div[1]/div/div[14]/span/span/span/span")).click();
	    driver.findElement(By.id("address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId_8")).click();
	}

	@When("Enter a valid postal code.")
	public void enter_a_valid_postal_code() {
	    driver.findElement(By.id("address-ui-widgets-enterAddressPostalCode")).sendKeys("N1G3K0");
	}

	@When("Click on Add AddressButton.")
	public void click_on_add_address_button() {
	    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/form/span/div/span/span/span/input")).click();
	}
	
	@When("Select Original Address RadioButton.")
	public void select_original_address_radio_button() {
	    driver.findElement(By.id("address-ui-widgets-original-address-block_id-input")).click();
	}

	@When("Click on Save Address.")
	public void click_on_save_address() {
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/form/span/div/span/span/span/input")).click();
	}

	@Then("Address must be saved in customer account address module.")
	public void address_must_be_saved_in_customer_account_address_module() {
	   String expectedTitle="Your Addresses";
	   String actualTitle= driver.getTitle();
	   System.out.println(actualTitle);
	   Assert.assertEquals(actualTitle, expectedTitle);
	}

	@When("^Enter invalid (.*) in Full Name field.$")
	public void enter_invalid_full_name_in_full_name_field(String fname) {
	    driver.findElement(By.id("address-ui-widgets-enterAddressFullName")).sendKeys(fname);
	}

	@When("^Enter invalid (.*) in Phone Number field.$")
	public void enter_invalid_phone_number_in_phone_number_field(String phone) {
		driver.findElement(By.id("address-ui-widgets-enterAddressPhoneNumber")).sendKeys(phone);
	}

	@When("^Enter invalid (.*) in Address first field.$")
	public void enter_invalid_afirst_field_in_address_first_field(String ffield) {
		driver.findElement(By.id("address-ui-widgets-enterAddressLine1")).sendKeys(ffield);
	}

	@When("^Enter invalid (.*) in Address second field.$")
	public void enter_invalid_asecond_field_in_address_second_field(String sfield) {
		driver.findElement(By.id("address-ui-widgets-enterAddressLine2")).sendKeys(sfield);
	}

	@When("^Enter an invalid (.*) of Canada.$")
	public void enter_an_invalid_city_of_canada(String city) {
		driver.findElement(By.id("address-ui-widgets-enterAddressCity")).sendKeys(city);
	}

	@When("^Enter an invalid (.*) in postal code.$")
	public void enter_an_invalid_postal_code_in_postal_code(String postalcode) {
		driver.findElement(By.id("address-ui-widgets-enterAddressPostalCode")).sendKeys(postalcode);
	}
	
	@Then("User must be on the add address page.")
	public void user_must_be_on_the_add_address_page() {
	    String expectedTitle1= "Your Addresses";
		String actualTitle1= driver.getTitle();
	    System.out.println(actualTitle1);
	    Assert.assertEquals(actualTitle1, expectedTitle1);
	    driver.close();
	}


 


	
	
}
