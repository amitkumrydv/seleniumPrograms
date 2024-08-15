package com.selenium.logic;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class TicketBooking {
	
	
	
	
	
	

	public static void main(String[] args) throws IOException, TesseractException, InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		
		
		driver.get("https://www.irctc.co.in/nget/train-search");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	
		
		WebElement login =driver.findElement(By.xpath("//a[normalize-space()='LOGIN']"));
		
		login.click();
		
		WebElement user =driver.findElement(By.xpath("//input[@placeholder='User Name']"));
		
		wait.until(ExpectedConditions.elementToBeClickable(user));
		
		user.clear();
		user.click();
		user.sendKeys("Enter Your UserName");
		
		
WebElement pwd =driver.findElement(By.xpath("//input[@placeholder='Password']"));
		
wait.until(ExpectedConditions.elementToBeClickable(pwd));
		pwd.clear();
		pwd.click();
		pwd.sendKeys("Enter your password");
		
		
		WebElement capture =driver.findElement(By.xpath("//img[@class='captcha-img']"));
		
		File capturImage =capture.getScreenshotAs(OutputType.FILE);
		
		
		File target=new File(System.getProperty("user.dir") + "/Screenshots/SHOT.png" );
		
		FileUtils.copyFile(capturImage, target);
		
	//	Download https://github.com/UB-Mannheim/tesseract/wiki
		
		Tesseract tesseract = new Tesseract();
		
		tesseract.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata" );
		
	//	tesseract.setDatapath(System.getProperty("D:\\Sowftware\\TesserApp\\tesseract-ocr-tesseract-e3f272b\\tessdata"));
		
		Thread.sleep(5000);
	String textCapture=	tesseract.doOCR(target);
	
	System.out.println("textCapture  --------->   "+textCapture);
		
		
	WebElement captureInput =driver.findElement(By.xpath("//input[@id='captcha']"));
		
	captureInput.clear();
	captureInput.sendKeys(textCapture);
	
	
	WebElement signButton =driver.findElement(By.xpath("//button[normalize-space()='SIGN IN']"));
	signButton.click();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
