package com.spring.study.service;

import com.spring.study.domain.*;

import java.util.Map;

public interface ClothesService {
    BaseResponse init();
    BaseResponse initAdd();
    BaseListResponse add(ClothesList<Clothes> clothesList);
    BaseResponse delete(String name);
    Map<String, Object> recommend();
    boolean dummyAdd();
    boolean deleteAll();
    ClothesResponse find(String name);
    BaseListResponse findAll();
}
