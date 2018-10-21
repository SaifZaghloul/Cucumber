package Pages.Helpers;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import test.java.TCs.LibraryTest;

public class ElementFinder {

	public WebElement expandRootElement(WebElement root) {
		WebElement element = (WebElement) ((JavascriptExecutor) LibraryTest.driver)
				.executeScript("return arguments[0].shadowRoot", root);
		return element;
	}

	public WebElement getElement(String cssSelector) throws InterruptedException {
		return LibraryTest.driver.findElement(By.cssSelector(cssSelector));
	}

	// Extract Element,
	// array of css selectors and get element
	public WebElement getElement(String[] cssSelectors) throws InterruptedException {

		WebElement root = LibraryTest.driver.findElement(By.cssSelector(cssSelectors[0]));
		WebElement shadowRoot = null;

		for (int i = 1; i < cssSelectors.length; i++) {
			shadowRoot = expandRootElement(root);
			root = shadowRoot.findElement(By.cssSelector(cssSelectors[i]));
			// Thread.sleep(2000);
		}

		return root;
	}

	// Extract list of Elements
	public List<WebElement> getElementList(String[] cssSelectors) throws InterruptedException {

		WebElement root = LibraryTest.driver.findElement(By.cssSelector(cssSelectors[0]));
		WebElement shadowRoot = null;

		for (int i = 1; i < cssSelectors.length - 2; i++) {
			shadowRoot = expandRootElement(root);
			root = shadowRoot.findElement(By.cssSelector(cssSelectors[i]));
			Thread.sleep(2000);
		}

		shadowRoot = expandRootElement(root);
		List<WebElement> Firstlist = shadowRoot.findElements(By.cssSelector(cssSelectors[cssSelectors.length - 2]));
		List<WebElement> Finallist = new ArrayList();
		for (WebElement x : Firstlist) {
			shadowRoot = expandRootElement(x);
			Finallist.addAll(shadowRoot.findElements(By.cssSelector(cssSelectors[cssSelectors.length - 1])));
		}

		return Finallist;
	}

	public List<WebElement> getElementListDirect(String[] cssSelectors) throws InterruptedException {

		WebElement root = LibraryTest.driver.findElement(By.cssSelector(cssSelectors[0]));
		WebElement shadowRoot = null;

		for (int i = 1; i < cssSelectors.length - 1; i++) {
			shadowRoot = expandRootElement(root);
			root = shadowRoot.findElement(By.cssSelector(cssSelectors[i]));
			Thread.sleep(2000);
		}

		shadowRoot = expandRootElement(root);
		List<WebElement> list = shadowRoot.findElements(By.cssSelector(cssSelectors[cssSelectors.length - 1]));

		return list;
	}

	public void ScrollIntoView(WebElement element) {
		((JavascriptExecutor) LibraryTest.driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void Slide(WebElement element) {
		Actions move = new Actions(LibraryTest.driver);
		Action action = (Action) move.dragAndDropBy(element, 40, 0).build();
		action.perform();
	}

}
