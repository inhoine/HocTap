import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateProduct {
    WebDriver driver;
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


    By saveProduct = By.xpath("(//button[@type='submit'])[2]");


    public void test() throws InterruptedException {

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

        WebElement clickprodcut = driver.findElement(selectProdcut);
        clickprodcut.click();

        Thread.sleep(1000);


        WebElement selectCreateProduct = driver.findElement(createProductbutton);
        selectCreateProduct.click();
        Thread.sleep(2000);

        WebElement inputProductname = driver.findElement(productName);
        inputProductname.sendKeys("Sản phẩm auto");
        Thread.sleep(1000);

        WebElement inputImg = driver.findElement(selectImg);
        inputImg.sendKeys("C://Users//admin//Desktop//MediaStep//cuahangtienloi//khoidong.png");
        Thread.sleep(1000);




        WebElement inputListingprice = driver.findElement(listingPrice);
        inputListingprice.clear();
        inputListingprice.sendKeys("10000");
        Thread.sleep(3000);

        WebElement inputSellingprice = driver.findElement(sellingPrice);
        inputSellingprice.clear();
        inputSellingprice.sendKeys("10000");
        Thread.sleep(3000);

        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(stockProduct);
        element.sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);
        element = driver.findElement(stockProduct);
//        try {

//        }catch (StaleElementReferenceException e){
//
//        }

        //            // Di chuột đến phần tử
        // Di chuột đến phần tử
        try {
            actions.moveToElement(element).perform();
        }catch (StaleElementReferenceException e){
            element = driver.findElement(stockProduct);
            actions.moveToElement(element).perform();
        }

        // Nhấp chuột phải
        actions.click(element).perform();
        actions.sendKeys("5").perform();

//        WebElement inputStockproduct = driver.findElement(stockProduct);
////        inputStockproduct.clear(); // Xóa nội dung cũ nếu cần
//        inputStockproduct.sendKeys("10");
//        Thread.sleep(3000);



//        Thread.sleep(1000);

//        WebElement applyStock = driver.findElement(applyStockbutton);
//        applyStock.click();

        WebElement selectsaveProduct = driver.findElement(saveProduct);
        selectsaveProduct.click();

    }
}
