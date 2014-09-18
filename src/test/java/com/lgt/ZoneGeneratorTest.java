package com.lgt;

import org.junit.Test;

import static org.junit.Assert.*;

public class ZoneGeneratorTest {

    @Test
    public void testInitZoneData() throws Exception {
        ZoneGenerator zoneGenerator = new ZoneGenerator();
        zoneGenerator.initZoneData();
    }
}