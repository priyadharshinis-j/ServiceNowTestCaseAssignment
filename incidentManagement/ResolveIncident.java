package incidentManagement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ResolveIncident {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options =new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
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
		
		input.sendKeys("Incident");
		Thread.sleep(3000);
		input.sendKeys(Keys.RETURN);
		
		Thread.sleep(5000);
		
		WebElement frame = (WebElement)js.executeScript("return document.querySelector(\'body > macroponent-f51912f4c700201072b211d4d8c26010\').shadowRoot.querySelector(\'#gsft_main\')");
		driver.switchTo().frame(frame);
		
		List<WebElement> numberList = driver.findElements(By.xpath("(//tbody[@class='list2_body']//td[3])"));
		List<String> stringList = new ArrayList<String>();
		
		for(int i =1;i<=numberList.size()-1;i++)
		{
			String text_ = driver.findElement(By.xpath("(//tbody[@class='list2_body']//td[3])["+i+"]")).getText();
			stringList.add(text_);
			
		}
		String item="";
		for(int i=0;i<stringList.size();i++)
		{
			int index = (int)(Math.random() * stringList.size());
			item=stringList.get(index);
			
		}


		WebElement search = driver.findElement(By.xpath("//input[@class='form-control']"));
		search.clear();
		search.sendKeys(item,Keys.RETURN);
		

		WebElement incident = driver.findElement(By.xpath("(//td[@class='vt']/a)"));
		String text = incident.getText();
		incident.click();
			
		Thread.sleep(3000);
		
		WebElement option_ = driver.findElement(By.id("incident.state"));
		Select select_ = new Select(option_);
		select_.selectByVisibleText("Resolved");
		
		driver.findElement(By.id("sysverb_update")).click();
		
		WebElement search_ = driver.findElement(By.xpath("//input[@class='form-control']"));
		search_.clear();
		search_.sendKeys(text,Keys.RETURN);
		
		
		driver.findElement(By.xpath("//span[text()='Incidents']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id=\"context_list_titleincident\"]/div[2]")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[text()='Default view']")).click();
		Thread.sleep(3000);
		
		
		
		
	}

}
