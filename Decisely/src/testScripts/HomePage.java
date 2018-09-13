package testScripts;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;


@SuppressWarnings("unused")
public class HomePage {

	static WebDriver driver;

	//To Launch browser, clear cookies and maximise browser
	
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nivedita\\Desktop\\Programs\\softwares\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.close();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		//Hit URL
		driver.get("https://www.decisely.com/");

		//to wait till page loads
		//implicit wait
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, 60);

		String strTitle = driver.getTitle();		
		System.out.println(strTitle);

	}

	
	//Method to click Login button in HomePage
	
	public void clickLogin() {
		WebElement btnLogin = driver.findElement(By.xpath("//*[@id=\"loginOpen\"]"));
		btnLogin.click();
		//ExplicitWait
		WebDriverWait wait = new WebDriverWait(driver, 30);

	}
	
	//Method to click Search button in Home Page
	public void clickSearch() {	
		WebElement btnSearch = driver.findElement(By.xpath("//*[@id=\"search\"]/svg"));
		btnSearch.click();
		//ExplicitWait
		WebDriverWait wait = new WebDriverWait(driver, 30);

	}
	
	//Method to Update and Search in Home Page
	public void UpdateSearchBoxAndSearch(String strSearch) {
		
		WebElement fieldSearch = driver.findElement(By.xpath("//*[@id=\"searchHeader\"]/form/label/input"));
		fieldSearch.sendKeys(strSearch);
		
		WebElement btnSearchSubmit = driver.findElement(By.xpath("//*[@id=\"searchHeader\"]/form/input"));
		btnSearchSubmit.click();
		
	}

}

