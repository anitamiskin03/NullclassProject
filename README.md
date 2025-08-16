Amazon E-Commerce Automation Testing Project

##  Introduction
This project automates end-to-end testing of **Amazon.in** using **Selenium WebDriver, Java, and TestNG**.  
The automation suite covers user scenarios like searching products, adding to cart, validating user profile details, applying constraints (price, character restrictions), and capturing screenshots of failures.

---

##  Tech Stack
- **Language**: Java  
- **Automation Tool**: Selenium WebDriver  
- **Test Framework**: TestNG  
- **Build Tool**: Maven  
- **Design Pattern**: Page Object Model (POM)  
- **Reports**: TestNG Reports / Extent Reports  

---

##  Features & Scenarios Automated
1. **Login & Profile Validation**
   - Login to Amazon.in  
   - Verify user profile details are displayed correctly  
   - Profile name validation: must not contain disallowed characters  

2. **Product Search & Filtering**
   - Search for a product  
   - Skip unwanted categories (e.g., Electronics)  
   - Ignore products starting with letters (A, B, C, D)  

3. **Shopping Cart**
   - Add multiple products to cart  
   - Verify cart total price > ₹2000  
   - Validate username (only alphanumeric, no special characters)  

4. **Order Flow**
   - Place order only if total amount > ₹500  
   - Execute tests only in allowed time window (e.g., 6 PM – 7 PM)  

5. **Error Handling**
   - Capture screenshots on test failure  
   - Generate reports after execution  

---

##  Project Structure
Amazon/
├── src/
│ ├── main/java/pages/ # Page Object Classes
│ ├── test/java/testcases/ # TestNG Test Classes
│ ├── test/java/util/ # Utilities (ConfigReader, DriverFactory, etc.)
├── pom.xml # Maven dependencies
├── testng.xml # TestNG Suite file
├── README.md # Project Documentation

---


├───src
│   ├───main
│   │   └───java
│   │       ├───Amazon
│   │       │   └───NullClassAmazonProject
│   │       │           App.java
│   │       │
│   │       ├───base
│   │       │       TestBase.java
│   │       │
│   │       ├───config
│   │       │       config.properties
│   │       │
│   │       ├───pages
│   │       │       AmazonGoToCartPage.java
│   │       │       AmazonHomePage.java
│   │       │       AmazonLoginPage.java
│   │       │       AmazonPaymentPage.java
│   │       │       AmazonPopupHandler.java
│   │       │       AmazonProductDetailsPage.java
│   │       │       AmazonProductFilterPage.java
│   │       │       AmazonProductPage.java
│   │       │       AmazonProfilePage.java
│   │       │       AmazonSearchProductsPage.java
│   │       │       AmazonShoppingCartPage.java
│   │       │       AmazonValidProductAndVerifyPage.java
│   │       │       TimeValidator.java
│   │       │       VerifyAmazonPaymentPage.java
│   │       │
│   │       └───util
│   │               ConfigReader.java
│   │               EmailSender.java
│   │               ScreenshotUtil.java
│   │
│   └───test
│       └───java
│           ├───Amazon
│           │   └───NullClassAmazonProject
│           │           AppTest.java
│           │
│           └───testcases
│                   AmazonLoginTest.java
│                   AmazonPaymentTest.java
│                   AmazonProductDetailsTest.java
│                   AmazonSearchProductsTest.java
│                   AmazonShoppingCartTest.java
│                   Task1.docx
│                   Task2AmazonTests.java
│                   Task3MonitorPriceChangeTest.java
│                   Task4AmazonProductFilterTest.java
│                   Task5AmazonUserProfileTest.java
│                   Task6AmazonValidProductAndVerifyTest.java
│                   Task7AmazonAddProductVerify.java


## ⚡ Getting Started

### 🔹 1. Clone Repository
```bash
git clone https://github.com/<your-username>/<repo-name>.git
cd <repo-name>
🔹 2. Import Project
Open IntelliJ IDEA / Eclipse

Import as Maven Project

🔹 3. Install Dependencies
mvn clean install

🔹 4. Run Tests
mvn test
Or run directly from testng.xml

Reports & Evidence
After execution, reports can be found under:

test-output/ (TestNG default reports)

reports/ExtentReport.html (if Extent Reports integrated)

Failure screenshots are saved in screenshots/ folder.

Sample Code
BaseTest.java
<img width="642" height="428" alt="image" src="https://github.com/user-attachments/assets/77ae5428-8a30-4e6e-a3d5-1374002b9bc9" />


Author
Anita
Automation Tester | Skilled in Selenium, Java, TestNG, Maven, POM | Passionate about QA & Test Automation

Email: anitamiskin03@gmail.com
🔗 GitHub: anitamiskin03


