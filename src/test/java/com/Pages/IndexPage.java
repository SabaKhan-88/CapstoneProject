package com.Pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Generic.Utility;

public class IndexPage
{

	WebDriver driver;
	
	public IndexPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//div[@class='list-group']//a")
	List<WebElement> allCategory;
	
	@FindBy(xpath="//div[@id='tbodyid']//h4//a")
	List<WebElement> allOptions;
	
	@FindBy(linkText="Add to cart")
	WebElement addtoCart;
	
	@FindBy(id="cartur")
	WebElement cartBtn;
	
	public void getAllCategories()
	{
		for(WebElement i: allCategory)
		{
			System.out.println(i.getText());
		}
	}
	
	public void getAllOptions()
	{
		try {
		for(WebElement i: allCategory)
		{
			System.out.println("Category: "+i.getText());
		
			System.out.println("Options for the same");
			
			for(WebElement j:allOptions)
			{
				System.out.println(j.getText());
			}
		}
		}catch(StaleElementReferenceException s)
		{
			System.out.println("Page refresh....");
		}
	}
	public String getAppUrl()
	{
		return driver.getCurrentUrl();
	}
	
	
	public void addProductToCart(String category,String pname)
	{
		try {
		for(WebElement i: allCategory)
		{
			if(i.getText().contains(category))
			{
				i.click();
				break;
			}
			
		}
		Utility.getScreenshot(driver,"productcategaory");
		
		for(WebElement i: allOptions)
		{
			if(i.getText().contains(pname))
			{
				i.click();
				break;
				
		}
		}
		Utility.getScreenshot(driver,"productadded");
		addtoCart.click();
		Thread.sleep(2000);
		Utility.getScreenshot(driver,"productaddedalert");

		Alert alt=driver.switchTo().alert();
		System.out.println("Alert Text is: "+alt.getText());
		alt.accept();
		}catch(StaleElementReferenceException s)
		{
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			}
	
	public CartPage launchCartPage()
	{
		cartBtn.click();
		Utility.getScreenshot(driver,"cartpage");

		return new CartPage(driver);
	}
	
}
