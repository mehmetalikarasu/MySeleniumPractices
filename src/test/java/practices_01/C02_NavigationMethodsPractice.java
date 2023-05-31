package practices_01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_NavigationMethodsPractice {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); //Sayfayi Max buyuklukte yapmak icin...
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); //sayfanin tum elementlerinin yuklemesini beklemesi icin...

            //1. Youtube ana sayfasina gidelim . https://www.youtube.com/
        driver.get("https://www.youtube.com/");

            //2. Amazon soyfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com/");

            //3. Tekrar YouTube’sayfasina donelim
        driver.navigate().back();

            //4. Yeniden Amazon sayfasina gidelim
        driver.navigate().forward();

            //5. Sayfayi Refresh(yenile) yapalim
        driver.navigate().refresh();

            //6.Sayfayi kapatalim / Tum sayfalari kapatalim
        driver.quit(); // "quit" tum sekmeleri kapatir,"close" ise sadece driverin ustunde oldugu sekmeyi...

    }
}
