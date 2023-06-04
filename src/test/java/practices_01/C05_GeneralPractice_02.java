package practices_01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_GeneralPractice_02 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1. Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını doğrulayın
        //(verify), eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
        driver.get("https://youtube.com");
        String actualYoutubeTitle = driver.getTitle();
        String expectedYoutubeTitle = "youtube";

        if (actualYoutubeTitle.equals(expectedYoutubeTitle)){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED, Actual Title is: "+actualYoutubeTitle);

        //2. Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa doğru
        //URL'yi yazdırın.
        String actualYoutubeUrl = driver.getCurrentUrl();
        if (actualYoutubeUrl.contains("youtube")){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED, Actual url is: "+actualYoutubeUrl);

        //3. Daha sonra Amazon sayfasina gidin https://www.amazon.com/
        driver.get("https://amazon.com");

        //4. Youtube sayfasina geri donun
        driver.navigate().back();

        //5. Sayfayi yenileyin
        driver.navigate().refresh();

        //6. Amazon sayfasina donun
        driver.navigate().forward();

        //7. Sayfayi tamsayfa yapin
        driver.manage().window().fullscreen();

        //8. Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın, Yoksa doğru
        //başlığı(Actual Title) yazdırın.
        String actualAmazonTitle = driver.getTitle();
        String expectedAmazonTitle = "Amazon";
        if (actualAmazonTitle.contains(expectedAmazonTitle)){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED, Actual title is: "+actualAmazonTitle);

        //9.Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse doğru
        //URL'yi yazdırın
        String actualAmazonUrl =driver.getCurrentUrl();
        if (actualAmazonUrl.equals("https://www.amazon.com/")){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED, Actual url is: "+actualAmazonUrl);

        //10.Sayfayi kapatin
        driver.close();

    }
}
