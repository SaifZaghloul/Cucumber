package Sections;

import org.openqa.selenium.WebElement;

import Pages.Helpers.ElementFinder;

public class Colors {

	private ElementFinder elementFinder;

	public Colors() {
		elementFinder = new ElementFinder();
	}

	public void slideColors() throws InterruptedException {
		String[] ColorSlider = { "body>con-app", "#layout > app-header-layout > iron-pages > con-configure",
				"con-sales-group-slider:nth-child(8)", "con-paginator", "#dots > li:nth-child(3)" };
		WebElement slider = elementFinder.getElement(ColorSlider);
		// elementFinder.Slide(slider);
		Thread.sleep(3000);
		// elementFinder.Slide(slider);
		slider.click();
	}

	public void ConfirmColor() throws InterruptedException {
		String[] Confirm = { "body>con-app", "#layout > app-header-layout > iron-pages > con-configure",
				"con-sales-group-slider:nth-child(8)", "#optionSlider > con-slide:nth-child(5) > con-option",
				"div > div.content > div.row > div > div > button > span" };
		WebElement confirmColor = elementFinder.getElement(Confirm);

		confirmColor.click();
	}

	public boolean InitialColorSelected() throws InterruptedException {
		String[] Confirm = { "body>con-app", "#layout > app-header-layout > iron-pages > con-configure",
				"con-sales-group-slider:nth-child(8)", "#optionSlider > con-slide:nth-child(3) > con-option",
				"div > div.content > div.row > div > div > button" };
		WebElement confirmColor = elementFinder.getElement(Confirm);

		if (confirmColor.getAttribute("class").contains("selected"))
			return true;
		else
			return false;

	}

	public Float InitColorPrice() throws InterruptedException {
		String[] Price = { "body>con-app", "#layout > app-header-layout > iron-pages > con-configure",
				"con-sales-group-slider:nth-child(8)", "#optionSlider > con-slide:nth-child(3) > con-option",
				"div > div.content > div:nth-child(1)" };
		WebElement ColorPrice = elementFinder.getElement(Price);
		elementFinder.ScrollIntoView(ColorPrice);
		Thread.sleep(3000);

		// System.out.println(ColorPrice.getText());

		String temp = ColorPrice.getText().substring(0, ColorPrice.getText().length() - 2).replace(".", "").replace(",", ".");

		return Float.valueOf(temp);
	}

	public Float ChosenColorPrice() throws InterruptedException {
		String[] Price = { "body>con-app", "#layout > app-header-layout > iron-pages > con-configure",
				"con-sales-group-slider:nth-child(8)", "#optionSlider > con-slide:nth-child(5) > con-option",
				"div > div.content > div:nth-child(1)" };
		WebElement ColorPrice = elementFinder.getElement(Price);

		String temp = ColorPrice.getText().substring(0, ColorPrice.getText().length() - 2).replace(".", "").replace(",", ".");

		return Float.valueOf(temp);
	}

	public String ChosenColorName() throws InterruptedException {
		String[] Price = { "body>con-app", "#layout > app-header-layout > iron-pages > con-configure",
				"con-sales-group-slider:nth-child(8)", "#optionSlider > con-slide:nth-child(5) > con-option",
				"div > div.content > div.feature-name" };
		WebElement ColorName = elementFinder.getElement(Price);

		String temp = ColorName.getText();

		return temp;
	}

}
