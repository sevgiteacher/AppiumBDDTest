package appium;

public class appiumHelper extends LocatorMethods {

    public static void navigateHelper(){
        setUp();
    }

    public static void clickHelper(String element){
        locateElement(element).click();
    }

    public static void typeHelper(String content,String element){
        driver.hideKeyboard();
        locateElement(element).sendKeys(content);
    }





}
