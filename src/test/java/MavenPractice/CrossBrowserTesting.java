package MavenPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTesting {
	WebDriver driver;

	/**
	 * This function will execute before each Test tag in testng.xml
	 * @param browser
	 * @throws Exception
	 */
	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) throws Exception{
		//Check if parameter passed from TestNG is 'firefox'
		if(browser.equals("firefox")){
			//create firefox instance
			System.setProperty("webdriver.gecko.driver","/Users/gurleen/Documents/SeleniumJars/geckodriver");
			driver = new FirefoxDriver();
		}
		//Check if parameter passed as 'chrome'
		else if(browser.equals("chrome")){
			//set path to chromedriver.exe
			System.setProperty("webdriver.chrome.driver","/Users/gurleen/Documents/SeleniumJars/chromedriver");
			//create chrome instance
			driver = new ChromeDriver();
		}

		else{
			//If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void fbLogin(){


		driver.get("https://auth.scotiaonline.scotiabank.com/online?oauth_key=bHaac3VHIaI&oauth_key_signature=eyJraWQiOiJrUFVqdlNhT25GWUVDakpjMmV1MXJvNGxnb2VFeXJJb2tCbU1oX3BiZXNVIiwidHlwIjoiSldUIiwiYWxnIjoiUlMyNTYifQ.eyJyZWZlcmVyIjoiaHR0cHM6XC9cL3d3dy5zY290aWFiYW5rLmNvbVwvIiwib2F1dGhfa2V5IjoiYkhhYWMzVkhJYUkiLCJjb25zZW50X3JlcXVpcmVkIjpmYWxzZSwicmVkaXJlY3RfdXJpIjoiaHR0cHM6XC9cL3d3dy5zY290aWFvbmxpbmUuc2NvdGlhYmFuay5jb21cL29ubGluZVwvbGFuZGluZ1wvb2F1dGhsYW5kaW5nLmJucyIsImV4cCI6MTYzMDI2OTUwNiwiaWF0IjoxNjMwMjY4MzA2LCJqdGkiOiI4ZmJhMThlMS05OTY0LTRlODgtODcwNS00OTJjMWVhMWJkZTAiLCJjbGllbnRfaWQiOiI4ZWU5MGMzOS0xYzUyLTRmZjQtOGFlNi1hN2I1NGM1Mzk5MzMiLCJjbGllbnRfbWV0YWRhdGEiOnsiQ2hhbm5lbElEIjoiU09MIiwiQXBwbGljYXRpb25Db2RlIjoiSDcifSwiaXNzdWVyIjoiaHR0cHM6XC9cL3Bhc3Nwb3J0LnNjb3RpYWJhbmsuY29tIn0.sSF5SVtKeBVH0jRtFO4Wbz5Gid8lVF58mJBUgJnsHrWjdSZ_ABR9Kq8seHDlqSAHMxkIxPVKot9An6cpGofW8zdqogO0YxhQD1WAVjh9QT6ZghPvkDaJf0uQgWtrJdlwBTc_70wNsuNa1jDeQadsGP7egSm7WqqYuJXl3z1NOBeGanzRO213sCmdaKUQJP5Mg2mAY_rRcUuy7KhwzADBYhxdn0-L7noW3wB-ObgTSg_s6rNNcpVoQ_Ap-yEcyXbDvofCNdsF01rVZiXlm2tNrYOwCCilxdz9_xpuuFeTLMf3yDs6-ZKMy4vECn6p3CmIs1sIAsRE9hW-Ku6mJg4jtQ&preferred_environment=");



		driver.findElement(By.id("usernameInput-input")).sendKeys("abghty765l");

		driver.findElement(By.id("password-input")).sendKeys("gtydf567");

		driver.findElement(By.id("signIn")).click();


		String expectedErr = "Please check your card number / username or password and try again.";

		String actualErr = driver.findElement(By.id("globalError")).getText();
		System.out.println(actualErr);
		Assert.assertEquals(expectedErr, actualErr);

		driver.quit();
	}
}


