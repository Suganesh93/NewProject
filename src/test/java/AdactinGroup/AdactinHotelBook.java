package AdactinGroup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class AdactinHotelBook {
	WebDriver driver;
	@Test
	public void openAdatin() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\elcot\\eclipse-workspace\\HotelProject\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://adactinhotelapp.com/");
		driver.manage().window().maximize();
		String a = driver.getCurrentUrl();
		System.out.println(a);
		WebElement userName = driver.findElement(By.id("username"));
		userName.sendKeys("Suganesh");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("Sugan@123");
		WebElement login = driver.findElement(By.id("login"));
		login.click();
		Thread.sleep(4000);
		}
	@Test(dependsOnMethods="openAdatin")
	public void bookingPage() {
		WebElement dropdown1 = driver.findElement(By.id("location"));
		Select select = new Select(dropdown1);
		select.selectByVisibleText("London");
		WebElement hotelSelect = driver.findElement(By.id("hotels"));
		Select select1 = new Select(hotelSelect);
		select1.selectByIndex(3);
		WebElement roomSelect = driver.findElement(By.id("room_type"));
		Select roomType = new Select(roomSelect);
		roomType.selectByValue("Deluxe");
		WebElement roomSelection = driver.findElement(By.id("room_nos"));
		Select roomNumber = new Select(roomSelection);
		roomNumber.selectByValue("7");
		WebElement checkinDate = driver.findElement(By.id("datepick_in"));
		checkinDate.sendKeys("01/08/2021");
		WebElement checkOutDate = driver.findElement(By.id("datepick_out"));
		checkinDate.sendKeys("02/08/2021");
		WebElement adultSelect = driver.findElement(By.id("adult_room"));
		Select totalMember = new Select(adultSelect);
		totalMember.selectByIndex(3);
		WebElement childSelect = driver.findElement(By.id("child_room"));
		Select totalChild = new Select(childSelect);
		totalChild.selectByIndex(2);
		WebElement searchRoom = driver.findElement(By.id("Submit"));
		searchRoom.click();
		
		

	}
	@Test(dependsOnMethods="bookingPage")
	public void conformRoom() throws InterruptedException {
		WebElement clickButton = driver.findElement(By.id("radiobutton_0"));
		clickButton.click();
		WebElement clickContinue = driver.findElement(By.id("continue"));
		clickContinue.click();
		Thread.sleep(4000);

		
}
	@Test(dependsOnMethods="conformRoom")
	public void paymentPage() throws InterruptedException {
		WebElement firstName = driver.findElement(By.id("first_name"));

		 firstName.sendKeys("varun");
		 WebElement lastName = driver.findElement(By.id("last_name"));
		 lastName.sendKeys("row");
		 WebElement address = driver.findElement(By.id("address"));
		 address.sendKeys("Sunshine house "+"\n"+"chennai");
		 WebElement cardDetail = driver.findElement(By.id("cc_num"));
		 cardDetail.sendKeys("9876543234567890");
		 WebElement cardType = driver.findElement(By.id("cc_type"));
		 Select selectCardType = new Select(cardType);
		 selectCardType.selectByVisibleText("VISA");
		 WebElement SelectMonth = driver.findElement(By.id("cc_exp_month"));
		 Select selectMonth = new Select(SelectMonth );
		 selectMonth.selectByIndex(2);
		 WebElement selectYear = driver.findElement(By.id("cc_exp_year"));
		 Select selectYear1 = new Select(selectYear);
		 selectYear1.selectByIndex(3);
		 WebElement selectCvv = driver.findElement(By.id("cc_cvv"));
		 selectCvv.sendKeys("234");
		 
		 WebElement cliclBook= driver.findElement(By.id("book_now"));
		 cliclBook.click();
		 Thread.sleep(7000);
		 
		 WebElement ordernun = driver.findElement(By.name("order_no"));
		 String attribute = ordernun.getAttribute("value");
		 System.out.println(attribute);
		 driver.quit();
		 
		 
		 
		 
	}
	
}
