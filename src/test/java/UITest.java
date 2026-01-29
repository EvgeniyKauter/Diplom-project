import Pages.PracticeFormPage;
import Settings.BaseTestForUI;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import jdk.jfr.Description;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Configuration.*;


public class UITest extends BaseTestForUI {

    @Test
    @Description("Проверка заполнения полей формы и popup")
    void testForm() {
        formPage.setFirstName("Евгений")
                .setLastName("Каутер")
                .setEmail("kauter@mail.ru")
                .setGenderFemale()
                .setPhoneNumber("9040830784")
                .setDateOfBirthInCalendar() // выбор даты кликом
                //.setDateOfBirthByInput("03 Jul 2010") // ввод даты с клавиатуры. Не удаётся стереть старую дату.
                                                        // Способы закомментированы в методе inputDate
                .setSubject("Maths")
                .setHobbieSport()
                .setHobbieReading()
                .setHobbieMusic()
                .setDownloadFile()
                .setInputAddress("Belgorod, Sadovaya str.")
                .setState()
                .setCity()
                .setSubmit();

        popUpPage.checkStudentName("Евгений Каутер")
                .checkStudentEmail("kauter@mail.ru")
                .checkGender("Female")
                .checkMobile("9040830784")
                .checkDateOfBirth("13 January,2026")
                .checkSubject("Maths")
                .checkHobbies("Music")
                .checkPicture("test.txt")
                .checkAddress("Belgorod, Sadovaya str.")
                .checkStateAndCity("NCR Delhi");

    }

    @Test
    @Description("Валидация корректного домена электронного адреса")
    void testValidationEmailDomen() {

        formPage.setValidationDomen("kauter@mai.r");
    }

    @Test
    @Description("Валидация наличия символа @ в электронном адресе")
    void testValidationEmailSobaka() {

        formPage.setValidationSobaka("kautermail.com");
    }

    @Test
    @Description("Валидация количества цифр в номере телефона")
    void testValidationNumbersCount() {

        formPage.setValidationNumbersCount("123456789");
    }

    @Test
    @Description("Валидация наличия букв в номере телефона")
    void testValidationNumberForLetters() {

        formPage.setValidationNumberForLetters("a123456789");
    }

    //mvn clean -Dtest=UITest test
    //mvn allure:serve
}
