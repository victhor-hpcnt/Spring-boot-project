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
    @DeleteMapping(path = "/init")
    public BaseResponse init() {
        return clothesService.init();
    }
    @ApiOperation(value = "Clothes init", notes = "옷리스트를 셋팅한다.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "셋팅 성공"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    @PostMapping(path = "/initAdd")
    public BaseResponse initAdd() {
        return clothesService.initAdd();
    }

    @ApiOperation(value = "Clothes 검색", notes = "옷을 검색한다.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "검색 성공"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    @GetMapping(path = "/find")
    public ClothesResponse find(@RequestParam(value="name", required=true) String name) {
        return clothesService.find(name);
    }

    @ApiOperation(value = "Clothes list", notes = "옷 리스트를 들고온다.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "리스트 조회 성공"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    @GetMapping(path = "/findAll")
    public BaseListResponse findAll() {
        return clothesService.findAll();
    }

    @ApiOperation(value = "Clothes add", notes = "옷을 추가한다.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "조회 성공"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    @PostMapping(path = "/add")
    public BaseListResponse add(@RequestBody ClothesList<Clothes> clothesList) {
        return clothesService.add(clothesList);
    }

    @ApiOperation(value = "Clothes delete", notes = "옷을 삭제한다.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "조회 성공"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    @DeleteMapping(path = "/delete")
    public BaseResponse delete(@RequestBody Map<String, String> map) {
        return clothesService.delete(map.get("name"));
    }

}
