package factory;

import com.microsoft.playwright.*;
import config.ConfigManager;

/**
 * @author : Ibrahim Sadigov
 * @mailto : isadigov4638@ada.edu.az
 * @created : 11 April, 2025
 **/
public class BrowserFactory {
    private static Browser browser;

    public static Browser getBrowser(Playwright playwright) {
        if (browser == null) {
            String browserType = ConfigManager.getProperty("browser"); // e.g., "chromium", "firefox", "webkit"
            boolean headless = Boolean.parseBoolean(ConfigManager.getProperty("headless"));
            switch (browserType.toLowerCase()) {
                case "firefox":
                    browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(headless));
                    break;
                case "webkit":
                    browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(headless));
                    break;
                case "chromium":
                default:
                    browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(headless));
                    break;
            }
        }
        return browser;
    }
}
