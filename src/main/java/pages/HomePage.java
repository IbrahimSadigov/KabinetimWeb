package pages;

import com.microsoft.playwright.Page;

/**
 * @author : Ibrahim Sadigov
 * @mailto : isadigov4638@ada.edu.az
 * @created : 11 April, 2025
 **/
public class HomePage {
    private final Page page;

    public HomePage(Page page) {
        this.page = page;
    }

    // Example method: you can add methods to interact with the home page
    public String getPageTitle() {
        return page.title();
    }
}
