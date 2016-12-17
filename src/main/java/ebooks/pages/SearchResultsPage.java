package ebooks.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Vlados on 15.11.2016.
 */
public class SearchResultsPage {
    private WebDriver webDriver;

    public SearchResultsPage(WebDriver driver) {
        webDriver = driver;
    }

    public List<WebElement> booksList() {
        try {
            List<WebElement> books = webDriver.findElement(By.className("top"))
                    .findElements(By.tagName("tr")); // сдесь вернеться список всех tr элементов(книг) список будет содержать
            return books;
        }catch (Exception ex){
            throw new RuntimeException("List was not found", ex);
        }
    }

    public void openBookClickImg(String booktitle) {
        try {
            List<WebElement> book = booksList();

            for (WebElement books : book) {
                WebElement bookLink = books.findElement(By.tagName("img"));

                if (bookLink.getAttribute("alt").contains(booktitle)) {
                    bookLink.click();
                    break;
                }
            }
        }catch (Exception ex){
            throw new RuntimeException("Book was not found", ex);
        }

    }

    public void openBookClickTitle(String booktitle){
        try {
            List<WebElement> book = booksList();

            for (WebElement books : book){
                WebElement bookLink = books.findElement(By.tagName("a"));

                if (bookLink.getAttribute("title").contains(booktitle)){
                    bookLink.click();
                    break;
                }
            }
        }catch (Exception ex){
            throw new RuntimeException("Book was not found", ex);
        }
    }


}
