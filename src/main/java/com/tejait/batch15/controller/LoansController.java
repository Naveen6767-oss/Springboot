
package com.tejait.batch15.controller;

import com.tejait.batch15.model.BusinessProducts;
import com.tejait.batch15.model.CompanyAddress;
import com.tejait.batch15.model.CompanyDetails;
import com.tejait.batch15.model.Loans;
import com.tejait.batch15.service.LoansService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("loans")
public class LoansController {

    LoansService service;
    @PostMapping("applyLoan")
    public ResponseEntity<Loans> saveLoanDetails(@RequestBody Loans loan){
        Loans savedloan=service.saveloandetails(loan);
        return new ResponseEntity<>(savedloan, HttpStatus.CREATED);
    }
    @GetMapping("loanTaskboard")
    public ResponseEntity<List<Loans>> getAllLoans(){
        List<Loans> loans = service.getallloandetails();
        return new ResponseEntity<>(loans,HttpStatus.OK);
    }
    @GetMapping("getProductDetails/{appid}")
    public ResponseEntity<BusinessProducts> getById(@PathVariable Integer appid){
        BusinessProducts list =service.getallbusinessdetails(appid);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }@GetMapping("getCompanyDetails/{appid}")
    public ResponseEntity<CompanyDetails> GetById(@PathVariable Integer appid){
        CompanyDetails companydetails=service.getcompanydetailsbyid(appid);
        return new ResponseEntity<>(companydetails,HttpStatus.OK);
    }@GetMapping("getCompanyAddress/{appid}")
    public ResponseEntity<CompanyAddress> getByid(@PathVariable Integer appid){
        CompanyAddress getcompanyaddress =service.getCompanyAddressdetails(appid);
        return new ResponseEntity<>(getcompanyaddress,HttpStatus.OK);
    }
}
