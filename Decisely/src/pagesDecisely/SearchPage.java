package pagesDecisely;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


@SuppressWarnings("unused")
public class SearchPage extends HomePage {							/* Inheritance */

	static SearchPage ObjSearchPage = new SearchPage();
	static HomePage ObjSearchBox = new SearchPage();           		/* Polymorphism */ 



	private static String strSearchprivate = "News";									/*Encapsulation*/
	private static String strURLprivate= "https://www.decisely.com/?s=News";

	//Method to verify search result displayed
	public void verifySearchPageDisplayed(String strSearch) {
		strSearch = "News";
		WebElement txtSearchResults = driver.findElement(By.xpath("//*[@id=\"main\"]//h1"));
		if (txtSearchResults.getText().contains(strSearch)) {

			System.out.println("Results for search item '" + strSearch + "' is displayed successfully");
		}else {
			System.out.println("Results for search item '" + strSearch + "' is not displayed successfully");
		}

	}

	//Method to UpdateAndSearch in SearchResults page
	public void UpdateSearchBoxAndSearch(String strSearch) {
		strSearch = strSearchprivate;

		WebElement eleSearch = driver.findElement(By.xpath("//*[@id=\"search\"]"));
		WebElement fieldSearch = driver.findElement(By.xpath("//*[@id=\"searchHeader\"]/form/label/input"));
		WebElement btnSearchSubmit = driver.findElement(By.xpath("//*[@id=\"searchHeader\"]/form/input"));

		eleSearch.click();
		fieldSearch.sendKeys(strSearch);
		btnSearchSubmit.click();

	}

	//Method to verify search results page
	public void VerifySearchResults(String strSearch) {
		strSearch = strSearchprivate;									
		ObjSearchBox.UpdateSearchBoxAndSearch(strSearch);         		/* Method overloading*/	
		ObjSearchPage.verifySearchPageDisplayed(strSearch);

	}

	//Method to update and verify URL

	public void VerifyUpdateURL(String strURL) {
		strURL = strURLprivate;
		driver.get(strURL);
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);					/*Exception Handling*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		try {
			WebElement txtNothingFound = driver
					.findElement(By.xpath("//*[@id=\"main\"]//h3[contains(@class,'page-title')]"));

			if(txtNothingFound.getText().contains("Nothing Found")) {
				System.out.println("Invalid Search text Detected. Please search for a valid text");
			}else {
				System.out.println("No Error in Page load, Search success!");
			}

		} catch (Exception e) {
			System.out.println("No Error in Page load, Search success!");
		}



	}
	
	//Method to get and Return List Size
	public int ListofSearchResultsReturned() {
		int i = 0;
		try {
			List<WebElement> list = driver
					.findElements(By.xpath("//*[@id=\"main\"]//div[contains(@class,'post-wraps text-center')]")); /*Collections*/
			
			for (WebElement ele : list) {
				i = i + 1;
			}
			System.out.println(i + " search results are displayed per page");
		} catch (Exception e) {
			System.out.println("Search Returned 0 Results");
		}
		return i;
	}




}
