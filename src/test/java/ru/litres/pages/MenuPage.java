package ru.litres.pages;

import com.codeborne.selenide.*;
import static com.codeborne.selenide.Selenide.*;

public class MenuPage {

    SelenideElement
            partnerOzon = $(".Partners-module__logo__ozon_2I1FN");
    public MenuPage openPage() {
        open("https://www.litres.ru/");

        return this;
    }

    public MenuPage selectPartner(){
        partnerOzon.click();

        return this;
    }

    public MenuPage switchTo(String value){
        Selenide.switchTo().window(1).getCurrentUrl().equals(value);

        return this;
    }
}
