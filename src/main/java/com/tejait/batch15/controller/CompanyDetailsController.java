
package com.tejait.batch15.controller;

import com.tejait.batch15.model.CompanyDetails;
import com.tejait.batch15.service.CompanyDetailsService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("loans")
public class CompanyDetailsController {

    @Autowired
    private final CompanyDetailsService service;

    @RequestMapping(

            value = "saveCompanyDetails/{appId}",

            method = {RequestMethod.POST, RequestMethod.PUT}

    )

    public ResponseEntity<CompanyDetails> saveCompanyDetails(

            @PathVariable int appId,

            @RequestBody CompanyDetails details) {

        // bind appId from URL

        details.setAppId(appId);

        CompanyDetails companydetails =

                service.saveCompanydetails(details);

        // UPDATE case

        if (details.getId() != 0) {

            return new ResponseEntity<>(companydetails, HttpStatus.OK);

        }

        // SAVE case

        return new ResponseEntity<>(companydetails, HttpStatus.CREATED);

    }
}
