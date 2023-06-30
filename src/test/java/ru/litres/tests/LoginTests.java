package ru.litres.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.litres.pages.LoginPage;
import static io.qameta.allure.Allure.step;

public class LoginTests extends TestBase{
    LoginPage loginPage = new LoginPage();
    @Test
    @Tag("smoke") @Tag("loginVK")
    @DisplayName("Возможность логина через vk")
    void loginTest(){
        step("Открыть главную страницу", () ->{
            loginPage.openPage();
        });
        step("Нажать кнопку 'Войти'", () ->{
            loginPage.loginOption();
        });
        step("Проверить возможность логина через VK", ()->{
            loginPage.VKlogin("VK ID");
        });
    }

    @Test
    @Tag("smoke") @Tag("loginPhone")
    @DisplayName("Логин по номеру телефона с не валидным значением")
    void loginWithNumber(){
        step("Открыть главную страницу", () ->{
            loginPage.openPage();
        });
        step("Нажать кнопку 'Войти'", () ->{
            loginPage.loginOption();
        });
        step("Ввести не валидный номер телефона и нажать продолжить", () ->{
            loginPage.phoneLogin("99");
        });
        step("Проверить ошибку при вводе невалидного номера", () ->{
            loginPage.checkError("Номер введён не полностью");
        });
    }

}
