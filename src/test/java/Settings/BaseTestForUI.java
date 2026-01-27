package Settings;

import Pages.PopUpPage;
import Pages.PracticeFormPage;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.*;

public abstract class BaseTestForUI {

    public PracticeFormPage formPage = new PracticeFormPage();
    public PopUpPage popUpPage = new PopUpPage();

    public static void openPage () {
        pageLoadStrategy = "eager";
        open("https://demoqa.com/automation-practice-form");
    }

    @BeforeAll
    public static void setup() {
        openPage();
    }
}
