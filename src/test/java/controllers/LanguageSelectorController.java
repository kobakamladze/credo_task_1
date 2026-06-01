package controllers;

import Constants.Languages;
import base.AppiumElement;
import org.openqa.selenium.By;

public class LanguageSelectorController {

    private final By btnChangeLanguage = By.xpath("//*[@resource-id='changeLanguageButton']");
    private final By btnKaLanguage = By.xpath("//*[@resource-id='kaLanguageButton']");
    private final By btnEnLanguage = By.xpath("//*[@resource-id='enLanguageButton']");
    private final By btnRuLanguage = By.xpath("//*[@resource-id='ruLanguageButton']");
    private final By btnClose = By.xpath("//*[@resource-id='closeButton']");

    private void selectLanguage(Languages language) {
        switch (language) {
            case EN:
                new AppiumElement(btnEnLanguage).click();
                break;
            case RU:
                new AppiumElement(btnRuLanguage).click();
                break;
            case KA:
                new AppiumElement(btnKaLanguage).click();
                break;
            default:
                return;
        }
    }

    private void clickChangeLanguageButton() {
        new AppiumElement(btnChangeLanguage).click();
    }

    private void clickCloseButton() {
        new AppiumElement(btnClose).click();
    }

    public void switchLanguageTo(String language) {
        clickChangeLanguageButton();
        selectLanguage(Languages.valueOf(language));
        clickCloseButton();
    }
}
