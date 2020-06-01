package appium;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import static appium.Direction.*;
import static appium.LocatorMethods.*;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofSeconds;


public class ScrollSwipeActionHelper {
    public static void touchActionSwipeHelper(String direction, String el1, String el2) {
        int size1 = locateElementsWithoutWait(el2).size();

        Dimension size = driver.manage().window().getSize();

        int startX = 0;
        int endX = 0;
        int startY = 0;
        int endY = 0;

        switch (valueOf(direction)) {
            case RIGHT:
                startY = locateElement(el1).getLocation().getY();
                endY = locateElement(el1).getLocation().getY();
                startX = (int) (size.width * 0.90);
                endX = (int) (size.width * 0.05);
                break;

            case LEFT:
                startY = locateElement(el1).getLocation().getY();
                endY = locateElement(el1).getLocation().getY();
                startX = (int) (size.width * 0.05);
                endX = (int) (size.width * 0.90);
                break;

            case UP:
                endY = (int) (size.height * 0.70);
                startY = (int) (size.height * 0.30);
                startX = locateElement(el1).getLocation().getX();
                endX = locateElement(el1).getLocation().getX();
                break;

            case DOWN:
                startY = (int) (size.height * 0.70);
                endY = (int) (size.height * 0.30);
                startX = locateElement(el1).getLocation().getX();
                endX = locateElement(el1).getLocation().getX();
                break;
        }

        while (size1 < 1) {
            getAction(startX, endX, startY, endY);
            size1 = locateElementsWithoutWait(el2).size();
        }
    }

    private static void getAction(int startY, int endY, int startX, int endX) {
        new TouchAction<>(driver).press(point(startX,startY))
                .waitAction(waitOptions(ofSeconds(1)))
                .moveTo(point(endX,endY)).release().perform();
    }

    public static void scrollToHelper(String text) {
        driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollTextIntoView(\"" + text + "\")"));
    }

    public static void touchActionMoveToElementHelper(String el1, String el2){
        final WebElement ele1 = locateElement(el1);
        final WebElement ele2 = locateElement(el2);
        TouchAction action=new TouchAction(driver);
        action.press(element(ele1)).waitAction(waitOptions(ofSeconds(1)))
                .moveTo(element(ele2)).release().perform();
    }

}
