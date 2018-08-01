package com.spring.study.controller;


import com.spring.study.service.ClothesService;
import com.spring.study.service.ClothesServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@Api(description = "옷", tags = {"Clothes"})
public class ClothesController {

    @Resource(name = "ClothesService")
    private ClothesServiceImpl clothesService;

    @ApiOperation(value = "Clothes 추천", notes = "옷을 추천한다.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "조회 성공"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    @GetMapping(path = "/")
    public Map<String, String> recommendClothes() {

        return clothesService.recommend();
    }
}
