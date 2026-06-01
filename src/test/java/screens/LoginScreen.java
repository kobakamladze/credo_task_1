package screens;

import base.AppiumElement;
import org.openqa.selenium.By;

public class LoginScreen {

    private final By inputUsername = By.xpath("//*[@resource-id='usernameInput']");
    private final By inputPassword = By.xpath("//*[@resource-id='passwordInput']");
    private final By txtUsernameError = By.xpath("//*[@resource-id='usernameErrorText']");
    private final By txtPasswordError = By.xpath("//*[@resource-id='passwordErrorText']");
    private final By btnLogin = By.xpath("//*[@resource-id='loginButton']");
    private final By txtFlashMessage = By.xpath("//*[@resource-id='flashMessageText']");

    public void fillUsername(String username) {
        new AppiumElement(inputUsername).sendKeys(username);
    }

    public void fillPassword(String username) {
        new AppiumElement(inputPassword).sendKeys(username);
    }

    public String getUsernameErrorText() {
        return new AppiumElement(txtUsernameError).getText();
    }

    public String getPasswordErrorText() {
        return new AppiumElement(txtPasswordError).getText();
    }

    public void clickLoginButton() {
        new AppiumElement(btnLogin).click();
    }

    public boolean isLoginButtonClickable() {
        return new AppiumElement(btnLogin).isEnabled();
    }

    public String getFlashMessageErrorText() {
        return new AppiumElement(txtFlashMessage).getText();
    }
}
