import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class OrderSSR {
    WebDriver driver;
    By usernametxt = By.xpath("(//input[@name= 'username'])[1]");
    By pwdtxt = By.xpath("(//input[@name= 'password'])[1]");
    By Login = By.xpath("(//button[@type= 'submit'])[1]");
    By iconToSSR = By.xpath("//img[@alt= 'export square']");
    By productList = By.xpath("(//a[@class ='nav-link level-0'])[1]");
    By productDetail = By.xpath("//div[@id = '1288028']");
    By btnAddtocart = By.xpath("//button[@id ='button-add-to-cart']");
    By btnCart = By.xpath("//a[@class ='navbar-brand shopping-cart-navbar']");
    By btnCompleteCart = By.xpath("//button[@rv-on-click= 'methods.onCheckout']");
    By editInfor = By.xpath("//img[@alt= 'Edit shipping info']");
    By fieldPhonenumber = By.xpath("//input[@id = 'phoneNumber']");
    By fieldAddress = By.xpath("//input[@id = 'address']");
    By fieldCityCode = By.xpath("//select[@id = 'cityCode']");
    By cityCode = By.xpath("(//option[@value= 'VN-30'])[1]");
    By fieldDistrictCode = By.xpath("//select[@id = 'districtCode']");
    By districtCode = By.xpath("//option[@value= '3801']");
    By fieldwardCode = By.xpath("//select[@id = 'wardCode']");
    By wardCode = By.xpath("//option[@value= '380105']");
    By btnCompleteAddress = By.xpath("//div[@class= 'btn btn-submit-shipping-address']");
    By paymentMethod = By.xpath("(//div[@class = 'checkout-action-text'])[2]");
    By paymentMethodList = By.xpath("(//div[@class = 'position-relative container-item-payment-method cursor-pointer'])[3]");
    By btnBtnpaymentMethod = By.xpath("//button[@rv-on-click='methods.onSubmitPayment']");
    By btnCompleteOrder = By.xpath("(//button[@rv-on-click='methods.onSubmit'])[1]");

    public void testSSR() throws InterruptedException {
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
        Thread.sleep(3000);
        WebElement clickIconSSR = driver.findElement(iconToSSR);
        clickIconSSR.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(iconToSSR));


        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        // Chuyển sang cửa sổ thứ hai (index 2)
        driver.switchTo().window(windowHandles.get(1));
        Thread.sleep(2000);

        WebElement selectProductList = driver.findElement(productList);
        selectProductList.click();
        Thread.sleep(5000);

        //Scroll
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < 2; i++) { // Số lần cuộn
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            try {
                Thread.sleep(2000); // Thời gian chờ giữa các lần cuộn
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        WebElement goProductdetail = driver.findElement(productDetail);
        goProductdetail.click();
        Thread.sleep(3000);

        WebElement addTocart = driver.findElement(btnAddtocart);
        addTocart.click();
        Thread.sleep(1000);

        WebElement goTocart = driver.findElement(btnCart);
        goTocart.click();
        Thread.sleep(1000);


        WebElement clickBtnComplete = driver.findElement(btnCompleteCart);
        clickBtnComplete.click();
        Thread.sleep(1000);


        WebElement clickEditInfor = driver.findElement(editInfor);
        clickEditInfor.click();
        Thread.sleep(1000);

        WebElement inputPhonenumber = driver.findElement(fieldPhonenumber);
        inputPhonenumber.sendKeys("0345456022");
        Thread.sleep(1000);

        WebElement inputAddress = driver.findElement(fieldAddress);
        inputAddress.sendKeys("57 Nguyen Viet Xuan");
        Thread.sleep(1000);

        WebElement selectFieldCity = driver.findElement(fieldCityCode);
        selectFieldCity.click();
        Thread.sleep(1000);

        WebElement selectCity = driver.findElement(cityCode);
        selectCity.click();
        Thread.sleep(1000);

        WebElement selectDistrictField = driver.findElement(fieldDistrictCode);
        selectDistrictField.click();
        Thread.sleep(1000);

        WebElement selectDistrict = driver.findElement(districtCode);
        selectDistrict.click();
        Thread.sleep(1000);

        WebElement selectWardField = driver.findElement(fieldwardCode);
        selectWardField.click();
        Thread.sleep(1000);

        WebElement selectWard = driver.findElement(wardCode);
        selectWard.click();
        Thread.sleep(1000);

        WebElement selectbtnComplete = driver.findElement(btnCompleteAddress);
        selectbtnComplete.click();
        Thread.sleep(4000);


        WebElement selectpaymentMethod = driver.findElement(paymentMethod);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(paymentMethod));
        selectpaymentMethod.click();
        Thread.sleep(2000);

        WebElement selectPaymentMethod = driver.findElement(paymentMethodList);
        selectPaymentMethod.click();
        Thread.sleep(2000);


        WebElement selectBtnConformPayment = driver.findElement(btnBtnpaymentMethod);
        selectBtnConformPayment.click();
        Thread.sleep(2000);

        WebElement selectBtnCompleteOrder = driver.findElement(btnCompleteOrder);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnCompleteOrder));
        selectBtnCompleteOrder.click();

        Thread.sleep(5000);
        driver.close();
        System.out.println("Tao san pham thanh cong");


    }
}
