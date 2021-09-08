package com.handsomezhou.demo.util;

/**
 * Created by handsomezhou on 2020/2/24.
 */
public class RandomCodeUtil {
    /**
     * 可以有多个随机Key
     */
    public static String RANDOM_KEY="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    public static char CHAR_ZERO='0';
    /**
     * @param timestamp 1582556186993
     * @return
     */
    public static String generateRandomCode(long timestamp){
        String timestampStr= String.valueOf(timestamp);

        return generateRandomCode(timestampStr);
    }

    /**
     * @param str
     * @return
     */
    public static String generateRandomCode(String str){
        StringBuffer randomCodeSb=new StringBuffer();
        do{
            if(null==str||str.length()<=0){
                break;
            }

            int strSize=str.length();
            for (int i=strSize-1; i>=0;i--) {
                int index=(str.charAt(i)-CHAR_ZERO)%strSize;
                int value=str.charAt(index)-CHAR_ZERO;
                int index_value=index*value;

                randomCodeSb.append(RandomCodeUtil.getChar(index_value));
            }
        }while (false);
        return randomCodeSb.toString();
    }
    /**
     * 根据num计算出对应RANDOM_KEY的index所对应的值
     * @param num
     * @return
     */
    public static char getChar(int num){
        return getChar(RANDOM_KEY,num);
    }

    /**
     *
     * @param str
     * @param num
     * @return
     */
    public static char getChar(String str, int num){

        char chr=CHAR_ZERO;
        do{
            if(null==str){
                break;
            }

            if(str.length()<=0){
                break;
            }

            int strLength=str.length();
            int index=num%strLength;
            chr=str.charAt(index);
        }while (false);

        return chr;
    }
}

