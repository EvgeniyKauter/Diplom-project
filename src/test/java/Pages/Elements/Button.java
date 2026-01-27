package Pages.Elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import java.io.File;

public class Button {

    private final String description;
    private final SelenideElement selector;

    public Button (SelenideElement selector, String description) {
        this.selector = selector;
        this.description = description;
    }

    public Button download() {
        selector.shouldBe(Condition.enabled);
        //selector.click();
        selector.uploadFile(new File("C:\\Users\\e.kauter\\Desktop\\test.txt"));
        return this;
    }

    public Button click() {
        selector.shouldBe(Condition.enabled);
        selector.click();
        return this;
    }
}
