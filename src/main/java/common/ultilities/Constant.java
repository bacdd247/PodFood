package common.ultilities;

import common.tools.PropertiesManager;

public class Constant {
    public static final int TIME_OUT = 60;
    public static final int IMPLICIT_WAIT = Integer.parseInt(PropertiesManager.getValueOf("webdriver.timeouts.implicitlywait"));
}
