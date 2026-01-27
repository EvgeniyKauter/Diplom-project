package Pages.Elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class CheckBox {

    private final SelenideElement selector;
    private final String description;

    public CheckBox (SelenideElement selector, String description) {
        this.selector = selector;
        this.description = description;
    }

    public CheckBox click() {
        selector.shouldBe(Condition.enabled);
        selector.click();
        return this;
    }
}
