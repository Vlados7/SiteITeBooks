package ebooks.pages;

import ebooks.blocks.Footer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by Vlados on 15.11.2016.
 */
public class MainPage {
    private WebDriver webDriver;

    public MainPage(WebDriver driver) {
        webDriver = driver;
    }

    public WebElement booksListBlock(String listTitle){
        try {
            List<WebElement> elementList = webDriver.findElements(By.className("top"));
            for (WebElement element : elementList){
                if (element.findElement(By.tagName("h2")).getText().contains(listTitle)){
                    return element;
                }
            }
        }catch (Exception ex){
            throw new RuntimeException("Block was not found", ex);
        }
        return null; // если элемент не будет найдет вернет null
    }

    public WebElement topDownloadeBooksImage(String bookImage){
        WebElement block = booksListBlock("Top Download eBooks");
        try {
            return block.findElement(By.cssSelector("img[alt='"+ bookImage +"']"));
        }catch (Exception ex){
            throw new RuntimeException("BookImage was not found", ex);
        }
    }

    public WebElement topDownloadeBooksTitle(String bookTitle){
        WebElement block = booksListBlock("Top Download eBooks");
        try {
            return block.findElement(By.cssSelector("a[title='"+ bookTitle +"']"));
        }catch (Exception ex){
            throw new RuntimeException("BookTitle was not found", ex);
        }
    }

    public WebElement lastUploadedBooksImage(String bookImage){
        WebElement block = booksListBlock("Last Upload eBooks");
        try {
           return block.findElement(By.cssSelector("img[alt='"+ bookImage +"']"));
        }catch (Exception ex){
            throw new RuntimeException("BookImage was not found", ex);
        }
    }

    public WebElement lastUploadedBooksTitle(String bookTitle){
        WebElement block = booksListBlock("Last Upload eBooks");
        try {
            return block.findElement(By.cssSelector("a[title='"+ bookTitle +"']"));
        }catch (Exception ex){
            throw new RuntimeException("BookTitle was not found", ex);
        }
    }

}
