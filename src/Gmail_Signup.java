import java.util.Arrays;
import java.util.Random;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


public class Gmail_Signup {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", s
				+ "\\Chrome090615\\chromedriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability("chrome.switches", Arrays.asList("--incognito"));
		ChromeDriver driver = new ChromeDriver(capabilities);
		
		try{
			driver.manage().window().maximize();
		driver.get("https://accounts.google.com/SignUp");
		Thread.sleep(2000);
		Random rn=new Random();
		int n=rn.nextInt(20)+5;
		int month=rn.nextInt(12)+1;
		System.out.println("Random num :"+n+"\n month "+month);
		Thread.sleep(2000);
		driver.findElementByXPath("//*[@id='FirstName']").sendKeys("inx");
		Thread.sleep(2000);
		driver.findElementByXPath("//*[@id='LastName']").sendKeys("tst"+n);
		Thread.sleep(2000);
		driver.findElementByXPath("//*[@id='GmailAddress']").sendKeys("inxtst"+n);
		Thread.sleep(2000);
		driver.findElementByXPath("//*[@id='Passwd']").sendKeys("mail@001");
		Thread.sleep(2000);
		driver.findElementByXPath("//*[@id='PasswdAgain']").sendKeys("mail@001");
		Thread.sleep(2000);
		driver.findElementByXPath("//*[@id='BirthMonth']").click();
				
		Thread.sleep(1000);
		System.out.println("after 1 sec");
		driver.findElementByXPath("//*[@id=':"+month+"']").click();
		Thread.sleep(1000);
		driver.findElementByXPath("//*[@id='BirthDay']").sendKeys("01");
		Thread.sleep(2000);
		driver.findElementByXPath("//*[@id='BirthYear']").sendKeys("1990");
		Thread.sleep(2000);
		driver.findElementByXPath("//*[@id='Gender']").click();
		Thread.sleep(500);
		driver.findElementByXPath("//*[@id=':f']/div").click();
		Thread.sleep(4000);
		driver.findElementByXPath("//*[@id='RecoveryPhoneNumber']").sendKeys("9925020415");
		System.out.println("Wating for 5 secs");
		Thread.sleep(8000);
		driver.findElementByXPath("//*[@id='TermsOfService']").click();
		/*Thread.sleep(500);
		driver.findElementById("submitbutton").click();
		
		Thread.sleep(15000);
		System.out.println("After 15 secs");
		String s1=driver.findElementByXPath("//*[@id='gb']/div[1]/div[1]/div/div[4]/div[1]/a").getText();
		System.out.println(s1);*/
		 
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
