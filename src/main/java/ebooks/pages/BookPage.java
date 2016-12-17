package ebooks.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Vlados on 15.11.2016.
 */
public class BookPage {
    private WebDriver webDriver;

    public BookPage(WebDriver driver) {
        webDriver = driver;
    }

    public void buyBook(String titleBook){
        try {
            webDriver.findElement(By.cssSelector("a[title='"+ titleBook + "']")).click();
        }catch (Exception ex){
            throw new RuntimeException("Element was not found", ex);
        }
    }

}
