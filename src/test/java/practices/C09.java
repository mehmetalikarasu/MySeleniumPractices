package practices;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C09 {
    /*
       - Before methodu ile drive'i olusturup ayarlamalari yapiniz
       - ebay sayfasına gidiniz
       - electronics bölümüne tıklayınız
       - Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım
       - Her sayfanın sayfa başlığını yazdıralım
       - After methodu ile sayfayı kapatalım
    */
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://ebay.com");
        driver.findElement(By.xpath("(//*[@href='https://www.ebay.com/b/Electronics/bn_7000259124'])[2]")).click();
        List<WebElement> heightAndWidthIs225 = driver.findElements(By.xpath("//*[@height='225'] | //*[@width='225']"));
        for (int i =0;i<heightAndWidthIs225.size();i++){
            heightAndWidthIs225 = driver.findElements(By.xpath("//*[@height='225'] | //*[@width='225']"));
            heightAndWidthIs225.get(i).click();
            System.out.println(driver.getTitle());
            Thread.sleep(1000);
            driver.navigate().back();
            Thread.sleep(1000);
        }

    }

    @After
    public void tearDown() {
        driver.close();
    }
}
