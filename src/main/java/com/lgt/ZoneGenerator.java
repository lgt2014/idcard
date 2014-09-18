package com.lgt;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by lgt on 8/17/14.
 */
public class ZoneGenerator {
    public Map<String, Object> zones = new HashMap<String, Object>();

    /**
     * generate zone data from files.
     */
    public void initZoneData() {
        String pathURL = ZoneGenerator.class.getResource("/china.txt").getPath() + "/";
        Map<String, String> provinces = FileHelper.getConfig(pathURL);
        Set<String> keys = provinces.keySet();
        for (String key : keys) {
            System.out.println(key);
            System.out.println((provinces.get(key)));
        }
    }

    private Map<String, String> getZoneData(String filePath) {
        Map<String, String> res = new HashMap<>();
        Map<String, String> data = FileHelper.getConfig(filePath);
        return res;
    }
}
