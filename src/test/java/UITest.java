import Pages.PracticeFormPage;
import Settings.BaseTestForUI;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Configuration.*;


public class UITest extends BaseTestForUI {

    @Test // Тест заполнения формы
    @Order(1)
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

}
