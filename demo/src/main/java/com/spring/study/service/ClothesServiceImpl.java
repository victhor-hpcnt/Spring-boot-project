package com.spring.study.service;


import com.spring.study.domain.Clothes;
import com.spring.study.repository.ClothesRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service("ClothesService")
public class ClothesServiceImpl implements ClothesService {

    @Resource(name = "ClothesRepository")
    private ClothesRepository clothesRepository;

    @Override
    public Map<String, String> recommend() {
        Map<String, String> map = new HashMap<>();

        clothesRepository.deleteAll();

        if(!add()) {
            map.put("Type","fail");
        }
        map.put("Type","success");
        return map;
    }

    @Override
    public boolean add() {
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



}
