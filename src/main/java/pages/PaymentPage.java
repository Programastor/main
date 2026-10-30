package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PaymentPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // Локаторы виджета и Iframe
    private final By paymentWindow = By.cssSelector("div.payment-widget-app");
    private final By paymentFrame = By.xpath("//iframe[@class='payment-widget-iframe']");
    private final By paymentFrameContainer = By.cssSelector("div.app-wrapper__content");

    // Данные внутри фрейма
    private final By paymentAmount = By.xpath("//div[@class='pay-description__cost']/span");
    private final By paymentDetails = By.xpath("//div[@class='pay-description__text']/span");
    private final By payButton = By.xpath("//app-card-page//button[@type='submit']");
    private final By paymentSystemIcons = By.xpath("//div[contains(@class, 'cards-brands__container')]//img");

    // Лейблы полей карты
    private final By cardNumberFieldLabel = By.xpath("//input[@id='cc-number']/following-sibling::label");
    private final By cardExpirationFieldLabel = By.xpath("//input[@formcontrolname='expirationDate']/following-sibling::label");
    private final By cardCvcFieldLabel = By.xpath("//input[@formcontrolname='cvc']/following-sibling::label");
    private final By cardHolderFieldLabel = By.xpath("//input[@formcontrolname='holder']/following-sibling::label");

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Ожидание загрузки виджета оплаты")
    public boolean isPaymentWindowDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(paymentWindow)).isDisplayed();
    }

    @Step("Переключение внутрь iframe виджета оплаты")
    public void waitOfVisibilityFrame() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(paymentFrame));
        wait.until(ExpectedConditions.visibilityOfElementLocated(paymentFrameContainer));
    }

    @Step("Получение суммы к оплате")
    public String getPaymentAmount() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(paymentAmount)).getText();
    }

    @Step("Получение деталей платежа (номер телефона)")
    public String getPaymentDetails() {
        return driver.findElement(paymentDetails).getText();
    }

    @Step("Получение текста с кнопки оплаты (с суммой)")
    public String getPaymentButtonText() {
        return driver.findElement(payButton).getText().trim();
    }

    @Step("Проверка лейбла 'Номер карты'")
    public String getCardNumberFieldLabel() {
        return driver.findElement(cardNumberFieldLabel).getText();
    }
    public String getCardExpirationFieldLabel() {
        return driver.findElement(cardExpirationFieldLabel).getText();
    }
    public String getCardCvcFieldLabel() {
        return driver.findElement(cardCvcFieldLabel).getText();
    }
    public String getCardHolderFieldLabel() {
        return driver.findElement(cardHolderFieldLabel).getText();
    }

    public List<WebElement> getPaymentSystemIcons() {
        return driver.findElements(paymentSystemIcons);
    }
}