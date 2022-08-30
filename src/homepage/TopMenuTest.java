package homepage;

import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.Utility;

import java.util.List;

public class TopMenuTest extends Utility {
    String baseurl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseurl);
    }
                //  1.1 create method with name "selectMenu" it has one parameter name "menu" of type String
               //1.2 This method should click on the menu whatever name is passed as parameter.
        public void selectMenu(String menu) {
        List<WebElement> topMenuName = driver.findElements(By.xpath("//div[@class='header-menu']/ul[1]"));

        for (WebElement name : topMenuName) {
            if (name.getText().equalsIgnoreCase(menu)) {
                name.click();
                break;
            }
        }
    }


     @Test
     public void verifycomputersnavigation(){
        selectMenu("Computers");
        verifyText("Computers",By.xpath("//div[@class='header-menu']/ul[1]/li[1]/a"),"Computers");

     }
     @Test
     public void verifyelectronicsnavigation(){
        selectMenu("Electronics");
        verifyText("Electronics",By.xpath("//div[@class='header-menu']/ul[1]/li[2]/a"),"Electronics");
     }
     @Test
     public void verifyApparelnavigation(){
        selectMenu("Apparel");
        verifyText("Apparel",By.xpath("//div[@class='header-menu']/ul[1]/li[3]/a"),"Apparel");
     }
    @Test
    public void verifyDigitaldownloadnavigation(){
        selectMenu("Digital downloads");
        verifyText("Digital downloads",By.xpath("//div[@class='header-menu']/ul[1]/li[4]/a"),"Digital downloads");
    }
    @Test
    public void verifybooksnavigation(){
        selectMenu("Books");
        verifyText("Books",By.xpath("//div[@class='header-menu']/ul[1]/li[5]/a"),"Books");
    }
    @Test
    public void verifyjewelrynavigation(){
        selectMenu("Jewelry");
        verifyText("Jewelry",By.xpath("//div[@class='header-menu']/ul[1]/li[6]/a"),"Jewelry");
    }
    @Test
    public void verifygiftcardsnavigation(){
        selectMenu("Gift Cards");
        verifyText("Gift Cards",By.xpath("//div[@class='header-menu']/ul[1]/li[7]/a"),"Gift Cards");
    }




    @After
    public void teardown() {
        closeBrowser();
    }
}