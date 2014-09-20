package com.lgt;

import static junit.framework.Assert.*;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


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
        String str="37158119871113687";
        assertEquals("6",IDGenerator.getIdentifierStr(str));
    }
    @Test
    public void testGetZoneData(){
        assertEquals("420102",IDGenerator.getZoneData("江岸区"));
        assertEquals("370000",IDGenerator.getZoneData("山东"));
        assertEquals("370000",IDGenerator.getZoneData("山东省"));
        assertEquals("371500",IDGenerator.getZoneData("聊城"));
    }
    @Test
    public void testGetOptionalNames(){
        IDGenerator idGenerator = new IDGenerator();
        Class[] paramsType = new Class[1];
        paramsType[0] = String.class;
        Object[] args = new Object[1];
        args[0] = new String("山东");
        List res1 = new ArrayList<String>();
        res1.add("山东");
        res1.add("山东省");
        res1.add("山东市");
        res1.add("山东县");
        res1.add("山东区");
        List res2 = new ArrayList<String>();
        res2.add("聊城");
        res2.add("聊城省");
        res2.add("聊城市");
        res2.add("聊城县");
        res2.add("聊城区");
        try {
            Method method = idGenerator.getClass().getDeclaredMethod("getOptionalNames",paramsType);
            method.setAccessible(true);
            List name = (List) method.invoke(idGenerator,new Object[]{new String("山东")});
            assertTrue(name.equals(res1));
            name = (List) method.invoke(idGenerator,new Object[]{new String("聊城")});
            assertTrue(name.equals(res2));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testGetSequence(){
        String seq = IDGenerator.getSequence("江岸区");
        assertEquals("000",seq);
    }
}