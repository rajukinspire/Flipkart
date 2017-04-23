package pages;

import org.openqa.selenium.By;
import globallibrary.BaseClass;
import globallibrary.GlobalLibrary;

public class LoginPage extends BaseClass{
	
	public String mailTextBox="(//input[@type='text'])[2]";
	public String pwdTextBox="(//input[@type='password'])";
	public String submit="(//button[@type='submit'])[2]";
	public String logIn="//a[text()='Log In']";
	
	private static LoginPage loginPage=null;
	private  LoginPage(){
		
		
	}
	
	public static LoginPage getLoginPage(){
		
		if(loginPage==null){
			
			loginPage=new LoginPage();
			
		}
		return loginPage;
	}
	
	
	
	public void loginApplication(String username,String password){
		
		GlobalLibrary.clickObject("Click Next Button", logIn);
		GlobalLibrary.setText("Enter the user Name", mailTextBox, username);
		GlobalLibrary.setText("Enter the user Name", pwdTextBox, password);
		GlobalLibrary.clickObject("Click Next Button", submit);
		
		
		
		
	}

}
