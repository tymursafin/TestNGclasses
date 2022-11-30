package class03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DataProviderDemo {

    //    Test Scenario:
    //    navigate to syntax HRMS
    //    login into the webiste using the following credentials and check for correct errors
    //    a.username ="Admin"  , password="12345"  ---> Error Message ="Invalid credentials"
    //    b.username= "ABCD"   , password ="Hum@nhrm123" -->Error Message ="Invalid credentials"
    //    c.username= ""   ,   password ="Hum@nhrm123"   -->Error Message ="Username cannot be empty"
    //    d.username= "Admin" ,password= ""  -->Error Message= "Password cannot be empty"
    WebDriver driver;

    @BeforeMethod
    public void OpenBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @DataProvider(name="credentials")
    public Object[][] data(){
        return new Object[][]{
                {"Admin", "12345", "Invalid credentials"},
                {"ABCD", "Hum@nhrm123", "Invalid credentials"},
                {"Admin", "", "Password cannot be empty"},
                {"", "Hum@nhrm123", "Username cannot be empty"}
        };
    }

    @Test(dataProvider = "credentials")
    public void LoginWithInvalidCredentials(String userName, String password, String expectedErrorMessage){
        // finding the username text box
        WebElement username = driver.findElement(By.xpath("//input[@id='txtUsername']"));
        // send username
        username.sendKeys(userName);
        // finding the password field
        WebElement pswrd = driver.findElement(By.xpath("//input[@id='txtPassword']"));
        // send password
        pswrd.sendKeys(password);
        // finding the element login btn
        WebElement loginBtn = driver.findElement(By.xpath("//input[@id='btnLogin']"));
        // click the login
        loginBtn.click();
        // get the element message invalid credentials
        WebElement errorMsg = driver.findElement(By.xpath("//span[@id='spanMessage']"));
        // extract the error message
        String actualError = errorMsg.getText();
        // assertion
        Assert.assertEquals(actualError,expectedErrorMessage);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}
