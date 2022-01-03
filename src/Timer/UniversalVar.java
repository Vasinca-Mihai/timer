package Timer;

public class UniversalVar {
    public static final String setFilePath = "./src/UserData/";
    public static final String soundsFilepath = "./src/Resources/Sounds/";
    public static final String iconPath = "./src/Resources/images/";
    private static boolean doneCheck = true;

    public static boolean getDoneCheck() {
        return doneCheck;
    }

    public static void setDoneCheck(boolean setTo) {
        doneCheck = setTo;
    }
}
