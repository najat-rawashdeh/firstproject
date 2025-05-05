package sumyalesson1;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class hello {
	
	WebDriver driver = new ChromeDriver();
	Random rand = new Random();
	
	@BeforeTest
	public void mySetup() {
		driver.get("https://codenboxautomationlab.com/practice/");
		driver.manage().window().maximize(); 
		
	}
	@Test(priority = 1, enabled =false )
	public void autoCompleteTest() throws InterruptedException 
	{
		WebElement autoCompleteInputField = driver.findElement(By.id("autocomplete"));
	
		String [] Countries = {"jo","sy","ja","ye"};
		int randomIndex =rand.nextInt(Countries.length);
		
		System.out.println(randomIndex);
		autoCompleteInputField.sendKeys(Countries[randomIndex]);
			Thread.sleep(1000);
		
			autoCompleteInputField.sendKeys(Keys.chord(Keys.ARROW_DOWN,Keys.ENTER));
		}
	@Test(priority = 2)
	public void SelectTag() {
		WebElement TheSelector=driver.findElement(By.id("dropdown-class-example"));
		
		Select mySelect = new Select(TheSelector);
		//mySelect.selectByContainsVisibleText("Appium");
		mySelect.selectByIndex(1);
		mySelect.selectByValue("option3");
	}
	@Test(priority = 3)
	public void CheckBoxTest() {
		
	
	WebElement DivofCheckBox= driver.findElement(By.id("checkbox-example"));
	List<WebElement> AllCheckBoxes = DivofCheckBox.findElements(By.tagName("input"));
	int randomIndex = rand.nextInt(AllCheckBoxes.size());
	AllCheckBoxes.get(randomIndex).click();
	
	//for(int i = 0; 1 < AllCheckBoxes. size();i++) 
	//	AllCheckBoxes. get(i).click();
}

}