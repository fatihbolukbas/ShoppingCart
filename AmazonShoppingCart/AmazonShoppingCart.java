package AmazonShoppingCart;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;


import java.time.Duration;

public class AmazonShoppingCart {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\fatih\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com.tr/");
        driver.manage().window().maximize();

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        //Log in
        driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']")).click();
        driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("fatih.bolukbas@hotmail.com");
        driver.findElement(By.xpath("//input[@id='continue']")).click();
        driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("159753fatih");
        driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();

        //Search
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("macbook");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();

        //Categorization
        driver.findElement(By.xpath("//li[@id='p_85/21345931031']//i[@class='a-icon a-icon-checkbox']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@id='p_n_fulfilled_by_amazon/21345978031']//i[@class='a-icon a-icon-checkbox']"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@id='p_89/Apple']//i[@class='a-icon a-icon-checkbox']"))).click();


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");

        driver.findElement(By.xpath("//input[@id='low-price']")).sendKeys("7500");
        driver.findElement(By.xpath("//input[@class='a-button-input']")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='a-dropdown-prompt']"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@id='s-result-sort-select_1']"))).click();

        //Choosing product
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_3']//span[@class='a-size-base-plus a-color-base a-text-normal']"))).click();

        //Quantitiy
        driver.findElement(By.xpath("//select[@id='quantity']")).click();
        for (int i = 1; i <= 2; i++){
            driver.findElement(By.xpath("//select[@id='quantity']")).sendKeys(Keys.ARROW_DOWN);
        }
        driver.findElement(By.xpath("//select[@id='quantity']")).sendKeys(Keys.ENTER);

        //Cart
        driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@aria-labelledby='attach-sidesheet-view-cart-button-announce']"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='a-fixed-left-grid-col a-col-right']//span[@class='a-size-small sc-action-delete']//span[@class='a-declarative']"))).click();

        //Home page
        driver.findElement(By.xpath("//a[@id='nav-logo-sprites']")).click();

    }
}
