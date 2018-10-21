package Sections;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Pages.Helpers.ElementFinder;

public class Summary {

	private static final By driver = null;

	private ElementFinder elementFinder;

	public Summary() {
		elementFinder = new ElementFinder();
	}

	public WebElement SelectSummary() throws InterruptedException {

		Thread.sleep(10000);
		String[] SummarySelector = { "body > con-app", "#layout > app-header-layout > iron-pages > con-price",
				"div > div > con-rfx", "div > div > div:nth-child(7) > button" };

		WebElement Selector = elementFinder.getElement(SummarySelector);
		Thread.sleep(6000);

		elementFinder.ScrollIntoView(Selector);

		// Selector.click();
		return Selector;

	}

	public List<String> Options() throws InterruptedException {

		String[] OptionsSelector = { "body > con-app", "con-modal-summary",
				"#interiorExteriorOptionsSection > div > div > con-list-option", "div > div > div > h3" };

		List<WebElement> ChosenOptions = elementFinder.getElementList(OptionsSelector);
		List<String> OptionNames = new ArrayList();
		System.out.println("Number of Options : " + ChosenOptions.size());

		for (WebElement x : ChosenOptions) {
			elementFinder.ScrollIntoView(x);
			OptionNames.add(x.getText());
		}
		return OptionNames;

	}

}
