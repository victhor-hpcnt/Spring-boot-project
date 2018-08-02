package com.spring.study.controller;


import com.spring.study.domain.*;
import com.spring.study.service.ClothesServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@Api(description = "옷", tags = {"Clothes"})
public class ClothesController {

    @Resource(name = "ClothesService")
    private ClothesServiceImpl clothesService;

    @ApiOperation(value = "Clothes init", notes = "옷리스트를 초기화 한다.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "초기화 성공"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    @DeleteMapping(path = "/home")
    public BaseResponse init() {
        return clothesService.init();
    }

    @ApiOperation(value = "Clothes init list", notes = "옷리스트를 셋팅한다.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "셋팅 성공"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    @PostMapping(path = "/home/clothes")
    public BaseResponse initClothes() {
        return clothesService.initClothes();
    }

    @ApiOperation(value = "Clothes search", notes = "옷을 검색한다.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "검색 성공"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    @GetMapping(path = "/clothes/{name}")
    public ClothesResponse getClothes(@PathVariable(value="name") String name) {
        return clothesService.getClothes(name);
    }

    @ApiOperation(value = "Clothes list", notes = "옷 리스트를 들고온다.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "리스트 조회 성공"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    @GetMapping(path = "/clothes")
    public BaseListResponse getList() {
        return clothesService.getList();
    }

    @ApiOperation(value = "Clothes add", notes = "옷을 추가한다.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "추가 성공"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    @PostMapping(path = "/clothes")
    public BaseListResponse add(@RequestBody ClothesListRequest<Clothes> clothesListRequest) {
        return clothesService.add(clothesListRequest);
    }

    @ApiOperation(value = "Clothes delete", notes = "옷을 삭제한다.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "삭제 성공"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    @DeleteMapping(path = "/clothes/{name}")
    public BaseResponse delete(@PathVariable(value = "name") String name) {
        return clothesService.delete(name);
    }

    @ApiOperation(value = "Clothes update", notes = "옷을 수정한다.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "갱신 성공"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    @PutMapping(path = "/clothes")
    public ClothesResponse update(@RequestBody ClothesRequest clothesRequest) {
        return clothesService.update(clothesRequest);
    }

    @ApiOperation(value = "Clothes delete", notes = "옷을 수정한다.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "갱신 성공"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    @PutMapping(path = "/clothes/recommendation")
    public ClothesResponse recommend() {
        return clothesService.recommend();
    }


}
