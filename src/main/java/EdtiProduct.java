import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class EdtiProduct {
    WebDriver driver;
    By usernametxt = By.xpath("(//input[@name= 'username'])[1]");
    By pwdtxt = By.xpath("(//input[@name= 'password'])[1]");
    By Login = By.xpath("(//button[@type= 'submit'])[1]");
    By selectProdcut = By.xpath("(//div[@class= ' menu gs-atm__scrollbar-1']/div)[5]");

    By productDetail = By.xpath("//a[@href='/product/edit/1299290']");

    By listingPrice = By.xpath("(//input[@class ='form-control cur-input cur-input--unit'])[1]");


    public void testEdit() throws InterruptedException {
        //Download ChromeDriver
        io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
        // Init chrome driver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://admin.unisell.vn");
        Thread.sleep(3000);
        WebElement inputfield = driver.findElement(usernametxt);
        inputfield.sendKeys("pepo01gl@gmail.com");
        WebElement inputpwd = driver.findElement(pwdtxt);
        inputpwd.sendKeys("123456A@");

        WebElement clickLogin = driver.findElement(Login);
        clickLogin.click();
        Thread.sleep(1000);

        WebElement clickprodcut = driver.findElement(selectProdcut);
        clickprodcut.click();

        Thread.sleep(2000);

        driver.get("https://admin.unisell.vn/product/edit/1299290");

        Thread.sleep(2000);

//        WebElement selectProduct = driver.findElement(productDetail);
//        selectProduct.click();


        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(listingPrice);
        element.sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);
        try {
            actions.moveToElement(element).perform();
        }catch (StaleElementReferenceException e){
            element = driver.findElement(listingPrice);
            actions.moveToElement(element).perform();
        }
        actions.click(element).perform();
        actions.sendKeys("450000").perform();

    }
}




