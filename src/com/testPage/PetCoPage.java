package com.testPage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.utilities.WrapperClass;

public class PetCoPage extends WrapperClass {

	WebDriver driver;
	String sheetName="petCo";
 
	public PetCoPage(WebDriver driver) {
		this.driver = driver;

	}

	public void fishAndFood() throws InterruptedException {
		Thread.sleep(2000);
		Actions action = new Actions(driver);

		action.moveToElement(driver.findElement(By.xpath("//*[@id='shop-by-pet']"))).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Fish")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Fish Food")).click();
		Thread.sleep(1000);
		driver.findElement(By.partialLinkText("Frozen Fish Food")).click();
	}
	
	public void sortAndName() throws InterruptedException {
		Select select = new Select( driver.findElement(By.id("product-listing-sort-by_4_3074457345618259661_4099276460824412685")));
		select.selectByValue("1");
		Thread.sleep(2000);
		
		String nameOfSecodProduct=driver.findElement(By.linkText("Gamma Frozen Food Mysis Shrimp Blister Pack Fish Food")).getText();
		System.out.println("name of the second product after sortung A to Z :::::::::::::"+nameOfSecodProduct);
		String price= driver.findElement(By.xpath("//span[contains(text(),'$27.19')]")).getText();
		System.out.println("price of the product ::::::::::::::::::::::::"+price);
		
		
	}
	public void priceSort() throws InterruptedException {
		driver.findElement(By.xpath("//span[contains(text(),'$25 to $50')]")).click();
		Thread.sleep(2000);
		
	}
	public void writeExcel() throws IOException {
		String value=driver.findElement(By.linkText("Gamma Frozen Food Bloodworm Blister Pack")).getText();
		ExcelWrite ew= new ExcelWrite();
		ew.putCellValue(sheetName, value);
		
		
	}
	

}
