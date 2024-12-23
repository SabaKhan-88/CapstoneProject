package com.TestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseClass{
  @Test(priority=1)
  public void validateListOfOptions()
  {
	  int total=hp.getTotalOptions();
	  Assert.assertEquals(total, 8);
	  System.out.println("Total Options are: "+total);
  }
  
  
  @Test(priority=2)
  public void validateOptions()
  {
	  
	  hp.getOptionsText();
  }
  
  @Test(priority=3)
  public void validateSignIn()
  {
	  
	  hp.doSignUp(un,"test123");
  }
  
  @Test(priority=4)
  public void validateLogin()
  {
	  
	  hp.doLogin("priyanka19","test123");
	  
  }
  
}
