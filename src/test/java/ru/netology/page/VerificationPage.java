package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import lombok.val;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import ru.netology.data.DataHelper;

import java.sql.DriverManager;
import java.sql.SQLException;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
    private SelenideElement code = $("[data-test-id=code] input");
    private SelenideElement button = $("[data-test-id=action-verify]");

    public VerificationPage() {
        code.shouldBe(visible);
    }

    public DashboardPage validVerify(DataHelper.VerificationCode codeVerify) {
        code.setValue(codeVerify.getCode());
        button.click();
        return new DashboardPage();
    }

    public void getErrorInvalidVerify(){
        $(byText("Ошибка")).shouldBe(visible);
        $(byText("Неверно указан код! Попробуйте ещё раз.")).shouldBe(visible);
    }

}
