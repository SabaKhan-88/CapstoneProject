package com.Pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Generic.Utility;

public class HomePage
{
	
	private WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath="//ul[@class='navbar-nav ml-auto']//li//a")
	List<WebElement> menu;
	
	@FindBy(id="signin2")
	WebElement signIn;
	
	@FindBy(id="sign-username")
	WebElement signUn;
	
	@FindBy(id="sign-password")
	WebElement signPass;
	
	@FindBy(xpath="//button[normalize-space()='Sign up']")
	WebElement signBtn;
	
	@FindBy(id="login2")
	WebElement loginLink;
	
	@FindBy(id="loginusername")
	WebElement loginUn;
	
	@FindBy(id="loginpassword")
	WebElement loginPass;
	
	@FindBy(xpath="//button[normalize-space()='Log in']")
	WebElement loginBtn;
	
	@FindBy(id="cartur")
	WebElement cartLink;
	
	@FindBy(id="nameofuser")
	WebElement nameofUser;
	
	public int getTotalOptions()
	{
		return menu.size();
	}
	
	
	public void getOptionsText()
	{
		for(WebElement i:menu)
		{
			System.out.println(i.getText());
		}
	}
	public String getAppUrl()
	{
		return driver.getCurrentUrl();
	}
	
	public void doSignUp(String un,String psw)
	{
		signIn.click();
		signUn.sendKeys(un);
		signPass.sendKeys(psw);
		Utility.getScreenshot(driver,"SignUp");
		signBtn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Utility.getScreenshot(driver,"SignUpAlert");
		Alert alt=driver.switchTo().alert();
		System.out.println("Alert text is: "+alt.getText());
		alt.accept();
		
	}
	
	
	
	public IndexPage doLogin(String un,String psw)
	{
		loginLink.click();
		loginUn.sendKeys(un);
		loginPass.sendKeys(psw);
		Utility.getScreenshot(driver,"login");
		loginBtn.click();
	
		System.out.println("User logged In: "+nameofUser.getText());
		return new IndexPage(driver);

	}
	
	
	public void launchCartPage()
	{
		cartLink.click();
	}
}
