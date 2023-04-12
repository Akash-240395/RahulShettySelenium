package selPackage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MainCalenderHandling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\Software\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		/*
		 * Actions act = new Actions(driver);
		 * act.moveToElement(driver.findElement(By.id("form-field-travel_comp_date"))).
		 * build().perform();
		 */

		driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
		// select 28 August

		while (!driver
				.findElement(By.cssSelector(".ui-datepicker-group.ui-datepicker-group-first .ui-datepicker-month"))
				.getText().contains("May")) {
			driver.findElement(By.cssSelector(".ui-icon.ui-icon-circle-triangle-e")).click();
		}

		List<WebElement> dates = driver.findElements(By.cssSelector("#ui-datepicker-div .ui-state-default"));
		int totalDates = driver.findElements(By.cssSelector("#ui-datepicker-div .ui-state-default")).size();
		System.out.println(totalDates);

		for (int i = 0; i < totalDates; i++) {
			String text = driver.findElements(By.cssSelector("#ui-datepicker-div .ui-state-default")).get(i).getText();
			if (text.equalsIgnoreCase("24")) {
				driver.findElements(By.cssSelector("#ui-datepicker-div .ui-state-default")).get(i).click();
				break;
			}
		}

	}

}
