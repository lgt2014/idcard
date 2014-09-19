package com.lgt;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 */
public class IDGenerator {

    public static final int IDENTIFIER_LENGTH = 11;
    private static ZoneTree zt ;
    private static Map<String,Integer> seqs = new HashMap<String,Integer>();
    static{
        ZoneGenerator zoneGenerator = new ZoneGenerator();
        zoneGenerator.initZoneData();
        zt = zoneGenerator.getZt();
    }
    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            System.out.println(generateID("临清市", "19871123"));
        }
    }

    public static String generateID(String zoneName,String birth){
        String zoneData = zt.findNode(zt.getRoot(),zoneName).getData();
        String seq = getSequence(zoneName);
        String ids = zoneData + birth + seq;
        String identifier = getIdentifierStr(ids);
        return ids+identifier;
    }
    /**
     * Get the factor of according index.
     * [2^(18-i)]mod11
     * The index start from 1 to 17.
     *
     * @param index
     * @return the factor according to index.
     * -1 if the index is invalid.
     */
    public static int getFactor(int index) {
        int[] factor = {-1, 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
        if (index < 1 || index > 17) {
            index = 0;
        }
        return factor[index];
    }

    public static String getZoneData(String zoneName){

        Node n = zt.findNode(zt.getRoot(),zoneName);
        return n.getData();
    }

    public static String getBirthday(String   birth){
        return birth;
    }
    public static String getSequence(String zoneName){
        int seq=0;
        if(seqs.get(zoneName)==null){
            seqs.put(zoneName,0);
        }else{
            seq = seqs.get(zoneName);
            seq++;
            seqs.put(zoneName,seq);
        }
        return String.format("%1$03d",seq);
    }
    /**
     * Get the sum of every number multi its factor.
     *
     * @param ids The first 17th number array.
     * @return sum.
     */
    public static int getSum(int[] ids) {
        int sum = 0;
        for (int i = 0; i < ids.length; i++) {
            sum += ids[i] * getFactor(i + 1);
        }
        return sum;
    }

    public static String getIdentifierStr(String str){
        int[] ids = new int[17];
        for(int i=0;i<17;i++){
            ids[i]=Integer.parseInt(str.substring(i,i+1));
        }
        return getIdentifierStr(ids);
    }
    public static String getIdentifierStr(int[] ids) {
        int sum = getSum(ids);
        int mod = sum % IDENTIFIER_LENGTH;
        return getIdentifierStr(mod);
    }

    public static String getIdentifierStr(int mod) {
        String[] identifierStr = {"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};
        if (mod >= 0 && mod <= 10) {
            return identifierStr[mod];
        } else {
            return "-1";
        }
    }
}
