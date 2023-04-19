package testsuite;

import broswerfactory.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class LoginTest extends BaseTest {
    String baseUrl = ("https://courses.ultimateqa.com/");     //Storing Url in variable

    @Test
    public void setUp() {                                     //Setup opening browser

        openBrowser(baseUrl);                                //Getting URL
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {

        //implicit time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Find login element via xpath and
        WebElement loginLink1 = driver.findElement(By.xpath("//a[@href='/users/sign_in']"));
        loginLink1.click();

        //Verify the element of email and send the email address
        WebElement emailField = driver.findElement(By.name("user[email]"));
        emailField.sendKeys("xyz123@gmail.com");

        //Verify the element of password and send the password address
        WebElement password = driver.findElement(By.id("user[password]"));
        password.sendKeys("xyz123");

        //Finding web element for button and click
        WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
        button.click();

        //Storing expected to variable
        String expectedMessage = "Invalid email or password.";

        //Finding actual text on webpage
        WebElement actualTextElement = driver.findElement(By.xpath("//li[@class='form-error__list-item']"));

        //Getting text from webpage and storing it in element
        String actualMessage = actualTextElement.getText();

        //Comparing expected and actual message of webpage
        Assert.assertEquals("Invalid email address", expectedMessage, actualMessage);
    }

}
