import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class EditProductandCreateOrder {
    WebDriver driver;
    By usernametxt = By.xpath("(//input[@name= 'username'])[1]");
    By pwdtxt = By.xpath("(//input[@name= 'password'])[1]");
    By Login = By.xpath("(//button[@type= 'submit'])[1]");
    By selectProdcut = By.xpath("(//div[@class= ' menu gs-atm__scrollbar-1']/div)[5]");
    By menuOrdersList = By.xpath("(//div[@class = ' menu gs-atm__scrollbar-1']/div)[3]");
    By POS = By.xpath("(//div[@class = ' sub-menu open']/div)[6]");
    By searchProductPOS = By.xpath("(//input[@class= 'uik-input__input'])[1]");
    By selectProductPOS = By.xpath("(//div[@class = 'product-item-row gsa-hover--gray gs-atm__scrollbar-1 '])[1]");
    By completeOrder = By.xpath("(//button[@type = 'submit'])[2]");
    By findCustomer = By.xpath("//input[@class= 'uik-input__input' and @placeholder= 'Tìm kiếm khách hàng' ]");
    By selectCustomer = By.xpath("(//div[@class= 'gs-mobile-list__row'])[1]");
    By checkBoxDelivery = By.xpath("(//div[@class= 'new-ui-checkbox-type new-ui-checkbox-square medium mr-2 form-check'])[1]");
    By listDeliverymethod = By.xpath("//div[@class =' delivery-select-pos w-100']");
    By buttonSavedelivery = By.xpath("//button[@class ='gs-button  gs-button__green gs-button--undefined ']");
    By newOrder = By.xpath("//tr[@class = 'transaction-row cursor--pointer']");
    By buttonConfirm = By.xpath("//button[@id= 'btn-readyToShip']");
    By deliveryMethod = By.xpath("//select[@name = 'deliveryMethod']");
    By selfDelivery = By.xpath("//option[@value = 'selfdelivery']");
    By buttonConfirmDelivery = By.xpath("//button[@data-testid = 'btn-confirm']");


    By productDetail = By.xpath("//a[@href='/product/edit/1299290']");

    By listingPrice = By.xpath("(//input[@class ='form-control cur-input cur-input--unit'])[1]");
    By sellingPrice = By.xpath("(//input[@class ='form-control cur-input cur-input--unit'])[2]");
    By saveEditproduct = By.xpath("(//button[@type='submit'])[3]");
    By closePopupsave = By.xpath("//button[@class= 'gs-button  gs-button__green gs-button--undefined ']");



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
        //Cho nay

        WebElement clickprodcut = driver.findElement(selectProdcut);
        clickprodcut.click();

        Thread.sleep(2000);

//        driver.get("https://admin.unisell.vn/product/edit/1299290");
//
//        Thread.sleep(2000);
        //Cho nay
        WebElement selectProduct = driver.findElement(productDetail);
        selectProduct.click();
        Thread.sleep(2000);

//        List<String> allWindows = (List<String>) driver.getWindowHandles();
//        if (allWindows.size() >1) {
//            driver.switchTo().window(allWindows.get(1));
//        }
//        System.out.println("Back to Main Window: "+ driver.getTitle());

        String mainWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(mainWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(listingPrice);
        try {
            actions.moveToElement(element).perform();
        }catch (StaleElementReferenceException e){
            element = driver.findElement(listingPrice);
            actions.moveToElement(element).perform();
        }
        element.sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);
        actions.click(element).perform();
        actions.sendKeys("450000").perform();
        Thread.sleep(1000);

        element = driver.findElement(sellingPrice);
        element.sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);
        try {
            actions.moveToElement(element).perform();
        }catch (StaleElementReferenceException e){
            element = driver.findElement(sellingPrice);
            actions.moveToElement(element).perform();
        }
        actions.click(element).perform();
        actions.sendKeys("450000").perform();
        Thread.sleep(1000);

        WebElement saveEditProduct = driver.findElement(saveEditproduct);
        saveEditProduct.click();
        Thread.sleep(3000);

        WebElement closePopup = driver.findElement(closePopupsave);
        closePopup.click();
        Thread.sleep(3000);

        WebElement menuOrders = driver.findElement(menuOrdersList);
        menuOrders.click();
        Thread.sleep(1000);


        WebElement selectPOS = driver.findElement(POS);
        selectPOS.click();
        Thread.sleep(2000);

//        String mainWindow2 = driver.getWindowHandle();
//        for (String windowHandle : driver.getWindowHandles()) {
//            if (!windowHandle.equals(mainWindow2)) {
////                driver.switchTo().window(windowHandle);
//                break;
//            }
//        }
        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        // Chuyển sang cửa sổ thứ hai (index 2)
        driver.switchTo().window(windowHandles.get(2));


        WebElement clickSearchProduct = driver.findElement(searchProductPOS);
        clickSearchProduct.click();
        Thread.sleep(1000);

        WebElement selectProduct1 = driver.findElement(selectProductPOS);
        selectProduct1.click();
        Thread.sleep(2000);

        WebElement selectFieldCus = driver.findElement(findCustomer);
        selectFieldCus.sendKeys("Bin");

        Thread.sleep(3000);

        WebElement clickCustomer = driver.findElement(selectCustomer);
        clickCustomer.click();

        Thread.sleep(2000);


        WebElement selectCheckBoxDelivery = driver.findElement(checkBoxDelivery);
        selectCheckBoxDelivery.click();

        Thread.sleep(1000);

        WebElement selectListdelivery = driver.findElement(listDeliverymethod);
        selectListdelivery.click();

        Thread.sleep(3000);

        WebElement selectbuttonSave = driver.findElement(buttonSavedelivery);
        selectbuttonSave.click();
        Thread.sleep(1000);


        WebElement clickComplete = driver.findElement(completeOrder);
        clickComplete.click();
        Thread.sleep(2000);


        windowHandles = new ArrayList<>(driver.getWindowHandles());
        // Chuyển sang cửa sổ thứ hai (index 2)
        driver.switchTo().window(windowHandles.get(1));
        Thread.sleep(2000);

        driver.navigate().refresh();
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



//        Thread.sleep(5000);

//        driver.close();
    }
}




