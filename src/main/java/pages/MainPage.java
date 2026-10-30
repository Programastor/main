package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // Локаторы блока оплаты
    private final By blockTitle = By.xpath("//section[@class='pay']//h2");
    private final By paymentLogos = By.xpath("//section[@class='pay']//ul/li/img");
    private final By detailsLink = By.xpath("//section[@class='pay']//a[contains(text(), 'Подробнее о сервисе')]");
    private final By cookieAgreeButton = By.id("cookie-agree");

    // Выпадающий список услуг
    private final By serviceTypeButton = By.xpath("//button[@class='select__header']");
    private final By serviceTypeOption = By.xpath("//p[@class='select__option']");

    // Поля ввода
    private final By connectionPhoneField = By.id("connection-phone");
    private final By connectionAmountField = By.id("connection-sum");
    private final By connectionEmailField = By.id("connection-email");
    private final By continueButton = By.xpath("//section[@class='pay']//form[1]//button");

    private final By internetPhoneField = By.id("internet-phone");
    private final By installmentAccountField = By.id("score-instalment");
    private final By arrearsAccountField = By.id("score-arrears");

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Открытие главной страницы")
    public void open() {
        driver.get("https://www.mts.by/");
    }

    @Step("Закрытие баннера cookies")
    public void closeCookieBanner() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(cookieAgreeButton)).click();
        } catch (Exception ignored) {}
    }

    @Step("Получение текста заголовка блока 'Онлайн пополнение'")
    public String getBlockTitleText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(blockTitle)).getText();
    }

    @Step("Получение количества логотипов платежных систем")
    public int getPaymentLogosCount() {
        return driver.findElements(paymentLogos).size();
    }

    @Step("Проверка видимости всех логотипов")
    public boolean areAllLogosDisplayed() {
        List<WebElement> logos = driver.findElements(paymentLogos);
        for (WebElement logo : logos) {
            if (!logo.isDisplayed()) return false;
        }
        return true;
    }

    @Step("Клик по ссылке 'Подробнее о сервисе'")
    public void clickDetailsLink() {
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(detailsLink));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        try {
            link.click();
        } catch (org.openqa.selenium.TimeoutException ex) {
            ((JavascriptExecutor) driver).executeScript("window.stop();");
        }
    }

    @Step("Получение текущего URL")
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    @Step("Выбор типа услуги: {serviceType}")
    public void selectServiceType(String serviceType) {
        wait.until(ExpectedConditions.elementToBeClickable(serviceTypeButton)).click();
        List<WebElement> options = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(serviceTypeOption));

        for (WebElement option : options) {
            if (option.getText().equals(serviceType)) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);
                try { Thread.sleep(300); } catch (InterruptedException e) {}
                break;
            }
        }
    }

    @Step("Получение плейсхолдера поля телефона (Услуги связи)")
    public String getConnectionPhonePlaceholder() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(connectionPhoneField)).getAttribute("placeholder");
    }

    @Step("Получение плейсхолдера поля суммы (Услуги связи)")
    public String getConnectionAmountPlaceholder() {
        return driver.findElement(connectionAmountField).getAttribute("placeholder");
    }

    @Step("Получение плейсхолдера поля email (Услуги связи)")
    public String getConnectionEmailPlaceholder() {
        return driver.findElement(connectionEmailField).getAttribute("placeholder");
    }

    @Step("Получение плейсхолдера поля телефона (Домашний интернет)")
    public String getInternetPhonePlaceholder() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(internetPhoneField)).getAttribute("placeholder");
    }

    @Step("Получение плейсхолдера поля счета (Рассрочка)")
    public String getInstallmentAccountPlaceholder() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(installmentAccountField)).getAttribute("placeholder");
    }

    @Step("Получение плейсхолдера поля счета (Задолженность)")
    public String getArrearsAccountPlaceholder() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(arrearsAccountField)).getAttribute("placeholder");
    }

    @Step("Ввод номера телефона: {phone} и суммы: {amount}")
    public void fillPaymentForm(String phone, String amount) {
        WebElement phoneInput = wait.until(ExpectedConditions.visibilityOfElementLocated(connectionPhoneField));
        phoneInput.clear();
        phoneInput.sendKeys(phone);

        WebElement amountInput = driver.findElement(connectionAmountField);
        amountInput.clear();
        amountInput.sendKeys(amount);
    }

    @Step("Клик по кнопке 'Продолжить'")
    public PaymentPage clickContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
        return new PaymentPage(driver);
    }
}