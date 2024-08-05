package com.selenium.logic;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleWindowsExample {
    public static void main(String[] args) throws InterruptedException, AWTException {
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
        WebElement newWindowLink = driver.findElement(By.xpath("//span[@class='a-truncate-cut'][contains(text(),'Oneplus Nord CE4 (Celadon Marble, 8GB RAM, 256GB S')]"));

        // Click the element to open a new window
        
        Actions action = new Actions(driver);
        
        action.contextClick(newWindowLink).perform();   // Right click to open new tab
        
        Thread.sleep(10000);
        
        action.sendKeys("keys.ENTER");
        
        
        
        Robot robot = new Robot();

        // Give the context menu some time to appear
        Thread.sleep(2000);

        // Example: Navigate the context menu using arrow keys and press Enter
        // Adjust the key events as needed based on the context menu options and structure

        // Press Down arrow key to navigate to the desired option
      //  robot.keyPress(KeyEvent.VK_DOWN);
     //   robot.keyRelease(KeyEvent.VK_DOWN);

        // If needed, repeat for additional down keys
        // robot.keyPress(KeyEvent.VK_DOWN);
        // robot.keyRelease(KeyEvent.VK_DOWN);

        // Press Enter to select the option
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);
        
        
        
        
        
        
        
        
        
        
        
        Thread.sleep(10000);
        
        
      //  newWindowLink.click();

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
