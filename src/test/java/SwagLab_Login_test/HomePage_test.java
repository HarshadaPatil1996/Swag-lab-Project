package SwagLab_Login_test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LibraryFiles.Base_Class;
import LibraryFiles.Utility_Class;
import SwagLab.Home.SwagLab_Home_Page;
import SwagLab.Login.SwagLab_Login_Page;
import SwagLab.Menu.SwagLab_Menu_Page;

public class HomePage_test extends Base_Class
{

	SwagLab_Home_Page home;
	
	SwagLab_Login_Page login;
	
	SwagLab_Menu_Page menu;
	
	int TCID;
	
	
    @BeforeClass
	public void Open_Browser() throws IOException 
	{
		Initialize_Browser();
		
		home=new SwagLab_Home_Page(driver);
		
		login=new SwagLab_Login_Page(driver);
		 
		menu =new SwagLab_Menu_Page(driver);
    	
	}
	
	@BeforeMethod
	public void Login() throws IOException
	
	{
		login.Inp_SwagLab_Login_Page_Username(Utility_Class.GetPropertyFileTD("username"));
		
		login.Inp_SwagLab_Login_Page_Password(Utility_Class.GetPropertyFileTD("password"));
		
		login.Click_SwagLab_Login_Page_LoginBtn();
		
	}
	
	@Test(priority = 1)
	public void Verify_Logo()
	{
		TCID=1;
		
		boolean act = home.check_SwagLab_Home_Page_logo();
		
		assertTrue(act, "Failed--Logo not present");
		
		
	}
	
	@Test(priority = 2)
	public void Verify_AddtoCart_Text_Change() throws EncryptedDocumentException, IOException, InterruptedException 
	{
		
		home.Click_SwagLab_Home_Page_AddtoCartBtn();
		Thread.sleep(1000);
		
		String exp=home.verify_SwagLab_Home_Page_text();
		String act=Utility_Class.GetTD(1,0);
		
		assertEquals(exp, act,"Failed--Both results are different");
		
	}
	
	@AfterMethod
	public void Logout(ITestResult result) throws IOException 
	{
		if (result.getStatus()==ITestResult.FAILURE) 
		{
			Utility_Class.GetScreenShot(driver, TCID);
			
		}
		
		menu.Click_SwagLab_Menu_Page_MenuBtn();
		
		menu.Click_SwagLab_Menu_Page_LogoutBtn();
		
	}
	
	@AfterClass
	public void Close_Browser() 
	{
		driver.quit();
	}
	
}
