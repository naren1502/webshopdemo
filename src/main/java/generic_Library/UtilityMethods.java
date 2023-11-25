package generic_Library;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class UtilityMethods {
	
	public static String errorShots(WebDriver driver,String fileName) throws IOException {
		
		File screenShot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String filePath = "./errorShots/"+fileName+".png";
		FileUtils.copyFile(screenShot, new File(filePath));
		
		return filePath;
	}
	
	public static String name() {
		LocalDateTime sysdate = LocalDateTime.now();
		return sysdate.toString().replace(":","_");
	}

}
