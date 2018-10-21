package Sections;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import Pages.Helpers.ElementFinder;
import test.java.TCs.LibraryTest;

public class Conflict {

	private static final JavascriptExecutor driver = null;
	public ElementFinder elementFinder;

	public Conflict() {
		elementFinder = new ElementFinder();
	}

	public boolean CheckConflict() throws InterruptedException {
		String[] ConflictSelect = { "body > con-app", "con-modal-conflict", "con-modal > div" };

		Thread.sleep(5000);
		try {
			WebElement Conflict = elementFinder.getElement(ConflictSelect);
			return true;
		} catch (NullPointerException e) {
			return false;
		}
	}

	public WebElement SelectConflict() throws InterruptedException {

		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("javascript:window.scrollBy(800,950)");

		Thread.sleep(5000);
		String[] ConflictSelect = { "body > con-app", "con-modal-conflict",
				"con-modal > div > div > div.row.modal-buttons > div:nth-child(2) > button" };

		WebElement Selector = elementFinder.getElement(ConflictSelect);

		Thread.sleep(5000);
		/*
		String[] Price = { "body > con-app","#layout > app-header-layout > iron-pages > con-configure","con-sales-group-slider:nth-child(16)","#optionSlider > con-slide > con-option","con-modal-conflict",
				 "con-modal > div > div > div.row.modal-buttons > div:nth-child(2) > button"};
		WebElement ConflPrice = elementFinder.getElement(Price);
		/*/

		elementFinder.ScrollIntoView(Selector);

		// Selector.click();

		return Selector;

	}

	public Float IntConflictPrice() throws InterruptedException {
		String[] Price = { "body > con-app", "con-modal-conflict",
				"con-modal > div > div > div.row.price-difference > div.price.col-s-12.col-m-12.col-l-12" };
		WebElement ConflPrice = elementFinder.getElement(Price);

		elementFinder.ScrollIntoView(ConflPrice);

		Thread.sleep(5000);
		String temp = ConflPrice.getText().substring(1, ConflPrice.getText().length()).replace(".", "").replace(",", ".")
				.replace("€", "");

		return Float.valueOf(temp);

	}

	public String ConflictSign() throws InterruptedException {
		Thread.sleep(5000);
		String[] Price = { "body > con-app", "con-modal-conflict",
				"con-modal > div > div > div.row.price-difference > div.price.col-s-12.col-m-12.col-l-12" };
		WebElement ConflPrice = elementFinder.getElement(Price);

		elementFinder.ScrollIntoView(ConflPrice);

		Thread.sleep(5000);
		char sign = ConflPrice.getText().charAt(0);
		// System.out.println(sign);
		return String.valueOf(sign);

	}

	public List<String> AddedOptions() throws InterruptedException {

		String[] OptionsSelector1 = { "body > con-app", "con-modal-conflict",
				"con-modal > div > div > div:nth-child(4) > con-list-option", "div > div.option-details > div.info-wrapper > h3" };
		String[] OptionsSelector2 = { "body > con-app", "con-modal-conflict",
				"con-modal > div > div > div:nth-child(6) > con-list-option",
				"div > div.selector-element > span[class*='selected']" };

		List<WebElement> ChosenOptions = elementFinder.getElementList(OptionsSelector1);
		List<WebElement> ChosenOptionalOptions = elementFinder.getElementList(OptionsSelector2);
		List<String> OptionNames = new ArrayList();
		// System.out.println("Number of Options : " + ChosenOptions.size());

		for (WebElement x : ChosenOptions) {
			elementFinder.ScrollIntoView(x);
			OptionNames.add(x.getText());
		}

		for (WebElement x : ChosenOptionalOptions) {
			elementFinder.ScrollIntoView(x);
			JavascriptExecutor executor = (JavascriptExecutor) LibraryTest.driver;
			WebElement parentElement = (WebElement) executor.executeScript("return arguments[0].parentNode;", x);
			WebElement parent = (WebElement) executor.executeScript("return arguments[0].parentNode;", parentElement);
			OptionNames.add(parent.findElement(By.className("product-name")).getText());
		}

		// System.out.println(OptionNames.size());
		return OptionNames;

	}

	public List<String> RemovedOptions() throws InterruptedException {

		String[] OptionsSelector = { "body > con-app", "con-modal-conflict",
				"con-modal > div > div > div:nth-child(5) > con-list-option", "div > div.option-details > div.info-wrapper > h3" };

		List<WebElement> ChosenOptions = elementFinder.getElementList(OptionsSelector);
		List<String> OptionNames = new ArrayList();
		// System.out.println("Number of Options : " + ChosenOptions.size());

		for (WebElement x : ChosenOptions) {
			elementFinder.ScrollIntoView(x);
			OptionNames.add(x.getText());
		}
		return OptionNames;
	}

}
