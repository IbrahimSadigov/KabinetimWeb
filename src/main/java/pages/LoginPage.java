package pages;

import com.microsoft.playwright.Page;

/**
 * @author : Ibrahim Sadigov
 * @mailto : isadigov4638@ada.edu.az
 * @created : 11 April, 2025
 **/
public class LoginPage {
    private final Page page;
    private final String baseUrl;

    // Define selectors as constants
    private static final String USERNAME_INPUT = "#username";
    private static final String PASSWORD_INPUT = "#password";
    private static final String LOGIN_BUTTON = "#loginButton";

    public LoginPage(Page page, String baseUrl) {
        this.page = page;
        this.baseUrl = baseUrl;
    }

    // Navigate to the login page
    public void navigate() {
        page.navigate(baseUrl + "/login");
    }

    // Fill in credentials and submit the form
    public void login(String username, String password) {
        page.fill(USERNAME_INPUT, username);
        page.fill(PASSWORD_INPUT, password);
        page.click(LOGIN_BUTTON);
        // Wait for navigation; adjust as needed based on your application’s behavior
        //page.waitForNavigation();
    }
}
