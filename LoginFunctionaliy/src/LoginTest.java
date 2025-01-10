import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize the WebDriver
        WebDriver driver = new ChromeDriver();

        // Run all test cases in sequence
        testCase001(driver); // Valid Login
        testCase002(driver); // Invalid Login - Empty Fields
        testCase003(driver); // Invalid Username, Valid Password
        testCase004(driver); // Valid Username, Invalid Password
        testCase005(driver); // Password Boundary Value (20 characters max)
        testCase006(driver); // Required Fields marked with asterisk(*)

        // Close the browser
        driver.quit();
    }

    //        Test Case 1: Valid Login
    public static void testCase001(WebDriver driver) {
        driver.get("https://practice.expandtesting.com/login");
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        usernameField.sendKeys("practice");
        passwordField.sendKeys("SuperSecretPassword!");
        loginButton.click();
        if (driver.getTitle().contains("Dashboard")) {
            System.out.println("Test Case TC001 Passed: User logged in.");
        } else {
            System.out.println("Test Case TC001 Failed.");
        }
    }

    //               Test Case 2: Invalid Login - Empty Fields
    public static void testCase002(WebDriver driver) {
        driver.get("https://practicetestautomation.com/practice-test-login/");
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        usernameField.clear();
        passwordField.clear();
        loginButton.click();
        WebElement errorMessage = driver.findElement(By.id("error-message"));
        if (errorMessage.getText().contains("Please enter username/password")) {
            System.out.println("Test Case TC002 Passed: Error message displayed.");
        } else {
            System.out.println("Test Case TC002 Failed.");
        }
    }

    // Test           Case 3: Invalid Username, Valid Password
    public static void testCase003(WebDriver driver) {
        driver.get("https://practicetestautomation.com/practice-test-login/");
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        usernameField.sendKeys("invalidUsername");
        passwordField.sendKeys("SuperSecretPassword!");
        loginButton.click();
        WebElement errorMessage = driver.findElement(By.id("error-message"));
        if (errorMessage.getText().contains("Your Username is Invalid")) {
            System.out.println("Test Case TC003 Passed: Invalid username error message.");
        } else {
            System.out.println("Test Case TC003 Failed.");
        }
    }

    // Test Case 4: Valid Username,    Invalid Password
    public static void testCase004(WebDriver driver) {
        driver.get("https://practicetestautomation.com/practice-test-login/");
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        usernameField.sendKeys("Practice");
        passwordField.sendKeys("InvalidPassword");
        loginButton.click();
        WebElement errorMessage = driver.findElement(By.id("error-message"));
        if (errorMessage.getText().contains("Your Password is Invalid")) {
            System.out.println("Test Case TC004 Passed: Invalid password error message.");
        } else {
            System.out.println("Test Case TC004 Failed.");
        }
    } 

    // Test Case 5: Password Bo  undary Value (20 characters max)
    public static void testCase005(WebDriver driver) {
        driver.get("https://practicetestautomation.com/practice-test-login/");
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        usernameField.sendKeys("Practice");
        passwordField.sendKeys("SuperSecretPassword!");
        loginButton.click();
        if (driver.getTitle().contains("Dashboard")) {
            System.out.println("Test Case TC005 Passed: User logged in.");
        } else {
            System.out.println("Test Case  TC005 Failed.");
        }
    }

    // Test Case 6: Required Fields should be marked with asterisk(*)
    public static void testCase006(WebDriver driver) {
        driver.get("https://practicetestautomation.com/practice-test-login/");
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        if (usernameField.getAttribute("required") != null && passwordField.getAttribute("required") != null) {
            System.out.println("Test Case TC006 Passed: Fields are marked as required.");
        } else {
            System.out.println("Test Case TC006 Failed: Fields are not marked as required.");
        }
    }
}
