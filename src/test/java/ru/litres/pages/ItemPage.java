package ru.litres.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ItemPage {
    SelenideElement
            search = $(".SearchForm-module__input_1E6az"),
            searchResult = $(".SearchTitle-module__title_YEbWG"),
            catalog = $(byText("Каталог")),
            genre =$(byText("Классическая литература")),
            format = $(".Checkbox__check_2AK6Y"),
            language = $(".Checkbox__label_1xulf",6),
            rating = $(".Switcher__toggleWrapper_nNoPA",2),
            filterDe = $(".Chips__ChipsElem_dvVua",1),
            filterText = $(".Chips__ChipsElem_dvVua"),
            filterRating = $(".Chips__ChipsElem_dvVua",2);



    public ItemPage openPage() {
        open("https://www.litres.ru/");

        return this;
    }
    public ItemPage searchInput(String value){
        search.click();
        search.setValue(value).pressEnter();

        return this;
    }
    public ItemPage searchResult(String value){
        searchResult.shouldHave(Condition.text(value));

        return this;
    }
    public ItemPage selectCatalog(){
        catalog.click();

        return this;
    }
    public ItemPage selectGenre(){
        genre.click();

        return this;
    }
    public ItemPage selectFormat(){
        format.click();

        return this;
    }
    public ItemPage selectLanguage(){
        language.click();

        return this;
    }
    public ItemPage selectRating(){
        rating.click();

        return this;
    }
    public ItemPage languageFilter(String value){
        filterDe.shouldHave(Condition.text(value));

        return this;
    }
    public ItemPage formatFilter(String value){
        filterText.shouldHave(Condition.text(value));

        return this;
    }
    public ItemPage ratingFilter(String value){
        filterRating.shouldHave(Condition.text(value));

        return this;
    }
}
