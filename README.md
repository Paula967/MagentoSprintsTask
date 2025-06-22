 🛍️ Magento Sprints Task - Selenium Automation Project

Automated test framework for an **E-commerce Magento website** built using:

✅ Selenium WebDriver  
✅ TestNG Framework  
✅ Page Object Model (POM)  
✅ JSON Test Data  
✅ Utility Classes  
✅ TestNG Reports  

---

## ⚙️ Tech Stack

- Java 17+
- Selenium WebDriver
- TestNG
- Maven
- JSON for test data
- Page Object Model (POM) Design Pattern

---

## 🗂️ Project Structure

MagentoSprintsTask
├── src
│ ├── main
│ │ └── java
│ │ └── GuiPages
│ │ ├── BasePage.java
│ │ ├── HomePage.java
│ │ ├── CatalogSearchPage.java
│ │ ├── CartPage.java
│ │ ├── ShippingPage.java
│ │ ├── PaymentPage.java
│ │ └── SuccessPage.java
│ ├── test
│ │ ├── java
│ │ │ └── TestPackage
│ │ │ ├── AddToCartTest.java
│ │ │ ├── PaymentTest.java
│ │ │ ├── TestProductSearchInHomePage.java
│ │ └── resources
│ │ └── testDataFiles
│ │ ├── ProductName.json
│ │ ├── productDetails.json
│ │ └── ShippingInformations.json
├── pom.xml
├── testng.xml
└── README.md

yaml
Copy
Edit

---

## 🚀 Setup and Execution Instructions

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/Paula967/MagentoSprintsTask.git
2️⃣ Import Project into IntelliJ IDEA
File → Open → Select the project folder

Let IntelliJ auto-import Maven dependencies

3️⃣ Install Maven Dependencies
bash
Copy
Edit
mvn clean install
4️⃣ Configure ChromeDriver
Download ChromeDriver (compatible with your Chrome version)

Add ChromeDriver path to your system PATH

Or specify WebDriver path in BaseClass if needed

5️⃣ Run Tests
Option 1: From IntelliJ IDEA
Right-click on testng.xml

Select Run 'testng.xml'

Option 2: From Maven CLI
bash
Copy
Edit
mvn test
6️⃣ View Test Reports
After running the tests, open:

bash
Copy
Edit
/test-output/index.html
/test-output/emailable-report.html
Open in any browser to view TestNG reports

📋 Features Implemented
✅ Search product functionality test
✅ Add product to cart test
✅ Proceed to checkout
✅ Fill shipping info
✅ Complete payment
✅ Validate success order message
✅ Test data driven by JSON
✅ Page Object Model implemented
✅ Utility class for JSON reading
✅ TestNG reports generation

✨ Author
Paula Farid
