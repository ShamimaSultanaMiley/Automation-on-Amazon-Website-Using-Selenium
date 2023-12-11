# Selenium Automation Framework for Amazon Product Analysis

## Overview

This project is an automated testing framework developed using Java and TestNG for analyzing Amazon product details such as title, price, number of people who bought it in the past month, product rating, and delivery date. The framework utilizes Selenium for web automation and is designed to navigate through multiple pages of search results on Amazon.

## Project Structure

The project is structured into two main packages:

1. **basePackage**: Contains the base class (`Base`) responsible for setting up the WebDriver, loading configuration and locator properties, and providing reusable methods for interacting with web elements.

   - `Base`: Initializes WebDriver, loads configuration and locator properties, and defines common methods for navigation, sending keys, clicking, and retrieving text.

2. **testCases**: Contains test classes, such as `AmazonTest`, which extends the `Base` class. Test classes implement specific test scenarios using TestNG annotations.

   - `AmazonTest`: Implements test scenarios for analyzing Amazon product details, including retrieving the total number of search results on each page and extracting information such as title, price, number of people who bought it in the past month, product rating, and delivery date.

## Prerequisites

Before running the tests, ensure the following:

- **Web Drivers**: ChromeDriver and GeckoDriver are placed in the `executables` folder for Chrome and Firefox, respectively.
  
- **Configuration Properties**: Update the `config.properties` file in the `properties` folder with the desired configurations, such as the browser to be used and the URL.

## How to Run

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/amazon-automation-framework.git
   ```
2. Open the project in your preferred Java IDE.

3. Configure the `config.properties` file in the `src/test/resources/properties` folder.

4. Run the test classes using TestNG.

## Test Scenarios

### 1. Test Get Total Result For Every Page

This test scenario navigates to Amazon, searches for a specified product (e.g., "Shampoo"), and iterates through each page of search results. It extracts and prints details for each product, including title, price, number of people who bought it in the past month, product rating, and delivery date.

### 2. Test Top Rated From Our Brands (Commented Out)

An additional test scenario (`testTopRatedFromOurBrands`) is provided but commented out in the `AmazonTest` class. Uncomment and customize it as needed to implement a specific test case.

## Notes

- Make sure to adapt the XPath expressions in `LocatorProperties` based on the structure of the Amazon website, as changes to the website may affect the reliability of the automation scripts.

- Additional test scenarios and functionalities can be added by extending the framework.
