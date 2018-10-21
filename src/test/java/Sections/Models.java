package Sections;

import org.openqa.selenium.WebElement;

import Pages.Helpers.ElementFinder;

public class Models {

	private ElementFinder elementFinder;

	public Models() {
		elementFinder = new ElementFinder();
	}

	public void slideModels() throws InterruptedException {
		String[] ModelSlider = { "body>con-app", "#layout > app-header-layout > iron-pages > con-configure",
				"con-paginator:nth-child(5)", "#dots > li:nth-child(3)" };
		WebElement slider = elementFinder.getElement(ModelSlider);
		// elementFinder.Slide(slider);
		Thread.sleep(3000);
		// elementFinder.Slide(slider);
		slider.click();
	}

	public void ConfirmModel() throws InterruptedException {
		String[] Confirm = { "body>con-app", "#layout > app-header-layout > iron-pages > con-configure",
				"#lineSlider > con-slide:nth-child(5) > div > div > div > div > button > span" };
		WebElement confirmModel = elementFinder.getElement(Confirm);

		confirmModel.click();
	}

	public boolean InitialModelSelected() throws InterruptedException {
		String[] Confirm = { "body>con-app", "#layout > app-header-layout > iron-pages > con-configure",
				"#lineSlider > con-slide:nth-child(3) > div > div > div > div > button" };
		WebElement confirmModel = elementFinder.getElement(Confirm);

		if (confirmModel.getAttribute("class").toString().contains("selected"))
			return true;
		else
			return false;
	}

	public Float InitModelPrice() throws InterruptedException {
		String[] Price = { "body>con-app", "#layout > app-header-layout > iron-pages > con-configure",
				"#lineSlider > con-slide:nth-child(3) > con-line-details", "div > div.content.line-details > p.line-price" };
		WebElement ModelPrice = elementFinder.getElement(Price);
		String temp = ModelPrice.getText().substring(3, ModelPrice.getText().length()-2).replace(".", "").replace(",", ".");

		return Float.valueOf(temp);
	}

	public Float ChosenModelPrice() throws InterruptedException {
		String[] Price = { "body>con-app", "#layout > app-header-layout > iron-pages > con-configure",
				"#lineSlider > con-slide:nth-child(5) > con-line-details", "div > div.content.line-details > p.line-price" };
		WebElement ModelPrice = elementFinder.getElement(Price);
		String temp = ModelPrice.getText().substring(3, ModelPrice.getText().length()-2).replace(".", "").replace(",", ".");

		return Float.valueOf(temp);
	}

}
