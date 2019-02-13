package com.weborders.tests.smoke_tests;

import com.weborders.pages.LoginPage;
import com.weborders.pages.OrderPage;
import com.weborders.pages.ViewAllOrdersPage;
import com.weborders.pages.ViewAllProductsPage;
import com.weborders.utilities.ApplicationConstants;
import com.weborders.utilities.ConfigurationReader;
import com.weborders.utilities.TestBase;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class PageHeadersTests extends TestBase {

    @Test
    public void pageHeadersTest(){

//        LoginPage loginPage = new LoginPage();
//
//        ViewAllProductsPage viewAllProductsPage = new ViewAllProductsPage();
//        ViewAllOrdersPage viewAllOrdersPage = new ViewAllOrdersPage();
//        OrderPage orderPage = new OrderPage();

       extentLogger = report.createTest("Page headers test");



       extentLogger.info("Logging to the Application");
        pages.login().login(ConfigurationReader.getProperty("username"),
                ConfigurationReader.getProperty("password"));

        extentLogger.info("Verifying Header for all orders page");
        assertEquals(pages.viewAllOrders().header.getText(), ApplicationConstants.LIST_OF_ALL_ORDERS);

        extentLogger.info("Clicking on view all products lick");
        pages.viewAllOrders().viewAllProductsLink.click();

        extentLogger.info("Clicking on view all products page");
        assertEquals(pages.viewAllOrders().header.getText(), ApplicationConstants.LIST_OF_ALL_PRODUCTS);

        extentLogger.info("Clicking on order link");
        pages.viewAllOrders().orderLink.click();

        extentLogger.info("");
        assertEquals(pages.viewAllOrders().header.getText(), ApplicationConstants.ORDER);


    }

}
