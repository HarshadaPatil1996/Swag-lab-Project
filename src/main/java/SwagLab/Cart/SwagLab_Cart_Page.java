package SwagLab.Cart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLab_Cart_Page
{

	@FindBy(xpath = "//a[@class='shopping_cart_link']") private WebElement cart;
	@FindBy(xpath = "//div[@class='inventory_item_name']") private WebElement item;
	
	
  public SwagLab_Cart_Page(WebDriver driver)
  {
	  PageFactory.initElements(driver, this);
  }
	
	public void Click_SwagLab_Cart_Page_CartLogo() 
	{
		cart.click();
	}
	
	public String Get_SwagLab_Cart_Page_ItemText() 
	{
		String text=item.getText();
		
		return text;
	}
	
	
}
