package org.proarch;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CricbuzzTestResult {
	
	public static void main(String[] args) {
		
        WebDriver driver = new ChromeDriver();
        

        try {
            // Open the Cricbuzz website
            driver.get("https://www.cricbuzz.com/");
            driver.manage().window().maximize();

            // Initialize Actions class for mouse over actions
            Actions actions = new Actions(driver);

            // Locate the "Team" tab
            WebElement teamTab = driver.findElement(By.xpath("//a[text()='Teams']"));

            // Perform mouse over on "Team" tab
            actions.moveToElement(teamTab).perform();

            // Select "Australia" from the dropdown
            WebElement australiaOption = driver.findElement(By.xpath("//a[text()='Australia']/parent::div/child::a[5]"));
            australiaOption.click();

            // Wait for the page to load (you can replace with explicit waits if necessary)
            Thread.sleep(2000);

            // Click on the "Result" tab
            WebElement resultTab = driver.findElement(By.xpath("//a[text()='Results']"));
            resultTab.click();

            // Wait for the results page to load
            Thread.sleep(2000);

            // Fetch the first three results
            List<WebElement> results = driver.findElements(By.xpath("//div[@id='series-matches']/child::div"));

            System.out.println("First three results:");
         
            for (int i = 0; i < Math.min(3, results.size()); i++) {
                System.out.println((i + 1) + ". " + results.get(i).getText());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
	}

}
