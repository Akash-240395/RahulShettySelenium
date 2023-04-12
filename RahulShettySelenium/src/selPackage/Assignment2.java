package selPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\Software\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/angularpractice/");

		driver.findElement(By.name("name")).sendKeys("Akash Patel");
		driver.findElement(By.name("email")).sendKeys("akash.patel24.ap@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("Akash@2424");
		driver.findElement(By.id("exampleCheck1")).click();

		Select sel = new Select(driver.findElement(By.id("exampleFormControlSelect1")));
		sel.selectByVisibleText("Male");

		driver.findElement(By.id("inlineRadio2")).click();
		driver.findElement(By.name("bday")).sendKeys("24/03/1995");
		Thread.sleep(2000);
		
		/*
		 * Actions act = new Actions(driver);
		 * act.moveToElement(driver.findElement(By.className("btn btn-success"))).build(
		 * ).perform();
		 */
		driver.findElement(By.cssSelector("input[class='btn btn-success']")).click();

		System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText());

	}

}
