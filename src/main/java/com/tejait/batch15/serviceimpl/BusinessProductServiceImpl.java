package com.tejait.batch15.serviceimpl;


import com.tejait.batch15.model.BusinessProducts;
import com.tejait.batch15.repository.BusinessProductRepository;
import com.tejait.batch15.service.BusinessProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BusinessProductServiceimpl implements BusinessProductService {
    BusinessProductRepository repository;

    @Override
    public BusinessProducts saveproductsdetails(BusinessProducts products) {

        // check if record already exists for this appId
        BusinessProducts existing =
                repository.findByAppId(products.getAppId());

        // if exists → convert save into update
        if (existing != null) {
            products.setId(existing.getId());
        }

        return repository.save(products);
    }

}
