package com.lgt;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static org.junit.Assert.*;

public class FileHelperTest {

    @Test
    public void testReadProperty() throws Exception {
        Properties properties = FileHelper.readProperty(FileHelper.class.getResource("/").getPath()+"/37.txt");
        Properties expectedProps = new Properties();
        expectedProps.setProperty("聊城市","3715");
        assertEquals(expectedProps,properties);
    }
    @Test
    public void testGetConfig(){
        Map config = FileHelper.getConfig(FileHelper.class.getResource("/").getPath()+"/37.txt");
        Map expectConfig = new HashMap();
        expectConfig.put("聊城市", "3715");
        assertEquals(expectConfig,config);
    }
}