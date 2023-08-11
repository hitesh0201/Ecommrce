package LogInAcct;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class logInbyCredentials {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://ecommerce-playground.lambdatest.io./");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        performLogin(driver);
        navigateToMainPage(driver);
        searchForProduct(driver);
        buyHTCTouch(driver);

        driver.quit();
    }

    public static void performLogin(WebDriver driver) {
        Actions actions = new Actions(driver);

        WebElement myAccountTab = driver.findElement(By.xpath("//*[@id='widget-navbar-217834']/ul/li[6]/a"));
        WebElement logInTab = driver.findElement(By.xpath("//*[@id='widget-navbar-217834']/ul/li[6]/ul/li[1]/a/div/span"));

        actions.moveToElement(myAccountTab).build().perform();
        actions.moveToElement(logInTab).click().build().perform();

        WebElement inputEmail = driver.findElement(By.id("input-email"));
        WebElement inputPswrd = driver.findElement(By.id("input-password"));

        inputEmail.sendKeys("johnEdward315@gmail.com");
        inputPswrd.sendKeys("JohnEdw@123");

        driver.findElement(By.xpath("//*[@id='content']/div/div[2]/div/div/form/input")).click();
    }

    public static void navigateToMainPage(WebDriver driver) {
        WebElement navigateToMainPage = driver.findElement(By.id("entry_217821"));
        navigateToMainPage.click();
    }

    public static void searchForProduct(WebDriver driver) {
        WebElement allCategoriesButton = driver.findElement(By.xpath("//*[@id='search']/div[1]/div[1]/div[1]/button"));
        allCategoriesButton.click();

        WebElement searchText = driver.findElement(By.xpath("//*[@id='search']/div[1]/div[1]/div[2]/input"));
        searchText.sendKeys("HTC Touch HD");

        WebElement searchButton = driver.findElement(By.xpath("//*[@id='search']/div[2]/button"));
        searchButton.click();
    }

    public static void buyHTCTouch(WebDriver driver) {
        WebElement listView = driver.findElement(By.id("list-view"));
        listView.click();

        WebElement clickOnHTCToBuy = driver.findElement(By.xpath("//*[@id='mz-product-grid-image-75-212469']/div/div[1]"));
        clickOnHTCToBuy.click();

        WebElement buyProduct = driver.findElement(By.xpath("//*[@id='entry_216843']/button"));
        buyProduct.click();

        WebElement checkbox = driver.findElement(By.xpath("//*[@id='form-checkout']/div/div[2]/div/div[5]/label"));
        checkbox.click();

        WebElement continueBtn = driver.findElement(By.id("button-save"));
        continueBtn.click();

        WebElement confirmBtn = driver.findElement(By.id("button-confirm"));
        confirmBtn.click();

        WebElement continueBtnOnLastPage = driver.findElement(By.xpath("//*[@id=\"common-success\"]/nav/ol/li[1]/a/i"));
        continueBtnOnLastPage.click();
    }
}
