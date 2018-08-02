package com.spring.study.repository;

import com.spring.study.domain.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("ClothesRepository")
public interface ClothesRepository extends JpaRepository<Clothes, Long> {
    Clothes findByName(String name);
    @Transactional
    Long deleteByName(String name);
}
