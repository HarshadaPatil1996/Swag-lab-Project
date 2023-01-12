package LibraryFiles;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import net.bytebuddy.utility.RandomString;

public class Utility_Class
{
     
    
	public static String GetPropertyFileTD(String key) throws IOException
	   //Created by= Harshada Patil
	{ //this method is to get test data from propeties file, just need a string key.
	
		FileInputStream file=new FileInputStream("C:\\Users\\Sairam\\eclipse-workspace\\SwagLab\\PropertiesFile.properties");
		
		Properties pr=new Properties();
		
		pr.load(file);
		
		String value=pr.getProperty(key);
		
		return value;
		
	
	}
	
	public static String GetTD(int rowindex,int cellindex) throws EncryptedDocumentException, IOException 
	
	{// this method is create to get test data from excel sheet.
		FileInputStream file=new FileInputStream("C:\\Users\\Sairam\\eclipse-workspace\\SwagLab\\Test data\\Swag Lab Test Data.xlsx");
		
		Sheet sh = WorkbookFactory.create(file).getSheet("Sheet1");
		
		String value1 = sh.getRow(rowindex).getCell(cellindex).getStringCellValue();
		
		return value1;
	}
	
	public static void GetScreenShot(WebDriver driver,int TCID) throws IOException
	
	{   //this method is created to capture failed test case screenshots. 
		String a=RandomString.make(2);
	
		File local = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		
		File src=new File("F:\\16JulyA_SeleniumMaven\\16JulyA_SeleniumMaven\\FailedTCesScreenshots\\Failed"+a+".jpg");
		
		FileHandler.copy(local, src);
		
	}

}
