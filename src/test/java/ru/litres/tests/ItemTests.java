package ru.litres.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.litres.pages.ItemPage;

import static io.qameta.allure.Allure.step;

public class ItemTests {
    ItemPage itemPage = new ItemPage();

    @Test
    @Tag("smoke") @Tag("search")
    @DisplayName("Проверка работы поиска")
    void searchTest (){
        step("Открыть главную страницу", () ->{
            itemPage.openPage();
        });
        step("Ввести в поле поиска значение", () ->{
            itemPage.searchInput("Война и мир");
        });
        step("Проверить результат поиска", () ->{
            itemPage.searchResult("Результаты поиска «Война и мир");
        });
    }

    @Test
    @Tag("smoke") @Tag("parametrizedSearch")
    @DisplayName("Проверка работы поиска по параметрам")
    void parametrizedSearch() {
        step("Открыть главную страницу", () -> {
            itemPage.openPage();
        });
        step("Открыть каталог", () ->{
            itemPage.selectCatalog();
        });
        step("Выбрать жанр 'Классическая литература'",() -> {
            itemPage.selectGenre();
        });
        step("Выбрать формат 'Текст'", () ->{
            itemPage.selectFormat();
        });
        step("Выбрать немецкий язык", () ->{
            itemPage.selectLanguage();
        });
        step("Выбрать параметр 'Высокая оценка'", () ->{
            itemPage.selectRating();
        });
        step("Проверить, что выбранные фильтры применены", () ->{
            itemPage.languageFilter("Немецкий")
                    .formatFilter("Текст")
                    .ratingFilter("Высокая оценка");

        });

    }

}