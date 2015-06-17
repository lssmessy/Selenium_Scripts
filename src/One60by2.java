import java.io.File;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class One60by2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Test message
		// TODO Auto-generated method stub
		/*String s=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", s+"\\Chrome090615\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();*/
		/*
		 * Using below code you can change the profile of firefox browser.
		to do that first go to run > firefox.exe -P > Set any profile existing or new one 
		and then give the name in getProfile method shown below.
		that's it . and you are done
*/		
		try{
		ProfilesIni prof=new ProfilesIni();
		FirefoxProfile profile=prof.getProfile("Selenium");
		/*String firebug="C:\\Users\\pritesh.patel\\AppData\\Local\\Temp\\anonymous1726063930120484385webdriver-profile\\extensions\\firebug@software.joehewitt.com.xpi";
		profile.addExtension(new File(firebug));*/
		FirefoxDriver driver=new FirefoxDriver(profile);//This script is working on firefox only
		
		
			//Maximize the window of browser
			driver.manage().window().maximize();
			//get the url and display on browser
			driver.get("http://www.160by2.com/Index");
			//Enter the credentials
			driver.findElement(By.id("username")).sendKeys(Credentials.username);
			driver.findElement(By.id("password")).sendKeys(Credentials.password);
			//sleep for the specified time
			Thread.sleep(2000);
			//click on login button
			driver.findElementByXPath("//*[@id='loginform']/div/section/div/div[1]/div[3]/div[3]/button").click();
			System.out.println("logged in");
			String number[]={"8469212091","9426576315"};
			
			//generate the random numbers
			Random rn=new Random();
			int num=rn.nextInt(5)+1;
			int num2=rn.nextInt(5)+1;
			int num3=rn.nextInt(50)+1;
			System.out.println("Random number is "+num);
			//Switch the frames as the webelement which we require isn't in defauld frame
			driver.switchTo().frame(driver.findElementByXPath("//*[@id='by2Frame']"));
			//Check whether element is displayed or not
			boolean dep=driver.findElementByClassName("da-sms-btn").isDisplayed();
			System.out.println(dep);
			driver.findElementByClassName("da-sms-btn").click();
			System.out.println("button cliecked");
			
			for(int i=0; i<number.length; i++) //Loop through the number of elements
			{
				
			//Explicitly wait for the given seconds till expected conditions met 
			(new WebDriverWait(driver, 3)).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/div/div[3]/div[1]/div[1]/div[1]/p[2]/input")));
			//Write the first element of array numbers
			driver.findElementByXPath("/html/body/form/div/div[3]/div[1]/div[1]/div[1]/p[2]/input").sendKeys(number[i]);
			
			Thread.sleep(3000);
			System.out.println("After 3 secs ");
			// Drop down click
			driver.findElement(By.xpath("/html/body/form/div/div[3]/div[2]/div/div[2]/div[2]/div[1]/select")).click();
			Thread.sleep(2000);
			System.out.println("After 2 secs dropdown clicked");
			// Select any option from dropdown
			driver.findElement(By.xpath("/html/body/form/div/div[3]/div[2]/div/div[2]/div[2]/div[1]/select/option["+num3+"]")).click();
			Thread.sleep(1000);
			System.out.println("After 1 secs random category");
			//Selected category name
			String category=driver.findElement(By.xpath("/html/body/form/div/div[3]/div[2]/div/div[2]/div[2]/div[1]/select/option["+num3+"]")).getText();
			System.out.println(category+"\n");
						 
			Thread.sleep(1000);
			System.out.println("After 1 secs ");
			//Click any link from 1-5 given in box
			driver.findElementByXPath("/html/body/form/div/div[3]/div[2]/div/div[2]/div[2]/div[2]/ul/li["+num2+"]/a").click();
			//Wait till text gets displayed
			(new WebDriverWait(driver, 3)).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/div/div[3]/div[2]/div/div[2]/div[2]/div[1]/ul/li["+num+"]/a")));
			//Click on any random thought
			Thread.sleep(2000);
			System.out.println("After 2 secs random message clicked");
			driver.findElementByXPath("/html/body/form/div/div[3]/div[2]/div/div[2]/div[2]/div[1]/ul/li["+num+"]/a").click();
			//Get the text of random number
			String text=driver.findElementByXPath("/html/body/form/div/div[3]/div[2]/div/div[2]/div[2]/div[1]/ul/li["+num+"]/a").getText();
			
			Thread.sleep(2000);
			System.out.println("After 2 secs send button clicked");
			//Click on send button 
			driver.findElementByXPath("/html/body/form/div/div[3]/div[1]/input[1]").click();
			System.out.println("Message sent to"+number[i]+" \n");
			System.out.println(text+"\n==========");
			Thread.sleep(4000);
			System.out.println("After 4 secs ");
			//Switch to the default iframe as new element is not in selected frame
			driver.switchTo().defaultContent();
			//Click on sendSMS from menubar
			driver.findElementByXPath("/html/body/div[4]/nav/ul/li[2]/ul/li[1]/a").click();
			Thread.sleep(2000);
			System.out.println("After 2 secs ");
			//Switch iframe as we have to repeat the operation till the for loop gets completed
			driver.switchTo().frame(driver.findElementByXPath("//*[@id='by2Frame']"));
			
			}
			System.out.println("\n=====\n Sent to all numbers");
		}catch(Exception e){
			
		}
	}

}
