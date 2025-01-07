package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.testng.Reporter;

public class ReadPropertyFile {

	private Properties prop;
	
	
	public ReadPropertyFile(String filepath)
	{
		try
		{
			File file = new File(filepath);
			FileInputStream fileinputstream = new FileInputStream(file);
			prop = new Properties();
			prop.load(fileinputstream);
		}
		catch(Exception e)
		{
			e.getStackTrace();
			Reporter.log(e.getMessage());
		}
	}
	
	public String getProperty(String key)
	{
		return prop.getProperty(key);
	}
}
