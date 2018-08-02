package com.spring.study.domain;

public class ClothesResponse {
    private String result;
    private Clothes clothes;

    public Clothes getClothes() {
        return clothes;
    }

    public void setClothes(Clothes clothes) {
        this.clothes = clothes;
    }

    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }

}
