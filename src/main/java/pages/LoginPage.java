package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

/**
 * @author : Ibrahim Sadigov
 * @mailto : isadigov4638@ada.edu.az
 * @created : 11 April, 2025
 **/
public class LoginPage {
    private final Page page;
    private final String baseUrl;

    // Navigate to the login page
    // Define selectors as constants
    private final Locator MSISDN;
    private final Locator LOGIN_BUTTON;

    public LoginPage(Page page, String baseUrl) {
        this.page = page;
        this.baseUrl = baseUrl;
        MSISDN = page.getByPlaceholder("Telefon nömrəsi");
        LOGIN_BUTTON = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions()
                .setName("Davam et"));
    }

    public void navigate() {
        page.navigate(baseUrl + "/login");
    }

    // Fill in credentials and submit the form
    public void login(String msisdn) {
        MSISDN.fill(msisdn);
        LOGIN_BUTTON.click();
        // Wait for navigation; adjust as needed based on your application’s behavior
        //page.waitForNavigation();
    }
}
