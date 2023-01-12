package LibraryFiles;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base_Class
{
	
	protected WebDriver driver;
	
	
	public void Initialize_Browser() throws IOException
	{
		
		driver=new ChromeDriver();
				
		driver.manage().window().maximize();
		
		driver.get(Utility_Class.GetPropertyFileTD("url"));
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	}
	
}
