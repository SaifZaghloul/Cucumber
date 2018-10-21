package Sections;

import org.openqa.selenium.WebElement;

import Pages.Helpers.ElementFinder;

public class Rims {

	private ElementFinder elementFinder;

	public Rims() {
		elementFinder = new ElementFinder();
	}

	public void slideRims() throws InterruptedException {
		String[] RimsSlider = { "body>con-app", "#layout > app-header-layout > iron-pages > con-configure",
				"con-sales-group-slider:nth-child(12)", "con-paginator", "#dots > li:nth-child(3)" };
		WebElement slider = elementFinder.getElement(RimsSlider);
		// elementFinder.Slide(slider);
		Thread.sleep(5000);
		// elementFinder.Slide(slider);

		// elementFinder.ScrollIntoView(slider);

		// return slider;
		slider.click();
	}

	public void ConfirmRim() throws InterruptedException {
		String[] Confirm = { "body>con-app", "#layout > app-header-layout > iron-pages > con-configure",
				"con-sales-group-slider:nth-child(12)", "#optionSlider > con-slide:nth-child(5) > con-option",
				"div > div.content > div.row > div > div > button > span" };
		WebElement confirmColor = elementFinder.getElement(Confirm);

		confirmColor.click();
	}

	public boolean InitialRimSelected() throws InterruptedException {
		String[] Confirm = { "body>con-app", "#layout > app-header-layout > iron-pages > con-configure",
				"con-sales-group-slider:nth-child(12)", "#optionSlider > con-slide:nth-child(3) > con-option",
				"div > div.content > div.row > div > div > button" };
		WebElement confirmRim = elementFinder.getElement(Confirm);
		if (confirmRim.getAttribute("class").contains("selected"))
			return true;
		else
			return false;

	}

	public Float InitRimPrice() throws InterruptedException {
		String[] Price = { "body>con-app", "#layout > app-header-layout > iron-pages > con-configure",
				"con-sales-group-slider:nth-child(12)", "#optionSlider > con-slide:nth-child(3) > con-option",
				"div > div.content > div:nth-child(1)" };
		WebElement RimPrice = elementFinder.getElement(Price);
		elementFinder.ScrollIntoView(RimPrice);
		Thread.sleep(3000);

		String temp = RimPrice.getText().substring(0, RimPrice.getText().length() - 2).replace(".", "").replace(",", ".");

		return Float.valueOf(temp);
	}

	public Float ChosenRimPrice() throws InterruptedException {
		String[] Price = { "body>con-app", "#layout > app-header-layout > iron-pages > con-configure",
				"con-sales-group-slider:nth-child(12)", "#optionSlider > con-slide:nth-child(5) > con-option",
				"div > div.content > div:nth-child(1)" };
		WebElement RimPrice = elementFinder.getElement(Price);

		String temp = RimPrice.getText().substring(0, RimPrice.getText().length() - 2).replace(".", "").replace(",", ".");

		return Float.valueOf(temp);
	}

	public String ChosenRimName() throws InterruptedException {
		String[] Price = { "body>con-app", "#layout > app-header-layout > iron-pages > con-configure",
				"con-sales-group-slider:nth-child(12)", "#optionSlider > con-slide:nth-child(5) > con-option",
				"div > div.content > div.feature-name" };
		WebElement RimName = elementFinder.getElement(Price);

		String temp = RimName.getText();

		return temp;
	}

}
