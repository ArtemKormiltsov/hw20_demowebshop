package guru.qa.pages;

import guru.qa.data.UserData;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.*;

public class DemoWebShopPage {

    @Step("Редактирование профиля и проверка отредактированных данных")
    public void editAndCheckProfile(UserData userDataAfterEdit) {
        open("/customer/info");
        $("#FirstName").setValue(userDataAfterEdit.firstName);
        $("#LastName").setValue(userDataAfterEdit.lastName);
        $("#Email").setValue(userDataAfterEdit.email);
        $("[value='Save']").click();
        refresh();
        $("#FirstName").shouldHave(value(userDataAfterEdit.firstName));
        $("#LastName").shouldHave(value(userDataAfterEdit.lastName));
        $("#Email").shouldHave(value(userDataAfterEdit.email));
    }
}