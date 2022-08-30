package electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utility.Utility;

import java.util.Random;

public class ElectronicsTest extends Utility {
    String baseurl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseurl);
    }

    @Test
    public void testverified(){
        //1.1 Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Electronics ']"));

        //1.2 Mouse Hover on “Cell phones” and click
        mouseHoverToElementAndClick(By.xpath("//body[1]/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));


        //1.3 Verify the text “Cell phones”
        String expectedMessage = "Cell phones";
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]"));
        Assert.assertEquals("Message verify", expectedMessage, actualMessage);
    }
    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        //2.1 Mouse Hover on “Electronics” Tab
        //2.2 Mouse Hover on “Cell phones” and click
        //2.3 Verify the text “Cell phones”
        this.testverified();

        //2.4 Click on List View Tab
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));

        //2.5 Click on product name “Nokia Lumia 1020” link
        Thread.sleep(1000);
        mouseHoverToElementAndClick(By.xpath("//h2[@class='product-title']//a[contains(text(),'Nokia Lumia 1020')]"));


        //2.6 Verify the text “Nokia Lumia 1020”

        String actualMessage1 = getTextFromElement(By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"));
        String expectedMessage1 = "Nokia Lumia 1020";
        Assert.assertEquals("Message Nokia verify", expectedMessage1, actualMessage1);

        //2.7 Verify the price “$349.00”
        String expectedMessage2 = "$349.00";
        String actualMessage2 = getTextFromElement(By.xpath("//span[contains(text(),'$349.00')]"));
        Assert.assertEquals("Message verify price", expectedMessage2, actualMessage2);

        //2.8 Change quantity to 2
        clearTextFromField(By.xpath("//input[@class='qty-input']"));
        sendTextToElement(By.xpath("//input[@class='qty-input']"),"2");

        //2.9 Click on “ADD TO CART” tab
        clickOnElement(By.xpath("//button[@class='button-1 add-to-cart-button']"));

        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String expectedMessage3 = "The product has been added to your shopping cart";
        String actualMessage3 = getTextFromElement(By.xpath("//p[@class='content']"));
        Assert.assertEquals("Price", expectedMessage3, actualMessage3);

        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//span[@title='Close']"));

        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
      mouseHoverToElementAndClick(By.xpath("//span[@class='cart-label']"));
        clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));

        //2.12 Verify the message "Shopping cart"
        String expectedMsg = "Shopping cart";
        String actualMsg = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals( expectedMsg, actualMsg);

        //2.13 Verify the quantity is 2
        //2.14 Verify the Total $698.00
        String expectedMessage4 = "$698.00";
        String actualMessage4 = getTextFromElement(By.xpath("//span[@class='product-subtotal']"));
        Assert.assertEquals( expectedMessage4, actualMessage4);

        //2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        //2.16 Click on checkout
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //“2.17 Verify the Text “Welcome, Please Sign In!”
        String expectedMessage5 = "Welcome, Please Sign In!";
        String actualMessage5 = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertEquals("please sign in", expectedMessage5, actualMessage5);

        //2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//a[@class='ico-register']"));

        //2.19 Verify the text “Register”
        String expectedMessage6 = "Register";
        String actualMessage6 = getTextFromElement(By.xpath("//h1[contains(text(),'Register')]"));
        Assert.assertEquals("please sign in", expectedMessage6, actualMessage6);

        //2.20 Fill the mandatory fields
        sendTextToElement(By.xpath("//input[@id='FirstName']"), "garry");
        sendTextToElement(By.xpath("//input[@id='LastName']"), "poter");
        sendTextToElement(By.xpath("//input[@id='Email']"), "abc125@gmail.com");
        sendTextToElement(By.xpath("//input[@id='Password']"), "Abcd1234");
        sendTextToElement(By.xpath("//input[@id='ConfirmPassword']"), "Abcd1234");

        //2.21 Click on “REGISTER” Button
        clickOnElement(By.xpath("//button[@id='register-button']"));

        //2.22 Verify the message “Your registration completed”
        String expectedMessage7 = "Your registration completed";
        String actualMessage7 = getTextFromElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
        Assert.assertEquals("please sign in", expectedMessage7, actualMessage7);

        //2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[@class='button-1 register-continue-button']"));

        //2.24 Verify the text “Shopping cart”
        String expectedMessage8 = "Shopping cart";
        String actualMessage8 = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("please sign in", expectedMessage8, actualMessage8);

        //2.25 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        //2.26 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //2.27 Fill the Mandatory fields
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"),"kavan");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"),"patel");
        clearTextFromField(By.xpath("//input[@id='BillingNewAddress_Email']"));
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"),"xyz@yahoo.com");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Company']"),"ABC");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"United States");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_StateProvinceId']"),"California");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"),"london");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"),"Harrow");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"),"ha3 8ew");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"),"084743643");
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));

        //2.28 Click on “CONTINUE”

        //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.xpath("//input[@id='shippingoption_2']"));

        //2.30 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));

        //2.31 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));

        //2.32 Select “Visa” From Select credit card dropdown
        selectByValueFromDropdown(By.xpath("//select[@id='CreditCardType']"),"visa");

        //2.33 Fill all the details
        sendTextToElement(By.xpath("//input[@id='CardholderName']"),"Mr garry Poter");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"),"4012888888881881");
        selectByValueFromDropdown(By.xpath("//select[@id='ExpireMonth']"),"5");
        selectByValueFromDropdown(By.xpath("//select[@id='ExpireYear']"),"2023");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='CardCode']"),"391");


        //2.34 Click on “CONTINUE”CHECKOUT”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));


        //2.35 Verify “Payment Method” is “Credit Card”
        String expectedMessage9 = "Credit Card";
        String actualMessage9 = getTextFromElement(By.xpath("//span[contains(text(),'Credit Card')]"));
        Assert.assertEquals(expectedMessage9,actualMessage9);

        //2.36 Verify “Shipping Method” is “2nd Day Air”
        String expectedMessage10 = "2nd Day Air";
        String actualMessage10 = getTextFromElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[1]/span[2]"));
        Assert.assertEquals(expectedMessage10,actualMessage10);

        //2.37 Verify Total is “$698.00”
        String expectedMessage11 = "$698.00";
        String actualMessage11 = getTextFromElement(By.xpath("//tr[@class='order-total']//strong[text()='$698.00']"));
        Assert.assertEquals(expectedMessage11,actualMessage11);


        //2.38 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));

        //2.39 Verify the Text “Thank You”
        String expectedMessage12 = "Thank you";
        String actualMessage12 = getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]"));
        Assert.assertEquals(expectedMessage12,actualMessage12);

        //2.40 Verify the message “Your order has been successfully processed!”
        String expectedMessage13 = "Your order has been successfully processed!";
        String actualMessage13 = getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        Assert.assertEquals(expectedMessage13,actualMessage13);

        //2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));

        //2.42 Verify the text “Welcome to our store”
        String expectedMessage14 = "Welcome to our store";
        String actualMessage14 = getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        Assert.assertEquals(expectedMessage14,actualMessage14);

        //2.43 Click on “Logout” link
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));


        //2.44 Verify the URL is “https://demo.nopcommerce.com/”
        String expectedUrl ="https://demo.nopcommerce.com/";
        String actualUrl = "https://demo.nopcommerce.com/";
        Assert.assertEquals(expectedUrl,actualUrl);


    }
    //@After
    //public void teardown(){
        //closeBrowser();
  //  }
}
