package screenplay;

import io.appium.java_client.MobileBy;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginScreen {
    private LoginScreen(){ throw new IllegalStateException("LoginScreen class"); }

    public static final Target EMAIL_BOX = Target.the("email box")
            .locatedForAndroid(MobileBy.linkText("//android.view.ViewGroup[@text='Password']//preceding::android.widget.EditText"))
            .locatedForIOS(By.xpath(""));

    public static final Target PASSWORD_BOX = Target.the("password box")
            .locatedForAndroid(MobileBy.linkText("//android.view.ViewGroup[@text='Password']//following::android.widget.EditText"))
            .locatedForIOS(By.xpath(""));

    public static final Target LOGIN_BT = Target.the("login button")
            .locatedForAndroid(By.xpath("//*[contains(@text,'Login')]"))
            .locatedForIOS(By.xpath(""));
}
