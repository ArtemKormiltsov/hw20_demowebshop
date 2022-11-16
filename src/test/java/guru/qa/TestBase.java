package guru.qa;

import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.config.ConfigReader;
import guru.qa.config.ProjectConfiguration;
import guru.qa.config.web.WebConfig;
import guru.qa.helpers.Attachments;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    private static final WebConfig webConfig = ConfigReader.Instance.read();

    @BeforeAll
    public static void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        ProjectConfiguration projectConfiguration = new ProjectConfiguration(webConfig);
        projectConfiguration.webConfig();
        projectConfiguration.apiConfig();
    }

    @AfterEach
    public void getAttachments() {
        Attachments.takeScreenshot();
        Attachments.addSource();
        Attachments.addHTMLSource();
        Attachments.addBrowserConsoleLog();
        Attachments.addVideo();
    }
}