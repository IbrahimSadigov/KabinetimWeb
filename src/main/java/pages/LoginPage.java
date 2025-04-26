package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;

import java.util.List;

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
    private final Locator NEXT_BUTTON;
    private final Locator OTP;
    private final Locator PASSWORD;
    private final Locator AGREE_BUTTON;

    public LoginPage(Page page, String baseUrl) {
        this.page = page;
        this.baseUrl = baseUrl;
        MSISDN = page.getByPlaceholder("Telefon nömrəsi");
        NEXT_BUTTON = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions()
                .setName(" Davam et "));
        OTP = page.getByRole(AriaRole.TEXTBOX);
        PASSWORD = page.locator("#login-password");
        AGREE_BUTTON = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Razıyam "));
    }

    public void navigate() {
        page.navigate(baseUrl);
    }

    // Fill in credentials and submit the form
    public void login(String msisdn, String password) {
        MSISDN.fill(msisdn);
        NEXT_BUTTON.click();
//        if (OTP.count()>0 && OTP.isVisible()) {
//        System.out.println("otp " + OTP.count());
//        for (Locator l : OTP.all()) {
//            l.fill("777777");
//        }
//        NEXT_BUTTON.click();
//        }
        PASSWORD.fill(password);
        NEXT_BUTTON.click();
//        if (AGREE_BUTTON.count() > 0 && AGREE_BUTTON.isVisible(new Locator.IsVisibleOptions().setTimeout(2000))) {
//            AGREE_BUTTON.click();
//        }
        page.waitForURL("**/home");
    }
}
