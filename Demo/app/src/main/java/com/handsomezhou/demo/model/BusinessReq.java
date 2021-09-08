package com.handsomezhou.demo.model;

import com.android.commontools.util.AppUtil;
import com.android.commontools.util.DeviceUtil;
import com.handsomezhou.demo.AppApplication;
import com.handsomezhou.demo.util.SecurityUtil;


/**
 * Created by handsomezhou on 2019/9/26.
 *
 * 业务请求
 */

public class BusinessReq<T> {
    /**
     * 客户端id
     */
    private String clientId;

    /**
     *  当前时间戳(毫秒单位)
     */
    private long timestamp;
    /**
     *
     */
    private String appKey;

    /**
     * version number 版本号
     */
    private Integer vn;

    /**
     * 防篡改
     * 1.signature = HmacSHA256(app_secret, timestamp)
     *
     * 2.signature
     * 其中
     * String originSign = "mid=" + MID + "&param=" + param + "&timestamp=" + timestamp + "&" + KEY;
     * return DigestUtils.md5Hex(originSign).toUpperCase();
     */
    //private String signature;
    /**
     * 业务数据
     */
    private T data;

    public BusinessReq() {
        String deviceId=DeviceUtil.getDeviceId(AppApplication.getContext());
        clientId= SecurityUtil.getClientId(deviceId);
        timestamp= System.currentTimeMillis();
        appKey= SecurityUtil.getAppKey(clientId,timestamp);
        vn= AppUtil.getVersionCode(AppApplication.getContext());
        /*System.out.println("BusinessReq timestamp["+timestamp+"]["+String.valueOf(timestamp).length()+"]");
        System.out.println("BusinessReq deviceId["+deviceId+"]["+deviceId.length()+"]");
        System.out.println("BusinessReq clientId["+clientId+"]["+clientId.length()+"]");
        System.out.println("BusinessReq appKey["+appKey+"]["+appKey.length()+"]");*/
    }

    public BusinessReq(long timestamp, String appKey, T data) {
        this.timestamp = timestamp;
        this.appKey = appKey;
        this.data = data;
        this.vn= AppUtil.getVersionCode(AppApplication.getContext());
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public Integer getVn() {
        return vn;
    }

    public void setVn(Integer vn) {
        this.vn = vn;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
