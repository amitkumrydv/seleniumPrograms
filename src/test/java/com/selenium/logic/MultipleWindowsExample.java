package com.selenium.logic;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.Set;

public class MultipleWindowsExample {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
       // System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
    	
    	WebDriverManager.chromedriver().setup();

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        // Open the main window
        driver.get("https://www.amazon.in/");
        
        
        driver.manage().window().maximize();
        
        driver.findElement(By.linkText("Today's Deals")).click();

        // Get the current window handle (main window)
        String mainWindowHandle = driver.getWindowHandle();

        // Find the element that opens a new window
        WebElement newWindowLink = driver.findElement(By.xpath("//img[@src=\"https://m.media-amazon.com/images/I/4105IiC5tDL._AC_UF226,226_FMjpg_.jpg\"]"));

        // Click the element to open a new window
        newWindowLink.click();

        // Get all window handles after opening the new window
        Set<String> allWindowHandles = driver.getWindowHandles();

        // Switch to the new window
        for (String windowHandle : allWindowHandles) {
            if (!windowHandle.equals(mainWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        // Perform actions on the new window
        System.out.println("Title of the new window: " + driver.getTitle());

        // Close the new window
        driver.close();

        // Switch back to the main window
        driver.switchTo().window(mainWindowHandle);

        // Perform actions on the main window
        System.out.println("Title of the main window: " + driver.getTitle());

        // Close the main window
        driver.quit();
    }
}
