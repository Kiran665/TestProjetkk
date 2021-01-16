package utilitiesForGmail;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class UtilitiesGmail {
	
	// 1. Taking Screenshot
		public static void screenshote_k(WebDriver driver,String screenshotname)
		{
			TakesScreenshot s=(TakesScreenshot)driver;
			File source=s.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(source, new File("./Screenshots/"+screenshotname+".png"));
			} catch (Exception e) {
				System.out.println("the exception is"+e.getMessage());
			}
			System.out.println("Screenshot Taken....");	
		}


}
