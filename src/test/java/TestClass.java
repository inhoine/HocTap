import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestClass {
    @Test
    void loginGoSell() throws InterruptedException {
        new Login().loginGoSell();
    }


    @Test
    void test() throws InterruptedException {
        new CreateProduct().test();
    }
//    @Test
//    void test1() throws InterruptedException {
//        new EditProductandCreateOrder().testEdit();
//    }
//
//    @Test
//    void testConfirm() throws InterruptedException {
//        new ConfirmOrder().testConfirm();
//    }
//
//    @Test
//    void testSSR() throws InterruptedException {
//        new OrderSSR().testSSR();
//    }
}
