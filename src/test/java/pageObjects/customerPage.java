package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import utilities.waitHelper;

public class customerPage {
  public WebDriver driver;
  public waitHelper waitHelper;

  public customerPage(WebDriver driver) {
    this.driver = driver;
    waitHelper = new waitHelper(driver);
  }

  By customersSideBarMenu = By.linkText("Customers");
  By customerMenu = By.xpath("//ul[@data-widget='treeview']/li[4]/ul/li[1]");
  By addNewButton = By.xpath("//a[@class='btn btn-primary']");
  By custInfoForm = By.id("customer-info");
  By email = By.id("Email");
  By password = By.id("Password");
  By firstName = By.id("FirstName");
  By lastName = By.id("LastName");
  By genderMale = By.id("Gender_Male");
  By dateOfBirth = By.id("DateOfBirth");
  By saveButton = By.cssSelector("[name='save']");
  By confirmMsg = By.tagName("body");
  By openSearchGrid = By.cssSelector("[class='row search-row']");
  By searchFirstName = By.id("SearchFirstName");
  By searchLastName = By.id("SearchLastName");
  By searchButton = By.id("search-customers");
  By searchedCustName = By.xpath("//table[@id='customers-grid']/tbody/tr/td[3]");
  //
  public void navigateToCustPage() {
    waitHelper.waitForElement(driver.findElement(customersSideBarMenu), 30);
    driver.findElement(customersSideBarMenu).click();

    waitHelper.waitForElement(driver.findElement(customerMenu), 30);
    driver.findElement(customerMenu).click();

  }

  public void clickOnAddNewButton() {
    driver.findElement(addNewButton).click();
  }

  public boolean custFormDisplayed() {
    return driver.findElement(custInfoForm).isDisplayed();
  }

  public void enterCustInfo(String pwd, String fn, String ln, String dob) {
    driver.findElement(password).sendKeys(pwd);
    driver.findElement(firstName).sendKeys(fn);
    driver.findElement(lastName).sendKeys(ln);
    driver.findElement(genderMale).click();
    driver.findElement(dateOfBirth).sendKeys(dob);
  }
  public void enterEmail(String mail) {
    driver.findElement(email).sendKeys(mail);
  }

  public void clickOnSaveButton() {
    driver.findElement(saveButton).click();
  }
  public String getConfirmMsg() {
    return driver.findElement(confirmMsg).getText();
  }

  public void searchWithName(String fn, String ln) throws InterruptedException {
    Thread.sleep(4000);
    if (!driver.findElement(searchFirstName).isDisplayed()) {
      driver.findElement(openSearchGrid).click();
    }
    Thread.sleep(4000);
    driver.findElement(searchFirstName).sendKeys(fn);
    driver.findElement(searchLastName).sendKeys(ln);
  }
  public void clickonSearchButton() {
    driver.findElement(searchButton).click();
  }
  public String getSearchedName() {
    waitHelper.waitForElement(driver.findElement(searchedCustName), 40);
    return driver.findElement(searchedCustName).getText();
  }
}