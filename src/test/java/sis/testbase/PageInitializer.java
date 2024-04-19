package sis.testbase;

import sis.pages.AddNewStudent;
import sis.pages.LoginPageElements;

public class PageInitializer extends BaseClass {

	public static LoginPageElements login;
	public static AddNewStudent add;
	
	
	
	
	
	
	
	
	
	
	
	
	public static void initialize() {
		login = new LoginPageElements();
		add = new AddNewStudent();
	}
	
	
	
	
	
	
	
}
