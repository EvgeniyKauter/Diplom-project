package Pages.Elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class PopUp {

    private final SelenideElement selector;
    private final String description;

    public PopUp (SelenideElement selector, String description) {
        this.selector = selector;
        this.description = description;
    }

    public PopUp checkWords (String word) {
        selector.shouldBe(Condition.visible);
        selector.shouldHave(Condition.text(word));
        return this;
    }
}
