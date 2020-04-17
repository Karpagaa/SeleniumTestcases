package testcases;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TC003_MakeMyTrip {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
    
		// 1) Go to https://www.makemytrip.com/
		driver.get("https://www.makemytrip.com/");		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// 2) Click Hotels		
		driver.findElementByXPath("(//a[@class='makeFlex hrtlCenter column'])[1]").click();
		
		
		// 3) Enter city as Goa, and choose Goa, India		
		driver.findElementByXPath("//span[@data-cy='hotelCityLabel']").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//input[@placeholder='Enter city/ Hotel/ Area/ Building']").sendKeys("Goa,India",Keys.TAB);
		
		
		
		// 4) Enter Check in date as Next month 15th (May 15) and Check out as start date+5		
		driver.findElementById("checkin").click();
		String startDate = driver.findElementByXPath("(//div[text()='15'])[2]").getText();
		driver.findElementByXPath("(//div[text()='15'])[2]").click();
		int endDate=Integer.parseInt(startDate)+5;
		driver.findElementByXPath("(//div[text()='"+endDate+"'])[2]").click();
		
		
		
		// 5) Click on ROOMS & GUESTS and click 2 Adults and one Children(age 12). Click Apply Button.
		driver.findElementByXPath("//div[@class='hsw_inputBox roomGuests  ']").click();
		driver.findElementByXPath("//li[@data-cy='adults-2']").click();
		driver.findElementByXPath("//li[@data-cy='children-1']").click();
		driver.findElementByXPath("//button[text()='APPLY']").click();
		
		// 6) Click Search button		
		driver.findElementById("hsw_search_button").click();
		
		// 7) Select locality as Baga		
		driver.findElementByXPath("//div[@class='mmBackdrop wholeBlack']").click();
		driver.findElementByXPath("//label[text()='Baga']").click();
		Thread.sleep(3000);
		
		// 8) Select 5 start in Star Category under Select Filters				
		driver.findElementByXPath("//label[text()='5 Star']").click();
				
		
		//9) Click on the first resulting hotel and go to the new window		
		driver.findElementByXPath("(//p[@id='hlistpg_hotel_name'])[1]").click();
		Set<String> windowSet = driver.getWindowHandles();
		List<String> windowList = new ArrayList<String>(windowSet);
		driver.switchTo().window(windowList.get(1));		
		
		//10) Print the Hotel Name		
		String hotelName = driver.findElementById("detpg_hotel_name").getText();
		System.out.println("Hotel name is: " + hotelName);
		
		//11) Click MORE OPTIONS link and Select 3Months plan and close		
		driver.findElementByXPath("(//span[text()='MORE OPTIONS'])[1]").click();
		driver.findElementByXPath("(//span[text()='SELECT'])[1]").click();
		driver.findElementByXPath("//span[@class='close']").click();
		
		
		//12) Click on BOOK THIS NOW
		driver.findElementByXPath("//a[text()='BOOK THIS NOW']").click();
		
		//13) Print the Total Payable amount
		String totalPayableAmount = driver.findElementById("revpg_total_payable_amt").getText();
		System.out.println("Total payable amount: " + totalPayableAmount);
		
		//14) Close the browser
		driver.quit();	
		

		
	}

}
