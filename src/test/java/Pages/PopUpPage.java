package Pages;

import Pages.Elements.PopUp;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PopUpPage {

    private final PopUp studentName = new PopUp($(byXpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[1]/td[2]")),
            "Имя и фамилия студента");
    private final PopUp studentEmail = new PopUp($(byXpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[2]/td[2]")),
            "Электронный адрес студента");
    private final PopUp gender = new PopUp($(byXpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[3]/td[2]")),
            "Пол");
    private final PopUp mobile = new PopUp($(byXpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[4]/td[2]")),
            "Мобильный телефон");
    private final PopUp dateOfBirth = new PopUp($(byXpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[5]/td[2]")),
            "Дата рождения");
    private final PopUp subject = new PopUp($(byXpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[6]/td[2]")),
            "Предмет");
    private final PopUp hobbies = new PopUp($(byXpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[7]/td[2]")),
            "Хобби");
    private final PopUp picture = new PopUp($(byXpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[8]/td[2]")),
            "Картинка");
    private final PopUp address = new PopUp($(byXpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[9]/td[2]")),
            "Адрес");
    private final PopUp stateAndCity = new PopUp($(byXpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[10]/td[2]")),
            "Штат и город");

    @Step("Проверка имени и фамилии студента")
    public PopUpPage checkStudentName(String name) {
        studentName.checkWords(name);
        return this;
    }

    @Step("Проверка электронного адреса")
    public PopUpPage checkStudentEmail(String email) {
        studentEmail.checkWords(email);
        return this;
    }

    @Step("Проверка пола")
    public PopUpPage checkGender(String genderName) {
        gender.checkWords(genderName);
        return this;
    }

    @Step("Проверка мобильного номера")
    public PopUpPage checkMobile(String mobileNumber) {
        mobile.checkWords(mobileNumber);
        return this;
    }

    @Step("Проверка даты рождения")
    public PopUpPage checkDateOfBirth(String date) {
        dateOfBirth.checkWords(date);
        return this;
    }

    @Step("Проверка предмета")
    public PopUpPage checkSubject(String subjectName) {
        subject.checkWords(subjectName);
        return this;
    }

    @Step("Проверка хобби")
    public PopUpPage checkHobbies(String hobbiesNames) {
        hobbies.checkWords(hobbiesNames);
        return this;
    }

    @Step("Проверка названия картинки")
    public PopUpPage checkPicture(String pictureName) {
        picture.checkWords(pictureName);
        return this;
    }

    @Step("Проверка адреса")
    public PopUpPage checkAddress(String addressName) {
        address.checkWords(addressName);
        return this;
    }

    @Step("Проверка штата и города")
    public PopUpPage checkStateAndCity(String stateAndCityName) {
        stateAndCity.checkWords(stateAndCityName);
        return this;
    }
}
