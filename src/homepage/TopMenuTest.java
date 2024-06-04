package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.ArrayList;
import java.util.List;

public class TopMenuTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


    public void selectMenu(String menu) {
        List<WebElement> names = driver.findElements(By.xpath("//ul[@class='top-menu notmobile']/child::li"));
        for (WebElement e : names) {
            if (e.getText().equalsIgnoreCase(menu)) {
                e.click();
                break;
            }
        }
    }
    /*1.3. create the @Test
    method name verifyPageNavigation.use selectMenu method to
    select the Menu and click on it and verify the page navigation.*/

    @Test
    public void verifyPageNavigation() {
        List<String> names = new ArrayList<>();
        names.add("Computers");
        names.add("electronics");
        names.add("Apparel");
        names.add("Digital downloads");
        names.add("Books");
        names.add("Jewelry");
        names.add("Gift Cards");

        for (int i = 0; i < names.size(); i++) {
            selectMenu(names.get(i));
            String actualmessge = getTextFromElement(By.xpath("//h1[contains(text(),'" + names.get(i) + "')]"));
            Assert.assertEquals("", names.get(i), actualmessge);
        }
    }




    @After
    public void tearDown() {
        closeBrowser();

    }
}
