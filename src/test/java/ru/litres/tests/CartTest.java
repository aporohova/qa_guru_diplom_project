package ru.litres.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.litres.pages.CartPage;

import static io.qameta.allure.Allure.step;

public class CartTest extends TestBase{
    CartPage cartPage = new CartPage();
    @Test
    @Tag("smoke") @Tag("Cart")
    @DisplayName("Добавление книги в корзину")
    void addToCartTest(){
        step("Открыть главную страницу", () ->{
            cartPage.openPage();
        });
        step("Ввести в поле поиска значение", () ->{
            cartPage.searchInput("Java");
        });
        step("Выбрать кингу", () ->{
           cartPage.openSearchResult();
        });
        step("Добавить книгу в корзину", () ->{
           cartPage.addToCart();
        });
        step("Закрыть рекламное предложение", () ->{
           cartPage.closePopup();
        });
        step("Открыть корзину", () ->{
           cartPage.openCart();
        });

    }

}
