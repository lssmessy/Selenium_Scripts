import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Way2SMS_Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", s
				+ "\\Chrome090615\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		/*
		 * ProfilesIni prof=new ProfilesIni(); FirefoxProfile
		 * profile=prof.getProfile("Selenium"); FirefoxDriver driver=new
		 * FirefoxDriver(profile);
		 */
		try {
			// Maximize the browser window
			driver.manage().window().maximize();
			// Open this url in browser
			driver.get("http://site21.way2sms.com/content/index.html");
			// Implitcit timeout for the element to be displayed
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			// Find the elements from the page
			driver.findElementByXPath("//*[@id='username']").sendKeys(
					Credentials.way2_username);
			driver.findElementByXPath("//*[@id='password']").sendKeys(
					Credentials.way2_password);
			driver.findElementByXPath("//*[@id='loginBTN']").click();

			System.out.println("Waiting for 5 secs");
			// Explicitly wait till element is displayed
			WebElement we = (new WebDriverWait(driver, 5))
					.until(ExpectedConditions.elementToBeClickable(By
							.id("ebFrm")));
			System.out.println(we.isDisplayed());
			if (we.isDisplayed() == true) {

				Thread.sleep(3000);
				driver.findElementByXPath(
						"//*[@id='ebFrm']/div[2]/div[1]/input").click();
				System.out.println("WE cliekded");
			} else {
				System.out.println("Not found");
				new WebDriverWait(driver, 5).until(ExpectedConditions
						.elementToBeClickable(By.id("ebFrm")));
			}
			// Find the elements from the page
			driver.findElementByXPath("//*[@id='sendSMS']/a").click();
			System.out.println("Send sms option Clicked ");
			//Switch the frame as we cant find the requested web element in current frame
			driver.switchTo().frame(
					driver.findElementByXPath("//*[@id='frame']"));
			//create any where whom you want to send the messages
			String numbers[] = { "8469212091", "9426576315" };// /{"8866685998","9998004440"};
			//Generate random numbers 
			Random rn = new Random();
			for (int i = 0; i < numbers.length; i++) {
				//find the web element
				WebElement mb = driver.findElement(By.id("mobile"));
				boolean disp = mb.isDisplayed();
				//Add the ith element to the textfield
				mb.sendKeys(numbers[i]);
				int num = rn.nextInt(4) + 1;
				int cat = rn.nextInt(35) + 1;
				Thread.sleep(3000);
				//Actions to be performed like mousehover
				//Define the object of the Actions class and then find the web element and move mouser cursor to that point
				
				Actions sel = new Actions(driver);
				WebElement wb = driver
						.findElement(By
								.xpath("//*[@id='sndSMSSection']/div/div[2]/div[1]/div[1]"));
				sel.moveToElement(wb)
						.moveToElement(driver.findElementByXPath("//*[@id='smsCats']/li["+cat +"]")).click().perform();

				System.out.println("+================\n Clicked category => " + wb.getText());
				driver.findElementByXPath(
						"//*[@id='smsGreetsPaging']/ol/li[" + num + "]")
						.click();
				System.out.println("clicked option numbers :" + num+"\n");
				Thread.sleep(4000);
				WebElement cs = driver.findElementByXPath("//*[@id='greet"
						+ num + "']");
				System.out.println(cs.getText() + "\n");
				driver.findElementByXPath("//*[@id='greet" + num + "']")
						.click();
				driver.findElementByXPath("//*[@id='Send']").click();
				System.out.println("Message sent to " + numbers[i]+"\n================");
				Thread.sleep(2000);
				driver.findElementByXPath("/html/body/form/div[1]/div/p[1]")
						.click();
				Thread.sleep(3000);
			}

			/*
			 * String tk
			 * =driver.findElement(By.id("Token")).getAttribute("value");
			 * System.out.println(tk);
			 */

			/*
			 * WebElement mo=(new WebDriverWait(driver,
			 * 15)).until(ExpectedConditions
			 * .elementToBeClickable(By.cssSelector("#mobile")));
			 * System.out.println("after 15 secs"); boolean
			 * dis=mo.isDisplayed(); System.out.println(dis);
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
