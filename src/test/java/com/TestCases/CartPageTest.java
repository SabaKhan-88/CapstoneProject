package com.TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CartPageTest extends BaseClass
{
	@BeforeClass
	public void pageSetup()
	{
		ip=hp.doLogin("priyanka19","test123");
		ip.addProductToCart("Phones","Samsung galaxy s7");
		cp=ip.launchCartPage();
	}


  @Test(priority=1)
  public void getProductDetails()
  {
	  cp.getProductDetails();
  }

  @Test(priority=2)
  public void validateOrder()
  {
	  cp.placeOrder("Priyanka","India","Pune","card123","Dec","2025");

  }
}
