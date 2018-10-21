package Sections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Pages.Helpers.ElementFinder;
import test.java.TCs.LibraryTest;

public class General {

	private ElementFinder elementFinder;

	public General() {
		elementFinder = new ElementFinder();
	}

	public void DismissCookie() throws InterruptedException {
		String[] Selectors = { "body > con-app", "con-overlay-cookies",
				"con-overlay > div > div > div > div.col-l-3.col-m-12.col-s-12 > div > div > button" };
		WebElement Cookie = elementFinder.getElement(Selectors);
		Cookie.click();
	}

	public void ModelSelection() throws InterruptedException {
		String[] ModelSelection = { "body>con-app", "#layout > app-header-layout > iron-pages > con-404", "div > a" };
		WebElement Models = elementFinder.getElement(ModelSelection);
		Models.click();
	}

	public void ChooseCar() throws InterruptedException {
		LibraryTest.driver.findElement(By.cssSelector("#main > ul > li:nth-child(2) > ul > li:nth-child(1) > a")).click();
	}

	public void PriceTab() throws InterruptedException {
		String[] Tabs = { "body>con-app",
				"#layout > app-header-layout > app-header > app-toolbar:nth-child(1) > div > div > div.navigation-menu > iron-selector > a:nth-child(3)" };
		WebElement PriceTab = elementFinder.getElement(Tabs);
		// PriceTab.click();
		String url = LibraryTest.driver.getCurrentUrl().replace("configure", "price");
		LibraryTest.driver.get(url);
	}

	public void ConfigTab() throws InterruptedException {
		String[] Tabs = { "body>con-app",
				"#layout > app-header-layout > app-header > app-toolbar:nth-child(1) > div > div > div.navigation-menu > iron-selector > a:nth-child(2)" };
		WebElement ConfigTab = elementFinder.getElement(Tabs);
		// ConfigTab.click();
		//return ConfigTab;
		String url = LibraryTest.driver.getCurrentUrl().replace("price", "configure");
		LibraryTest.driver.get(url);
	}

	public Float GetPrice() throws InterruptedException {
		String[] PriceF = { "body > con-app", "#layout > app-header-layout > iron-pages > con-price",
				"div > div > con-price-details",
				"#summaryPriceSection > section.price-summary > div > div.value.col-s-5.col-m-4.col-l-6.align-right" };
		WebElement Price = elementFinder.getElement(PriceF);
		return Float.valueOf(Price.getText().substring(0, Price.getText().length()-2).replace(".", "").replace(",", "."));
	}

}
