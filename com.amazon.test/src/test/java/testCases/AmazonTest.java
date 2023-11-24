package testCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import basePackage.Base;

public class AmazonTest extends Base {
	@Test
	public void testGetTotalResultForEveryPage() throws InterruptedException {
		navigateUrl(configProperties.getProperty("url"));

		String searchTag = "Shampoo", lastPage = "";
		int last, count = 1, totalItemResult = 0;

		// will find searchbox then will send search product
		try {
			sendKeys(By.xpath(LocatorProperties.getProperty("search_box")), searchTag + Keys.ENTER);
		} catch (NoSuchElementException e) {
			System.out.println("search box not found");
		}
		
		// will find the the last page number of the searched producd
		try {
			lastPage = getText(By.xpath(LocatorProperties.getProperty("last_page_number")));
			System.out.println("Last Page Number =" + lastPage);
		} catch (NoSuchElementException e) {
			System.out.println("Last page number not found");
		}

// //div[@class='a-section a-spacing-small puis-padding-left-small puis-padding-right-small']
//    
		// convert last page number string to int
		last = Integer.parseInt(lastPage);

		for (int i = 1; i <= last; i++) {

			// code for scroll down
			JavascriptExecutor js = (JavascriptExecutor) driver;
			// This will scroll down the page by 1000 pixel vertical
			js.executeScript("window.scrollBy(0,4000)");

			Thread.sleep(5000);
			// total number of search product in each page
			List<WebElement> itemList = driver.findElements(By.xpath(LocatorProperties.getProperty("item_list_for_every_page")));
			int result = itemList.size();
			System.out.println("Item list size [" + count + "] :" + result);

			// total product from first to last page
			totalItemResult = totalItemResult + result;
			System.out.println("Total item list size [" + count + "] :" + totalItemResult);
			
           //will count each page 1to that page total result
			int count2 = 1;
			
			for (WebElement singleItem : itemList) {

				// will print the title of each product
				try {
					String itemTitle = singleItem.findElement(By.xpath(".//span[@class='a-size-base-plus a-color-base a-text-normal']")).getText();
					System.out.println("Title of page [" + count + "] :Item no [" + count2 + "] :" + itemTitle);

				} catch (NoSuchElementException e) {
					System.out.println("Title of page [" + count + "] :Item no [" + count2 + "] : Not Found");
				}

				// will print the price of each product
				try {
					String itemSymbol = singleItem.findElement(By.xpath(".//div[@class='a-section a-spacing-small puis-padding-left-small puis-padding-right-small']//span[@class='a-price-symbol']")).getText();

					try {

						String itemPricewhole = singleItem.findElement(By.xpath(".//div[@class='a-section a-spacing-small puis-padding-left-small puis-padding-right-small']//span[@class='a-price-whole']")).getText();

						try {

							String itemPriceFraction = singleItem.findElement(By.xpath(".//div[@class='a-section a-spacing-small puis-padding-left-small puis-padding-right-small']//span[@class='a-price-fraction']")).getText();
							System.out.println("Price of page [" + count + "] :Item no [" + count2 + "] :" + itemSymbol+ "" + itemPricewhole + "" + "." + "" + itemPriceFraction);

						} catch (NoSuchElementException e) {
							// System.out.println("Item Price Fraction Not found");
						}
					} catch (NoSuchElementException e) {
						// System.out.println("Item Price Whole Not found");
					}
				} catch (NoSuchElementException e) {
					// System.out.println("Price Symbol Not Found");
				}
           //end of price code
				
				//beginning of number_of_people_bought_past_month
				try {
                    
					String itemNumberOfPeopleBoughtPastMonth = singleItem.findElement(By.xpath(LocatorProperties.getProperty("number_of_people_bought_past_month"))).getText();
					System.out.println("Number Of People Bought  of page [" + count + "] :Item no [" + count2 + "] :" + itemNumberOfPeopleBoughtPastMonth);
					

				} catch (NoSuchElementException e) {
					// System.out.println("Item Number of people bought last month not found");
				}	
				
				
//end of number_of_people_bought_past_month			
				
//beginning of item rating
				try {

					String itemNumberOfRating = singleItem.findElement(By.xpath(LocatorProperties.getProperty("number_of_rating"))).getText();
					System.out.println("Product Rating of page [" + count + "] :Item no [" + count2 + "] :" + itemNumberOfRating);

				} catch (NoSuchElementException e) {
					// System.out.println("Item Number of Rating  Not found");
				}	
				
				
//end of item rating
				
				//beginning of DeliveryDate
				try {

					String itemDeliveryDate = singleItem.findElement(By.xpath(LocatorProperties.getProperty("delivery_date"))).getText();
					System.out.println("Product Delivery Date of page [" + count + "] :Item no [" + count2 + "] :" + itemDeliveryDate);

				} catch (NoSuchElementException e) {
					// System.out.println("Product Delivery Date  Not found");
				}	
				
				
//end of DeliveryDate
				
				
				count2++;
			}

			Thread.sleep(5000);
			
           //will click to the button nextpage
			try {
				// click(By.xpath(LocatorProperties.getProperty("next_page")));
				driver.findElement(By.xpath(LocatorProperties.getProperty("next_page"))).click();
				;
			} catch (NoSuchElementException e) {
				System.out.println("Next page number not found");
			}

			count++;

		}

	}

//	public void testTopRatedFromOurBrands() throws InterruptedException {
//		
//	}

}


