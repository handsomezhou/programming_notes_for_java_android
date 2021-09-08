package com.handsomezhou.demo.util;

import com.handsomezhou.demo.model.BusinessReq;

/**
 * Created by handsomezhou on 2020/2/25.
 */
public class SecurityUtil {
    /**
     *    deviceId;timestamp;f(x);
     *     {"appKey":"75aAO5aGaGWA5","clientId":"U0Nc0OJcO00UqcOO","timestamp":1582626145617}
     *     clientId=f(deviceId);
     *     appKey=f(clientId+timestamp)
     */
    /**
     *
     * @param deviceId
     * @return
     */
    public static String getClientId(String deviceId){
        return RandomCodeUtil.generateRandomCode(deviceId);
    }

    /**
     *
     * @param clientId
     * @param timestamp
     * @return
     */
    public static String getAppKey(String clientId, long timestamp){
        String str=timestamp+clientId;
        String outOfOrderStr=outOfOrder(str);
        return RandomCodeUtil.generateRandomCode(outOfOrderStr);
    }

    /**
     * 固定乱序
     * @param str
     * @return
     */
    private static String outOfOrder(String str){
        StringBuffer outOfOrderSb=new StringBuffer();

        do{
            if(null==str||str.length()<=0){
                break;
            }

            int strLen=str.length();
            int sum=0;
            for(int i=0;i<strLen; i++){
                sum=sum+str.charAt(i);
            }

            int splitIndex=sum%strLen;
            for(int i=splitIndex;i<strLen;i++){
                outOfOrderSb.append(str.charAt(i));
            }

            for(int i=0;i<splitIndex;i++){
                outOfOrderSb.append(str.charAt(i));
            }

        }while (false);

        return outOfOrderSb.toString();
    }

    /**
     * 是否合法客户端
     * @param businessReq
     * @return
     */
    public static boolean isLegalClient(final BusinessReq businessReq){
        boolean legalClient=false;

        do{
            if(null==businessReq){
                break;
            }

            if(false==getAppKey(businessReq.getClientId(),businessReq.getTimestamp()).equals(businessReq.getAppKey())){
                break;
            }

            legalClient=true;
        }while (false);

        return legalClient;
    }

}
