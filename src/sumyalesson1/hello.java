package sumyalesson1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

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

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
	}
	@Test(priority = 1, enabled = false)
	public void RadioButton() {

		List<WebElement> AllRadioButton = driver.findElements(By.className("radioButton"));

		int totalRadioButtons = driver.findElements(By.className("radioButton")).size();

		// this is to select random radio button
		int RandomRadioButtonIndex = rand.nextInt(totalRadioButtons);

		AllRadioButton.get(RandomRadioButtonIndex).click();

		/*
		 * __ if you need to select spcific raido button to be clicked __
		 * 
		 * AllRadioButton.get(0).click(); AllRadioButton.get(1).click();
		 * AllRadioButton.get(2).click();
		 * 
		 */
	}
	
	@Test(priority = 2, enabled =false )
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
	@Test(priority = 3)
	public void SelectTag() {
		WebElement TheSelector=driver.findElement(By.id("dropdown-class-example"));
		
		Select mySelect = new Select(TheSelector);
		//mySelect.selectByContainsVisibleText("Appium");
		mySelect.selectByIndex(1);
		mySelect.selectByValue("option3");
	}
	@Test(priority = 4)
	public void CheckBoxTest() {
		
	
	WebElement DivofCheckBox= driver.findElement(By.id("checkbox-example"));
	List<WebElement> AllCheckBoxes = DivofCheckBox.findElements(By.tagName("input"));
	int randomIndex = rand.nextInt(AllCheckBoxes.size());
	AllCheckBoxes.get(randomIndex).click();
	
	//for(int i = 0; 1 < AllCheckBoxes. size();i++) 
	//	AllCheckBoxes. get(i).click();
}
	@Test(priority = 5 , enabled = false )
	public void Window_Example() throws InterruptedException {
		WebElement SwitchWindowButton =driver.findElement(By.id("openwindow"));
		SwitchWindowButton.click();
		Set<String> handles = driver.getWindowHandles();

		List<String> windowList = new ArrayList<>(handles);

		driver.switchTo().window(windowList.get(1));
		System.out.println(driver.getTitle());
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"menu-item-9660\"]/a/span[1]")).click();

		driver.switchTo().window(windowList.get(0));
		Thread.sleep(2000);

		System.out.println(driver.getTitle());
		
	}
	@Test(priority = 6, enabled = false)
	public void Switch_Tab_Example() throws InterruptedException {
		WebElement SwitchTabButton = driver.findElement(By.id("opentab"));

		SwitchTabButton.click();

		Set<String> handles = driver.getWindowHandles();

		List<String> TabList = new ArrayList<>(handles);

		driver.switchTo().window(TabList.get(1));

		Thread.sleep(2000);

		System.out.println(driver.getTitle());

		driver.switchTo().window(TabList.get(0));
		Thread.sleep(2000);

		System.out.println(driver.getTitle());
	}

	@Test(priority = 7, enabled = false)
	public void AlertTest() throws InterruptedException {
		Thread.sleep(2000);
		WebElement InputFieldForTheName = driver.findElement(By.id("name"));
		InputFieldForTheName.sendKeys("Najat Rawashdeh");

		WebElement AlertButton = driver.findElement(By.id("alertbtn"));
		AlertButton.click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
	}
	@Test(priority = 8, enabled = false)
	public void ConfirmTest() throws InterruptedException {
		Thread.sleep(2000);
		WebElement InputFieldForTheName = driver.findElement(By.id("name"));
		InputFieldForTheName.sendKeys("abedalraheem");

		WebElement AlertButton = driver.findElement(By.id("confirmbtn"));
		AlertButton.click();
		Thread.sleep(2000);

		// driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();

	}	
	@Test(priority = 9)
	public void TableTest() {

		// to prirnt all the rows

		WebElement theTable = driver.findElement(By.id("product"));

		List<WebElement> AllRows = theTable.findElements(By.tagName("tr"));
		List<WebElement> AllData = theTable.findElements(By.tagName("td"));

		// this is the logic to print random row

//	int randomRow = 	rand.nextInt(AllRows.size());
//		System.out.println(AllRows.get(randomRow).getText());

		// to print all the rows
//		for (int i = 0; i < AllRows.size(); i++) {
//
//			System.out.println(AllRows.get(i).getText());
//		}

		for (int i = 0; i < AllData.size(); i = i++) {

			System.out.println(AllData.get(i).getText());
		}

	}}
