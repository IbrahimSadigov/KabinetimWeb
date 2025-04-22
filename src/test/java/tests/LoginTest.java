package tests;

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
public class LoginTest {
    private static Playwright playwright;
    private static Browser browser;
    private BrowserContext context;
    private Page page;
    // Read the base URL from configuration
    private static final String baseUrl = ConfigManager.getProperty("baseUrl");

    @BeforeAll
    public static void setUpClass() {
        playwright = Playwright.create();
        browser = BrowserFactory.getBrowser(playwright);
    }

    @AfterAll
    public static void tearDownClass() {
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }

    @BeforeEach
    public void setUp() {
        // Create a new isolated browser context for each test
        context = browser.newContext();
        page = context.newPage();
    }

    @AfterEach
    public void tearDown() {
        if (context != null) context.close();
    }

    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage(page, baseUrl);
        loginPage.navigate();
        loginPage.login("testuser", "password");

        // Validate that after login the URL contains '/home'
        String currentUrl = page.url();
        assertTrue(currentUrl.contains("/home"), "User should be redirected to home page after login");
    }
}
