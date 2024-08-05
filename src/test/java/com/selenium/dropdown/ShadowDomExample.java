package com.selenium.dropdown;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShadowDomExample {
    public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
    	WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://shop.polymer-project.org/");

        // Identify shadow host
        WebElement shadowHost = driver.findElement(By.cssSelector("a[aria-label=\"Men's Outerwear Shop Now\"]"));

        // JavaScript to return the shadow root of a given shadow host element
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement shadowRoot = (WebElement) jsExecutor.executeScript("return arguments[0].shadowRoot", shadowHost);

        // Interact with elements inside the shadow root
        WebElement shadowContent = shadowRoot.findElement(By.cssSelector("span"));
        System.out.println(shadowContent.getText());

        driver.quit();
    }
}
