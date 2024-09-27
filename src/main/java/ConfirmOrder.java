import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriver;

public class ConfirmOrder {
    WebDriver driver;
    By usernametxt = By.xpath("(//input[@name= 'username'])[1]");
    By pwdtxt = By.xpath("(//input[@name= 'password'])[1]");
    By Login = By.xpath("(//button[@type= 'submit'])[1]");
    By menuOrdersList = By.xpath("(//div[@class = ' menu gs-atm__scrollbar-1']/div)[3]");
    By newOrder = By.xpath("//tr[@class = 'transaction-row cursor--pointer']");
    By buttonConfirm = By.xpath("//button[@id= 'btn-readyToShip']");
    By deliveryMethod = By.xpath("//select[@name = 'deliveryMethod']");
    By selfDelivery = By.xpath("//option[@value = 'selfdelivery']");
    By buttonConfirmDelivery = By.xpath("//button[@data-testid = 'btn-confirm']");

    public void testConfirm () throws InterruptedException {
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

        Thread.sleep(2000);

        WebElement menuOrders = driver.findElement(menuOrdersList);
        menuOrders.click();
        Thread.sleep(3000);

        WebElement selectOrders = driver.findElement(newOrder);
        selectOrders.click();
        Thread.sleep(3000);

        WebElement selectbuttonConfirm = driver.findElement(buttonConfirm);
        selectbuttonConfirm.click();
        Thread.sleep(1000);

        WebElement selectDeliveryMethod = driver.findElement(deliveryMethod);
        selectDeliveryMethod.click();
        Thread.sleep(1000);

        WebElement selectSelfdelivery = driver.findElement(selfDelivery);
        selectSelfdelivery.click();
        Thread.sleep(1000);

        WebElement selectConfirmDelivery = driver.findElement(buttonConfirmDelivery);
        selectConfirmDelivery.click();

        Thread.sleep(5000);

        driver.close();
    }
}
