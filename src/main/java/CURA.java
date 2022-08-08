import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CURA {
    //DATA
    WebDriver driver ;

    //Ctor

    public CURA() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\admin\\Desktop\\chromedriver.exe");
        this.driver= new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        this.driver.manage().window().maximize();
    }
    //func
    public String openSite(String url){

        this.driver.get(url);
        return this.driver.getCurrentUrl();
    }

    public  String openLoginPage(){
        WebElement loginPageBtn = this.driver.findElement(By.id("btn-make-appointment"));
        loginPageBtn.click();
        WebElement loginLabel = driver.findElement(By.cssSelector("#login > div > div > div.col-sm-12.text-center > h2"));
        return loginLabel.getText();
    }

    public String[] login(){
        String[] urls= new String[2];
        String validUsername = "John Doe";
        String validPassword = "ThisIsNotAPassword";
        WebElement usernameTB= this.driver.findElement(By.id("txt-username"));
        WebElement passwordTB= this.driver.findElement(By.id("txt-password"));
        usernameTB.sendKeys(validUsername);
        passwordTB.sendKeys(validPassword);
        WebElement loginBtn = this.driver.findElement(By.cssSelector("#btn-login"));
        urls[0] = this.driver.getCurrentUrl();
        loginBtn.click();
        urls[1] = this.driver.getCurrentUrl();

        return urls;
    }

    public void quit(){
        this.driver.quit();
    }





}
