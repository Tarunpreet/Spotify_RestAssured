package org.spotify.Utils;

import java.util.Properties;

import static org.spotify.Utils.PropertiesUtil.PropertiesLoader;

public class DataManager {
    private final Properties properties;
    private static DataManager Instance;
    private DataManager()
    {
        properties=PropertiesLoader("data");
    }
    public static DataManager getInstance()
    {
        if (Instance==null) //Will be Initilaized once only so properties file will get loaded one time only in whole execution
        {
            Instance=new DataManager();
            return Instance;
        }
        return Instance;//ALready Initailized giving previous object only
    }
    public Object get(String Key)
    {
        return properties.get(Key);
    }
}
