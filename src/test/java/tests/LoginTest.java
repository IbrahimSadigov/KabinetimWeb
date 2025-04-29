package tests;

import base.BaseTest;
import config.ConfigManager;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.*;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author : Ibrahim Sadigov
 * @mailto : isadigov4638@ada.edu.az
 * @created : 11 April, 2025
 **/
public class LoginTest extends BaseTest {

    // Read the base URL from configuration
    private static final String baseUrl = ConfigManager.getProperty("baseUrl");
    private static final String msisdn = ConfigManager.getProperty("msisdn");
    private static final String password = ConfigManager.getProperty("password");

    @Test
    @DisplayName("Login Test Case")
    public void loginTest() {
        Allure.step("1. Navigate to the login page", () -> {
            new LoginPage(page, baseUrl).navigate();
        });

        Allure.step("2. Perform login with MSISDN and password (and OTP/policy if needed)", () -> {
            new LoginPage(page, baseUrl).login(msisdn, password);
        });

        Allure.step("3. Verify that the URL contains '/home'", () -> {
            String currentUrl = page.url();
            assertTrue(currentUrl.contains("/home"),
                    "Expected to be on home, but was: " + currentUrl);
        });
//        LoginPage loginPage = new LoginPage(page, baseUrl);
//        loginPage.navigate();
//        loginPage.login(msisdn, password);
//        String currentUrl = page.url();
//        assertTrue(currentUrl.contains("/home"), "User should be redirected to home page after login");
    }
}
