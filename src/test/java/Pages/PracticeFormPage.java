package Pages;

import Pages.Elements.*;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$$;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class PracticeFormPage {

    private final InputLine firstName = new InputLine($(byId("firstName")), "Строка ввода имени");
    private final InputLine lastName = new InputLine($(byId("lastName")), "Строка ввода фамилии");
    private final InputLine email = new InputLine($(byId("userEmail")), "Строка ввода email");
    private final RadioButton genderMale = new RadioButton($(byXpath("//*[@id=\"genterWrapper\"]/div[2]/div[1]/label")),
            "Выбор пол: Male");
    private final RadioButton genderFemale = new RadioButton($(byXpath("//*[@id=\"genterWrapper\"]/div[2]/div[2]/label")),
            "Выбор пол: Female");
    private final RadioButton genderOther = new RadioButton($(byXpath("//*[@id=\"genterWrapper\"]/div[2]/div[3]/label")),
            "Выбор пол: Other");
    private final InputLine phoneNumber = new InputLine($(byId("userNumber")), "Строка ввода номера телефона");
    private final Date dateInCalendar = new Date($(byId("dateOfBirthInput")), $$(byClassName("react-datepicker__month-select")).first(),
            $$(byClassName("react-datepicker__year-select")).first(), $(byClassName("react-datepicker__day--013")),
            "Выбор даты рождения в календаре");
    private final Date dateInput = new Date($(byId("dateOfBirthInput")), "Ввод даты рождения с клавиатуры");
    private final InputLine subject = new InputLine($(byId("subjectsInput")), "Строка ввода предмета");
    private final CheckBox hobbieSport = new CheckBox($(byXpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[1]/label")),
            "Выбор хобби: sports");
    private final CheckBox hobbieReading = new CheckBox($(byXpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[2]/label")),
            "Выбор хобби: reading");
    private final CheckBox hobbieMusic = new CheckBox($(byXpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[3]/label")),
            "Выбор хобби: music");
    private final Button downloadFile = new Button($(byId("uploadPicture")), "Загрузка файла");
    private final InputLine address = new InputLine($(byId("currentAddress")), "Ввод адреса");
    private final DropdownList state = new DropdownList($(byClassName("css-1wa3eu0-placeholder")), $(byId("react-select-3-input")),
            "NCR", "Выбор штата");
    private final DropdownList city = new DropdownList($(byClassName("css-2b097c-container")), $(byId("react-select-4-input")),
            "Delhi", "Выбор города");
    private final Button submit = new Button($(byId("submit")), "Нажать Подтвердить");

    @Step("Вводим имя")
    public PracticeFormPage setFirstName(String word) {
        firstName.inputName(word);
        return this;
    }

    @Step("Вводим фамилию")
    public PracticeFormPage setLastName(String word) {
        lastName.inputName(word);
        return this;
    }

    @Step("Вводим email")
    public PracticeFormPage setEmail(String word) {
        //email.checkEmail(word);
        email.inputEmail(word);
        return this;
    }

    @Step("Выбираем пол Male")
    public PracticeFormPage setGenderMale() {
        genderMale.click();
        return this;
    }

    @Step("Выбираем пол Female")
    public PracticeFormPage setGenderFemale() {
        genderFemale.click();
        return this;
    }

    @Step("Выбираем пол Other")
    public PracticeFormPage setGenderOther() {
        genderOther.click();
        return this;
    }

    @Step("Вводим номер телефона")
    public PracticeFormPage setPhoneNumber(String number) {
        phoneNumber.inputPhoneNumber(number);
        return this;
    }

    @Step("Выбираем дату рождения в календаре")
    public PracticeFormPage setDateOfBirthInCalendar() {
        dateInCalendar.chooseDate();
        return this;
    }

    @Step("Вводим дату рождения с клавиатуры")
    public PracticeFormPage setDateOfBirthByInput(String date) {
        dateInput.inputDate(date);
        return this;
    }

    @Step("Вводим предмет")
    public PracticeFormPage setSubject (String word) {
        subject.inputSubject(word);
        return this;
    }

    @Step("Выбираем хобби спорт")
    public PracticeFormPage setHobbieSport() {
        hobbieSport.click();
        return this;
    }

    @Step("Выбираем хобби чтение книг")
    public PracticeFormPage setHobbieReading() {
        hobbieReading.click();
        return this;
    }

    @Step("Выбираем хобби музыка")
    public PracticeFormPage setHobbieMusic() {
        hobbieMusic.click();
        return this;
    }

    @Step("Загружаем файл")
    public PracticeFormPage setDownloadFile() {
        downloadFile.download();
        return this;
    }

    @Step("Вводим адрес")
    public PracticeFormPage setInputAddress(String words) {
        address.inputAddress(words);
        return this;
    }

    @Step("Выбираем штат")
    public PracticeFormPage setState() {
        state.chooseElement();
        return this;
    }

    @Step("Выбираем город")
    public PracticeFormPage setCity() {
        city.chooseElement();
        return this;
    }

    @Step("Нажимаем на кнопку Подтвердить")
    public PracticeFormPage setSubmit() {
        submit.click();
        return this;
    }

}
