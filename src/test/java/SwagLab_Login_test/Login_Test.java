package SwagLab_Login_test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import LibraryFiles.Base_Class;
import LibraryFiles.Utility_Class;
import SwagLab.Login.SwagLab_Login_Page;

public class Login_Test extends Base_Class
{

	SwagLab_Login_Page login;
	
	int TCID;
	
	
	@BeforeClass
    
	public void OpenBrowser() throws IOException 
	
	{
		Initialize_Browser();
		
		login=new SwagLab_Login_Page(driver);
	}
	
	
	@Test
	
	public void Verify_Login_Using_Valid_Cred() throws IOException 
	
	{   
		TCID=101;
		login.Inp_SwagLab_Login_Page_Username(Utility_Class.GetPropertyFileTD("username"));
		
		login.Inp_SwagLab_Login_Page_Password(Utility_Class.GetPropertyFileTD("password"));
		
	    login.Click_SwagLab_Login_Page_LoginBtn();
	    
	    String exp=driver.getCurrentUrl();
	    String act=Utility_Class.GetTD(0, 0);
	    Reporter.log(act,true);
	    assertEquals(act, exp,"failed");
		
	}
	
	@AfterMethod
	public void screenshot(ITestResult result) throws IOException 
	{
		if (result.getStatus()==ITestResult.FAILURE) 
		{
			Utility_Class.GetScreenShot(driver, TCID);
		}
		
		
	}
	
	
	@AfterClass
	public void Close_Browser() 
	{
		driver.quit();
	}
	
	
}