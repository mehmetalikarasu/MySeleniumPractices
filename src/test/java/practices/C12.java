package practices;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C12 {
    //BeforeClass methodu ile driver ı olusturun ve Maximize edin, 15 sn bekletin
    //Before methodunda http://www.google.com adresine gidin
    //Üç farklı test methodu ile;
    //arama kutusuna "The God Father" yazip, cikan sonuc sayisini yazdirin
    //arama kutusuna  "Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
    //arama kutusuna  "Kill Bill" yazip, cikan sonuc sayisini yazdirin
    //After method'u ile başlıkları yazdırınız
    //AfterClass ile browser'ı kapatınız
    static WebDriver driver;

    @BeforeClass
    public static void beforeClass() throws Exception {
        //BeforeClass methodu ile driver ı olusturun ve Maximize edin, 15 sn bekletin
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Before
    public void setUp() throws Exception {
        //Before methodunda http://www.google.com adresine gidin
        driver.get("http://www.google.com");
    }

    //Üç farklı test methodu ile;
    @Test
    public void test01()  {
        //arama kutusuna "The God Father" yazip, cikan sonuc sayisini yazdirin
        driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("The God Father", Keys.ENTER);
        String[] sonucYazisi = driver.findElement(By.xpath("//*[@id='result-stats']")).getText().split(" ");
        System.out.println("The God Father icin cikan sonuc sayisi: "+sonucYazisi[1]);
    }

    @Test
    public void test02()  {
        //arama kutusuna  "Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
        driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("Lord of the Rings", Keys.ENTER);
        driver.navigate().refresh();
        String[] sonucYazisi = driver.findElement(By.xpath("//*[@id='result-stats']")).getText().split(" ");
        System.out.println("Lord of the Rings icin cikan sonuc sayisi: "+sonucYazisi[1]);
    }

    @Test
    public void test03() {
        //arama kutusuna  "Kill Bill" yazip, cikan sonuc sayisini yazdirin
        driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("Kill Bill", Keys.ENTER);
        driver.navigate().refresh();
        String[] sonucYazisi = driver.findElement(By.xpath("//*[@id='result-stats']")).getText().split(" ");
        System.out.println("Kill Bill icin cikan sonuc sayisi: "+sonucYazisi[1]);
    }

    @After
    public void tearDown() throws Exception {
        //After method'u ile başlıkları yazdırınız
        System.out.println("Baslik: "+driver.getTitle());
    }

    @AfterClass
    public static void afterClass() throws Exception {
        //AfterClass ile browser'ı kapatınız
        driver.close();
    }
}
