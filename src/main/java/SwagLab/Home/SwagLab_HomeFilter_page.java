package SwagLab.Home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SwagLab_HomeFilter_page
{

	@FindBy(xpath = "//select[@class='product_sort_container']") private WebElement filter;
	
	@FindBy(xpath = "//option[text()='Price (low to high)']")private WebElement LtoH;
	

   public SwagLab_HomeFilter_page(WebDriver driver)
   {
	   PageFactory.initElements(driver, this);
   }
	
    public void Click_SwagLab_HomeFilter_page_filterBtn() 
    {
	       filter.click();
    }
	
	
    public void Click_SwagLab_HomeFilter_page_dropdownOption() 
    {
	        LtoH.click();
	        
    }
	
	
	public String Get_SwagLab_HomeFilter_page_DropdownText() 
	{
		String text = LtoH.getText();
		return text;
	}
	
	
	
	
	
	
	
	
	
	
}
