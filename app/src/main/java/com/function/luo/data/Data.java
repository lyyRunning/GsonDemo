package com.function.luo.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by luo on 2019/7/15.
 */

public class Data implements Serializable{

    private int id;
    private String store;

    private List<Dog> dog = new ArrayList<Dog>();

    public Data() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public List<Dog> getDog() {
        return dog;
    }

    public void setDog(List<Dog> dog) {
        this.dog = dog;
    }
}
