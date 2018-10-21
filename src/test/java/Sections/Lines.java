package Sections;

import org.openqa.selenium.WebElement;

import Pages.Helpers.ElementFinder;

public class Lines {

	private ElementFinder elementFinder;

	public Lines() {
		elementFinder = new ElementFinder();
	}

	public void openSideMenu() throws InterruptedException {
		String[] sideMenuSelectors = { "body>con-app", "#layout>app-header-layout>app-header>app-toolbar>div.menu-bar" };
		WebElement sideMenu = elementFinder.getElement(sideMenuSelectors);
		sideMenu.click();
	}

}
