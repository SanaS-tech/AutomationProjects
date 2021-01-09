package dec22;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class P3OrderCarOnline {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\browserDrivers\\chromedriver.exe");
		
		WebDriver d1 = new ChromeDriver();
				
		d1.get("https://www.lexus.com/");
		
		String acTitle = d1.getTitle();
		String exTitle = "Experience Amazing";
		
		if (acTitle.contains(exTitle)) {
			System.out.println("Title Pass");
			} else {
				System.out.println("FAIL");
				}
		 
		d1.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		d1.findElement(By.xpath("//div[@class='ccpa-footer-banner']//a[@href='https://privacy.toyota.com/']")).click();
		
		String parentHandle = d1.getWindowHandle();
		String childHandle = null;
		
		Set<String> allHandles = d1.getWindowHandles();
		
		for (String handle : allHandles) {
			if ( !(handle.equals(parentHandle)) ) {
				d1.switchTo().window(handle);
				childHandle = handle;
			}
		}
		
		
		String acTitle2 = d1.getTitle();
		String exTitle2 = "Privacy Hub";
		
		if (acTitle2.contains(exTitle2)) {
			System.out.println("Title #2 Pass");
			} else {
				System.out.println("FAIL");
				}
		
		
		d1.findElement(By.xpath("//a[@href='privacy-hub/privacyright.html']")).click();
		
		
//		for (String handle : allHandles) {
//			if ( !(handle.equals(parentHandle)) && !(handle.equals(childHandle)) ) {
//				d1.switchTo().window(handle);
//			}
//		}
		
		
		String acURL = d1.getCurrentUrl();
		String exURL = "https://privacy.toyota.com/privacy-hub/privacyright.html";
		
		if (acURL.contains(exURL)) {
			System.out.println("URL Pass");
			} else {
				System.out.println("FAIL");
				}
	
		
		d1.switchTo().window(parentHandle);
		
		d1.findElement(By.xpath("//a[@href='/build-your-lexus/#!/']")).click();
		
		d1.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebElement zipNo = d1.findElement(By.xpath("//input[@class='zip-enter byl-js-focus']"));
		
		zipNo.sendKeys("22182");
		
		d1.findElement(By.xpath("//button[@class='btn-rev btn-border omniture']")).click();
		
		d1.findElement(By.xpath("//span[1]/ul/li[2]/a[1]/span/span[1]")).click();
		
		
		
		WebElement price = d1.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/article/div/span[2]/span/ul/li[6]/div[2]/ul/li/a/span[2]"));
		
		String strPrice = price.getText();
		
		int intPrice = Integer.parseInt(strPrice.substring(1, 3).concat(strPrice.substring(4, 7)));
//		System.out.println(intPrice);
		
		Thread.sleep(2000);
		
		price.click();
		
		d1.findElement(By.xpath("//img[@alt='Silver Lining Metallic , 01J4']")).click();

		d1.findElement(By.xpath("//span[@id='total-price']")).click();
		
		WebElement basePri = d1.findElement(By.xpath("(//span[@class='title-price-small'])[1]"));
		String strbasePri = basePri.getText();
		int intbasePri = Integer.parseInt(strbasePri.substring(1, 3).concat(strbasePri.substring(4, 7)));

		
		if (intbasePri==intPrice) {
			System.out.println("Price is the same");
			} else {
				System.out.println("FAIL");
				}
		
		
		String strdpH = d1.findElement(By.xpath("(//span[@class='title-price-small'])[4]")).getText();
		int intdpH = Integer.parseInt(strdpH.substring(1, 2).concat(strdpH.substring(3, 6)));
		
		
		String strmSRP = d1.findElement(By.xpath("(//span[@class='title-price-small'])[5]")).getText();
		int intmSRP = Integer.parseInt(strmSRP.substring(1, 3).concat(strmSRP.substring(4, 7)));
	
		
		if ( (intbasePri + intdpH )==intmSRP) {
			System.out.println("MSRP fee is correct");
			} else {
				System.out.println("FAIL");
				}
		
		
		d1.findElement(By.xpath("//span[@id='total-price']")).click();
		
		d1.findElement(By.xpath("//img[@alt='Ultrasonic Blue Mica 2.0[ULTRASONIC17] , 08X1']")).click();
		
		//Close menu
		d1.findElement(By.xpath("//span[@id='total-price']")).click();
	
		
		
		String color = d1.findElement(By.xpath("(//span[@class='title-price-small'])[2]")).getText();
		int intcolor = Integer.parseInt(color.substring(1));

		
		String strmSRP1 = d1.findElement(By.xpath("(//span[@class='title-price-small'])[5]")).getText();
		int intmSRP1 = Integer.parseInt(strmSRP1.substring(1, 3).concat(strmSRP1.substring(4, 7)));

		
		if ( (intbasePri + intdpH + intcolor ) == intmSRP1) {
			System.out.println("MSRP fee with color is correct");
			} else {
				System.out.println("FAIL");
				}
		
		//Close menu
		d1.findElement(By.xpath("//span[@id='total-price']")).click();
		
		d1.findElement(By.xpath("//a[@class='byl-js-goToICol omniture']")).click();
		
		d1.findElement(By.xpath("//img[@alt='Circuit Red NuLuxe® with Hadori Aluminum trim , VL25']")).click();
		
		d1.findElement(By.xpath("//a[@class='byl-js-goToPackages omniture']")).click();
		
		d1.findElement(By.xpath("(//a[@class='byl-js-opt-select addRemove'])[5]")).click();
		
		
		//Open menu
		d1.findElement(By.xpath("//span[@id='total-price']")).click();
	
		
		String music = d1.findElement(By.xpath("(//div[@class='list-total'])[4]")).getText();
		int intmusic = Integer.parseInt(music.substring(1));

		
		String strmSRP2 = d1.findElement(By.xpath("(//div[@class='list-total'])[6]")).getText();
		int intmSRP2 = Integer.parseInt(strmSRP2.substring(1, 3).concat(strmSRP2.substring(4, 7)));
		
		System.out.println(intbasePri + " " + intdpH + " " + intcolor + " " + + intmSRP2);
		
		if ( (intbasePri + intdpH + intcolor + intmusic ) == intmSRP2) {
			System.out.println("MSRP fee with color & sound system is correct");
			} else {
				System.out.println("FAIL");
				}
		

		d1.findElement(By.xpath("//a[@class='byl-js-goToOptions omniture']")).click();
		d1.findElement(By.xpath("//a[@class='display-summary omniture']")).click();
		
		
		String finalMSRP = d1.findElement(By.xpath("//h2[@class='title-price']")).getText();
		int intfinalMSRP = Integer.parseInt(finalMSRP.substring(1, 3).concat(finalMSRP.substring(4, 7)));
		
		if ( intmSRP2 == intfinalMSRP) {
			System.out.println("MSRP fee with color & sound system is correct");
			} else {
				System.out.println("FAIL");
				}

		
		d1.findElement(By.xpath("//a[@class='btn-rev byl-js-purchase-inquiry']")).click();

		
		
		String mainHandle = d1.getWindowHandle();
		String dealerHandle = null;
		
		Set<String> Handles = d1.getWindowHandles();
		
		for (String handle : Handles) {
			if ( !(handle.equals(mainHandle)) ) {
				d1.switchTo().window(handle);
				dealerHandle = handle;
			}
		}
		
		
		String exText = "Send us Your Dream Car";
		
		if (d1.getPageSource().contains(exText)) {
			System.out.println("Page source PASS");
			} else {
				System.out.println("FAIL");
				}
		
		
		d1.findElement(By.cssSelector("#first-name")).click();
		
		Actions a = new Actions(d1);
		a.sendKeys("John").sendKeys(Keys.TAB).sendKeys("Doe").sendKeys(Keys.TAB).sendKeys("anymail@gmail.com").sendKeys(Keys.TAB)
		.sendKeys("3127250272").sendKeys(Keys.TAB).build().perform();
		
		WebElement radioButton = d1.findElement(By.id("64504"));
	
		((JavascriptExecutor) d1).executeScript("arguments[0].checked = true;", radioButton);
	

		
		WebElement submitButton = d1.findElement(By.xpath("//button[@class='btn-rev']"));
	
		
	//	((JavascriptExecutor) d1).executeScript("arguments[0].checked = true;", submitButton);
		submitButton.sendKeys(Keys.ENTER);

		
		String exText2 = "WE'LL BE IN TOUCH SHORTLY";
		
		WebElement fin = d1.findElement(By.className("list-title-sub"));
		
		
		
		if (fin.getText().contains(exText2)) {
			System.out.println("Final page source PASS");
			} else {
				System.out.println("FAIL");
				}
		
		
		
	}

}
