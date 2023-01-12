package SwagLab.Menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLab_Menu_Page
{

	@FindBy(xpath = "//button[@id='react-burger-menu-btn']") private WebElement mennu;
	
	@FindBy(xpath = "//a[@id='logout_sidebar_link']") private WebElement logout;
	
	
	public SwagLab_Menu_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void Click_SwagLab_Menu_Page_MenuBtn() 
	{
		mennu.click();
	}
	
	public void Click_SwagLab_Menu_Page_LogoutBtn() 
	{
		logout.click();
	}
	
}
