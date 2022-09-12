package basicPractice;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GNANA_SEKAR_T {

	/*
	 * Any tool, any language !
		1) Launch https://www.redbus.in
		2) Type From (Chennai)
		3) Type To (Bengaluru)
		4) Select Date as tomorrow
		5) Click Search Buses
		6) Get the count of buses
		7) Find the highest priced bus
	 */

	public static WebDriver driver;

	@BeforeMethod
	public void StartUp() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito", "start-maximized", "--log-level=3");
		options.addArguments("disable-infobars", "--disable-popup-blocking", "disable-extensions");
		options.setImplicitWaitTimeout(Duration.ofSeconds(30));
		options.setPageLoadTimeout(Duration.ofSeconds(30));
		options.setScriptTimeout(Duration.ofSeconds(30));
		driver = new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		driver.get("https://www.redbus.in");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void RedBusBooking() {

		driver.findElement(By.xpath("//input[@data-message='Please enter a source city']")).sendKeys("chennai");
		driver.findElement(By.xpath("//ul[@class='autoFill homeSearch']//li")).click();

		driver.findElement(By.xpath("//input[@data-message='Please enter a destination city']")).sendKeys("bengaluru");
		driver.findElement(By.xpath("//ul[@class='autoFill homeSearch']//li")).click();

		driver.findElement(By.xpath("(//td[@class='current day']//following::td)[1]")).click();
		driver.findElement(By.id("search_btn")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement close = driver.findElement(By.xpath("//div[@class='close-primo']"));
		wait.until(ExpectedConditions.elementToBeClickable(close));
		close.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		List<Integer> prices = new ArrayList<Integer>();
		List<WebElement> fares = driver.findElements(By.xpath("//div[@class='fare d-block']//span"));
		for(int i=0; i<fares.size(); i++) {
			prices.add(Integer.parseInt(fares.get(i).getText()));
		}

		Collections.sort(prices);
		long FirstHighestPrice = prices.get(prices.size()-1);

		String str = "(//span[contains(text(),'"+prices.get(prices.size()-1)+"')]/preceding::div[starts-with(@class,'column-two')])[1]//div[starts-with(@class,'travels')]";

		String busName = driver.findElement(By.xpath(str)).getText();

		System.out.println("Highest fare rate bus = "+busName+" and price ="+FirstHighestPrice);
	}
}