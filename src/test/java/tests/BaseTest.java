package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import io.qameta.allure.Attachment;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;

    @SuppressWarnings("deprecation")
	@BeforeEach
    public void setUp() {
        // Configuración del WebDriver (en este caso, Chrome)
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();

        // Configuración del tiempo de espera implícito
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        // Cierre del navegador después de cada prueba
        if (driver != null) {
            driver.quit();
        }
    }
    
//    @Attachment(value = "Screenshot", type = "image/png")
//    public byte[] captureScreenshot() {
//        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//    }

}