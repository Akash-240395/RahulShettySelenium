package selPackage;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Assignment3_checkoutItems {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\Software\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		WebDriverWait wt = new WebDriverWait(driver, 5);
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");

		doSignin(driver);
		selectProductsAndCheckout(wt, driver);
	}

	public static void doSignin(WebDriver driver) {

		String textShown = driver.findElement(By.xpath("//p[@class='text-center text-white']")).getText();
		// (username is rahulshettyacademy and Password is learning)
		String username = textShown.split(" ")[2].trim();
		System.out.println(username);
		String password = textShown.split(" ")[6].trim();
		String actPassword = password.replace(")", "");
		System.out.println(actPassword);

		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(actPassword);

		driver.findElement(By.cssSelector("#usertype")).click();

		/*
		 * wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		 * driver.findElement(By.id("okayBtn")).click();
		 */

		Select sel = new Select(driver.findElement(By.cssSelector("select[class='form-control']")));
		sel.selectByVisibleText("Consultant");

		driver.findElement(By.id("terms")).click();

		driver.findElement(By.name("signin")).click();
	}

	public static void selectProductsAndCheckout(WebDriverWait wt, WebDriver driver) {

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("ProtoCommerce Home")));

		Assert.assertEquals(driver.findElement(By.linkText("ProtoCommerce Home")).getText(), "ProtoCommerce Home");
		System.out.println("Opened required page");

		// Adding items in the cart
		String itemsNeeded[] = { "iphone X", "Samsung Note 8", "Blackberry" };

		List<WebElement> itemsShown = driver.findElements(By.xpath("//h4[@class='card-title']/a"));
		System.out.println(itemsShown.size());

		for (int i = 0; i < itemsShown.size(); i++) {

			String name = itemsShown.get(i).getText();

			List itemsNeededList = Arrays.asList(itemsNeeded);

			int j = 0;
			if (itemsNeededList.contains(name)) {
				driver.findElements(By.xpath("//button[@class='btn btn-info']")).get(i).click();
				j++;
			}

			if (j == itemsNeeded.length)
				break;
		}

		driver.findElement(By.cssSelector("a.nav-link.btn.btn-primary")).click();

	}
}
