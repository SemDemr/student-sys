package sis.steps;



import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import sis.testbase.BaseClass;
import sis.utils.CommonMethods;

public class Hooks {

@Before
public void start() {
	
	BaseClass.setup();
	
	
	
	
	
	
}

@After
public void end(Scenario scenario) {
	

	
	byte[] picture;
	
	

	if(scenario.isFailed())
	{
		
		picture  = CommonMethods.takesScreenshot("failed/" + scenario.getName());
	}
	else
	{
		picture = CommonMethods.takesScreenshot("passed/"+ scenario.getName());
	}
	
	scenario.attach(picture, "image/png", scenario.getName());
	
	BaseClass.tearDown();
}





}





