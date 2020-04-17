package testcases;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TC002_Nykaa {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
			ChromeDriver driver = new ChromeDriver();
        
			// 1) Go to https://www.nykaa.com/
			driver.get("https://www.nykaa.com/");		
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
			//2) Mouseover on Brands and Mouseover on Popular
			WebElement brandMouseover= driver.findElementByXPath("//a[text()='brands']");
			Actions builder = new Actions(driver);
			builder.moveToElement(brandMouseover).perform();
			WebElement popularMouseHover = driver.findElementByXPath("//a[text()='Popular']");
			builder.moveToElement(popularMouseHover).perform();
		
			//3) Click L'Oreal Paris
			driver.findElementByXPath("(//li[@class='brand-logo menu-links'])[5]").click();
		
			//4) Go to the newly opened window and check the title contains L'Oreal Paris
		
			Set<String> winSet = driver.getWindowHandles();
			List<String> winList = new ArrayList<String>(winSet);
			driver.switchTo().window(winList.get(1));
			System.out.println(driver.getTitle());
			if (driver.getTitle().contains("L'Oreal Paris")) {
				System.out.println("The title contains L'Oreal Paris");
			} 
			else {
				System.out.println("The title doesnt contains L'Oreal Paris");
			}
		
			//5) Click sort By and select customer top rated

			driver.findElementByXPath("//span[@class='pull-left']").click();
			driver.findElementByXPath("//span[text()='customer top rated']").click();
			Thread.sleep(3000);
		
			//6) Click Category and click Shampoo
		
			driver.findElementByClassName("expand-icon").click();
			driver.findElementByXPath("//label[@for='chk_Shampoo_undefined']").click();
			driver.findElementByXPath("(//label[@for='chk_Shampoo_undefined'])[2]").click();
				
		    //7) check whether the Filter is applied with Shampoo
				
			String Shampoo = driver.findElementByXPath("//ul[@class='pull-left applied-filter-lists']").getText();
			if(Shampoo.contains("Shampoo")) {
				System.out.println("The Filter is applied with Shampoo");
			} 
			else {
				System.out.println("The Filter is not applied with Shampoo");
			}
				
			//8) Click on L'Oreal Paris Colour Protect Shampoo
				
			driver.findElementByXPath("//h2[contains(@title,'Paris Colour Protect Shampoo')]").click();
				
			//9) GO to the new window and select size as 175ml
				
			Set<String> winset1 = driver.getWindowHandles();
			List<String> winlis1 = new ArrayList <String>(winset1);
			driver.switchTo().window(winlis1.get(2)).getTitle();
			System.out.println(driver.getTitle());
			driver.findElementByXPath("//span[text()='175ml']").click();
				
			//10) Print the MRP of the product
				
				
			String pro = driver.findElementByXPath("(//span[@class='post-card__content-price-offer'][1])").getText();
			int MRP = Integer.parseInt(pro.replaceAll("\\D", ""));
			System.out.println("The MRP of the Product is : " + MRP);
				
				
			//11) Click on ADD to BAG
					
			driver.findElementByXPath("(//button[text()='ADD TO BAG'])[1]").click();
				
					
			//12) Go to Shopping Bag 
				
			driver.findElementByClassName("AddBagIcon").click();
				
			//13) Print the Grand Total amount
				
			String total = driver.findElementByXPath("//div[@class='value medium-strong']").getText();
			int grandTotal = Integer.parseInt(total.replaceAll("\\D", ""));
			System.out.println("The grand total is : " + grandTotal);
				
				
			//14) Click Proceed
				
			driver.findElementByXPath("//button[@class='btn full fill no-radius proceed ']").click();
				
				
			//15) Click on Continue as Guest
				
			driver.findElementByXPath("//button[@class='btn full big']").click();
				
				
			//16) Print the warning message (delay in shipment)
				
				
			String warningMsg = driver.findElementByXPath("//div[@class='message']").getText();
			System.out.println("The warning message is "+ warningMsg);
						
				
				
			//17) Close all windows

			driver.quit();	
			


	}

}
