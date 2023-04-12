package selPackage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assginment8_autosuggestiveDropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\Software\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		driver.findElement(By.id("autocomplete")).sendKeys("uni");

		List<WebElement> options = driver.findElements(By.cssSelector(".ui-menu-item"));
		System.out.println(options.size());

		for (int i = 0; i < options.size(); i++) {
			String optionText = options.get(i).getText();
			if (optionText.equalsIgnoreCase("United kingdom (UK)")) {
				options.get(i).click();
				break;
			}
		}
		System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));
		
		WebElement staticDropdown = driver.findElement(By.id("dropdown-class-example"));
		
		Select sel = new Select(staticDropdown);
		sel.selectByVisibleText("Option2");
		
		System.out.println(driver.findElement(By.id("dropdown-class-example")).getAttribute("value"));

	}

}
