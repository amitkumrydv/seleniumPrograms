package com.selenium.logic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePickerByJavascriptExecuter {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		// System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
		
	      try {
			driver = new ChromeDriver();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.get("https://www.spicejet.com/");
		
		
		WebElement datePickerElement = driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-18u37iz']//div[@class='css-1dbjc4n r-14lw9ot r-11u4nky r-z2wwpe r-1phboty r-rs99b7 r-1loqt21 r-13awgt0 r-ymttw5 r-5njf8e r-1otgn73']//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep']"));
		
		
		
		datePickerElement.click();		
		
		String date="Sun, 30 Jun 2024";
		
		enterDate(datePickerElement,date);
		

	}
	
	public static void enterDate(WebElement element, String date) {
		 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[].setAttribute('value''"+date+"')", element);
		
		
	}
	
	
	
	
	

}
