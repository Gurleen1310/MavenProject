package MavenPractice;

import org.testng.annotations.Test;

public class Testing2 {

	  @Test(groups = "smoke")
	  public void test4() {
		  System.out.println("test 4");
	  }
	  

	  @Test
	  public void test5() {
		  System.out.println("test 5");
	  }
}
