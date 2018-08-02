package com.spring.study.domain;


import java.util.List;

public class ClothesListRequest<T> {

    private List<T> list;

    public List<T> getList() {
        return this.list;
    }
}
