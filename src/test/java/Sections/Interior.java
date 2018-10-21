package Sections;

import org.openqa.selenium.WebElement;

import Pages.Helpers.ElementFinder;

public class Interior {

	public ElementFinder elementFinder;

	public Interior() {
		elementFinder = new ElementFinder();
	}

	public WebElement SelectInterior() throws InterruptedException {

		String[] InteriorSelector = { "body > con-app", "#layout > app-header-layout > iron-pages > con-configure",
				"con-sales-group-slider:nth-child(24)", "#optionSlider > con-slide:nth-child(3) > con-option",
				"div > div.content > div.row > div > div > button" };

		WebElement Selector = elementFinder.getElement(InteriorSelector);
		Thread.sleep(6000);

		// elementFinder.ScrollIntoView(Selector);

		// Selector.click();
		return Selector;

	}

	public boolean InitialInteriorSelected() throws InterruptedException {
		String[] Confirm = { "body>con-app", "#layout > app-header-layout > iron-pages > con-configure",
				"con-sales-group-slider:nth-child(24)", "#optionSlider > con-slide:nth-child(3) > con-option",
				"div > div.content > div.row > div > div > button" };
		WebElement confirmInterior = elementFinder.getElement(Confirm);

		if (confirmInterior.getAttribute("class").contains("selected"))
			return true;
		else
			return false;

	}

	public Float InitInteriorPrice() throws InterruptedException {
		String[] Price = { "body>con-app", "#layout > app-header-layout > iron-pages > con-configure",
				"con-sales-group-slider:nth-child(24)", "#optionSlider > con-slide:nth-child(3) > con-option",
				"div > div.content > div:nth-child(1)" };
		WebElement InteriorPrice = elementFinder.getElement(Price);
		elementFinder.ScrollIntoView(InteriorPrice);
		Thread.sleep(3000);

		// System.out.println(ColorPrice.getText());

		String temp = InteriorPrice.getText().substring(0, InteriorPrice.getText().length() - 1).replace(".", "").replace(",",
				".");

		return Float.valueOf(temp);
	}

	public Float ChosenInteriorPrice() throws InterruptedException {
		String[] Price = { "body>con-app", "#layout > app-header-layout > iron-pages > con-configure",
				"con-sales-group-slider:nth-child(24)", "#optionSlider > con-slide:nth-child(3) > con-option",
				"div > div.content > div:nth-child(1)" };
		WebElement InteriorPrice = elementFinder.getElement(Price);
		elementFinder.ScrollIntoView(InteriorPrice);

		String temp = InteriorPrice.getText().substring(0, InteriorPrice.getText().length() - 1).replace(".", "")
				.replace(",", ".").replace(" ", "").replace("€", "");

		return Float.valueOf(temp);
	}

	public String ChosenInteriorName() throws InterruptedException {
		String[] Price = { "body>con-app", "#layout > app-header-layout > iron-pages > con-configure",
				"con-sales-group-slider:nth-child(24)", "#optionSlider > con-slide:nth-child(3) > con-option",
				"div > div.content > div.feature-name" };
		WebElement InteriorName = elementFinder.getElement(Price);

		return InteriorName.getText();

	}

}
