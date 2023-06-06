package practices;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); //Sayfayi Max buyuklukte yapmak icin...

            //1. Amazon sayfasina gidelim. https://www.amazon.com/
        driver.get("https://amazon.com");

            //2. Sayfa basligini(title) yazdirin
        String actualTitle = driver.getTitle();
        System.out.println("Amazon's Title: "+actualTitle);

            //3. Sayfa basliginin “Amazon” icerdigini test edin
        System.out.print("Sayfa basliginin “Amazon” icerdigini test edin: ");
        if (actualTitle.contains("Amazon")){
            System.out.println("Test Passed");
        }else System.out.println("Test Failed");

            //4. Sayfa adresini(url) yazdirin
        String actualUrl = driver.getCurrentUrl();
        System.out.println("Amazon url: "+actualUrl);

            //5. Sayfa url’inin “amazon” icerdigini test edin.
        System.out.print("Sayfa url’inin “amazon” icerdigini test edin: ");
        if (actualUrl.contains("amazon")){
            System.out.println("Test Passed");
        }else System.out.println("Test Failed");

            //6. Sayfa handle degerini yazdirin
        System.out.println("Sayfa Handle Degeri: "+driver.getWindowHandle());

            //7. Sayfa HTML kodlarinda “Gateway” kelimesi gectigini test edin
        System.out.print("Sayfa HTML kodlarinda “Gateway” kelimesi gectigini test edin: ");
        String actualPageSource = driver.getPageSource();
        if (actualPageSource.contains("Gateway")){
            System.out.println("Test Passed");
        }else System.out.println("test Failed");

            //8. Sayfayi kapatin
        driver.close();
    }
}
