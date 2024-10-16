package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.step;

public class StepsTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";

    @Test
    public void testLambdaStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step ("Open main page",
                () -> {open("https://github.com");}
        );

        step ("Finding repository",
                () -> {
                    $(".search-input").click();
                    $("#query-builder-test").sendKeys("eroshenkoam/allure-example");
                    $("#query-builder-test").submit();}
        );

        System.out.println("test");
    }
}
