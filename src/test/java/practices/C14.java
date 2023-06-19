package practices;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C14 extends TestBase{
    //-http://demo.automationtesting.in/Alerts.html sayfasına gidiniz
    //-Alert with OK karşısındaki click the button to display an alert box: butonuna tıklayınız
    //-Çıkan alert üzerindeki yazıyı konsola yazdırınız ve tamam butonuna basınız
    //-Alert with OK & Cancel butonuna basınız ve sonrasında click the button to display a confirm box butonuna basınız
    //-Çıkan alert'te iptal butonuna basınız
    //-Alert with Textbox butonuna basınız ve sonrasında click the button to demonstrate the prompt box butonuna basınız
    //-Çıkan prompt box'a 'isminizi' yazdırınız ve Tamam'a basınız
    //-Çıkan mesajı konsola yazdırınız
    //-Çıkan mesajın 'Hello <isminiz> How are you today' yazdığını doğrulayınız

    @Test
    public void test01() {
        //-http://demo.automationtesting.in/Alerts.html sayfasına gidiniz
        driver.get("http://demo.automationtesting.in/Alerts.html");

        //-Alert with OK karşısındaki click the button to display an alert box: butonuna tıklayınız
        driver.findElement(By.xpath("//*[@class='btn btn-danger']")).click();  // click the button to display an alert box butonu
        bekle(2);

        //-Çıkan alert üzerindeki yazıyı konsola yazdırınız ve tamam butonuna basınız
        System.out.println("Alert yazisi: "+driver.switchTo().alert().getText()); //Alert'deki text'i yazdirdik
        driver.switchTo().alert().accept(); //Tamam'a bastik
        bekle(2);

        //-Alert with OK & Cancel butonuna basınız ve sonrasında click the button to display a confirm box butonuna basınız
        driver.findElement(By.xpath("(//*[@class='analystic'])[2]")).click(); //Alert with OK & Cancel butonu
        bekle(2);
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click(); //click the button to display a confirm box butonu
        bekle(2);

        //-Çıkan alert'te iptal butonuna basınız
        driver.switchTo().alert().dismiss();
        bekle(2);
        //-Alert with Textbox butonuna basınız ve sonrasında click the button to demonstrate the prompt box butonuna basınız
        driver.findElement(By.xpath("(//*[@class='analystic'])[3]")).click(); //Alert with Textbox butonu
        bekle(2);
        driver.findElement(By.xpath("//*[@class='btn btn-info']")).click(); //click the button to demonstrate the prompt box butonu
        bekle(2);

        //-Çıkan prompt box'a 'isminizi' yazdırınız ve Tamam'a basınız
        driver.switchTo().alert().sendKeys("Mehmet Ali");
        bekle(2);
        driver.switchTo().alert().accept();

        //-Çıkan mesajı konsola yazdırınız
        WebElement text = driver.findElement(By.xpath("//*[@id='demo1']"));
        System.out.println("Text: "+text.getText());

        //-Çıkan mesajın 'Hello <isminiz> How are you today' yazdığını doğrulayınız
        Assert.assertEquals("Hello Mehmet Ali How are you today",text.getText());
    }
}
