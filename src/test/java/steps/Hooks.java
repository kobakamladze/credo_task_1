package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks {

    private final String APP_PACKAGE_NAME = "com.credobusiness";

    @Before
    public void setUp() {
        try {
            Runtime.getRuntime().exec("adb shell monkey -p " + APP_PACKAGE_NAME + " -c android.intent.category.LAUNCHER 1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() {
        try {
            Runtime.getRuntime().exec("adb shell am force-stop " + APP_PACKAGE_NAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
