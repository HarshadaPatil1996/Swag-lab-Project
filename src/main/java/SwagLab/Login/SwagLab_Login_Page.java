package SwagLab.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLab_Login_Page 
{
	
	
	@FindBy(xpath = "//input[@id='user-name']" ) private WebElement UN;
	
	@FindBy(xpath = "//input[@id='password']") private WebElement PW;
	
	@FindBy(xpath = "//input[@id='login-button']")private WebElement LG;
	
	
	public SwagLab_Login_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	
	}
	
	public void Inp_SwagLab_Login_Page_Username(String key) 
	{
		UN.sendKeys(key);
	}
	
	
	public void Inp_SwagLab_Login_Page_Password(String key) 
	{
		PW.sendKeys(key);
	}
	
	
	public void Click_SwagLab_Login_Page_LoginBtn() 
	{
		LG.click();
		
		
	}
	
	
	
	
}
