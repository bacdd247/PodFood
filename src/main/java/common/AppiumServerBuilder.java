package common;

import common.tools.PropertiesManager;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumServerBuilder {
    private AppiumDriverLocalService server;
    private boolean isAppiumBuilded;

    public void getAppiumService(){
        String hub = PropertiesManager.getValueOf("appium.hub");
        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder.usingPort(getPort(hub));
        builder.withIPAddress(getIp(hub));
        if(!isAppiumBuilded){
            server = AppiumDriverLocalService.buildService(builder);
            isAppiumBuilded = true;
        }
    }

    public void startServer(){
        if(server != null && !server.isRunning()){
            server.start();
        }
    }

    public void stopServer(){
        if (server != null && server.isRunning()){
            server.stop();
        }

    }

    private int getPort(String hub){
        int firstIndex = hub.lastIndexOf(":") + 1;
        int lastIndex = hub.indexOf("wd") - 1;
        return Integer.parseInt(hub.substring(firstIndex, lastIndex));
    }

    private String getIp(String hub){
        int firstIndex = hub.indexOf("/") + 2;
        int lastIndex = hub.lastIndexOf(":");
        return hub.substring(firstIndex, lastIndex);
    }
}
