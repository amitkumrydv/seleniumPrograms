package com.selenium.logic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CSSselector {

	public static void main(String[] args) {


		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com");
		
		
//		Tag id
		
//	driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("test");
		
	}

}
