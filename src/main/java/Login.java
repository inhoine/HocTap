import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login {

    WebDriver driver;
    WebDriverWait wait;
    By usernametxt = By.xpath("(//input[@name= 'username'])[1]");
    By pwdtxt = By.xpath("(//input[@name= 'password'])[1]");
    By Login = By.xpath("(//button[@type= 'submit'])[1]");
    public void loginGoSell () throws InterruptedException {
        //Download ChromeDriver
        io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
        // Init chrome driver
        this.driver = new ChromeDriver();

        this.driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        this.driver.get("https://admin.unisell.vn");
        wait.until(ExpectedConditions.urlToBe("https://admin.unisell.vn/login"));

        WebElement inputfield = this.driver.findElement(usernametxt);
        inputfield.sendKeys("pepo01gl@gmail.com");
        WebElement inputpwd = this.driver.findElement(pwdtxt);
        inputpwd.sendKeys("123456A@");
        WebElement clickLogin = this.driver.findElement(Login);
        clickLogin.click();
    }
}
