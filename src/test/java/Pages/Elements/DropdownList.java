package Pages.Elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class DropdownList {

    private final SelenideElement selectorList;
    private final SelenideElement selectorLine;

    private final String description;
    private final String fieldName;

    public DropdownList (SelenideElement selectorList, SelenideElement selectorLine,
                         String fieldName, String description) {
        this.description = description;
        this.selectorList = selectorList;
        this.selectorLine = selectorLine;
        this.fieldName = fieldName;
    }

    public DropdownList chooseElement () {
        selectorList.shouldBe(Condition.enabled);
        selectorList.click();
//        selectorLine.shouldBe(Condition.enabled);
//        selectorLine.click();  // почему-то не работает через выбор из открывающегося списка,
//                                  пишет что недопустимое состояние элемента под селектором react-select-3-input
        selectorLine.setValue(fieldName);
        selectorLine.pressEnter();
        return this;
    }
}
