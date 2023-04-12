package selPackage;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinksCountAndNavigatingToLinks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\Software\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// Getting the links count on a page
		System.out.println(driver.findElements(By.tagName("a")).size());

		// Getting count of links from a particular footer
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		System.out.println(footerDriver.findElements(By.tagName("a")).size());

		WebElement firstFooterDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(firstFooterDriver.findElements(By.tagName("a")).size());

		for (int i = 1; i < firstFooterDriver.findElements(By.tagName("a")).size(); i++) {

			String clickOnLnk = Keys.chord(Keys.CONTROL, Keys.ENTER);

			firstFooterDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLnk);
		}

		Set<String> windows = driver.getWindowHandles(); // 5 window handles
		Iterator<String> it = windows.iterator();

		while (it.hasNext()) {

			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());

		}

	}

}
