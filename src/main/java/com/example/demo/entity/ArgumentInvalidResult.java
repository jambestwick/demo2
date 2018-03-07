package com.example.demo.entity;

import java.io.Serializable;

public class ArgumentInvalidResult implements Serializable {

    private static final long serialVersionUID = -6932677619994486228L;

    /**
     * 字段名称
     */
    private String field;

    /**
     * 被拒绝的值
     */
    private Object rejectedValue;

    /**
     * 默认错误描述信息
     */
    private String defaultMessage;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Object getRejectedValue() {
        return rejectedValue;
    }

    public void setRejectedValue(Object rejectedValue) {
        this.rejectedValue = rejectedValue;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }

    public void setDefaultMessage(String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }

    public ArgumentInvalidResult(String field, Object rejectedValue, String defaultMessage) {
        this.field = field;
        this.rejectedValue = rejectedValue;
        this.defaultMessage = defaultMessage;
    }

    public ArgumentInvalidResult() {
    }
}
