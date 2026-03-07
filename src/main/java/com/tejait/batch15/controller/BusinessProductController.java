
package com.tejait.batch15.controller;

import com.tejait.batch15.model.BusinessProducts;
import com.tejait.batch15.service.BusinessProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("loans")
public class BusinessProductController {

    private final BusinessProductService service;

    @RequestMapping(

            value = "saveProductDetails/{appId}",

            method = {RequestMethod.POST, RequestMethod.PUT}

    )

    public ResponseEntity<BusinessProducts> saveBusinessProducts(

            @PathVariable int appId,

            @RequestBody BusinessProducts products) {

        // bind appId from URL

        products.setAppId(appId);

        BusinessProducts businessProducts =

                service.saveproductsdetails(products);

        // UPDATE case

        if (products.getId() != 0) {

            return new ResponseEntity<>(businessProducts, HttpStatus.OK);

        }

        // SAVE case

        return new ResponseEntity<>(businessProducts, HttpStatus.CREATED);

    }
}

