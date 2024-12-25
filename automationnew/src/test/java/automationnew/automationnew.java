package automationnew;

import org.apache.commons.io.FileUtils;

//import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class automationnew {
	WebDriver driver;
@BeforeTest
public void openbrowser(){
WebDriverManager.chromedriver().setup();
driver= new ChromeDriver();
driver.get("https://magento.softwaretestingboard.com/");
driver.manage().window().maximize();
}
@Test(priority = 1)
public void operation1() {
	 try {
         // Navigate to the desired URL

         // Scroll down the webpage
		 WebElement productitem=driver.findElement(By.xpath("//a[@href='https://magento.softwaretestingboard.com/radiant-tee.html']"));
         JavascriptExecutor js = (JavascriptExecutor) driver;
       //  for (int i = 0; i <= 100; i++) { // Scroll down multiple times
        	 Thread.sleep(2000);
             js.executeScript("arguments[0].scrollIntoView(true);",productitem);
             Thread.sleep(2000);
             WebElement addtocart=driver.findElement(By.xpath("(//button[@title='Add to Cart'])"));
            // addtocart.click();
             js.executeScript("arguments[0].click();", addtocart);
         	Thread.sleep(2000);
         	String expedctedurl="https://magento.softwaretestingboard.com/radiant-tee.html";
         	System.out.println(expedctedurl);
         	String actualurl=driver.getCurrentUrl().trim();
         	System.out.println(actualurl);
         	if(actualurl.equals(expedctedurl)) {
         		Assert.assertEquals(actualurl,expedctedurl);
         		WebElement size=driver.findElement(By.id("option-label-size-143-item-166"));
         		size.click();
         		Thread.sleep(2000);
         		WebElement colour=driver.findElement(By.id("option-label-color-93-item-56"));
         		colour.click();
         		Thread.sleep(2000);
         		// js.executeScript("arguments[0].scrollIntoView(true);",productitem);
         		// Thread.sleep(2000);
         		WebElement productdetailsaddtocart=driver.findElement(By.id("product-addtocart-button"));
         		productdetailsaddtocart.click();
         		Thread.sleep(2000);
         		WebElement scrollup=driver.findElement(By.xpath("//a[contains(text(),\"Sign In\")]"));
         		
         	//	JavascriptExecutor js = (JavascriptExecutor) driver;
         		js.executeScript("arguments[0].scrollIntoView(true);",scrollup);
         		Thread.sleep(3000);
         		
         	}else {
         		System.out.println("you are not current url");
         	}
            // Thread.sleep(1000); // Pause for content to load
       //  }
         	
     } catch (InterruptedException e) {
         e.printStackTrace();
     } 
}
@Test(priority = 2)
public void operation2() throws InterruptedException {
	
	WebElement cartcounter=driver.findElement(By.className("counter-number"));
    String cardcounter1=cartcounter.getText();
	System.out.println(cardcounter1);
	if((Integer.parseInt(cardcounter1))>0){
		System.out.println("product successfully added");
	}
	else {
		System.out.println("product not successfully added");
	}
}
@Test(priority=3)
public void operation3() throws InterruptedException {
Thread.sleep(2000);
//JavascriptExecutor js1 = (JavascriptExecutor) driver;

WebElement whatsnew=driver.findElement(By.xpath("//a/span[contains(text(),\"What's New\")]"));
//js1.executeScript("arguments[0].click();",whatsnew);
//whatsnew.click();
Actions act=new Actions(driver);
act.moveToElement(whatsnew);
act.click().build().perform();
Thread.sleep(2000);
WebElement product2=driver.findElement(By.xpath("//li[@class='product-item']/div[1]/a"));
/*JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("arguments[0].scrollIntoView(true);",product2);
product2.click();

WebElement addtocart2=driver.findElement(By.xpath("(//button[@title='Add to Cart'])"));
Thread.sleep(2000);
js.executeScript("arguments[0].scrollIntoView(true)",addtocart2);
addtocart2.click();
driver.navigate().refresh();
Thread.sleep(3000);
WebElement scrollup1=driver.findElement(By.xpath("//a[contains(text(),\"Sign In\")]"));
	
	//	JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("arguments[0].scrollIntoView(true);",scrollup1);
WebElement cartcounter2=driver.findElement(By.className("counter-number"));
String cardcounter3=cartcounter2.getText();
System.out.println(cardcounter3);
if((Integer.parseInt(cardcounter3))>0){
	System.out.println("product successfully added");
}
else {
	System.out.println("product not successfully added");
}*/
WebElement gear=driver.findElement(By.id("ui-id-6"));
WebElement watches=driver.findElement(By.id("ui-id-27"));
Actions act1=new Actions(driver);
act1.moveToElement(gear);
act1.click(watches).build().perform();
Thread.sleep(3000);
WebElement trdwatch=driver.findElement(By.xpath("//div[@class='products wrapper grid products-grid']/ol/li[3]/div/a"));
//trdwatch.click();
JavascriptExecutor js2 = (JavascriptExecutor) driver;
js2.executeScript("arguments[0].click();",trdwatch);
Thread.sleep(3000);
WebElement addtocart2=driver.findElement(By.xpath("(//button[@title='Add to Cart'])"));
addtocart2.click();
Thread.sleep(3000);
WebElement cartcounter4=driver.findElement(By.className("counter-number"));
String cardcounter5=cartcounter4.getText();
System.out.println(cardcounter5);
if((Integer.parseInt(cardcounter5))>1){
	System.out.println("product successfully added");
}
else {
	System.out.println("product not successfully added");
}

}
@Test(priority=4)
public void operation4() throws InterruptedException {
	Thread.sleep(2000);
	WebElement whatsnew=driver.findElement(By.xpath("//a/span[contains(text(),\"What's New\")]"));
	//WebElement watches=driver.findElement(By.id("ui-id-27"));
	
	Actions act1=new Actions(driver);
	act1.moveToElement(whatsnew);
	act1.click(whatsnew).build().perform();
	Thread.sleep(4000);
	WebElement t1=driver.findElement(By.xpath("//div[@class='products-grid grid']/ol/li[1]/div/a"));
	JavascriptExecutor js2 = (JavascriptExecutor) driver;
	js2.executeScript("arguments[0].click();",t1);
	Thread.sleep(3000);
	WebElement size=driver.findElement(By.id("option-label-size-143-item-167"));
		size.click();
		Thread.sleep(2000);
		WebElement colour=driver.findElement(By.id("option-label-color-93-item-56"));
		colour.click();
		Thread.sleep(2000);
	WebElement addtocart2=driver.findElement(By.xpath("(//button[@title='Add to Cart'])"));
	addtocart2.click();
	Thread.sleep(3000);
	WebElement cartcounter5=driver.findElement(By.className("counter-number"));
	String cardcounter6=cartcounter5.getText();
	System.out.println(cardcounter6);
	if((Integer.parseInt(cardcounter6))>2){
		System.out.println("product successfully added");
	}
	else {
		System.out.println("product not successfully added");
	}
	
}
@Test(enabled=false)
public void operation5mycart() throws InterruptedException, IOException {
	Thread.sleep(2000);
	WebElement women=driver.findElement(By.xpath("//*[contains(text(),\"Women\")]"));
	Actions act1=new Actions(driver);
	act1.moveToElement(women);
	//act1.click(mycart).build().perform();
	//mycart.click();
	Thread.sleep(2000);
	WebElement buttoms=driver.findElement(By.xpath("//*[contains(text(),\"Bottoms\")]"));
	act1.moveToElement(buttoms);
	WebElement Shorts=driver.findElement(By.xpath("//*[contains(text(),\"Shorts\")]"));
	act1.moveToElement(Shorts);
	act1.click(Shorts).build().perform();
	//WebElement editcart=driver.findElement(By.xpath("//*[contains(text(),\"View and Edit Cart\")]")); 
	//editcart.click();
	Thread.sleep(3000);
	WebElement sorter=driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[2]/div/a/span/span/img"));
	//act1.moveToElement(sorter);
	Thread.sleep(2000);
	JavascriptExecutor js2 = (JavascriptExecutor) driver;
	js2.executeScript("arguments[0].click();",sorter);
	Thread.sleep(3000);
	WebElement size=driver.findElement(By.id("option-label-size-143-item-171"));
	size.click();
	Thread.sleep(2000);
	WebElement colour=driver.findElement(By.id("option-label-color-93-item-50"));
	colour.click();
	Thread.sleep(2000);
	WebElement addtocart3=driver.findElement(By.xpath("(//button[@title='Add to Cart'])"));
	addtocart3.click();
	
	Thread.sleep(3000);
}
@Test(priority=5)
public void operation5() throws InterruptedException, IOException {
	WebElement mycart=driver.findElement(By.xpath("//a[@href=\"https://magento.softwaretestingboard.com/checkout/cart/\"]"));
	Actions act1=new Actions(driver);
	act1.moveToElement(mycart);
	act1.click(mycart).build().perform();
	Thread.sleep(3000);
	WebElement viewandcart=driver.findElement(By.xpath("//*[contains(text(),\"View and Edit Cart\")]"));
	viewandcart.click();
	
	TakesScreenshot screenshot= (TakesScreenshot)driver;
	File sourcefile=screenshot.getScreenshotAs(OutputType.FILE);
	File destfile=new File("C:\\Screenshot\\image1.jpg");
	//FileUtils.copyFile(sourcefile, new File("./Screenshots/Image1.png"));
	FileUtils.copyFile(sourcefile, destfile);
	
	
	/*List<WebElement>items=driver.findElements(By.className("item-info"));
	//int itemsize=items.getSize();
	for() {
		
	}*/
	Thread.sleep(3000);
	WebElement table=driver.findElement(By.xpath("//table[@id='shopping-cart-table']/thead/tr/th"));
	String table1=table.getText();
	System.out.println(table1);
}
@AfterClass
public void close() {
	
}
}
