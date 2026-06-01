package steps;

import screens.WelcomeScreen;

public class WelcomeSteps {

    WelcomeScreen welcomeScreen = new WelcomeScreen();

    //Actions
    public void skipIntroIfPresent() {
        if (welcomeScreen.isSkipButtonPresent() || welcomeScreen.isFinishButtonPresent()) {
            welcomeScreen.clickSkipButton();
            welcomeScreen.clickSkipButton();
            welcomeScreen.clickFinishButton();
        }
    }
}
