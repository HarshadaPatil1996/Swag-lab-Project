package SwagLab_Login_test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LibraryFiles.Base_Class;
import LibraryFiles.Utility_Class;
import SwagLab.Cart.SwagLab_Cart_Page;
import SwagLab.Home.SwagLab_HomeFilter_page;
import SwagLab.Home.SwagLab_Home_Page;
import SwagLab.Login.SwagLab_Login_Page;
import SwagLab.Menu.SwagLab_Menu_Page;

public class HomePage_test extends Base_Class
{

	SwagLab_Home_Page home;
	
	SwagLab_Login_Page login;
	
	SwagLab_Menu_Page menu;
	SwagLab_Cart_Page cart;
	SwagLab_HomeFilter_page filter;
	int TCID;
	
	
    @BeforeClass
	public void Open_Browser() throws IOException 
	{
		Initialize_Browser();
		
		home=new SwagLab_Home_Page(driver);
		
		login=new SwagLab_Login_Page(driver);
		 
		menu =new SwagLab_Menu_Page(driver);
		
    	cart=new SwagLab_Cart_Page(driver);
    	
    	filter=new SwagLab_HomeFilter_page(driver);
	}
	
	@BeforeMethod
	public void Login() throws IOException, InterruptedException
	
	{
		login.Inp_SwagLab_Login_Page_Username(Utility_Class.GetPropertyFileTD("username"));
		Thread.sleep(1000);
		login.Inp_SwagLab_Login_Page_Password(Utility_Class.GetPropertyFileTD("password"));
		Thread.sleep(1000);
		login.Click_SwagLab_Login_Page_LoginBtn();
		Thread.sleep(1000);
	}
	
	@Test(priority = 1,enabled = false)
	public void Verify_Logo() throws InterruptedException
	{
		TCID=1;
		Thread.sleep(1000);
		boolean act = home.check_SwagLab_Home_Page_logo();
		
		assertTrue(act, "Failed--Logo not present");
		
		
	}
	
	@Test(priority = 2,enabled = false)
	public void Verify_AddtoCart_Text_Change() throws EncryptedDocumentException, IOException, InterruptedException 
	{
		TCID=2;
		Thread.sleep(1000);
		home.Click_SwagLab_Home_Page_AddtoCartBtn();
		Thread.sleep(1000);
		
		String act=home.Get_SwagLab_Home_Page_Btntext();
		String exp=Utility_Class.GetTD(1,0);
		
		assertEquals(exp, act,"Failed--Both results are different");
		Thread.sleep(1000);
		home.Click_SwagLab_Home_Page_RemoveBtn();
		
	}
	
	@Test(priority = 3,enabled = false)
	public void Verify_selected_Item() throws EncryptedDocumentException, IOException, Exception 
	{
		TCID=3;
		Thread.sleep(1000);
		home.Click_SwagLab_Home_Page_AddtoCartBtn();
		Thread.sleep(1000);
		cart.Click_SwagLab_Cart_Page_CartLogo();
		
		String act = cart.Get_SwagLab_Cart_Page_ItemText();
		String exp=Utility_Class.GetTD(2, 0);
		
		assertEquals(exp, act,"Failed--Both results are different");
		Thread.sleep(1000);
	}
	
	@Test(priority=4)
	public void verify_dropdown_LowtoHigh() throws EncryptedDocumentException, IOException 
	{
		TCID=4;
		
		filter.Click_SwagLab_HomeFilter_page_filterBtn();
		
		filter.Click_SwagLab_HomeFilter_page_dropdownOption();
		String act=filter.Get_SwagLab_HomeFilter_page_DropdownText();
		
		String exp=Utility_Class.GetTD(2, 1);
		
		Assert.assertEquals(act, exp,"Failed--Both results are different");
		
	}
	
	@AfterMethod
	public void Logout(ITestResult result) throws IOException, InterruptedException 
	{
		if (result.getStatus()==ITestResult.FAILURE) 
		{
			Utility_Class.GetScreenShot(driver, TCID);
			
		}
		Thread.sleep(1000);
		menu.Click_SwagLab_Menu_Page_MenuBtn();
		Thread.sleep(1000);
		menu.Click_SwagLab_Menu_Page_LogoutBtn();
		
	}
	
	@AfterClass
	public void Close_Browser() throws InterruptedException 
	{
		Thread.sleep(1000);
		driver.quit();
	}
	
}
