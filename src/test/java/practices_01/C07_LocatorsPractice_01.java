package practices_01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_LocatorsPractice_01 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Asagidaki testi text’leri kullanarak locate edin
        //1. https://the-internet.herokuapp.com/add_remove_elements/ adresine
        //gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        //2. Add Element butonuna basin
        WebElement addElementButton = driver.findElement(By.xpath("//*[@onclick='addElement()']"));
        addElementButton.click();

        //3. Delete butonu’nun gorunur oldugunu test edin
        WebElement deleteButton = driver.findElement(By.xpath("//*[@onclick='deleteElement()']"));
        System.out.println("Is Delete Button displayed ? "+deleteButton.isDisplayed());

        //4. Delete tusuna basin
        deleteButton.click();

        //5. “Add/Remove Elements” yazisinin gorunur oldugunu test edin
        WebElement AddRemoveYazisi = driver.findElement(By.xpath("//h3"));
        System.out.println("Is Add/Remove Elements displayed ? "+addElementButton.isDisplayed());

        //6. Sayfayi kapatin
        driver.close();
    }
}
