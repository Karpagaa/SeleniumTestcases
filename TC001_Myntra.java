package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TC001_Myntra {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        
        // 1) Open https://www.myntra.com/
		driver.get("https://www.myntra.com/");		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// 2) Mouse over on WOMEN (Actions -> moveToElement
		WebElement elementMouseover= driver.findElementByXPath("//a[text()='Women'][1]");
		Actions builder = new Actions(driver);
		builder.moveToElement(elementMouseover).perform();
		
		// 3) Click Jackets & Coats
		driver.findElementByLinkText("Jackets & Coats").click();
		
		
		// 4) Find the total count of item
		String Count=driver.findElementByClassName("title-count").getText();
		int totalCount=Integer.parseInt(Count.replaceAll("\\D", ""));
		System.out.println("The total count of item is: " + totalCount);
		
		String jCount=driver.findElementByXPath("(//span[@class='categories-num'])[1]").getText();
		int jacketsCount=Integer.parseInt(jCount.replaceAll("\\D", ""));
		System.out.println("Count of Jackets is: " + jacketsCount);
		Thread.sleep(3000);
		
		String cCount=driver.findElementByXPath("(//span[@class='categories-num'])[2]").getText();
		int coatsCount=Integer.parseInt(cCount.replaceAll("\\D", ""));
		System.out.println("Count of Coats is: " + coatsCount);
		
	
		
		//5) Validate the sum of categories count matches
		int categoryCount=jacketsCount+coatsCount;
		if(totalCount==categoryCount) {
		System.out.println("Count is matching");
		
		}
		else {
			System.out.println("Count is not matching");
		}
		
		//6) Check Coats
		driver.findElementByXPath("//label[text()='Coats']").click();
		
		
		//7) Click + More option under BRAND	
		
		driver.findElementByXPath("//div[@class='brand-more']").click();
		
		
		//8) Type MANGO and click checkbox
		driver.findElementByXPath("//input[@placeholder='Search brand']").sendKeys("MANGO");
		driver.findElementByXPath("//label[@class=' common-customCheckbox']//div").click();
		
		
		//9) Close the pop-up x
		driver.findElementByXPath("//span[contains(@class,'myntraweb-sprite FilterDirectory-close')]").click();
		Thread.sleep(3000);
		
		
		//10) Confirm all the coats are of brand Mango
		int count=0;
		List<WebElement> listOfBrandName = driver.findElementsByXPath("//div[@class='product-productMetaInfo']//h3[1]");
		for (WebElement brand : listOfBrandName) {
			String brandName = brand.getText();
			if (brandName.equalsIgnoreCase("mango")) {
				count=count+1;
			} 
		}
		if (count==listOfBrandName.size()) {
			System.out.println("Confirm all the coats are of brand MANGO");
		} else {
			System.out.println("Confirm that not all the coats are of brand MANGO");
		}

		
		//11) Sort by Better Discount
		WebElement sortBy = driver.findElementByXPath("//div[@class='sort-sortBy']");
		builder.moveToElement(sortBy).perform();
		driver.findElementByXPath("//label[text()='Better Discount']").click();
		Thread.sleep(3000);

		
		
		//12) Find the price of first displayed item
		
		String priceOfFirstDisplayedItem =driver.findElementByXPath("(//span[@class='product-discountedPrice'])[1]").getText();
		int price=Integer.parseInt(priceOfFirstDisplayedItem.replaceAll("\\D", ""));
		System.out.println("Price of first displayed item: " + price);
		Thread.sleep(3000);
		
		
		//13) Mouse over on size of the first item
		WebElement firstItem = driver.findElementByXPath("(//li[@class='product-base'])[1]");
		WebElement sizeOfFirstItem = driver.findElementByXPath("(//h4[@class='product-sizes'])[1]//span");
		builder.moveToElement(firstItem).moveToElement(sizeOfFirstItem).perform();

		//14) Click on WishList Now
		driver.findElementByXPath("(//span[text()='wishlist now'])[1]").click();
		
		
		//15) Close Browser
		driver.close();
						
		
}
}

