Feature: Sign In Negative Cases

  Background:
    Given skip intro if present

  @EmptyFields
  Scenario Outline: Submit with empty password only
    When change language to "<language>"
    And user tries to log in with empty fields
    Then submit button is disabled and error message under fields appears "<errorMessage>"

    Examples:
      | language |            errorMessage           |
      |    KA    | აუცილებელი ველი არ არის შევსებული |
      |    EN    |      Mandatory field is empty     |
      |    RU    |   Необходимое поле не заполнено   |

  @WrongSymbols
  Scenario Outline: Invalid symbols
    When change language to "<language>"
    And the user attempts to sign in with name "<name>" and password "<password>"
    Then error message "<nameFieldErrorText>" under username field and "<passwordFieldErrorText>" under password field appears

    Examples:
      | language | name | password |                  nameFieldErrorText                    |         passwordFieldErrorText        |
      |    KA    |   §  |     §    | მომხმარებლის სახელში გამოყენებულია არასწორი სიმბოლოები | შეიყვანეთ მხოლოდ დასაშვები სიმბოლოები |
      |    EN    |   §  |     §    |                     Wrong symbols                      |       Please enter valid symbols      |
      |    RU    |   §  |     §    | В имени пользователя использованы недопустимые символы |   Введите только допустимые символы   |

  @InvalidCredentials
  Scenario Outline: Invalid credentials
    When change language to "<language>"
    And the user attempts to sign in with name "<name>" and password "<password>"
    Then flash message with error "<errorMessage>" appears

    Examples:
      | language | name | password |                      errorMessage                      |
      |    KA    | jake |    123   |  ავტორიზაცია ვერ ხერხდება, შეიყვანეთ მონაცემები სწორად |
      |    EN    | kob1 |    123   |      Authentication failed, enter data correctly       |
      |    RU    | wron |    123   |    Авторизация не удалась, введите данные правильно    |