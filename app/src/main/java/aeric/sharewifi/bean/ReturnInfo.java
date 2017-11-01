package aeric.sharewifi.bean;

import java.util.List;

/**
 * Created by ${Lizhiq} on 2017/11/1.
 */

public class ReturnInfo {
    private int code;
    private String msg;
    private String userMsg;
    private List<Object> data;

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setUserMsg(String userMsg) {
        this.userMsg = userMsg;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public String getUserMsg() {
        return userMsg;
    }

    public List<Object> getData() {
        return data;
    }
}

