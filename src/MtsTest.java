import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.MainPage;
import pages.PaymentPage;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

public class MtsTest {
    private WebDriver driver;
    private MainPage mainPage;

    private final String phone = "297777777";
    private final double sum = 10;
    private final String expectedAmount = String.format(Locale.US, "%.2f BYN", sum);

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        mainPage = new MainPage(driver);
        mainPage.open();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) driver.quit();
    }

    @Test
    public void testBlockTitle() {
        assertEquals("ОНЛАЙН ПОПОЛНЕНИЕ\nБЕЗ КОМИССИИ", mainPage.getBlockTitleText());
    }

    @Test
    public void testPaymentLogos() {
        assertTrue(mainPage.areAllLogosDisplayed(), "Не все логотипы видны!");
        assertEquals(5, mainPage.getPaymentLogosCount());
    }

    @Test
    public void testDetailsLink() {
        mainPage.clickDetailsLink();
        assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", mainPage.getCurrentUrl());
    }

    @Test
    public void testPlaceholdersForTabs() {
        mainPage.selectServiceType("Услуги связи");
        assertEquals("Номер телефона", mainPage.getConnectionPhonePlaceholder());
        assertEquals("Сумма", mainPage.getConnectionAmountPlaceholder());
        assertEquals("E-mail для отправки чека", mainPage.getConnectionEmailPlaceholder());

        mainPage.selectServiceType("Домашний интернет");
        assertEquals("Номер абонента", mainPage.getInternetPhonePlaceholder());

        mainPage.selectServiceType("Рассрочка");
        assertEquals("Номер счета на 44", mainPage.getInstallmentAccountPlaceholder());

        mainPage.selectServiceType("Задолженность");
        assertEquals("Номер счета на 2073", mainPage.getArrearsAccountPlaceholder());
    }

    @Test
    public void testPaymentWidgetDetails() {
        mainPage.selectServiceType("Услуги связи");
        mainPage.fillPaymentForm(phone, String.valueOf(sum));

        PaymentPage paymentPage = mainPage.clickContinue();

        assertTrue(paymentPage.isPaymentWindowDisplayed(), "Виджет оплаты не появился!");

        paymentPage.waitOfVisibilityFrame();

        assertEquals(expectedAmount, paymentPage.getPaymentAmount(), "Сумма на странице не совпадает!");
        assertTrue(paymentPage.getPaymentDetails().contains("375" + phone), "Номер телефона не найден!");

        assertEquals("Номер карты", paymentPage.getCardNumberFieldLabel());
        assertEquals("Срок действия", paymentPage.getCardExpirationFieldLabel());
        assertEquals("CVC", paymentPage.getCardCvcFieldLabel());
        assertEquals("Имя и фамилия на карте", paymentPage.getCardHolderFieldLabel());

        assertTrue(paymentPage.getPaymentSystemIcons().size() >= 5, "Иконки платежных систем не найдены!");
        assertTrue(paymentPage.getPaymentButtonText().contains(expectedAmount), "На кнопке нет суммы!");
    }
}