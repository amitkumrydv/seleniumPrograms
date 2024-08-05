package com.selenium.dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticeXpath {

	public static void main(String[] args) {
		
WebDriverManager.chromedriver().setup();
		
		
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://studentzone-ngasce.nmims.edu/authenticate/loginAsForm");
		
		WebElement user = driver.findElement(By.xpath("//input[@name='username']/parent::form"));
		WebElement pwd = driver.findElement(By.xpath("//input[@name='password']/parent::form"));
		
		user.clear();
		user.sendKeys("77118148950");
		
		pwd.clear();
		pwd.sendKeys("admin@ncdoe2023");
		
		

	}

}
