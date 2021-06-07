package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.customerPage;
import pageObjects.loginPage;
import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;

public class customersSteps extends baseClass {

  @Before
  public void setUp() throws IOException {
    //Set up Logger added
    logger = Logger.getLogger("noCommerce");
    PropertyConfigurator.configure("Log4j.properties");

    // Read Properties
    confProp = new Properties();
    FileInputStream connfProfile = new FileInputStream("config.properties");
    confProp.load(connfProfile);

    String browserName = confProp.getProperty("browser");

    if (browserName.equals("chrome")) {
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
    } else if (browserName.equals("firefox")) {
      WebDriverManager.firefoxdriver().setup();
      driver = new FirefoxDriver();
    }
    driver.manage().window().maximize();
  }

  @After
  public void QuitBrowser() {
    driver.quit();
  }

  @When("User is on Login Page")
  public void login_to_application() {

    loginPage = new loginPage(driver);
    customerPage = new customerPage(driver);
    logger.info("********** Opening URL *************");
    driver.get("https://admin-demo.nopcommerce.com");

  }

  @When("User enters credentials")
  public void user_enters_credentials() {
    logger.info("********** Entering credentials  *************");
    loginPage.enterCredentials("admin@yourstore.com", "admin");
  }
  
  @When("Click on Login button")
  public void click_on_Login_button() {
    loginPage.clickOnLoginButton();
  }

  @Then("User must navigate to Dashboard page")
  public void user_must_navigate_to_dashboard_page() {

    Assert.assertEquals("Dashboard", loginPage.getDashBoardHeader());
    logger.info("********** user Logged in SUccessfully *************");
  }

  @When("User navigates to customer page")
  public void user_navigates_to_customer_page() {
    logger.info("********** navigated to customer page *************");
    customerPage.navigateToCustPage();
  }

  @When("Click on Add New button")
  public void click_on_add_new_button() {
    logger.info("********** Adding new customer *************");
    customerPage.clickOnAddNewButton();
  }

  @Then("User must see Customer info form")
  public void user_must_see_customer_info_form() {
    Assert.assertTrue(customerPage.custFormDisplayed());

  }

  @When("User enters customer info as email {string} {string} {string} {string}")
  public void user_enters_customer_info_as_email(String pwd, String fn, String ln, String dob) throws InterruptedException {
    logger.info("********** Providinng the required Info *************");
    String email = generateRandomString() + "@gmail.com";
    customerPage.enterEmail(email);
    customerPage.enterCustInfo(pwd, fn, ln, dob);
  }

  @When("Click on Save button")
  public void click_on_save_button() {
    logger.info("********** Clickinng on Save button *************");
    customerPage.clickOnSaveButton();
  }

  @Then("Customer must see {string}")
  public void customer_must_see_message(String message) {
    Assert.assertTrue(customerPage.getConfirmMsg().contains(message));
    logger.info("********** New customer added SUccessfully *************");
  }

  @When("Search with {string} and {string}")
  public void search_with_and(String fn, String ln) throws InterruptedException {
    customerPage.searchWithName(fn, ln);
    logger.info("********** Searched keywords entered *************");
  }

  @When("User click on search Button")
  public void user_click_on_search_button() {
    customerPage.clickonSearchButton();
  }

  @Then("User should see searched customer")
  public void user_should_see_searched_customer() {
    Assert.assertEquals("John Jackman", customerPage.getSearchedName());
    logger.info("********** keyword successfully searched *************");
  }

}