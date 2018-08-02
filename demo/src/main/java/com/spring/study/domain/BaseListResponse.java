package com.spring.study.domain;

import java.util.List;

public class BaseListResponse<T> {

    private String result;
    private List<T> list;
    private int count;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }
}
