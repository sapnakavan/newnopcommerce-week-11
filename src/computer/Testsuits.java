package computer;

import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.Computer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utility.Utility;

import java.awt.*;
import java.util.List;

public class Testsuits extends Utility {
    String baseurl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseurl);
    }

    @Test
    public void Testname() {
        //1.1 Click on Computer Menu.
        //1.2 Click on Desktop
        Actions actions = new Actions(driver);
        WebElement computer = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a"));
        WebElement DeskTop = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a"));
        actions.moveToElement(computer).build().perform();
        actions.moveToElement(DeskTop).click().build().perform();


        //1.3 Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Name: Z to A");


        //1.4 Verify the Product will arrange in Descending order.
        String acc = getTextFromElement(By.xpath("//select[@id='products-orderby']/option[3]"));
        String expo = "Name: Z to A";
        Assert.assertEquals(expo,acc);


    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //2.1 Click on Computer Menu.
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a"));

        //2.2 Click on Desktop
        clickOnElement(By.xpath("//div[@class='category-grid sub-category-grid']//a[text()=' Desktops ']"));
        Thread.sleep(1000);

        //2.3 Select Sort By position "Name: A to Z"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Name: A to Z");


        //2.4 Click on "Add To Cart"
        Thread.sleep(1000);
         clickOnElement(By.xpath("//div[@class='item-box'][1]//button[text()='Add to cart']"));

        //2.5 Verify the Text "Build your own computer"
        String acc = getTextFromElement(By.xpath("//h1[contains(text(),'Build your own computer')]"));
        String expo = "Build your own computer";
        Assert.assertEquals(expo,acc);


        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByValueFromDropdown(By.xpath("//select[@name='product_attribute_1']"),"1");


        //2.7.Select "8GB [+$60.00]" using Select class.
        selectByValueFromDropdown(By.xpath("//select[@id='product_attribute_2']"),"5");
        Thread.sleep(1000);

        //2.8 Select HDD radio "400 GB [+$100.00]"
        clickOnElement(By.xpath("//input[@id='product_attribute_3_7']"));
        Thread.sleep(1000);


        //2.9 Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.xpath("//input[@id='product_attribute_4_9']"));
        Thread.sleep(1000);


        //A 2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"

          Thread.sleep(1000);
          clickOnElement(By.xpath("//input[@id='product_attribute_5_12']"));
          Thread.sleep(1000);

        //2.11 Verify the price "$1,475.00"
        String acc1 = getTextFromElement(By.xpath("//span[@class='price-value-1']"));
        String expo1 = "$1,475.00";
        Assert.assertEquals(expo1,acc1);


        //2.12 Click on "ADD TO CARD" Button.
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));

        //2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String acc2 = getTextFromElement(By.xpath("//div[@id='bar-notification']/div[1]/p"));
        String exp = "The product has been added to your shopping cart";
        Assert.assertEquals(exp,acc2);

        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//span[@class='close']"));

        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverToElement(By.xpath("//div[@class='header-links']/ul[1]/li[4]"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));


        //2.15 Verify the message "Shopping cart"
        String ac = getTextFromElement(By.xpath("//div[@class='page-title']"));
        String ex = "Shopping cart";
        Assert.assertEquals(ex,ac);

        //2.16 Change the Qty to "2" and Click on "Update shopping cart"
        clearTextFromField(By.xpath("//input[@class='qty-input']"));
        sendTextToElement(By.xpath("//input[@class='qty-input']"),"2");
        clickOnElement(By.xpath("//button[@id='updatecart']"));

        //2.17 Verify the Total"$2,950.00"
        String am = getTextFromElement(By.xpath("//span[@class='product-subtotal']"));
        String em = "$2,950.00";
        Assert.assertEquals(em,am);

        //2.18 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        //2.19 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //2.20 Verify the Text “Welcome, Please Sign In!”
        String text = getTextFromElement(By.xpath("//div[@class='page-title']/h1"));
        String text1 = "Welcome, Please Sign In!";
        Assert.assertEquals(text1,text);

        //2.21Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[@class='button-1 checkout-as-guest-button']"));

        //2.22 Fill the all mandatory field
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"),"peter");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"),"Rabit");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"),"test12@gmail.com");
        sendTextToElement(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"United states");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_StateProvinceId']"),"California");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"),"london");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"),"Harrow");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"),"ha3 8ew");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"),"084743643");


        //2.23 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));

        //2.24 Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.xpath("//input[@id='shippingoption_1']"));

        //2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));

        //2.26 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));

       //click on continue button
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));

        //2.27 Select “Master card” From Select credit card dropdown
        selectByValueFromDropdown(By.xpath("//select[@id='CreditCardType']"),"MasterCard");

        //2.28 Fill all the details
        sendTextToElement(By.xpath("//input[@id='CardholderName']"),"Mr peter rabit");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"),"5105105105105100");
        selectByValueFromDropdown(By.xpath("//select[@id='ExpireMonth']"),"5");
       selectByValueFromDropdown(By.xpath("//select[@id='ExpireYear']"),"2023");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='CardCode']"),"391");

        //2.29 Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));

        //2.30 Verify “Payment Method” is “Credit Card”
       String acc3 = getTextFromElement(By.xpath("//div[@class='payment-method-info']/ul"));
       String exp3 = "Payment Method: Credit Card";
       Assert.assertEquals(exp3,acc3);

        //2.32 Verify “Shipping Method” is “Next Day Air”
        String acc4 = getTextFromElement(By.xpath("//div[@class='shipping-method-info']/ul"));
        String exp4 = "Shipping Method: Next Day Air";
        Assert.assertEquals(exp4,acc4);

        //2.33 Verify Total is “$2,950.00”
        String acc5 = getTextFromElement(By.xpath("//tr[@class='order-total']/td[2]"));
        String exp5 ="$2,950.00";
        Assert.assertEquals(exp5,acc5);

        //2.34 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[@class='button-1 confirm-order-next-step-button']"));

        //2.35 Verify the Text “Thank You”

        String ver = getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]"));
        Thread.sleep(1000);
        String ver1 = "Thank you";
        Assert.assertEquals(ver1,ver);

        //2.36 Verify the message “Your order has been successfully processed!”
        String veri = getTextFromElement(By.xpath("//strong[text()='Your order has been successfully processed!']"));
        String verification = "Your order has been successfully processed!";
        Assert.assertEquals(verification,veri);
        Thread.sleep(1000);

        //2.37 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 order-completed-continue-button']"));

        //2.37 Verify the text “Welcome to our store”
        String a = getTextFromElement(By.xpath("//h2[text()='Welcome to our store']"));
        String b = "Welcome to our store";
        Assert.assertEquals(a,b);
    }

       @After
       public void teardown(){
        closeBrowser();
    }
}