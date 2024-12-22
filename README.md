# Billing System for Ice Cream Shop

This project is a desktop application designed to streamline billing for an ice cream shop. Developed using **NetBeans IDE** and **JDBC driver**, it connects to a **localhost database** to manage data efficiently.

## Features
- **Billing System**: Simplifies the checkout process with automated calculations.
- **Inventory Management**: Tracks stock levels and updates automatically.
- **Local Database**: Ensures data is securely stored and accessible.

## Technologies
- **Java**: Core programming language.
- **JDBC**: For database connectivity.
- **NetBeans IDE**: Development environment ([Download NetBeans IDE 20](https://netbeans.apache.org/front/main/download/nb20/)).

## Setup Instructions

### Step 1: Clone the Repository
1. Copy the following URL:
   ```
   https://github.com/GihanJY/Ice-cream-shop-Billing-System.git
   ```
2. Open GitHub Desktop or your preferred Git client.
3. Go to **File > Clone Repository > URL**.
4. Paste the URL in the text field and click the **Clone** button.

### Step 2: Import the Database
1. Open MySQL Workbench or your preferred MySQL client.
2. Import the SQL file included in the repository:
   - Locate the file: `assets/icecreamshopdb.sql`.
   - Execute the script to create and populate the database.

### Step 3: Add JDBC Driver to Project
1. Navigate to the `assets` folder in the repository.
2. Locate the JDBC driver file: `mysql-connector-j-8.3.0.jar`.
3. Add the driver to your project libraries in NetBeans:
   - Right-click on the project in the **Projects** view.
   - Select **Properties > Libraries > Add JAR/Folder**.
   - Add the `mysql-connector-j-8.3.0.jar` file.

### Step 4: Configure JDBC Connection
1. Open NetBeans IDE.
2. Go to the **Services** tab.
3. Create a new database connection:
   - **Driver**: MySQL (Connector/J Driver).
   - Use the JDBC driver file located in the `assets` folder.
   - **Host**: `localhost`.
   - **Port**: `3306`.
   - **Username**: `root`.
   - **Password**: [Your MySQL Password].

### Step 5: Build and Run the Project
1. Open the project in NetBeans IDE.
2. Build the project:
   - Go to the menu **Run > Build Project**.
3. Run the project:
   - Go to the menu **Run > Run Project**.

## Troubleshooting
- Ensure that MySQL is running on your local machine.
- Verify that the database credentials in the project match your MySQL configuration.
- If the project fails to connect to the database, confirm that the JDBC driver is correctly added to the project libraries.
- Check the MySQL server's port (default is `3306`) if connectivity issues persist.

For additional assistance, refer to the project repository or contact the developer.
