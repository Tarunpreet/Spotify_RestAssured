package org.spotify.Utils;

import java.util.Properties;

import static org.spotify.Utils.PropertiesUtil.PropertiesLoader;

public class ConfigManager {
    private final Properties properties;
    private static ConfigManager Instance;
    private ConfigManager()
    {
        properties=PropertiesLoader("cred");
    }
    public static ConfigManager getInstance()
    {
        if (Instance==null) //Will be Initilaized once only so properties file will get loaded one time only in whole execution
        {
            Instance=new ConfigManager();
            return Instance;
        }
        return Instance;//ALready Initailized giving previous object only
    }
    public  Object get(String Key)
    {
        return properties.get(Key);
    }
// usage    ConfigManager.getInstance -> as static fn which gives object of config manager.. chaining
 //   ConfigManager.getInstance.get(key) -> as gets call by an object of config manager class
}
