package dec10;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class P2CarFax {

	public static void main(String[] args) throws InterruptedException {
		
		
		/*
		 Go  to carfax.com
		 Click on Find a Used Car
		 Verify the page title contains the word “Used Cars”
		*/
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\browserDrivers\\chromedriver.exe");

		WebDriver d1 = new ChromeDriver();
		
		d1.get("https://www.carfax.com/");
		
		d1.findElement(By.id("cfx-cars")).click();
		
		String exText = "Used Cars";
		
		if (d1.getPageSource().contains(exText)) {
			System.out.println("PASS");
			} else {
				System.out.println("FAIL");
				}
		
	

		
		/*
		 Choose “Tesla” for  Make.
		 Verify that the Select Model dropdown box contains 3 current Tesla models - (Model 3, Model S, Model X). 
		 Choose “Model S” for Model.
		*/
		
		new Select(d1.findElement(By.cssSelector("#makeModelPanel > form > div:nth-child(1) > div > select"))).selectByValue("Acura");
		
		Thread.sleep(2000); 
		
		Select make = new Select(d1.findElement(By.cssSelector("#makeModelPanel > form > div:nth-child(1) > div > select")));
		make.selectByValue("Tesla");

		Thread.sleep(1000);
		
		Select model = new Select(d1.findElement(By.cssSelector("#makeModelPanel > form > div:nth-child(2) > div > select")));

		Thread.sleep(2000);

		List<String> exModel = Arrays.asList("Select Model", "Model 3", "Model S", "Model X", "Roadster");
		
		List<String> acModel = new ArrayList<String>();
		
		for(WebElement option : model.getOptions()) { acModel.add(option.getAttribute("value")); }

		if (acModel.equals(exModel)) {System.out.println("Models verified");} 
		else {System.out.println("Models not verified");}
		
		model.selectByValue("Model S");
		
		
		
		
		/*
		 Enter the zipcode as 22182 and click Next
		 Verify that the page has “Step 2 – Show me cars with” text
		 Click on all 4 checkboxes.
		*/
		
		WebElement zip = d1.findElement(By.xpath("//input[@type='tel']"));
		zip.sendKeys("22182");
		
		WebElement nextButton = d1.findElement(By.id("make-model-form-submit"));
		nextButton.click();
		
		String exText2 = "Step 2 - Show me cars with";
		
		if (d1.getPageSource().contains(exText2)) {
			System.out.println("Step 2 PASS");
			} else {
				System.out.println("Step 2 FAIL");
				}
		

		List <WebElement> checkBoxes = d1.findElements(By.className("checkbox-list-item--fancyCbx"));
		
		for (WebElement eachBox : checkBoxes) {
		if(!eachBox.isSelected()) {
			eachBox.click();
				}
		}
		
		
		
		
		/*
		Save the result of “Show me X Results” button to a variable. In this case it is 6.
		Click on “Show me x Results” button. 
		Verify that the results page has the same number of results as indicated in Step 10 
		by extracting the number and comparing the result
		*/

		WebElement resultButton = d1.findElement(By.className("totalRecordsText"));
		
		String extractedResult = resultButton.getText();
		System.out.println(resultButton.getText());
		resultButton.click();
		
		WebElement resultDisplay = d1.findElement(By.id("totalResultCount"));
		String displayedResult = resultDisplay.getText();
		System.out.println(resultDisplay.getText());
		
		if(extractedResult.equals(displayedResult)) {
			System.out.println("Extracted result matches displayed result");
		}else {System.out.println("Match fail");}
		
		
		
		
		/*
		 Verify the results also by getting the actual number of results displayed in the page with 
		 the number in the Step 10. For this step get the count the number of WebElements related to each result. 
		 Verify that each result contains String “Tesla Model S”.
		*/
		
		List<WebElement> listedResults = d1.findElements(By.xpath("//article[@data-vin]"));
		
		String s = String.valueOf(listedResults.size());
		if(s.equals(displayedResult)) {
			System.out.println("Listing displays the correct results");
		}else {System.out.println("Listing is inaccurate");}
		
		Thread.sleep(2000); 
		
		List<WebElement> modelDisplay = d1.findElements(By.xpath("//h4[@class='srp-list-item-basic-info-model']"));
		
		String s2 = "Tesla Model S";
		
		for (WebElement e : modelDisplay) {

			if (!e.getText().contains(s2)) {
				System.out.println("Listing does not contain Tesla Model S");
			}
		}
		
		
		
		
		/*
		 Get the price of each result and save them into a list in the order of their appearance.
		 Choose “Price - High to Low” option from Sort menu
		 Verify that the results are displayed from high to low price. 
		*/
	
		List<WebElement> price = d1.findElements(By.className("srp-list-item-price"));
		
		List<String> displayPrice = new ArrayList<>();
		
		for(WebElement eachPrice : price) { displayPrice.add(eachPrice.getText()); }
		
		//System.out.println(displayPrice);

		Select sort1 = new Select(d1.findElement(By.className("srp-header-sort-select")));
		sort1.selectByValue("PRICE_DESC");
		
		
		Thread.sleep(2000);
		
		List<WebElement> price2 = d1.findElements(By.className("srp-list-item-price"));
		
		List<String> displayPrice2 = new ArrayList<>();
		
		for(WebElement eachPrice2 : price2) { displayPrice2.add( (eachPrice2.getText().substring(8,10)).concat(eachPrice2.getText().substring(11,14)));  }
		
		//System.out.println(displayPrice2);

		
		
		List<Integer> verifySort = new ArrayList<>();
		
		for (int i = 0; i < displayPrice2.size(); i++) {
			verifySort.add(Integer.parseInt(displayPrice2.get(i)));
		}
		
		for (int i = 0; i < verifySort.size() - 1;) {

			if (!(verifySort.get(i) > verifySort.get(++i)) ) {
				System.out.println("Listing is not in order");
			}
		}
		
		
		
		
		/*
		 Choose “Mileage - Low to High” option from Sort menu
		 Verify that the results are displayed from low to high mileage. 
		*/
		
		Select sortMilage = new Select(d1.findElement(By.className("srp-header-sort-select")));
		sortMilage.selectByValue("MILEAGE_ASC");
		
		Thread.sleep(2000);
		
		List<WebElement> milageList = d1.findElements(By.xpath("//div[4]/div[2]/span[1]"));
		
		List<String> disMilage = new ArrayList<>();
		
		
		for(WebElement eachMilage : milageList) { disMilage.add(eachMilage.getText().substring(9,11).concat(eachMilage.getText().substring(12,15)));  } 
		
		//System.out.println(disMilage);
		
		List<Integer> verifyMiles = new ArrayList<>();
		
		for (int i = 0; i < disMilage.size(); i++) {
			verifyMiles.add(Integer.parseInt(disMilage.get(i)));
		}
		
		for (int i = 0; i < verifyMiles.size() - 1; ) {

			if (!(verifyMiles.get(i) < verifyMiles.get(++i)) ) {
				System.out.println("Mileage are not in order from low-to-high");
			}
		}
		
		
		
		
		/*
		  Choose “Year - New to Old” option from Sort menu
		  Verify that the results are displayed from new to old year.
		*/
		
		Select sortYear = new Select(d1.findElement(By.className("srp-header-sort-select")));
		sortYear.selectByValue("YEAR_DESC");
		
		Thread.sleep(2000);
		
		List<WebElement> modelYear = d1.findElements(By.xpath("//h4[@class='srp-list-item-basic-info-model']"));
		
		List<String> disYear = new ArrayList<>();
		

		for(WebElement eachYear : modelYear) { disYear.add(eachYear.getText().substring(0,4));  } 
		
		//System.out.println(disYear);
		
		List<Integer> verifyYear = new ArrayList<>();
		
		for (int i = 0; i < disYear.size(); i++) {
			verifyYear.add(Integer.parseInt(disYear.get(i)));
		}
		
		
		for (int i = 0, j = 1; i < verifyYear.size() - 1; i++, j++) {

			if ((int)verifyYear.get(i) > (int)verifyYear.get(j)) {
			} else if ((int)verifyYear.get(i) == (int)verifyYear.get(j)) {
			} else {
				System.out.println("Year is not order from high-to-low");
			}
		}
		
		
	}

}
