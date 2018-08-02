package com.spring.study.service;

import com.spring.study.domain.*;

import java.util.Map;

public interface ClothesService {
    BaseResponse init();
    BaseResponse initClothes();
    BaseListResponse add(ClothesListRequest<Clothes> clothesListRequest);
    BaseResponse delete(String name);
    ClothesResponse recommend();
    boolean dummyAdd();
    boolean deleteAll();
    ClothesResponse getClothes(String name);
    ClothesResponse update(ClothesRequest clothesRequest);
    BaseListResponse getList();
}
