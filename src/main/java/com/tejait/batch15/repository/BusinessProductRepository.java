package com.tejait.batch15.repository;

import com.tejait.batch15.model.BusinessProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessProductRepository extends JpaRepository<BusinessProducts,Integer> {
    public BusinessProducts findByAppId(Integer appId);

    Integer appId(int appId);
}