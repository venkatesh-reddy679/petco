package com.testCase;

import java.io.IOException;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.testPage.PetCoPage;
import com.utilities.WrapperClass;

public class PetCoTest extends WrapperClass {

	@Test
	public void f() throws InterruptedException, IOException {

		launchBrowser("chrome", "https://www.petco.com/");
		
		PetCoPage pcp = new PetCoPage(driver);

		pcp.fishAndFood();
		pcp.sortAndName();
		pcp.priceSort();
		pcp.writeExcel();
		screenshot();
		driver.close();

	}
}
