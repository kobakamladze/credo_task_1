package screens;

import base.AppiumElement;
import org.openqa.selenium.By;

public class WelcomeScreen {

    private final By btnSkip = By.xpath("//*[@resource-id='skipButton']");
    private final By btnFinish = By.xpath("//*[@resource-id='finishButton']");

    public boolean isSkipButtonPresent() {
        return new AppiumElement(btnSkip).isDisplayed();
    }

    public boolean isFinishButtonPresent() {
        return new AppiumElement(btnFinish).isDisplayed();
    }

    public void clickSkipButton() {
        new AppiumElement(btnSkip).click();
    }

    public void clickFinishButton() {
        new AppiumElement(btnFinish).click();
    }
}
