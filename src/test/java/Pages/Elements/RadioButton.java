package Pages.Elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.util.stream.Collector;

public class RadioButton {

    public RadioButton(SelenideElement selector, String description) {
        this.selector = selector;
        this.description = description;
    }

    private final String description;
    private final SelenideElement selector;

    public RadioButton click() {
        selector.shouldBe(Condition.enabled);
        selector.click();
        return this;
    }
}
