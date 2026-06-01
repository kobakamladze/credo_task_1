package stepDefinitions;

import controllers.LanguageSelectorController;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import steps.LoginSteps;
import steps.WelcomeSteps;

public class AuthorizationSteps {

    @Given("skip intro if present")
    public void skip_intro_if_present() {
        new WelcomeSteps().skipIntroIfPresent();
    }

    @When("change language to {string}")
    public void change_language_to(String language) {
        new LanguageSelectorController().switchLanguageTo(language);
    }

    @And("user tries to log in with empty fields")
    public void user_tries_to_login_with_empty_fields() {
        new LoginSteps().loginWithEmptyFields();
    }

    @And("the user attempts to sign in with name {string} and password {string}")
    public void user_attempts_to_sign_in_with_credentials(String username, String password) {
        new LoginSteps().login(username, password);
    }

    @Then("submit button is disabled and error message under fields appears {string}")
    public void submit_button_is_disabled_and_error_message_under_fields_appear(String errorMessage) {
        new LoginSteps().assertUsernameErrorEqualsText(errorMessage);
        new LoginSteps().assertPasswordErrorEqualsText(errorMessage);
        new LoginSteps().assertLoginButtonIsNotClickable();
    }

    @Then("error message under fields appears {string}")
    public void error_message_under_fields_appear(String errorMessage) {
        new LoginSteps().assertUsernameErrorEqualsText(errorMessage);
        new LoginSteps().assertPasswordErrorEqualsText(errorMessage);
        new LoginSteps().assertLoginButtonIsNotClickable();
    }

    @Then("error message {string} under username field and {string} under password field appears")
    public void error_message_under_username_field_and_under_password_field_appears(
            String nameFieldErrorText, String passwordFieldErrorText) {
        new LoginSteps().assertUsernameErrorEqualsText(nameFieldErrorText);
        new LoginSteps().assertPasswordErrorEqualsText(passwordFieldErrorText);
        new LoginSteps().assertLoginButtonIsNotClickable();
    }

    @Then("flash message with error {string} appears")
    public void flash_message_with_error_appears(String errorMessage) {
        new LoginSteps().assertFlashMessageErrorEqualsText(errorMessage);
    }
}
