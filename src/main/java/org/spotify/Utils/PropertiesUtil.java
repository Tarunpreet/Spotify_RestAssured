package org.spotify.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
    public static Properties PropertiesLoader(String Filename) {
       Properties pro=new Properties();
       String PathtoFile=System.getProperty("user.dir")+"/src/main/resources/"+Filename+".properties";
       File file=new File(PathtoFile);
        FileInputStream fileInputStream;
        try {
             fileInputStream=new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            pro.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return pro;
    }

}
