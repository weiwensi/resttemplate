package com.one.learn.resttemplate.util;

public enum EnumOne {


    REGISTER(100000, "注册使用") {
        @Override
        public String deliver(int pz) {
            return "hello";
        }
    },
    FORGET_PASSWORD(100001, "忘记密码使用") {
        @Override
        public String deliver(int pz) {
            return "你好";
        }
    },
    UPDATE_PHONE_NUMBER(100002, "更新手机号码使用")
    ;

    private final int code;
    private final String message;

    EnumOne(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "PinType{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }


    String deliver(int pz) {
        return "默认值";
    }


}
