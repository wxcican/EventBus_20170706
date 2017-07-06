package com.fuicuiedu.xc.eventbus_20170706;

/**
 * 作者：王小超
 * 邮箱：wxcican@qq.com
 */

public class MessageEvent {

    private String message;

    public MessageEvent(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
