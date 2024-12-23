package com.TestCases;

import org.testng.annotations.Test;

import com.Pages.CartPage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class IndexPageTest extends BaseClass 
{
	@BeforeClass
	public void pageSetup()
	{
		ip=hp.doLogin("priyanka19","test123");
	}
	
	
  @Test(priority=1)
  public void validateCategories() 
  {
	  ip.getAllCategories();
  }
  
  @Test(priority=2)
  public void validateAllProducts() 
  {
	  ip.getAllOptions();
  }
  
  @Test(priority=3)
  public void addProductToCart()
  {
	  ip.addProductToCart("Phones","Samsung galaxy s7");
  }
  
  @Test(priority=4)
  public void validateLaunchOfCartPage()
  {
	  ip.launchCartPage();
	  
  }
  
}
