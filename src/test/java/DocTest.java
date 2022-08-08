import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.Suite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DocTest {

    @Test
    public void loginTest(){
        CURA cura1 = new CURA();

        String expectedUrl= "https://katalon-demo-cura.herokuapp.com/";
        String actualUrl = cura1.openSite(expectedUrl);
        Assert.assertEquals(actualUrl , expectedUrl);
        System.out.println("smoke test --- > pass");

        String actualLabel = cura1.openLoginPage();
        String expectedLabel = "Login";
        Assert.assertEquals(actualLabel,expectedLabel);
        System.out.println("page test --- > pass");

        String[] urls = cura1.login();
        Assert.assertNotEquals(urls[0],urls[1]);
        System.out.println("login test--- > pass");
        cura1.quit();
    }

    @Test
    public void pTest(){
        CURA c2 = new CURA();
        c2.openSite("https://katalon-demo-cura.herokuapp.com/");
        c2.openLoginPage();
        c2.login();

        String date = c2.makeApp();
        date= date.replace('/','0');// 2400802022
        var dateInInt= (Long.parseLong(date) / 100000000);
        Assert.assertEquals(dateInInt , 24);
        c2.quit();
    }



}
