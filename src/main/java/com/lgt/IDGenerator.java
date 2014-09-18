package com.lgt;

/**
 * Hello world!
 */
public class IDGenerator {

    public static final int IDENTIFIER_LENGTH = 11;

    public static void main(String[] args) {
        System.out.println("Hello World!");
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

    public String getProvinceCode(String province){

        return "";
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
