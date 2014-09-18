package com.lgt;

import static junit.framework.Assert.*;

import org.junit.Test;


public class IDGeneratorTest{
    IDGenerator identifier = new IDGenerator();
    int [] ids = {3,4,0,5,2,4,1,9,8,0,0,1,0,1,0,0,1};
    @Test
    public void testGetFactor(){

        assertEquals(7, identifier.getFactor(1));
        assertEquals(9, identifier.getFactor(2));
        assertEquals(10, identifier.getFactor(3));
        assertEquals(5, identifier.getFactor(4));
        assertEquals(8, identifier.getFactor(5));
        assertEquals(4, identifier.getFactor(6));
        assertEquals(2, identifier.getFactor(7));
        assertEquals(1, identifier.getFactor(8));
        assertEquals(6, identifier.getFactor(9));
        assertEquals(3, identifier.getFactor(10));
        assertEquals(7, identifier.getFactor(11));
        assertEquals(9, identifier.getFactor(12));
        assertEquals(10, identifier.getFactor(13));
        assertEquals(5, identifier.getFactor(14));
        assertEquals(8, identifier.getFactor(15));
        assertEquals(4, identifier.getFactor(16));
        assertEquals(2, identifier.getFactor(17));
        assertEquals(-1, identifier.getFactor(171));
        assertEquals(-1, identifier.getFactor(-3));
        assertEquals(-1, identifier.getFactor(0));
    }
    //34052419800101001X
    @Test
    public void testGetSum(){

        assertEquals(189,identifier.getSum(ids));
    }
    @Test
    public void testGetIdentifier(){
        assertEquals("X",IDGenerator.getIdentifierStr(ids));
    }
}