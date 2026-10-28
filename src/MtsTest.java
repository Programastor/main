import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MtsTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        // скрыть окно браузера :
        options.addArguments("--headless");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        driver.get("https://www.mts.by/");


        try {
            WebElement cookieBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("cookie-agree")));
            cookieBtn.click();
        } catch (Exception e) {
            System.out.println("Баннер кукисов не появился или уже закрыт.");
        }
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testPaymentBlockTitle() {

        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//section[@class='pay']//h2")
        ));

        assertEquals("ОНЛАЙН ПОПОЛНЕНИЕ\nБЕЗ КОМИССИИ", title.getText(),
                "Текст заголовка блока не совпадает!");
        System.out.println("✅ Пункт 1: Название блока проверено.");
    }

    @Test
    public void testPaymentSystemLogos() {

        List<WebElement> paymentSystems = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.xpath("//section[@class='pay']//ul/li/img")
        ));


        assertEquals(5, paymentSystems.size(), "Количество логотипов не совпадает!");


        for (WebElement element : paymentSystems) {
            assertTrue(element.isDisplayed(), "Один из логотипов не виден на экране!");
        }
        System.out.println("✅ Пункт 2: Логотипы проверены (найдено 5, все видимы).");
    }

    @Test
    public void testServiceDetailsLink() {

        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//section[@class='pay']//a[contains(text(), 'Подробнее о сервисе')]")
        ));

        assertTrue(link.isDisplayed(), "Ссылка не видна!");
        link.click();


        wait.until(ExpectedConditions.urlContains("help/poryadok-oplaty-i-bezopasnost-internet-platezhey"));


        assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/",
                driver.getCurrentUrl(), "Переход по ссылке произошел на неверный адрес!");
        System.out.println("✅ Пункт 3: Ссылка работает, переход состоялся.");
    }

    @Test
    public void testSubmitPaymentForm() {

        WebElement fieldNumberPhone = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("connection-phone")));
        fieldNumberPhone.click();
        fieldNumberPhone.sendKeys("297777777");

        WebElement fieldAmount = driver.findElement(By.id("connection-sum"));
        fieldAmount.click();
        fieldAmount.sendKeys("10");

        WebElement continueButton = driver.findElement(By.xpath("//section[@class='pay']//form[1]//button"));
        assertTrue(continueButton.isEnabled(), "Кнопка 'Продолжить' неактивна!");
        continueButton.click();

        WebElement paymentWindow = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.payment-widget-app"))
        );
        assertTrue(paymentWindow.isDisplayed(), "Окно оплаты не появилось!");
        System.out.println("✅ Пункт 4: Форма заполнена, кнопка сработала.");
    }
}
