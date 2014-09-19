package com.lgt;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by lgt on 8/17/14.
 */
public class ZoneGenerator {
    public ZoneTree getZt() {
        return zt;
    }

    private ZoneTree zt = new ZoneTree();

    /**
     * generate zone data from files.
     */
    public void initZoneData() {
        String pathURL = ZoneGenerator.class.getResource("/china.txt").getPath();
        addZone(pathURL);
    }

    private void addZone(String path) {
        Map<String, String> provinces = FileHelper.getConfig(path);
        Set<String> keys = provinces.keySet();
        for (String key : keys) {
            zt.addNode(new Node(key, provinces.get(key)));
            if (provinces.get(key).length() >= 6) {
                return;
            }
            String ztPath = changePath(path, provinces.get(key) + ".txt");
            addZone(ztPath);
        }
    }

    private String changePath(String path, String s) {
        String fileName = path.replaceAll("/[a-z0-9]+.txt", "/" + s);
        return fileName;
    }

    private Map<String, String> getZoneData(String filePath) {
        Map<String, String> res = new HashMap<>();
        Map<String, String> data = FileHelper.getConfig(filePath);
        return res;
    }
}
