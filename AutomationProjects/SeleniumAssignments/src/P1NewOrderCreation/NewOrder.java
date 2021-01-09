package P1NewOrderCreation;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class NewOrder {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\browserDrivers\\chromedriver.exe");

		WebDriver d1 = new ChromeDriver();
		
		d1.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		
		
		WebElement user = d1.findElement(By.name("ctl00$MainContent$username"));
		user.sendKeys("Tester");
		
		WebElement pass = d1.findElement(By.name("ctl00$MainContent$password"));
		pass.sendKeys("test" + Keys.ENTER);
		
		
		d1.findElement(By.xpath("/html/body/form/table/tbody/tr/td[1]/ul/li[3]/a")).click();
		
		
		WebElement quantity = d1.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));
		
		int number = (int)(1 + (int)(Math.random() * 100));
		
		quantity.sendKeys(String.valueOf(number));
		
		
		WebElement cusName = d1.findElement(By.id("ctl00_MainContent_fmwOrder_txtName"));
		
		String s = "";

		do {
			s += (char) (97 + (int) (Math.random() * 26));
		} while (s.length() < 5);
		
		cusName.sendKeys("John " + String.valueOf(s) + " Doe");
		
		
		
		WebElement street = d1.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2"));
		street.sendKeys("8607 Westwood Center Dr");
		
		WebElement city = d1.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3"));
		city.sendKeys("Vienna");
		
		WebElement state = d1.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4"));
		state.sendKeys("Virginia");
		
		WebElement zipCode = d1.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));
		
		int number2 = (int)(10000 + (int)(Math.random() * 90000));
		
		zipCode.sendKeys(String.valueOf(number2));
		
	
		
		long vNo = 1000_0000_0000_000L + (long)(Math.random() * 9000_0000_0000_000L);
		String cardV = "4" + vNo;
		
		long mNo = 1000_0000_0000_000L + (long)(Math.random() * 9000_0000_0000_000L);
		String cardM = "5" + mNo;
		
		long aNo = 1000_0000_0000_00L + (long)(Math.random() * 9000_0000_0000_00L);
		String cardAm = "3" + aNo;
		
		
		
		
		List<WebElement> allRadio = d1.findElements(By.name("ctl00$MainContent$fmwOrder$cardList"));
		
		int rnd = (int)(0 + (int)(Math.random() * 3));
		
		allRadio.get(rnd).click();
		
		
		WebElement cardNo = d1.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6"));
		
		WebElement visa = d1.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0"));
		WebElement mas_Card = d1.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_1"));
		WebElement am_Ex = d1.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_2"));
		
		
		if (visa.isSelected()) {

			cardNo.sendKeys(cardV);

		} else if (mas_Card.isSelected()) {

			cardNo.sendKeys(cardM);

		} else if (am_Ex.isSelected()) {

			cardNo.sendKeys(cardAm);
		}
		
			
		WebElement exDate = d1.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1"));
		
		int number3 = (int)(1 + (int)(Math.random() * 12));
		int number4 = (int)(21 + (int)(Math.random() * 79));
		
		String s2 = "";
		if (number3 < 10) {s2 = "0" + number3;
		}else {s2 = "" + number3;}
		
		exDate.sendKeys(s2 + "/" + String.valueOf(number4));

		d1.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();
		
		String exText = "New order has been successfully added";
		
			if (d1.getPageSource().contains(exText)) {
				System.out.println("PASS");
				} else {
					System.out.println("FAIL");
					}
			
			
			
	}
	
		
}


