package newpackage;


import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class JavaToDo {
    String username = "thomasrajan.sundararaj";
    String accesskey = "Q2sBxjEhToyRf4TtXxcUPbUR6EiyIrZQ6dGCDiFS0HJ2fte6Ei";
    static RemoteWebDriver driver = null;
    String gridURL = "@hub.lambdatest.com/wd/hub";
    boolean status = false;
    //public static void main(String[] args) {
     //   new JavaToDo().test();
    //}
    @Parameters("browser")
    @BeforeTest
  public void launchbrowser(String browser) {
    	setUp(browser);
    }
    
    @Test
    public void testing2() {
    	// Open LambdaTest’s Selenium Playground from
    driver.get("https://www.lambdatest.com/selenium-playground/");
    // Click “Simple Form Demo” under Input Forms.

	driver.findElement(By.linkText("Simple Form Demo")).click();
	
	// Validate that the URL contains “simple-form-demo”.
	System.out.println(" url opened is" +driver.getCurrentUrl());
	String expectedUrl = driver.getCurrentUrl();
	try {
    if (expectedUrl.equals("https://www.lambdatest.com/selenium-playground/simple-form-demo")) {
        status = true;
        System.out.println(" entered and received url status is matching" + status);
    }
} catch (Exception e) {
    System.out.println(e.getMessage());
    
    }
	//Create a variable for a string value E.g: “Welcome to LambdaTest”
	String enteredtext = "Welcome to LambdaTest";
	// Use this variable to enter values in the “Enter Message” text box
	WebElement inputbox = driver.findElement(By.cssSelector("input#user-message"));
	WebElement inputboxwait = new WebDriverWait(driver, Duration.ofSeconds(20))
    	    .until(ExpectedConditions.elementToBeClickable(inputbox));
    inputbox.sendKeys(enteredtext);
    //Click “Get Checked Value”
    driver.findElement(By.id("showInput")).click();
    //Validate whether the same text message is displayed in the right-hand panel under the “Your Message:” section
   String s=  driver.findElement(By.id("message")).getText();
    System.out.println("Value displayed is "+ s);
    
    try {
        if (s.equals("Welcome to LambdaTest")) {
            status = true;
            System.out.println(" received text is matching" + status);
        }
    } catch (Exception e) {
        System.out.println(e.getMessage());
        
        }
    }
    @Test
    public void testing3() {
    	
    	//Open the https://www.lambdatest.com/selenium-playground page and click “Drag & Drop Sliders” under “Progress Bars & Sliders”.

    	driver.get("https://www.lambdatest.com/selenium-playground/");
        WebElement draglink = driver.findElement(By.linkText("Drag & Drop Sliders"));
        WebElement dragwait = new WebDriverWait(driver, Duration.ofSeconds(20))
        		.until(ExpectedConditions.elementToBeClickable(draglink));
        driver.findElement(By.linkText("Drag & Drop Sliders")).click();
        // Select the slider “Default value 15” and drag the bar to make it 95 by validating whether the range value shows 95.

        WebElement slider = driver.findElement(By.xpath("//*[@id='slider3']/div/input"));
        new Actions(driver).dragAndDropBy(slider, 101, 0).perform();
        String s1= driver.findElement(By.id("rangeSuccess")).getText();
        System.out.println(s1);
        
    }
    
   
    @Test
    public void testing4() {
    	
    	//Open the https://www.lambdatest.com/selenium-playground page and click “Input Form Submit” under “Input Forms”.
    	driver.get("https://www.lambdatest.com/selenium-playground/");
    	WebElement formlink = driver.findElement(By.linkText("Input Form Submit"));
    	WebElement linktextclickwait = new WebDriverWait(driver, Duration.ofSeconds(20))
    			.until(ExpectedConditions.elementToBeClickable(formlink));
    			
		formlink.click();
		// click on submit button
		WebElement Submit = driver.findElement(By.xpath("//*[@id='seleniumform']/div[6]/button"));
		WebElement Submitwait = new WebDriverWait(driver, Duration.ofSeconds(20))
    			.until(ExpectedConditions.elementToBeClickable(Submit));
		Submit.click();
		// Input the values		
		driver.findElement(By.id("name")).sendKeys("test");
		driver.findElement(By.id("inputEmail4")).sendKeys("abc@xyz.com");
		driver.findElement(By.name("password")).sendKeys("abc1234");
		driver.findElement(By.id("company")).sendKeys("Lambda");
		driver.findElement(By.id("websitename")).sendKeys("www.google.com");
		Select dropdownselect = new Select (driver.findElement(By.name("country")));
		dropdownselect.selectByVisibleText("United States");
		driver.findElement(By.id("inputCity")).sendKeys("Woodland Hills");
        driver.findElement(By.id("inputAddress1")).sendKeys("2345 Weby way Street");
        driver.findElement(By.id("inputAddress2")).sendKeys("A123");
        driver.findElement(By.id("inputState")).sendKeys("CA");
        driver.findElement(By.id("inputZip")).sendKeys("91307");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
               
      // click on submit button
        driver.findElement(By.xpath("//*[@id='seleniumform']/div[6]/button")).click();
        // get the confirmation text
        String s3 = driver.findElement(By.xpath("//*[@class='container']/div/div[2]/div/p")).getText();
        System.out.println(s3);
        try {
            if (s3.equals("Thanks for contacting us, we will get back to you shortly.")) {
                status = true;
                System.out.println(" Received text is matching  " + status);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            
            }
    }
    
    private void setUp(String browser) {
    	
    	 if (browser.equalsIgnoreCase("chrome")) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("version", "88.0");
        capabilities.setCapability("platform", "win10"); // If this cap isn't specified, it will just get any available one.
        capabilities.setCapability("build", "LambdaTestSampleApp");
        capabilities.setCapability("name", "LambdaTestJavaSample");
        try {
            driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
        } catch (MalformedURLException e) {
            System.out.println("Invalid grid URL");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    	 
    	 }else if (browser.equalsIgnoreCase("Firefox")) {
        
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("browserName", "Firefox");
            capabilities.setCapability("version", "82.0");
            capabilities.setCapability("platform", "win7"); // If this cap isn't specified, it will just get any available one.
            capabilities.setCapability("build", "LambdaTestSampleApp");
            capabilities.setCapability("name", "LambdaTestJavaSample");
            try {
                driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
            } catch (MalformedURLException e) {
                System.out.println("Invalid grid URL");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            
    	 }else if (browser.equalsIgnoreCase("MicrosoftEdge")) {
                
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("browserName", "MicrosoftEdge");
                capabilities.setCapability("version", "87.0");
                capabilities.setCapability("platform", "macOS Sierra"); // If this cap isn't specified, it will just get any available one.
                capabilities.setCapability("build", "LambdaTestSampleApp");
                capabilities.setCapability("name", "LambdaTestJavaSample");
                try {
                    driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
                } catch (MalformedURLException e) {
                    System.out.println("Invalid grid URL");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
    	 }else if (browser.equalsIgnoreCase("Internet Explorer")) {
                    
                    DesiredCapabilities capabilities = new DesiredCapabilities();
                    capabilities.setCapability("browserName", "Internet Explorer");
                    capabilities.setCapability("version", "11.0");
                    capabilities.setCapability("platform", "win10"); // If this cap isn't specified, it will just get any available one.
                    capabilities.setCapability("build", "LambdaTestSampleApp");
                    capabilities.setCapability("name", "LambdaTestJavaSample");
                    try {
                        driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
                    } catch (MalformedURLException e) {
                        System.out.println("Invalid grid URL");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
    	 }else {
             throw new IllegalArgumentException("The Browser Type is Undefined");
         }
        
    			 
    }
    
    @AfterSuite
    private void tearDown() {
        if (driver != null) {
            ((JavascriptExecutor) driver).executeScript("lambda-status=" + status);
            driver.close(); //really important statement for preventing your test execution from a timeout.
        }
    }
}