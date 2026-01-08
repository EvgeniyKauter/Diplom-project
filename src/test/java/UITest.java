import com.codeborne.selenide.Condition;
import org.junit.Test;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class UITest {

    @Test // Тест формы
    public void positiveCase () {
        open("https://demoqa.com/automation-practice-form");
        $(byXpath("//*[@id=\"firstName\"]")).setValue("Анна-М'ариё"); // Имя, ввод
        $(byId("lastName")).setValue("Иванова-П'ётрова"); // Фамилия, ввод
        $(byId("userEmail")).setValue("name-1'@example.com"); // Эл. почта, ввод
        $(byId("gender-radio-1")).click(); // Пол, радио
        $(byId("userNumber")).setValue("9040830784"); // Номер телефона, ввести
        $(byId("dateOfBirthInput")).click(); // Дата, выбрать
            $$("react-datepicker__month-select").first().click();
            $$("react-datepicker__year-select").first().click();
            $("react-datepicker__day react-datepicker__day--013").click();
        $(byId("subjectsContainer")).setValue("Maths").pressEnter(); // выбрать предмет из списка, выбрать
        $(byId("hobbies-checkbox-1")).click(); // выбрать хобби, чекбокс
        $(byId("input[type=file]")).sendKeys("C:\\Users\\e.kauter\\Documents\\Lightshot\\Screenshot_1.png"); //загрузить файл
        $(byId("currentAddress")).setValue("Belgorod");
        $(byClassName(" css-yk16xz-control")).setValue("NCR").pressEnter();
        $(byClassName(" css-1uccc91-singleValue")).setValue("Delhi").pressEnter();
        $(byId("submit")).click();
    }

}
