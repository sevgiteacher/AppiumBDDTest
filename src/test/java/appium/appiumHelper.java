package appium;

public class appiumHelper extends LocatorMethods {


    public static void navigateHelper(){
        setUp();
    }

    public static void tapHelper(String element){
        locateElement(element).click();
    }

    public static void typeHelper(String content,String element){
        locateElement(element).sendKeys(content);
    }



}
