import org.openqa.selenium.By;
import org.openqa.selenium.ContextAware;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DrawCanvas {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.htmlcanvasstudio.com/");
		driver.manage().window().maximize();
		clickDrawLine(driver);
		DrawLine(driver);
		clickDrawRectangle(driver);
		DrawRectangle(driver);		
		clickEraser(driver);
		EraseLine(driver);

	}

	public static void clickDrawLine(WebDriver driver) throws Exception {
		WebElement drawline = driver.findElement(By.xpath("//input[@title = 'Draw a line']"));
		drawline.click();
	}
	
	public static void DrawLine(WebDriver driver) throws Exception {
		WebElement c = driver.findElement(By.xpath("//canvas[@id = 'imageTemp']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(c).perform();
		
		builder.click(c).perform();
		builder.moveByOffset(200,0).perform();
		builder.click().perform();
		//drawline.click();
		Thread.sleep(2000);
		builder.moveToElement(c, 100, -100).perform();
		builder.click().perform();
		builder.moveByOffset(0, 200).perform();
		builder.click().perform();
		Thread.sleep(2000);
	}
	
	public static void clickDrawRectangle(WebDriver driver) throws Exception {
		WebElement drawrect = driver.findElement(By.xpath("//input[@title = 'Draw a rectangle']"));
		drawrect.click();
	}
	
	public static void DrawRectangle(WebDriver driver) throws Exception {
		WebElement c = driver.findElement(By.xpath("//canvas[@id = 'imageTemp']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(c, 0, 200).perform();
		builder.click().perform();
		builder.moveByOffset(200, -100).perform();
		builder.click().perform();
		Thread.sleep(2000);
	}
	
	public static void clickEraser(WebDriver driver) throws Exception {
		WebElement eraser = driver.findElement(By.xpath("//input[@title = 'Use eraser']"));
		eraser.click();
	}
	
	public static void EraseLine(WebDriver driver) throws Exception {
		WebElement c = driver.findElement(By.xpath("//canvas[@id = 'imageTemp']"));
		Actions builder = new Actions(driver);
		//builder.moveToElement(c, 200, 0).perform();
		builder.click(c).perform();
		builder.dragAndDropBy(c, 200, 0).perform();
		Thread.sleep(2000);
	}
}
