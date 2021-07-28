package seleniumbasics1;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class amazonproject 
{

	public static void main(String[] args) throws InterruptedException
	{
		
	 //BROWSER INITIATION
		System.setProperty("webdriver.chrome.driver", "C:\\selenium webdriver\\chromedriver\\chromedriver_win32//chromedriver.exe");
	    WebDriver driver=new ChromeDriver();
	    driver.get("https://www.amazon.in/");
	    driver.manage().window().maximize(); 
	    
	 // GET URL
	    driver.getCurrentUrl();
	    System.out.println("Current URL IS:" + driver.getCurrentUrl());

	  //SCROLLBAR
	  		JavascriptExecutor js=(JavascriptExecutor)driver;
	  		  js.executeScript("window.scrollBy(0,5000)");                   //for scrolling down
	  		  System.out.println("scrolled down");
	  			Thread.sleep(2000);
	  		
	  		  JavascriptExecutor js1=(JavascriptExecutor)driver;
	  		  js1.executeScript("window.scrollBy(0,-3000)");                  //for scrolling up
	  		  System.out.println("scrolled up");
	  		  Thread.sleep(2000); 
	  		  
	  //NAVIGATE BACK AND FORWARD
			  driver.navigate().back();                                       //navigating back
				System.out.println("navigated back");                 
				Thread.sleep(2000);
				driver.navigate().forward();
				System.out.println("navigated forward");                     //navigating front
				Thread.sleep(2000);
	    

	    //TITLE LENGTH		 
		String title = driver.getTitle();    // Storing Title name in the String variable 
		int titleLength = driver.getTitle().length(); // Storing Title length in the Int variable  
		System.out.println("Title of the page is : " + title);   
		System.out.println("Length of the title is : "+ titleLength);  
		  Thread.sleep(2000);
		
		//TITLE CHECK
		    String expectedtitle="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		    String actualtitle="";
		    actualtitle=driver.getTitle();
		    System.out.println(actualtitle);
		    if(actualtitle.contentEquals(expectedtitle))
		    {
		    	System.out.println("Test passed");
		    }
		    else
		    {
		    	System.out.println("Test failed");
		    }
		 System.out.println("title is checked");
		  Thread.sleep(2000);
		  
	   //IMAGE CLICK
		  driver.findElement(By.id("nav-logo-sprites")).click();
	      System.out.println("image is clicked");
	      Thread.sleep(2000);
	      
	  //MOUSEOVER
	    WebElement element=driver.findElement(By.xpath("//header/div[@id='navbar']/div[@id='nav-belt']/div[3]/div[1]/a[1]/span[1]"));
		Actions builder=new Actions(driver);
		builder.moveToElement(element).build().perform();
		element.click();
		Thread.sleep(2000);

	 //RADIO BUTTON
	   WebElement radio= driver.findElement(By.xpath("//body/div[@id='a-page']/div[@id='customer-preferences']/div[1]/div[1]/form[1]/div[1]/div[1]/div[3]/div[1]/label[1]/i[1]"));
	   radio.click();
	   System.out.println(radio.isSelected());
	   Thread.sleep(2000);
	   driver.findElement(By.xpath("//a[@id='icp-btn-close-announce']")).click();
	    
	  //DROP DOWN
	    Select drplist =new Select(driver.findElement(By.id("searchDropdownBox")));
	    drplist.selectByValue("search-alias=electronics"); //from dropdown electronics is selected
	    Thread.sleep(2000);
	    
	  //SEARCH
	    driver.findElement(By.name("field-keywords")).sendKeys("boat stone 190f 5w bluetooth speaker");
	    driver.findElement(By.id("nav-search-submit-button")).click();
	    Thread.sleep(2000);
	    
	   //CHECK BOX
	    driver.findElement(By.xpath("//*[@id=\"p_89/boAt\"]/span/a/div/label/i")).click();
	    driver.findElement(By.xpath(" //*[@id=\"p_n_is_cod_eligible/4931671031\"]/span/a/div/label/i")).click();
	    Thread.sleep(2000);
	    
	  
	   //FETCHING THE PRODUCT
	    driver.findElement(By.className("s-image")).click();
	    Thread.sleep(2000);
	    String mainwindow=driver.getWindowHandle();
	  		Set<String> s1= driver.getWindowHandles();
	  		Iterator<String>i1=s1.iterator();
	  		while(i1.hasNext())
	  		{
	  		               String childwindow=i1.next();
	  		               if(! mainwindow.equalsIgnoreCase(childwindow))
	  		               {
	  		            	   driver.switchTo().window(childwindow);
	  		            	   
	  		            	   
	  		            	//SELECTING QUANTITY
	  		            	   Select drplist1=new Select(driver.findElement(By.id("quantity")));
	  		           			drplist1.selectByValue("2");
	  		           		    Thread.sleep(2000);
	  		           		   
	  		            	
	  		            // FETCHING WARRANTY DETAILS
	  		            WebElement warranty=driver.findElement(By.xpath("//a[contains(text(),'1 Year Warranty')]"));
	  		            warranty.click();
	  		          System.out.println(warranty.getText()) ;
	  		         	   
	  		      		//ADDING ITEMS TO CART
	  		            	   driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click(); 
	  		            	   Thread.sleep(2000);
	  		               }
	  		}
	  		
	  			
	  //VIEWING CART
	  	      driver.findElement(By.linkText("Cart")).click();
	  	    Thread.sleep(2000);
	
	  //REFRESH
		 driver.navigate().refresh();
		 Thread.sleep(2000);
		 
	  //DOWNLOAD THE APP
		 driver.findElement(By.xpath("//header/div[@id='navbar']/div[@id='nav-main']/div[3]/div[1]/div[1]/a[1]")).click();
		 driver.findElement(By.xpath("//input[@id='mgt-email-sms-input']")).sendKeys("flipkartdemo99@gmail.com");
		 driver.findElement(By.className("a-button-input")).click();
		 System.out.println("download link is accessed");
		 Thread.sleep(2000);
		
	  //CLOSE		
		driver.close();
		 Thread.sleep(2000);
		 System.out.println("Page is closed"); //current page is closed
		 
	   //QUIT
		driver.quit();          //all the pages are closed
		Thread.sleep(2000);
	  
	    
	    
		
		
		
		
		
	}

}
