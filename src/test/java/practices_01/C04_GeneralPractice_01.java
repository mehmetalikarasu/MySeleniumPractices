package practices_01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_GeneralPractice_01 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


        //1. ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin (title) “facebook”
        //oldugunu dogrulayin (verify), degilse dogru basligi yazdirin.
        driver.get("https://facebook.com");
        String facebookTitle = driver.getTitle();
        if (facebookTitle.equals("facebook")){
            System.out.println("Title is "+facebookTitle+", Passed");
        }else System.out.println("Failed, Actual Title is: "+facebookTitle);


        //2. Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i
        //yazdirin.
        String actualUrl =driver.getCurrentUrl();//Tekrar kullanacagimiz icin variable'a assign ettim.
        if (actualUrl.contains("facebook")){
            System.out.println("Passed, Url contains facebook");
        }else System.out.println("Failed, Actual url: "+actualUrl);

        //3.  sayfasina gidin.
        driver.get("https://www.walmart.com/");

        //4. Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        String walmartTitle = driver.getTitle();
        if (walmartTitle.contains("Walmart.com")){
            System.out.println("Passed, Title contains Walmart.com");
        }else System.out.println("Failed, Title doesn't contain Walmart.com");

        //5. Tekrar “facebook” sayfasina donun
        driver.navigate().back();

        //6. Sayfayi yenileyin
        driver.navigate().refresh();

        //7. Sayfayi tam sayfa (maximize) yapin
        driver.manage().window().maximize();

        //8. Browser’i kapatin
        driver.close();
    }
}
