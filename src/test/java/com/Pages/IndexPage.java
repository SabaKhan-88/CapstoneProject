package com.Pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Generic.Utility;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IndexPage {

    WebDriver driver;

    public IndexPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='list-group']//a")
    List<WebElement> allCategory;

    @FindBy(xpath = "//div[@id='tbodyid']//h4//a")
    List<WebElement> allOptions;

    @FindBy(linkText = "Add to cart")
    WebElement addToCart;

    @FindBy(id = "cartur")
    WebElement cartBtn;

    public void getAllCategories() {
        for (WebElement i : allCategory) {
            System.out.println(i.getText());
        }
    }

    public void getAllOptions() {
        try {
            for (WebElement i : allCategory) {
                System.out.println("Category: " + i.getText());
                System.out.println("Options for the same:");

                for (WebElement j : allOptions) {
                    System.out.println(j.getText());
                }
            }
        } catch (StaleElementReferenceException s) {
            System.out.println("Page refreshed or elements changed. Please retry.");
        }
    }

    public String getAppUrl() {
        return driver.getCurrentUrl();
    }

    public void addProductToCart(String category, String pname) {
        try {
            for (WebElement i : allCategory) {
                if (i.getText().contains(category)) {
                    i.click();
                    break;
                }
            }

            Utility.getScreenshot(driver, "productCategory");

            for (WebElement i : allOptions) {
                if (i.getText().contains(pname)) {
                    i.click();
                    break;
                }
            }

            Utility.getScreenshot(driver, "productSelected");

            addToCart.click();

            // Use WebDriverWait instead of Thread.sleep
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.alertIsPresent());

            Utility.getScreenshot(driver, "productAddedAlert");

            Alert alt = driver.switchTo().alert();
            System.out.println("Alert Text is: " + alt.getText());
            alt.accept();

        } catch (StaleElementReferenceException s) {
            System.out.println("Stale Element Exception occurred.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public CartPage launchCartPage() {
        cartBtn.click();
        Utility.getScreenshot(driver, "cartPage");
        return new CartPage(driver);
    }
}
