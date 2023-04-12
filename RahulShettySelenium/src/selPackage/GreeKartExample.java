package selPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GreeKartExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\Software\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		//driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebDriverWait wt = new WebDriverWait(driver, 5);

		String itemsNeeded[] = { "Brocolli", "Cucumber", "Potato" };

		driver.get("https://rahulshettyacademy.com/seleniumPractise/");

		addItems(driver, itemsNeeded);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector(".promoBtn")).click();		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoInfo")));
		
		System.out.println(driver.findElement(By.cssSelector(".promoInfo")).getText());
		

	}

	public static void addItems(WebDriver driver, String itemsNeeded[]) {

		List<WebElement> products = driver.findElements(By.cssSelector(".product-name"));
		System.out.println(products.size());

		for (int i = 0; i < products.size(); i++) {

			String name = products.get(i).getText().split("-")[0].trim();
			// format to get only vegetable name
			// convert array into arrayList for easy search
			// Check if name extracted is present in ArrayList or not

			List<String> itemNeededList = Arrays.asList(itemsNeeded);

			int j = 0;
			if (itemNeededList.contains(name)) {
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				// break; Not to be used in ArrayList as it comes out of for loop and doesn't
				// check for other itemsNeeded.
				j++;

				if (j == itemsNeeded.length)
					break;

				// If we want to search for brocolli, adding another for loop is a bad practice
				/*
				 * for (int i=0; i<products.size(); i++) {
				 * 
				 * String name= products.get(i).getText();
				 * 
				 * if (name.contains("Brocolli")) {
				 * driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click(
				 * ); break; } }
				 */
			}

		}
	}

}
