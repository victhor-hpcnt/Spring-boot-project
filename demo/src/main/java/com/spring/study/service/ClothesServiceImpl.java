package com.spring.study.service;


import com.spring.study.domain.*;
import com.spring.study.repository.ClothesRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

@Service("ClothesService")
public class ClothesServiceImpl implements ClothesService {

    @Resource(name = "ClothesRepository")
    private ClothesRepository clothesRepository;

    //h2데이터 베이스를 초기화한다.
    @Override
    @Transactional
    public BaseResponse init() {
        BaseResponse baseResponse = new BaseResponse();
        boolean resultDelete = false;

        resultDelete = deleteAll();

        if(!resultDelete) {
            baseResponse.setResult("fail");
        } else {
            baseResponse.setResult("success");
        }
        return baseResponse;
    }

    //초기화하고 기본 데이터를 추가한다.
    @Override
    @Transactional
    public BaseResponse initClothes() {
        BaseResponse baseResponse = new BaseResponse();
        boolean resultDelete = false;
        boolean resultAdd = false;

        resultDelete = deleteAll();
        resultAdd = dummyAdd();

        if(!resultDelete || !resultAdd) {
            baseResponse.setResult("fail");
        } else {
            baseResponse.setResult("success");
        }
        return baseResponse;
    }

    //옷 삭제
    @Override
    public BaseResponse delete(String name) {
        BaseResponse baseResponse = new BaseResponse();

        Long result = clothesRepository.deleteByName(name);

        if(result > 0) {
            baseResponse.setResult("success");
        } else {
            baseResponse.setResult("fail");
        }
        return baseResponse;
    }

    //옷 추가
    @Override
    @Transactional
    public BaseListResponse add(ClothesListRequest<Clothes> clothesListRequest) {
        BaseListResponse baseListResponse = new BaseListResponse();
        List<Clothes> list = clothesListRequest.getList();
        Long size = clothesRepository.count();
        int listSize = list.size();
        if( listSize > 0) {
            for (int i = 0; i < listSize; i++) {
                clothesRepository.save(list.get(i));
            }
        }
        if( clothesRepository.count() == listSize + size) {
            baseListResponse.setResult("success");
            baseListResponse.setCount(listSize);
        } else {
            baseListResponse.setResult("fail");
        }

        return  baseListResponse;

    }

    //옷 검색
    @Override
    public ClothesResponse getClothes(String name) {
        ClothesResponse clothesResponse = new ClothesResponse();
        Clothes clothes = null;
        clothes = clothesRepository.findByName(name);

        if(clothes != null) {
            clothesResponse.setClothes(clothes);
            clothesResponse.setResult("success");
        } else {
            clothesResponse.setResult("fail");
        }
        return clothesResponse;

    }

    //옷 전체 리스트를 가져온다.
    @Override
    public BaseListResponse getList() {
        BaseListResponse baseListResponse = new BaseListResponse();
        List<Clothes> list = null;
        int listSize = 0;
        list = clothesRepository.findAll();

        listSize = list.size();

        if(listSize > 0) {
            baseListResponse.setResult("success");
            baseListResponse.setCount(listSize);
            baseListResponse.setList(list);
        } else {
            baseListResponse.setResult("fail");
        }
        return baseListResponse;

    }

    //옷을 수정한다.
    @Override
    public ClothesResponse update(ClothesRequest clothesRequest) {
        ClothesResponse clothesResponse = new ClothesResponse();
        Clothes clothes = null;
        Clothes result = null;
        clothes = clothesRepository.findByName(clothesRequest.getBefore());
        if(clothes != null) {
            clothes.setName(clothesRequest.getAfter());
            result = clothesRepository.save(clothes);
        }
        if(result != null) {
            clothesResponse.setResult("success");
            clothesResponse.setClothes(clothes);
        } else {
            clothesResponse.setResult("fail");
        }
        return clothesResponse;
    }

    //옷을 추천 받는다
    @Override
    public ClothesResponse recommend() {
        ClothesResponse clothesResponse = new ClothesResponse();
        List<Clothes> list = null;
        int num = 0;
        int listSize = 0;
        Random random = new Random();
        list = clothesRepository.findAll();

        listSize = list.size();

        if(listSize > 0) {
            num = random.nextInt(listSize);
            clothesResponse.setClothes(list.get(num));
            clothesResponse.setResult("success");
        } else {
            clothesResponse.setResult("fail");
        }
        return clothesResponse;
    }

    //데이터를 h2에 저장
    @Override
    @Transactional
    public boolean dummyAdd() {
        boolean result = false;
        clothesRepository.save(new Clothes("shirt",1));
        clothesRepository.save(new Clothes("tee",2));
        clothesRepository.save(new Clothes("pants",3));
        clothesRepository.save(new Clothes("jeans",4));

        int count = (int)clothesRepository.count();

        if(count == 4) {
            result = true;
        }
        return result;
    }

    //h2에 저장되어있는 데이터 삭제
    @Override
    @Transactional
    public boolean deleteAll() {
        boolean result = false;

        clothesRepository.deleteAll();
        int count = (int)clothesRepository.count();

        if(count == 0) {
            result = true;
        }

        return result;
    }
}
