package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Generic.Utility;

public class CartPage {

    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//tbody[@id='tbodyid']/tr/td[2]")
    WebElement productName;

    @FindBy(xpath = "//tbody[@id='tbodyid']/tr/td[3]")
    WebElement productPrice;

    @FindBy(xpath = "//button[text()='Place Order']")
    WebElement placeButton;

    @FindBy(id = "name")
    WebElement name;

    @FindBy(id = "country")
    WebElement country;

    @FindBy(id = "city")
    WebElement city;

    @FindBy(id = "card")
    WebElement card;

    @FindBy(id = "month")
    WebElement month;

    @FindBy(id = "year")
    WebElement year;

    @FindBy(xpath = "//div[contains(@class,'sweet-alert')]")
    WebElement message;

    @FindBy(xpath = "//button[text()='Purchase']")
    WebElement purchaseButton;

    public void getProductDetails() {
        System.out.println("Product name is: " + productName.getText());
        System.out.println("Product price is: " + productPrice.getText());
        Utility.getScreenshot(driver, "productDetails");
    }

    public void placeOrder(String n, String coun, String ci, String ca, String mon, String ye) {
        placeButton.click();
        name.sendKeys(n);
        country.sendKeys(coun);
        city.sendKeys(ci);
        card.sendKeys(ca);
        month.sendKeys(mon);
        year.sendKeys(ye);
        Utility.getScreenshot(driver, "purchaseDetails");

        purchaseButton.click();

        System.out.println("Message: " + message.getText());
        Utility.getScreenshot(driver, "finalMessage");
    }
}
