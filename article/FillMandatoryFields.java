package article;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FillMandatoryFields {
	
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
		
		input.sendKeys("Knowledge");
		Thread.sleep(3000);
		input.sendKeys(Keys.RETURN);
		
		Thread.sleep(5000);
		
		WebElement frame = (WebElement)js.executeScript("return document.querySelector(\'body > macroponent-f51912f4c700201072b211d4d8c26010\').shadowRoot.querySelector(\'#gsft_main\')");
		driver.switchTo().frame(frame);
		
		driver.findElement(By.xpath("//span[contains(@class,'btn-icon icon-article-document')]")).click();
		
		driver.findElement(By.xpath("//span[@class='icon icon-search']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		
		List<String> window = new ArrayList<String>(windowHandles);
		
		driver.switchTo().window(window.get(1));
		driver.findElement(By.linkText("IT")).click();
		Thread.sleep(3000);

		driver.switchTo().window(window.get(0));
		WebElement frame_ = (WebElement)js.executeScript("return document.querySelector(\'body > macroponent-f51912f4c700201072b211d4d8c26010\').shadowRoot.querySelector(\'#gsft_main\')");
		driver.switchTo().frame(frame_);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@id='sys_display.kb_knowledge.kb_category']")).click();
		driver.findElement(By.xpath("//button[@data-for='sys_display.kb_knowledge.kb_category']//span[1]")).click();
		
		//driver.switchTo().window(window.get(1));
		
		driver.findElement(By.xpath("//span[text()='IT']")).click();
		driver.findElement(By.xpath("//span[text()='Java']")).click();
		driver.findElement(By.id("ok_button")).click();
		
		driver.findElement(By.id("kb_knowledge.short_description")).sendKeys("Programming Language");
	
		driver.findElement(By.id("sysverb_insert")).click();
		
		
	}

}
