package com.nam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nam.entity.CategoryEntity;

@Repository

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{
		CategoryEntity findOneByCode(String code);
}
