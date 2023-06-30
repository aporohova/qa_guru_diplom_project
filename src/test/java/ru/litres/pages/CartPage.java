package ru.litres.pages;

import com.codeborne.selenide.SelenideElement;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CartPage {
    SelenideElement
            search = $(".SearchForm-module__input_1E6az"),
            searchResult = $(byText("Java. Решение практических задач")),
            addToCartButton = $(".art-buttons__basket"),
    popup =  $("html");
            //popup = $(By.linkText("close"));


    public CartPage openPage() {
        open("https://www.litres.ru/");

        return this;
    }
    public CartPage searchInput(String value){
        search.click();
        search.setValue(value).pressEnter();

        return this;
    }
    public CartPage openSearchResult(){
        searchResult.click();

        return this;
    }
    public CartPage addToCart(){
        addToCartButton.click();

        return this;
    }
    public CartPage openCart(){
        addToCartButton.click();

        return this;
    }
    public CartPage closePopup(){
        popup.click();

        return this;
    }

}
