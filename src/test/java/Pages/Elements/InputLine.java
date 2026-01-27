package Pages.Elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

public class InputLine {

    public InputLine (SelenideElement selector, String description) {
        this.selector = selector;
        this.description = description;
    }

    private final String description;
    private final SelenideElement selector;

    public InputLine inputName (String word) {
        selector.shouldBe(Condition.enabled).setValue(word);
        return this;
    }

    public InputLine inputEmail(String word) {
        selector.shouldBe(Condition.enabled).setValue(word);
        return this;
    }

    public InputLine inputPhoneNumber(String number) {
        selector.shouldBe(Condition.enabled).setValue(number);
        return this;
    }

    public InputLine inputSubject (String subject) {
        selector.shouldBe(Condition.enabled);
        selector.click();
        selector.setValue(subject);
        selector.pressEnter();
        return this;
    }

    public InputLine inputAddress (String address) {
        selector.shouldBe(Condition.enabled);
        selector.setValue(address);
        return this;
    }

    public void checkEmail (String email) {
        boolean containsSobaka = email.contains("@");
        boolean containsDomenRu = email.contains(".ru");
        boolean containsDomenCom = email.contains(".com");
        if (!containsSobaka || (!containsDomenRu || containsDomenCom)) {
            System.out.println("Неверно введён email. Отсутствует обязательный символ @");
        }
    }

}
