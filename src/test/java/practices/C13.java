package practices;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class C13 extends TestBase{
    //-Amazon sayfasına gidelim
    //-Arama Kutusundaki Dropdown menuyu yazdıralım
    //-Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil) seçip
    //başlık altındakileri aratalım. Her aramada sayfa başlığını yazdıralım
    //Not: Select Class'ı kullanalım


    @Test
    public void test01() {
        //-Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //-Arama Kutusundaki Dropdown menuyu yazdıralım
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select = new Select(ddm);
        for (WebElement w : select.getOptions()) {
            System.out.println(w.getText());
        }
        //-Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil) seçip
        //başlık altındakileri aratalım. Her aramada sayfa başlığını yazdıralım
        for (int i =1; i<6;i++){
            ddm=driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));//usttekileri tekrar for'un icine yapistiriyoruz
                                                                             //cunku for dongusu icindeyken yukaridakileri okuyamayabilyor.
            Select select1 = new Select(ddm);
            select1.getOptions().get(i).click();
            bekle(2);
            driver.findElement(By.id("nav-search-submit-button")).click();
            System.out.println(driver.getTitle());
            bekle(2);
        }

    }
}
