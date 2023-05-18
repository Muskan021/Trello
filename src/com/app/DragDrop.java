package com.app;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class DragDrop {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions option= new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://trello.com/login");		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
		
		WebElement email= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user")));
		email.sendKeys("tautomation836@gmail.com");
		
		WebElement continueBtn= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		continueBtn.click();
		
		WebElement password= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		password.sendKeys("Trello@123");
		
		WebElement login= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-submit")));
		login.click();
		
		//Thread.sleep(10000);
		
		WebElement boards= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='board-tile mod-add']")));
		boards.click();
		
		//Thread.sleep(3000);
		
		WebElement boardTitle= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Board title']//following-sibling::input")));
		boardTitle.sendKeys("Board");
		
		WebElement createBoard= driver.findElement(By.xpath("//button[@data-testid='create-board-submit-button']"));
		createBoard.click();
		
//		WebElement addList= driver.findElement(By.xpath("//a[contains(@class,'open-add-list')]"));
//		addList.click();
		//Thread.sleep(3000);
		WebElement listName= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='list-name-input']")));
		listName.sendKeys("List A");
		
		WebElement addListBtn= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'list-add-controls')]//input")));
		addListBtn.click();
		
		WebElement addCardtoListA= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(@class,'list-header-name-assist') and normalize-space(text())='List A']//ancestor::div[contains(@class,'list-header')]//following-sibling::div[contains(@class,'card-composer-container')]")));
		addCardtoListA.click();
		
		//Thread.sleep(3000);
		
		WebElement cardTitle= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[contains(@class,'list-card-composer-textarea')]")));
		cardTitle.sendKeys("Card");
		
		WebElement addCard= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Add card']")));
		addCard.click();
		
		listName= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='list-name-input']")));
		listName.sendKeys("List B");
		
		addListBtn= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'list-add-controls')]//input")));
		addListBtn.click();
		
		WebElement SourceElement= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class,'js-member-droppable')]")));
		WebElement TargetElement= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(@class,'list-header-name-assist') and normalize-space(text())='List B']//ancestor::div[contains(@class,'list-header')]//following-sibling::div[contains(@class,'card-composer-container')]")));
		Actions action = new Actions(driver);
		//Thread.sleep(3000);
		action.dragAndDrop(SourceElement, TargetElement).build().perform();
		
		WebElement card= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class,'list-card')]")));
		System.out.println("X co-ordinate of card: "+card.getLocation().getX());
		System.out.println("Y co-ordinate of card: "+card.getLocation().getY());
		
		WebElement account= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-testid='header-member-menu-button']")));
		account.click();
		
		//Thread.sleep(3000);
		
		WebElement logout= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-testid='account-menu-logout']")));
		logout.click();
		
		//tautomation836@gmail.com
		//Trello@123

	}

}
