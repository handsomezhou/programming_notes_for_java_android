package com.handsomezhou.demo.model;



import com.handsomezhou.demo.constant.ResultCode;

import java.io.Serializable;

/**
 * Created by handsomezhou on 2019/9/26.
 *
 * 业务响应
 */

public class BusinessRsp <T> implements Serializable {
    /**
     * 结果码
     */
    private int resultCode;

    /**
     * 结果信息
     */
    private String resultMessage;

    /**
     * 业务数据
     */
    private T data;

    public BusinessRsp() {
        this.resultCode= ResultCode.SUCCESS;
    }

    public BusinessRsp(int resultCode, String resultMessage, T data) {
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
        this.data = data;
    }

    @Override
    public String toString() {
        return "HttpResult{" +
                "resultCode=" + resultCode +
                ", resultMessage='" + resultMessage + '\'' +
                ", data=" + data +
                '}';
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
