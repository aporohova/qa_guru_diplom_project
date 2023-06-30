package ru.litres.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    SelenideElement
            login = $(".Login-module__wrapper_1YKv5"),
            loginVK = $(".AuthorizationPopup-module__socials__link_19A5Y"),
            loginPhone = $(byText("Номер телефона")),
            phoneInput = $(".PhoneCodes__numberInput_2Tejv"),
            nextButton = $(byText("Продолжить")),
            errorText = $(".PhoneCodes__errorText_sKvhD");

    public LoginPage openPage() {
        open("https://www.litres.ru/");

        return this;
    }

    public LoginPage loginOption() {
        login.click();

        return this;
    }

    public LoginPage VKlogin(String value) {
        loginVK.shouldHave(Condition.text(value));

        return this;
    }

    public LoginPage phoneLogin(String value) {
        loginPhone.click();
        phoneInput.setValue(value);
        nextButton.click();

        return this;
    }

    public LoginPage checkError(String value) {
        errorText.shouldHave(Condition.text(value));

        return this;
    }
}

