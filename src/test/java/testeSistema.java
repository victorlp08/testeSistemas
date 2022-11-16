import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class testeSistema {
    WebDriver webDriver;

    @BeforeAll
    public void driverSetup() {
        System.setProperty("webdriver.chrome.driver", "src/test/driver/chromedriver.exe");
    }

    @BeforeEach
    public void setup() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @AfterEach
    public void closeDriver() {
        webDriver.close();
    }

    @Test
    public void esperaAbrirSiteGlobosportTeste() {
        webDriver.get("https://ge.globo.com/");
        Assertions.assertEquals("https://ge.globo.com/", webDriver.getCurrentUrl());
    }

    @Test
    public void esperaAbrirMateriaTeste() throws InterruptedException {
        webDriver.get("https://ge.globo.com/");
        webDriver.findElement(By.xpath("//*[@id=\"glb-main-home\"]/div[2]/div/div/div/div/div[2]/div/a")).click();
        Thread.sleep(5000);
        Assertions.assertEquals("https://interativos.ge.globo.com/futebol/copa-do-mundo/especial/rota-dos-convocados-2022", webDriver.getCurrentUrl());
    }

    @Test
    public void esperaPesquisarSportTeste() {
        webDriver.get("https://ge.globo.com/");
        webDriver.findElement(By.xpath("//*[@id=\"busca-campo\"]")).sendKeys("sport", Keys.ENTER);
        Assertions.assertTrue(webDriver.getCurrentUrl().contains("sport"), webDriver.getCurrentUrl());
    }
}
