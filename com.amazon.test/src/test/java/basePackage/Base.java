package basePackage;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class Base {

	public static WebDriver driver;
	static FileInputStream fis;
	public static Properties LocatorProperties, configProperties;

	@BeforeSuite
	public void driverSetUp() throws IOException {
		String projectPath = System.getProperty("user.dir");

		// here we load this file as a text in fis variable
		fis = new FileInputStream(projectPath + "\\src\\test\\resources\\properties\\locator.properties");
		LocatorProperties = new Properties();
		// here we can convert this fis text to properties values
		LocatorProperties.load(fis);

		// here we load this file as a text in fis variable
		fis = new FileInputStream(projectPath + "\\src\\test\\resources\\properties\\config.properties");
		configProperties = new Properties();
		// here we can convert this fis text to properties values
		configProperties.load(fis);
		
		if (configProperties.getProperty("browser").contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\src\\test\\resources\\executables\\chromedriver.exe");
			driver = new ChromeDriver();
		} 
		else if (configProperties.getProperty("browser").contains("firefox")) {
			System.setProperty("webdriver.geko.driver", projectPath + "\\src\\test\\resources\\executables\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

	}

	public void navigateUrl(String url) {
		driver.get(url);
	}

	public void sendKeys(By by, String keyValue) {
		driver.findElement(by).sendKeys(keyValue);
	}

	public void click(By by) {
		driver.findElement(by).click();
	}

	public String getText(By by) {
		return driver.findElement(by).getText();
	}

	@AfterSuite
	public void driverClose() {
		driver.close();
	}

}
