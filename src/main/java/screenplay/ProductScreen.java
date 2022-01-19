package screenplay;

import net.serenitybdd.screenplay.targets.Target;

public class ProductScreen {
    private ProductScreen() {
        throw new IllegalStateException("ProductScreen class");
    }

    public static final Target PRODUCT_IN4 = Target.the("product information")
            .locatedForAndroid(By.xpath("//android.widget.TextView[contains(@text,'" + "" +"')]"))
            .locatedForIOS(By.xpath(""));


}
