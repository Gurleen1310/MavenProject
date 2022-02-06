package MavenPractice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Testing3 {
	
	SoftAssert softAssert = new SoftAssert();
	
	
	
@Test(priority = 1,groups = "smoke")
public void createUser() {
	System.out.println("I am in home test");
	System.out.println("Before Assertion");
	Assert.assertTrue(4>3,"Verifying Element");//we use regular asserty in industry
	System.out.println("After Assertion");
	Assert.assertEquals("abc", "abc");

}

@Test(priority = 2, dependsOnMethods = "createUser")
public void editUser() {
	System.out.println("Before assertion");
	softAssert.assertTrue(4>3 , "verifying Elemnet");
	System.out.println("(after assertion");
	softAssert.assertAll();//similar to error collector 
	
}

@Test(priority = 3, dependsOnMethods= "editUser")//depends on skips this test bcoz test2 failed
public void deleteUser() {
	System.out.println("I am in end test");
	System.out.println("Before assertion");
	softAssert.assertTrue(4>3 , "verifying Elemnet1");
	System.out.println("(after assertion");
	softAssert.assertEquals("abc", "abc");
	System.out.println("(after second assertion");
	softAssert.assertAll();
	
}


}
