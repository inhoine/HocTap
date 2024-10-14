import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateProduct {
    WebDriver driver;
    WebDriverWait wait;
    By usernametxt = By.xpath("(//input[@name= 'username'])[1]");
    By pwdtxt = By.xpath("(//input[@name= 'password'])[1]");
    By Login = By.xpath("(//button[@type= 'submit'])[1]");
    By getText = By.xpath("//div[@class = 'title d-none d-lg-block d-md-block']");
    By icgoWallet = By.xpath("(//div[@id= 'wallet-balance']/div)[2]");
    By textGowallet = By.xpath("//span[@class= 'q68SgCTxTQYGNh1eF0j62w==']");
    By TotalgoWallet = By.xpath("//div[@class= ' C0pXmfKbDwobjSqDnn032Q== color-white']");
    By selectProdcut = By.xpath("(//div[@class= ' menu gs-atm__scrollbar-1']/div)[5]");
    By createProductbutton = By.xpath("(//button[@class= 'gs-button  gs-button__green gs-button--undefined '])[1]");
    By productName = By.xpath("//input[@name = 'productName']");
    By selectImg = By.xpath("//input[@accept = 'image/jpeg,image/png,image/gif']");
    By listingPrice = By.xpath("(//input[@class ='form-control cur-input cur-input--unit'])[1]");
    By sellingPrice = By.xpath("(//input[@class ='form-control cur-input cur-input--unit'])[2]");
    By stockProduct = By.xpath("(//input[@class='form-control cur-input cur-input--non-unit'])[2]");
    By applyStockbutton = By.xpath("gs-button  gs-button__blue gs-button--undefined ");
    By btnAddVariation= By.xpath("(//span[@class= 'gs-fake-link '])[1]");
    By fieldVariationname = By.xpath("//input[@type= 'text' and @class= 'sc-fzpkqZ kmZxWv is-untouched is-pristine av-invalid form-control']");
    By fieldVariaionvalue = By.xpath("//input[@id = 'box-input-id']");
    By stockVariation = By.xpath("(//div[@class= 'cursor--pointer'])[6]");
    By numberStock = By.xpath("(//input[@class='u9JFaD5xX5jWeKYieOx3dA==   '])[3]");
    By btnUpdateStock = By.xpath("//button[@class ='gs-button  gs-button__green gs-button--undefined ']");
    By closePopupVideo = By.xpath("//div[@class = 'v5Um9Ms0fy+rVulr6jyrVQ==']");
    By saveProduct = By.xpath("(//button[@type='submit'])[2]");


    public void test() throws InterruptedException {

        //Download ChromeDriver
        io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
        // Init chrome driver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://admin.unisell.vn");
        wait.until(ExpectedConditions.urlToBe("https://admin.unisell.vn/login"));

        WebElement inputfield = driver.findElement(usernametxt);
        inputfield.sendKeys("pepo01gl@gmail.com");
        WebElement inputpwd = driver.findElement(pwdtxt);
        inputpwd.sendKeys("123456a@");
        WebElement clickLogin = driver.findElement(Login);
        clickLogin.click();

        wait.until(ExpectedConditions.urlToBe("https://admin.unisell.vn/home"));

//        WebElement titlegetText = driver.findElement(getText);
//        String text = titlegetText.getText();
//        System.out.println(text);
//
//        WebElement clickIcon = driver.findElement(icgoWallet);
//        clickIcon.click();
//
//
//        WebElement textgetWallet = driver.findElement(textGowallet);
//        String textgoWallet = textgetWallet.getText();
//
//        WebElement getTextWallet = driver.findElement(TotalgoWallet);
//        String goWallet = getTextWallet.getText();
//        System.out.println(textgoWallet + goWallet);

        WebElement clickprodcut = wait.until(ExpectedConditions.elementToBeClickable(selectProdcut));
        clickprodcut.click();
        WebElement clickClosePopupVideoProduct = wait.until(ExpectedConditions.elementToBeClickable(closePopupVideo));
        clickClosePopupVideoProduct.click();

        WebElement selectCreateProduct = wait.until(ExpectedConditions.elementToBeClickable(createProductbutton));
        selectCreateProduct.click();

        wait.until(ExpectedConditions.urlToBe("https://admin.unisell.vn/product/create"));

        WebElement inputProductname = wait.until(ExpectedConditions.visibilityOfElementLocated(productName));
        inputProductname.sendKeys("Sản phẩm auto");

        Thread.sleep(2000);
        //Input Img
        WebElement inputImg = driver.findElement(selectImg);
        inputImg.sendKeys("C://Users//admin//Desktop//MediaStep//cuahangtienloi//khoidong.png");
        //InputlistingPrice
        Actions actions = new Actions(driver);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(listingPrice));
        try {
            actions.moveToElement(element).perform();
        }catch (StaleElementReferenceException e){
            element = wait.until(ExpectedConditions.elementToBeClickable(listingPrice));
            actions.moveToElement(element).perform();
        }
        element.sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);
        actions.click(element).perform();
        actions.sendKeys("450000").perform();

        //InputSellingPrice
        actions = new Actions(driver);
        element = wait.until(ExpectedConditions.elementToBeClickable(sellingPrice));
        try {
            actions.moveToElement(element).perform();
        }catch (StaleElementReferenceException e){
            element = wait.until(ExpectedConditions.elementToBeClickable(sellingPrice));
            actions.moveToElement(element).perform();
        }
        element.sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);
        actions.click(element).perform();
        actions.sendKeys("450000").perform();

        WebElement selectbtnAddVariation = wait.until(ExpectedConditions.elementToBeClickable(btnAddVariation));
        selectbtnAddVariation.click();


        WebElement inputVariaionName = wait.until(ExpectedConditions.visibilityOfElementLocated(fieldVariationname));
        inputVariaionName.sendKeys("Color");


        WebElement inputVariaionValue = wait.until(ExpectedConditions.visibilityOfElementLocated(fieldVariaionvalue));
        inputVariaionValue.sendKeys("Black");
        Thread.sleep(1000);
        inputVariaionValue.sendKeys(Keys.ENTER);

        WebElement selectStockVariation = wait.until(ExpectedConditions.elementToBeClickable(stockVariation));
        selectStockVariation.click();


        WebElement inputStockVariation = wait.until(ExpectedConditions.visibilityOfElementLocated(numberStock));
        inputStockVariation.sendKeys("500");

        WebElement selectbtnUpdatestock = wait.until(ExpectedConditions.elementToBeClickable(btnUpdateStock));
        selectbtnUpdatestock.click();

//
//        //            // Di chuột đến phần tử
//        // Di chuột đến phần tử
//        try {
//            actions.moveToElement(element).perform();
//        }catch (StaleElementReferenceException e){
//            element = driver.findElement(stockProduct);
//            actions.moveToElement(element).perform();
//        }
//
//        // Nhấp chuột phải
//        actions.click(element).perform();
//        actions.sendKeys("5").perform();
//
////        WebElement inputStockproduct = driver.findElement(stockProduct);
//////        inputStockproduct.clear(); // Xóa nội dung cũ nếu cần
////        inputStockproduct.sendKeys("10");
//
////        WebElement applyStock = driver.findElement(applyStockbutton);
////        applyStock.click();
//
        WebElement selectsaveProduct = driver.findElement(saveProduct);
        selectsaveProduct.click();

    }
}
