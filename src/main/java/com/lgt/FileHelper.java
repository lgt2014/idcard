package com.lgt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by lgt on 8/18/14.
 */
public class FileHelper {
    public static Properties readProperty(String filePath){
        Properties properties = new Properties();
        try {
            FileReader reader = new FileReader(filePath);
            BufferedReader br = new BufferedReader(reader);
            String line ="";
            while((line=br.readLine())!=null){
                String[] property = line.split("=");
                properties.setProperty(property[0],property[1]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
    public static Map<String,String> getConfig(String filePath){
        Map<String,String> res = new HashMap<String,String>();
        try {
            FileReader reader = new FileReader(filePath);
            BufferedReader br = new BufferedReader(reader);
            String line ="";
            while((line=br.readLine())!=null){
                String[] property = line.split("=");
                res.put(property[0],property[1]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
}
