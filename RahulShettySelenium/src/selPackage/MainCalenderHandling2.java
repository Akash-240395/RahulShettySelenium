package selPackage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainCalenderHandling2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\Software\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get("https://www.path2usa.com/travel-companion/");

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0, 1000)");
		
		Thread.sleep(3000);

		driver.findElement(By.id("form-field-travel_comp_date")).click();

		while (!driver.findElement(By.className("cur-month")).getText().contains("June")) {
			driver.findElement(By.className("flatpickr-next-month")).click();
		}

		List<WebElement> dates = driver.findElements(By.xpath("//*[@class='flatpickr-day ']"));
		int datesCount = dates.size();
		System.out.println(datesCount);

		for (int i = 0; i < datesCount; i++) {
			String text = driver.findElements(By.xpath("//*[@class='flatpickr-day ']")).get(i).getText();
			if (text.equalsIgnoreCase("24")) {
				driver.findElements(By.xpath("//*[@class='flatpickr-day ']")).get(i).click();
				break;
			}

		}

	}
}
