package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.LoginPage;

import static com.codeborne.selenide.Selenide.open;

public class LoginTest {

    @BeforeEach
    public void setUp() {
        open("http://localhost:9999");
    }

    @AfterAll
    static void deleteData() {
        DataHelper.clearAllData();
    }

    @Test
    void shouldSendValidLogin() {
        val loginPage = new LoginPage();
        val verificationPage = loginPage.validLogin(DataHelper.getValidUser());
        val dashboardPage = verificationPage.validVerify(DataHelper.getValidVerificationCode());
        dashboardPage.dashboardVisible();

    }

    @Test
    void shouldSendInvalidLogin() {
        LoginPage loginPage = new LoginPage();
        loginPage.invalidLogin(DataHelper.getInvalidUser());
    }

    @Test
    void shouldGetErrorOverAttemps() {
        LoginPage loginPage = new LoginPage();
        loginPage.invalidLogin(DataHelper.getInvalidUser());
        loginPage.getDeleteAccount();
        loginPage.invalidLogin(DataHelper.getInvalidUser());
        loginPage.getDeleteAccount();
        loginPage.invalidLogin(DataHelper.getInvalidUser());
        loginPage.getErrorOverAttempts();
    }

    @Test
    void shouldGetErrorInvalidVerify() {
        val loginPage = new LoginPage();
        val verificationPage = loginPage.validLogin(DataHelper.getValidUser());
        val dashboardPage = verificationPage.validVerify(DataHelper.getInvalidVerificationCode());
        verificationPage.getErrorInvalidVerify();
    }
}
