package ebooks.blocks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by Vlados on 15.11.2016.
 */
public class SearchBlock {
    private WebElement block;

    public SearchBlock(WebElement element) {
        block = element;
    }

    public WebElement searchInput(){
        try {
            return block.findElement(By.id("q"));
        }catch (Exception ex){
            throw new RuntimeException("Element was not found", ex);
        }
    }

    public void enterSearchQuery(String query){
        try {
            searchInput().clear();
            searchInput().sendKeys(query);
        }catch (Exception ex){
            throw new RuntimeException("Search query was not found", ex);
        }
    }

    public WebElement searchButton(){
        try {
            return block.findElement(By.cssSelector("input[type='submit']"));
        }catch (Exception ex){
            throw new RuntimeException("Search button was not found", ex);
        }
    }

    public WebElement searchTypeRadio(String type){
        try {
          return block.findElement(By.cssSelector("input[value='" + type + "']"));
        }catch (Exception ex){
            throw new RuntimeException("Search type was not selected", ex);
        }
    }

}
