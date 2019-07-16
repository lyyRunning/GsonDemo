package com.function.luo.data;

import java.io.Serializable;

/**
 * Created by luo on 2019/7/15.
 */

public class Animal implements Serializable{

    public String result;
    public String message;
    private Data data;

    public Animal() {
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
