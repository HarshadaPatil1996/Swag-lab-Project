package SwagLab.Home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverInfo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLab_Home_Page 
{

	@FindBy(xpath = "//div[@class='app_logo']") private WebElement Logo;
	
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']") private WebElement cart;
	
	@FindBy(xpath = "//button[@id='remove-sauce-labs-backpack']") private WebElement remove;
	
	public SwagLab_Home_Page (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean check_SwagLab_Home_Page_logo() 
	{
		boolean result = Logo.isEnabled();
		
		return result;
	}
	
	public void Click_SwagLab_Home_Page_AddtoCartBtn() 
	{
		cart.click();
		
	}
	
	public String verify_SwagLab_Home_Page_text() 
	{
       String text=remove.getText();
		
		return text;
	}
	
}
