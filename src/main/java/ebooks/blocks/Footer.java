package ebooks.blocks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Vlados on 15.11.2016.
 */
public class Footer {
    private WebElement footer;

    public Footer(WebElement element) {
        footer = element;
    }

    public void clickLink(String linkTitle){
        try {
            footer.findElement(By.cssSelector("a[title='" + linkTitle + "']")).click();
        }catch (Exception ex){
            throw new RuntimeException("Link was not clicked");
        }
    }

}
