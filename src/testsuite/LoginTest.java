package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://parabank.parasoft.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);

    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        String expectedMessage = "Accounts Overview";
        //Enter valid username
        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys("John12345");
        //Enter valid password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("John12345");
        //Click on ‘LOGIN’ button
        WebElement login = driver.findElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]"));
        login.click();

        WebElement actualMessageElement = driver.findElement(By.xpath("//h1[contains(text(),'Accounts Overview')]"));
        String actualMessage = actualMessageElement.getText();
        Assert.assertEquals(" message  is not matching", expectedMessage, actualMessage);
    }

    @Test
    public void verifyTheErrorMessage() {
        String expectedMessage = "The username and password could not be verified.";
        //Enter invalid username
        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys("John1234=");
        //Enter invalid password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("John12345=");
        //Click on Login button
        WebElement login = driver.findElement(By.xpath("//div/input[@class='button']"));
        login.click();

        WebElement actualMessageElement = driver.findElement(By.xpath("//p[contains(text(),'The username and password could not be verified.')]"));
        String actualMessage = actualMessageElement.getText();
        Assert.assertEquals(" message  is  matching", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldLogOutSuccessfully() {
        String expectedMessage = "Customer Login";
        //Enter valid username
        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys("John123");
        //Enter valid password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("John12345");
        //Click on ‘LOGIN’ button
        WebElement login = driver.findElement(By.xpath("//div/input[@class='button']"));
        login.click();
        // Click on ‘Log Out’ link
        WebElement logOut = driver.findElement(By.xpath("//a[contains(text(),'Log Out')]"));
        logOut.click();

        WebElement actualMessageElement = driver.findElement(By.xpath("//h2[contains(text(),'Customer Login')]"));
        String actualMessage = actualMessageElement.getText();
        Assert.assertEquals(" message  is not matching", expectedMessage, actualMessage);

    }


}
