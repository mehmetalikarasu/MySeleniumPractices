package practices;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //1. Amazon soyfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //2. Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println("Size: "+driver.manage().window().getSize());
        System.out.println("Konum: "+driver.manage().window().getPosition());

        //3. Sayfayi simge durumuna getirin
        driver.manage().window().minimize();

        //4. simge durumunda 3 saniye bekleyip sayfayi maximize yapin
        Thread.sleep(3000); //3 saniye bekletir.
        driver.manage().window().maximize();

        //5. Sayfanin konumunu ve boyutlarini maximize durumunda yazdirin
        System.out.println("Maximize Size: "+driver.manage().window().getSize());
        System.out.println("Maximize Konum: "+driver.manage().window().getPosition());

        //6. Sayfayi fullscreen yapin
        driver.manage().window().fullscreen();

        //7. Sayfanin konumunu ve boyutlarini fullscreen durumunda yazdirin
        System.out.println("Fullscreen Size: "+driver.manage().window().getSize());
        System.out.println("Fullscreen Konum: "+driver.manage().window().getPosition());

        //8. Sayfayi kapatin
        driver.close();
    }
}
