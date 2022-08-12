package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class DefineSteps {
	
	@Given("application is opened")
	public void application_is_opened() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new cucumber.api.PendingException();
	  System.out.println("app is opened");
	}

	@When("user brought mobile for {int}")
	public void user_brought_mobile_for(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new cucumber.api.PendingException();
	
	   System.out.println("user purchased mobile for "+int1);
	}


}
