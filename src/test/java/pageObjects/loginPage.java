package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
  public WebDriver driver;

  //Constructor that will be automatically called as soon as the object of the class is created
  public loginPage(WebDriver driver) {
    this.driver = driver;
  }

  //Locators for the page title and the logout button
  By email = By.id("Email");
  By password = By.id("Password");
  By logInButton = By.xpath("//button[text()='Log in']");
  By dashboardHeader = By.xpath("//div[@class=\"content-header\"]/h1");

  //Method to capture the page heading
  public void enterCredentials(String mail, String pwd) {
    driver.findElement(email).clear();
    driver.findElement(email).sendKeys(mail);
    driver.findElement(password).clear();
    driver.findElement(password).sendKeys(pwd);
  }

  //Method to click on Logout button
  public void clickOnLoginButton() {
    driver.findElement(logInButton).click();
  }

  public String getDashBoardHeader() {
    String header = driver.findElement(dashboardHeader).getText();
    return header;
  }

  public String getCurrentPageTitle() {
    String title = driver.getTitle();
    return title;
  }
}