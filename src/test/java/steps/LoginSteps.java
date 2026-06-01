package steps;

import org.testng.Assert;
import screens.LoginScreen;

public class LoginSteps {

    LoginScreen loginScreen = new LoginScreen();

    //Actions
    public void login(String username, String password) {
        loginScreen.fillUsername(username);
        loginScreen.fillPassword(password);
        loginScreen.clickLoginButton();
    }

    public void loginWithEmptyFields() {
        loginScreen.clickLoginButton();
    }

    //Assertions
    public void assertUsernameErrorEqualsText(String errorMessage) {
        Assert.assertEquals(loginScreen.getUsernameErrorText(), errorMessage,
                String.format("Username error message is not equal to - %s", errorMessage));
    }

    public void assertPasswordErrorEqualsText(String errorMessage) {
        Assert.assertEquals(loginScreen.getPasswordErrorText(), errorMessage,
                String.format("Password error message is not equal to - %s", errorMessage));
    }

    public void assertFlashMessageErrorEqualsText(String errorMessage) {
        Assert.assertEquals(loginScreen.getFlashMessageErrorText(), errorMessage,
                String.format("Flash message error text is not equal to - %s", errorMessage));
    }

    public void assertLoginButtonIsNotClickable() {
        Assert.assertFalse(loginScreen.isLoginButtonClickable(), "Login button is still clickable");
    }
}
