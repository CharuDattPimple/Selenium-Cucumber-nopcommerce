package stepDefinitions;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.customerPage;
import pageObjects.loginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class baseClass {
	public WebDriver driver;
	public loginPage loginPage;
	public customerPage customerPage;
	public static Logger logger;
	public Properties confProp;
	
	public static String generateRandomString() {
		String randomText = RandomStringUtils.randomAlphabetic(7);
		return (randomText);
	}
}
