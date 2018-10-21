package Sections;

import org.openqa.selenium.WebElement;

import Pages.Helpers.ElementFinder;

public class Motors {

	private ElementFinder elementFinder;

	public Motors() {
		elementFinder = new ElementFinder();
	}

	public void slideMotors() throws InterruptedException {
		String[] MotorSlider = { "body>con-app", "#layout > app-header-layout > iron-pages > con-configure",
				"con-paginator:nth-child(7)", "#dots > li:nth-child(3)" };
		WebElement slider = elementFinder.getElement(MotorSlider);
		// elementFinder.Slide(slider);
		Thread.sleep(3000);
		// elementFinder.Slide(slider);
		slider.click();
		
		//return slider;
	}

	public void ConfirmMotor() throws InterruptedException {
		String[] Confirm = { "body>con-app", "#layout > app-header-layout > iron-pages > con-configure",
				"#engineSlider > con-slide:nth-child(5) > div > div > div > div > button > span" };
		WebElement confirmModel = elementFinder.getElement(Confirm);

		confirmModel.click();
	}

	public boolean InitialMotorSelected() throws InterruptedException {
		String[] Confirm = { "body>con-app", "#layout > app-header-layout > iron-pages > con-configure",
				"#engineSlider > con-slide:nth-child(3) > div > div > div > div > button" };
		WebElement confirmMotor = elementFinder.getElement(Confirm);

		if (confirmMotor.getAttribute("class").contains("selected"))
			return true;
		else
			return false;
	}

	public Float InitMotorPrice() throws InterruptedException {
		String[] Price = { "body>con-app", "#layout > app-header-layout > iron-pages > con-configure",
				"#engineSlider > con-slide:nth-child(3) > div > div > con-engine-details", "div.engine-price" };
		WebElement MotorPrice = elementFinder.getElement(Price);
		String temp = MotorPrice.getText().substring(0, MotorPrice.getText().length()-2).replace(".", "").replace(",", ".");

		return Float.valueOf(temp);
	}

	public Float ChosenMotorPrice() throws InterruptedException {
		String[] Price = { "body>con-app", "#layout > app-header-layout > iron-pages > con-configure",
				"#engineSlider > con-slide:nth-child(5) > div > div > con-engine-details", "div.engine-price" };
		WebElement MotorPrice = elementFinder.getElement(Price);
		String temp = MotorPrice.getText().substring(0, MotorPrice.getText().length()-2).replace(".", "").replace(",", ".");

		return Float.valueOf(temp);
	}

}
