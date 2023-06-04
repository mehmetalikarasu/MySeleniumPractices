package practices_01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C06_WebElementMethodsPractice_01 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Aşağıdaki görevi tamamlayın.
        //a.web sayfasına gidin. https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //b.Search(ara) “city bike”
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("city bike", Keys.ENTER);

        //c. Amazon'da görüntülenen ilgili sonuçların sayısını yazdırın
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String[] arr =sonucYazisi.getText().split(" ");
        System.out.println("Sonuc sayisi: "+arr[2]);

        //d.Sonra karşınıza çıkan ilk sonucun resmine tıklayın
        WebElement ilkSonuc = driver.findElement(By.xpath("(//*[@class='s-image'])[1]"));
        ilkSonuc.click();

        //e. Sayfayi kapatin.
        driver.quit();
    }
}
