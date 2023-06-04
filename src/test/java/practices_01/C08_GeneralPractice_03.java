package practices_01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C08_GeneralPractice_03 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

        //2- Browseri tam sayfa yapin
        driver.manage().window().maximize();

        //3.- Sayfayi “refresh” yapin
        driver.navigate().refresh();

        //4. Sayfa basliginin “Spend less” ifadesi icerdigini test edin
        String actualTitle = driver.getTitle();
        String expectedTitleContain = "Spend less";
        if (actualTitle.contains(expectedTitleContain)) {
            System.out.println("Test PASSED, Title contains Spend Less");
        }else System.out.println("Test FAILED, Title does not contain Spend Less");

        //5. Gift Cards sekmesine basin
        driver.findElement(By.xpath("(//*[@class='nav-a  '])[4]")).click();

        //6. Birthday butonuna basin
        driver.findElement(By.xpath("(//*[@class='bxc-grid__column  bxc-grid__column--2-of-12   bxc-grid__column--light'])[2]")).click();

        //7. Best Seller bolumunden ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@class='a-truncate-cut'])[1]")).click();

        //8. Gift card details’den 25 $’i secin
        driver.findElement(By.xpath("(//*[@class='a-button a-button-toggle'])[1]")).click();

        //9-Urun ucretinin 25$ oldugunu test edin
        String actualPrice = driver.findElement(By.xpath("//*[@class='a-color-price a-text-bold']")).getText();
        String expectedPrice ="$25.00";
        if (actualPrice.equals(expectedPrice)){
            System.out.println("Test PASSED, Price is "+actualPrice);
        }else System.out.println("Test FAILED, Price is "+actualPrice);

        //10-Sayfayi kapatin
        driver.close();
    }
}
