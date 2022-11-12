package incidentManagement;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateNewIncident {
	
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
		
		input.sendKeys("Incident");
		Thread.sleep(3000);
		input.sendKeys(Keys.RETURN);
		
		Thread.sleep(5000);
		
		WebElement frame = (WebElement)js.executeScript("return document.querySelector(\'body > macroponent-f51912f4c700201072b211d4d8c26010\').shadowRoot.querySelector(\'#gsft_main\')");
		driver.switchTo().frame(frame);
		
		WebElement newButton = (WebElement)js.executeScript("return document.querySelector(\'#sysverb_new\')");
		newButton.click();
		
		driver.findElement(By.id("incident.short_description")).sendKeys("Test");
		
		WebElement number = driver.findElement(By.id("incident.number"));
		String number_=number.getText();
		System.out.println(number_);
		
		Thread.sleep(2000);
		driver.findElement(By.id("sysverb_insert_bottom")).click();
		
		Thread.sleep(3000);
		
		List<WebElement> numberList = driver.findElements(By.xpath("(//tbody[@class='list2_body']//td[3])"));
		//List<String> stringList = new ArrayList<String>();
		Actions action = new Actions(driver);
		WebElement element;
		for(int i =1;i<=numberList.size()-1;i++)
		{
			String text = driver.findElement(By.xpath("(//tbody[@class='list2_body']//td[3])["+i+"]")).getText();
			
			if(number_.equals(text))
			{
				element = driver.findElement(By.xpath("(//tbody[@class='list2_body']//td[3])["+i+"]"));
				Thread.sleep(3000);
				action.moveToElement(element).doubleClick().perform();
				Thread.sleep(3000);
				action.keyDown(Keys.CONTROL).sendKeys("c").perform();
				break;
				
			}
		}
		
			
		Thread.sleep(3000);
		
		WebElement search = driver.findElement(By.xpath("//input[@class='form-control']"));
		search.sendKeys(Keys.chord(Keys.CONTROL,"v",Keys.RETURN));
	}

}
