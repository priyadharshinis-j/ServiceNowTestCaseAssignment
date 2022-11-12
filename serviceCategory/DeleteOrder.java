package serviceCategory;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteOrder {

	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
		driver.manage().window().maximize();
		
		driver.get("https://dev66192.service-now.com/");
		
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Hp-compaq1@");
		driver.findElement(By.id("sysverb_login")).click();
		Thread.sleep(15000);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement clickAll=(WebElement) js.executeScript("return document.querySelector('body > macroponent-f51912f4c700201072b211d4d8c26010').shadowRoot.querySelector('div > sn-canvas-appshell-root > sn-canvas-appshell-layout > sn-polaris-layout').shadowRoot.querySelector('div.sn-polaris-layout.polaris-enabled > div.layout-main > div.header-bar > sn-polaris-header').shadowRoot.querySelector('#d6e462a5c3533010cbd77096e940dd8c')");
		String click = "arguments[0].click()";
		Thread.sleep(5000);
		
		((JavascriptExecutor)driver).executeScript(click, clickAll);	
		
		Thread.sleep(5000);
		
		WebElement input = (WebElement) js.executeScript("return document.querySelector('body > macroponent-f51912f4c700201072b211d4d8c26010').shadowRoot.querySelector('div > sn-canvas-appshell-root > sn-canvas-appshell-layout > sn-polaris-layout').shadowRoot.querySelector('div.sn-polaris-layout.polaris-enabled > div.layout-main > div.header-bar > sn-polaris-header').shadowRoot.querySelector('nav > div > sn-polaris-menu:nth-child(1)').shadowRoot.querySelector('#filter')");
		
		input.sendKeys("Service Catalog");
		Thread.sleep(3000);
		input.sendKeys(Keys.RETURN);
		
		Thread.sleep(5000);
		
		WebElement frame = (WebElement)js.executeScript("return document.querySelector(\'body > macroponent-f51912f4c700201072b211d4d8c26010\').shadowRoot.querySelector(\'#gsft_main\')");
		driver.switchTo().frame(frame);
			
			Thread.sleep(5000);

			WebElement clickMobile= driver.findElement(By.xpath("//a[text()='Mobiles']"));
			Thread.sleep(6000);
			clickMobile.click();

			Thread.sleep(5000);
			
			
			WebElement clickApple = driver.findElement(By.xpath("//strong[text()='Apple iPhone 13']"));
			clickApple.click();
			
			
			driver.findElement(By.xpath("//label[text()='No']")).click();
			Thread.sleep(3000);
			
			WebElement select_ = driver.findElement(By.tagName("select"));
			Select select = new Select(select_);
			select.selectByIndex(1);
			
			driver.findElement(By.xpath("//label[contains(text(),'Pink')]")).click();
			
			driver.findElement(By.id("oi_order_now_button")).click();
			
			String requestId = driver.findElement(By.id("requesturl")).getText();
			System.out.println("Request Id is "+requestId);
			
			driver.findElement(By.id("requesturl")).click();
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//button[@id='sysverb_delete']")).click();
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@id='ok_button']")).click();
			
		
	}
}
