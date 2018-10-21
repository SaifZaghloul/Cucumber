package Sections;

import org.openqa.selenium.WebElement;

import Pages.Helpers.ElementFinder;

public class Mirrors {

	private ElementFinder elementFinder;

	public Mirrors() {
		elementFinder = new ElementFinder();
	}

	public WebElement SelectMirror() throws InterruptedException {

		String[] MirrorSelector = { "body > con-app", "#layout > app-header-layout > iron-pages > con-configure",
				"con-sales-group-slider:nth-child(16)", "#optionSlider > con-slide > con-option",
				"div > div.content > div.row > div > div > button > span" };

		WebElement Selector = elementFinder.getElement(MirrorSelector);
		Thread.sleep(5000);

		// elementFinder.ScrollIntoView(Selector);

		// Selector.click();
		return Selector;

	}

	public Float ChosenMirrorPrice() throws InterruptedException {
		String[] Price = { "body>con-app", "#layout > app-header-layout > iron-pages > con-configure",
				"con-sales-group-slider:nth-child(16)", "#optionSlider > con-slide > con-option",
				"div > div.content > div:nth-child(1)" };
		WebElement MirrorPrice = elementFinder.getElement(Price);

		String temp = MirrorPrice.getText().substring(0, MirrorPrice.getText().length() - 2).replace(".", "").replace(",",
				".");

		return Float.valueOf(temp);
	}

	public String ChosenMirrorName() throws InterruptedException {
		String[] Price = { "body>con-app", "#layout > app-header-layout > iron-pages > con-configure",
				"con-sales-group-slider:nth-child(16)", "#optionSlider > con-slide > con-option",
				"div > div.content > div.feature-name" };
		WebElement MirrorName = elementFinder.getElement(Price);

		String temp = MirrorName.getText();

		return temp;
	}

}
