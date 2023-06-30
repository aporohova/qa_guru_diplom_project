package ru.litres.tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.litres.pages.MenuPage;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class MainPageTests {
    MenuPage menuPage = new MenuPage();

    static Stream<Arguments> mainMenuTest(){
        return Stream.of(
                Arguments.of(List.of("Каталог", "Подписка за 0 ₽", "Новинки", "Популярное", "Аудиокниги", "Что почитать?", "Самиздат", "Промокод")));
    }
    @Tag("smoke") @Tag("menu")
    @DisplayName("Проверка отображения меню на главной странице")
    @MethodSource
    @ParameterizedTest(name="Меню главной страницы")
    void mainMenuTest(List<String> categories){
        step("Открыть главную страницу", () ->{
            menuPage.openPage();
        });
        step("Проверить отображение главного меню", () ->{
            $$(".LowerMenu-module__item_3QP99").filter(Condition.visible).shouldHave(CollectionCondition.containExactTextsCaseSensitive(categories));
        });
    }

   @Test
   @Tag("smoke") @Tag("redirectOzon")
   @DisplayName("Проверка редиректа с главной станицы на новую вкладку для партнера Ozon")
   void redirectTest() {
       step("Открыть главную страницу", () -> {
           menuPage.openPage();
       });
       step("Выбрать партнера 'Ozon'", () -> {
           menuPage.selectPartner();
       });
       step("Проверить редирект на страницу партнера", () -> {
           menuPage.switchTo("https://www.ozon.ru/");
       });
   }
}
