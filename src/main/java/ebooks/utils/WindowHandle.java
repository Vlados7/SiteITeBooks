package ebooks.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by Vlados on 19.11.2016.
 */
public class WindowHandle {
    private WebDriver webDriver;
//    private String currentWindowHandle = "";

    public WindowHandle(WebDriver driver) {
        webDriver = driver;
    }

    public void SwitchToWindows(){

//        Set<String> windows = webDriver.getWindowHandles();
//
//        Iterator<String> it = windows.iterator();
//        String mainWindow = (String) it.next();
//
//        String popUp = (String) it.next();
//
//        webDriver.switchTo().window(popUp);

        try {
           String currentWindowHandle = webDriver.getWindowHandle();

            Set<String> openWindowsHandles = webDriver.getWindowHandles();
            if (openWindowsHandles.size() <= 1){
                throw new Exception("New window was not opened");
            }

            for (String window : openWindowsHandles){
                webDriver.switchTo().window(window);
//                if (webDriver.getTitle().equals("hj"))
//                 break;
//
            }
        }catch (Exception ex){
            throw new RuntimeException("No", ex);
        }

    }
}
