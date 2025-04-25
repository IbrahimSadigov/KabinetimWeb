package tests;

import base.BaseTest;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import config.ConfigManager;
import factory.BrowserFactory;
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

    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage(page, baseUrl);
        loginPage.navigate();
        loginPage.login("102210092");

        // Validate that after login the URL contains '/home'
        String currentUrl = page.url();
        assertTrue(currentUrl.contains("/home"), "User should be redirected to home page after login");
    }
}
