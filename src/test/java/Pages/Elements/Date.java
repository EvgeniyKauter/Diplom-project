package Pages.Elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

public class Date {

    private SelenideElement selectorField;
    private SelenideElement selectorMonth;
    private SelenideElement selectorYear;
    private SelenideElement selectorDay;
    private String description;

    public Date(SelenideElement selectorField, String description) {
        this.selectorField = selectorField;
        this.description = description;
    }

    public Date(SelenideElement field, SelenideElement year, SelenideElement month, SelenideElement day, String description) {
        this.selectorField = field;
        this.selectorMonth = month;
        this.selectorYear = year;
        this.selectorDay = day;
        this.description = description;
    }

    public Date chooseDate() {
        selectorField.shouldBe(Condition.enabled);
        selectorField.click();
        selectorYear.shouldBe(Condition.enabled);
        selectorYear.click();
        selectorMonth.shouldBe(Condition.enabled);
        selectorMonth.click();
        selectorDay.shouldBe(Condition.enabled);
        selectorDay.click();
        return this;
    }

    public Date inputDate(String date) {
        selectorField.shouldBe(Condition.enabled);
        //selectorField.sendKeys(Keys.chord(Keys.CONTROL, "a" + Keys.DELETE));
        //selectorField.sendKeys(Keys.chord(Keys.CONTROL, "a")); // выделить всё
        //selectorField.sendKeys(Keys.BACK_SPACE);
        //selectorField.doubleClick().pressEnter();
        //selectorField.clear();
        selectorField.setValue(date);
        return this;
    }
}
