package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features={".\\src\\test\\java\\feature\\createaccount.feature",".\\src\\test\\java\\feature\\signin.feature",
		".\\src\\test\\java\\feature\\addaddress.feature"},glue={"stepdef"},
plugin= {"pretty","html:target/Htmlreports"},monochrome=true,dryRun=true,tags=("@AddAddressPage or @AddAddressValidData or @AddAddressInvalidData"))


public class Testrunner {

}
