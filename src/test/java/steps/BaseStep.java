package steps;

import common.AppiumServerBuilder;
import common.tools.Converter;
import common.tools.PropertiesManager;

public class BaseStep {
    protected String userId = PropertiesManager.getValueOf("users.bacdd.userId");
    protected String password = PropertiesManager.getValueOf("users.bacdd.password");
    private Converter converter;
    private AppiumServerBuilder server;
    protected Converter Converter = converter == null ? new Converter() : converter;
}
