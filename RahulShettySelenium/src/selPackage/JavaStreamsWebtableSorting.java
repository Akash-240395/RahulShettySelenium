package selPackage;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaStreamsWebtableSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\Software\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		// Click on element to sort
		// Store all elements in list
		// Convert to streams to get text only
		// Sort that list
		// Compare original and sorted list

		driver.findElement(By.xpath("//tr/th[1]")).click();

		List<WebElement> elements = driver.findElements(By.xpath("//tr/td[1]"));

		List<String> originalList = elements.stream().map(s -> s.getText()).collect(Collectors.toList());

		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

		Assert.assertTrue(sortedList.equals(originalList));

		// Want to search for beans and get the price of it
		// if item to be searched is not present on first page, use pagination

		List<String> priceList;

		do {
			List<WebElement> nextPageElements = driver.findElements(By.xpath("//tr/td[1]"));
			priceList = nextPageElements.stream().filter(s -> s.getText().contains("Rice")).map(s -> getVeggiePrice(s))
					.collect(Collectors.toList());

			if (priceList.size() < 1) {
				driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
			}
		} while (priceList.size() < 1);

		// List<String> priceList =
		// sortedList.stream().filter(s->s.contains("Beans")).map(s->getVeggiePrice(driver,s)).collect(Collectors.toList());

		priceList.forEach(s -> System.out.println(s));

	}

	private static String getVeggiePrice(WebElement s) {

		String price = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price;
	}

}
