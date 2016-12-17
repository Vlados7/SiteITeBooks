package ebooks.blocks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Vlados on 21.11.2016.
 */
public class SearchResultInGoogle {
    WebDriver webDriver;

    public SearchResultInGoogle(WebDriver driver){
        webDriver = driver;
    }

    public WebElement OpenBook(String titleBook){
        try {
            List<WebElement> books = webDriver.findElements(By.cssSelector("a[class='gs-title']"));
            for (WebElement book : books){
                if (book.getText().contains(titleBook)){
                   return book;
                }
            }
        }catch (Exception ex){
            throw new RuntimeException("Book was not found", ex);
        }

        return null;
    }

}
