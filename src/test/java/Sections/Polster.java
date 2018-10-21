package Sections;

import org.openqa.selenium.WebElement;

import Pages.Helpers.ElementFinder;

public class Polster {

	private ElementFinder elementFinder;

	public Polster() {
		elementFinder = new ElementFinder();
	}

	/*
	public void slidePolster() throws InterruptedException {
		String[] PolsterSlider = { "body>con-app", "#layout > app-header-layout > iron-pages > con-configure","con-sales-group-slider:nth-child(20)","con-paginator","#dots > li:nth-child(2) > span" };
		WebElement slider = elementFinder.getElement(PolsterSlider);
		
		Thread.sleep(3000);
		slider.click();
		
	}
	/*/
	public WebElement SelectPolster() throws InterruptedException {

		String[] PolsterSelector = { "body > con-app", "#layout > app-header-layout > iron-pages > con-configure",
				"con-sales-group-slider:nth-child(20)", "#optionSlider > con-slide:nth-child(3) > con-option",
				"div > div.content > div.row > div > div > button > span" };

		WebElement Selector = elementFinder.getElement(PolsterSelector);
		Thread.sleep(6000);

		// elementFinder.ScrollIntoView(Selector);

		// Selector.click();
		return Selector;

	}

	public boolean InitialPolsterSelected() throws InterruptedException {
		String[] Confirm = { "body>con-app", "#layout > app-header-layout > iron-pages > con-configure",
				"con-sales-group-slider:nth-child(20)", "#optionSlider > con-slide:nth-child(3) > con-option",
				"div > div.content > div.row > div > div > button" };
		WebElement confirmPolster = elementFinder.getElement(Confirm);

		if (confirmPolster.getAttribute("class").contains("selected"))
			return true;
		else
			return false;

	}

	public Float InitPolsterPrice() throws InterruptedException {
		String[] Price = { "body>con-app", "#layout > app-header-layout > iron-pages > con-configure",
				"con-sales-group-slider:nth-child(20)", "#optionSlider > con-slide:nth-child(3) > con-option",
				"div > div.content > div:nth-child(1)" };
		WebElement PolsterPrice = elementFinder.getElement(Price);
		elementFinder.ScrollIntoView(PolsterPrice);
		Thread.sleep(3000);

		// System.out.println(ColorPrice.getText());

		String temp = PolsterPrice.getText().substring(0, PolsterPrice.getText().length() - 2).replace(".", "").replace(",",
				".");

		return Float.valueOf(temp);
	}

	public Float ChosenPolsterPrice() throws InterruptedException {
		String[] Price = { "body>con-app", "#layout > app-header-layout > iron-pages > con-configure",
				"con-sales-group-slider:nth-child(20)", "#optionSlider > con-slide:nth-child(3) > con-option",
				"div > div.content > div:nth-child(1)" };
		WebElement PolsterPrice = elementFinder.getElement(Price);

		elementFinder.ScrollIntoView(PolsterPrice);

		String temp = PolsterPrice.getText().substring(0, PolsterPrice.getText().length() - 2).replace(".", "").replace(",",
				".");

		return Float.valueOf(temp);
	}

	public String ChosenPolsterName() throws InterruptedException {
		String[] Price = { "body>con-app", "#layout > app-header-layout > iron-pages > con-configure",
				"con-sales-group-slider:nth-child(20)", "#optionSlider > con-slide:nth-child(3) > con-option",
				"div > div.content > div.feature-name" };
		WebElement PolsterName = elementFinder.getElement(Price);

		String temp = PolsterName.getText();

		return temp;
	}

}