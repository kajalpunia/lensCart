package com.lenscart.productms.repository;

import com.lenscart.productms.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Products, Long> {
}
