package guru.qa;

import guru.qa.api.RegistrationApi;
import guru.qa.data.UserData;
import guru.qa.pages.DemoWebShopPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class DemoWebShopTest extends TestBase {
    static UserData userData = new UserData();
    static UserData userDataAfterEdit = new UserData();
    static DemoWebShopPage demowebshopPage = new DemoWebShopPage();
    static RegistrationApi registrationApi = new RegistrationApi();

    @Test
    @DisplayName("Регистрация нового пользователя и вход под ним")
    public void registrationTest() {
        registrationApi.registration(userData);
        registrationApi.login(userData);
        registrationApi.openPageWithAuth(userData);
    }

    @Test
    @DisplayName("Редактирование профиля с проверкой через UI")
    public void editProfileTest() {
        registrationApi.registration(userData);
        registrationApi.login(userData);
        registrationApi.openPageWithAuth(userData);
        demowebshopPage.editAndCheckProfile(userDataAfterEdit);
    }
}