package ebooks;

import ebooks.blocks.*;
import ebooks.blocks.SearchResultInGoogle;
import ebooks.pages.BookPage;
import ebooks.pages.MainPage;
import ebooks.pages.SearchResultsPage;
import ebooks.utils.WaitPages;
import ebooks.utils.WindowHandle;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Vlados on 15.11.2016.
 */
public class WebApplication {
    WebDriver webDriver;

    public WebApplication(WebDriver driver) {
        webDriver = driver;
    }

    //pages
    public MainPage mainPage(){
        return new MainPage(webDriver);
    }

    public SearchResultsPage searchResultsPage(){
        return new SearchResultsPage(webDriver);
    }

    public BookPage bookPage(){
        return new BookPage(webDriver);
    }

    // blocks with elements
    public SearchBlock searchBlock(){
        return new SearchBlock(webDriver.findElement(By.id("searchform")));
    }

    public Footer footer(){
        return new Footer(webDriver.findElement(By.className("footer")));
    }

    public SearchResultInGoogle searchResultInGoogle(){
        return new SearchResultInGoogle(webDriver);
    }

    public SearchResultInISBN_Directory searchResultInISBN_directory(){
        return new SearchResultInISBN_Directory(webDriver);
    }

    //utils
    public WindowHandle windowHandle(){
        return new WindowHandle(webDriver);
    }

    public WaitPages waitPages(){
        return new WaitPages(webDriver);
    }

}
