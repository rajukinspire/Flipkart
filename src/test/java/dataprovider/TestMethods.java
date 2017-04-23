package dataprovider;

import org.testng.annotations.Test;

public class TestMethods extends ExcelDataProvider{
	
	
	@Test
	public void testCase1(){
		
		System.out.println(rowCount("C:\\Users\\Rajesh\\Desktop\\Demo.xlsx","Sheet1"));
		
		
	}

}
