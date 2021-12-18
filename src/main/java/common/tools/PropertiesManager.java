package common.tools;

import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class PropertiesManager {
    PropertiesManager() {
        throw new IllegalStateException("Properties Manager class");
    }

    public static String getValueOf(String key){
        EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
        return variables.getProperty(key);
    }

    public static boolean getValueOfAsBoolean(String key){
        EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
        return variables.getPropertyAsBoolean(key, true);
    }
}
