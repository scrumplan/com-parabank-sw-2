package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {
    String baseUrl = "https://parabank.parasoft.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatSigningUpPageDisplay() {
        String expectedMessage = "Signing up is easy!";
        //click on the ‘Register’ link
        WebElement register = driver.findElement(By.linkText("Register"));
        register.click();
        WebElement actualMessageElement = driver.findElement(By.xpath("//h1[contains(text(),'Signing up is easy!')]"));
        String actualMessage = actualMessageElement.getText();
        Assert.assertEquals("Register tab is not matching", expectedMessage, actualMessage);

    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        String expectedMessage = "Your account was created successfully. You are now logged in.";
        //click on the ‘Register’ link
        WebElement register = driver.findElement(By.linkText("Register"));
        register.click();

        //Enter First name
        WebElement firstName = driver.findElement(By.id("customer.firstName"));
        firstName.sendKeys("Jhon");
        //Enter Last name
        WebElement lastName = driver.findElement(By.id("customer.lastName"));
        lastName.sendKeys("Smith");
        //Enter Address
        WebElement address = driver.findElement(By.id("customer.address.street"));
        address.sendKeys("39,jhonestreet");
        //Enter City
        WebElement city = driver.findElement(By.id("customer.address.city"));
        city.sendKeys("Lester");
        //Enter State
        WebElement state = driver.findElement(By.id("customer.address.state"));
        state.sendKeys("london");
        //Enter Zip Code
        WebElement zipCode = driver.findElement(By.id("customer.address.zipCode"));
        zipCode.sendKeys("1234");
        //Enter Phone
        WebElement phone = driver.findElement(By.id("customer.phoneNumber"));
        phone.sendKeys("+447512121234");
        //Enter SSN
        WebElement SSN = driver.findElement(By.id("customer.ssn"));
        SSN.sendKeys("12345");
        //Enter Username
        WebElement userName = driver.findElement(By.id("customer.username"));
        userName.sendKeys("John12345=");
        //Enter Password
        WebElement password = driver.findElement(By.id("customer.password"));
        password.sendKeys("John12345");
        //Enter Confirm
        WebElement confirm = driver.findElement(By.id("repeatedPassword"));
        confirm.sendKeys("John12345");
        //Click on REGISTER button
        WebElement registerButton = driver.findElement(By.xpath("//tbody/tr[13]/td[2]/input[1]"));
        registerButton.click();


        WebElement actualMessageElement = driver.findElement(By.xpath("//p[contains(text(),'Your account was created successfully. You are now')]"));
        String actualMessage = actualMessageElement.getText();
        Assert.assertEquals("Register tab is not matching", expectedMessage, actualMessage);


    }

}
