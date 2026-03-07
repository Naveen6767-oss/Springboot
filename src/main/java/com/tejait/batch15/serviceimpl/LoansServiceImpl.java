package com.tejait.batch15.serviceimpl;

import com.tejait.batch15.Exceptions.MailAlreadyExcistException;
import com.tejait.batch15.Exceptions.MobileAlreadyExists;

import com.tejait.batch15.model.BusinessProducts;
import com.tejait.batch15.model.CompanyAddress;
import com.tejait.batch15.model.CompanyDetails;
import com.tejait.batch15.model.Loans;
import com.tejait.batch15.repository.BusinessProductRepository;
import com.tejait.batch15.repository.CompanyAddressRepository;
import com.tejait.batch15.repository.CompanyDetailsRepository;
import com.tejait.batch15.repository.LoansRepository;

import com.tejait.batch15.service.LoansService;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class LoansServiceImpl implements LoansService {
    LoansRepository repository;

    BusinessProductRepository productRepository;
    CompanyDetailsRepository companyrepository;
    CompanyAddressRepository addressRepository;

    @Override
    public Loans saveloandetails(Loans loan) {
        if(repository.findByMailId(loan.getMailId()).isPresent()){
            throw new MailAlreadyExcistException("mail already exists");
        }
        if(repository.findByMobile(loan.getMobile()).isPresent()){
            throw new MobileAlreadyExists("mobile number already exists");
        }
        String fname=loan.getFname();
        String lname=loan.getLname();
        loan.setCustomerName((fname.concat(" "+lname)));
        return repository.save(loan);
    }

    @Override
    public List<Loans> getallloandetails() {

        return repository.findAll();
    }

    @Override
    public BusinessProducts getallbusinessdetails(Integer appid) {
        return productRepository.findByAppId(appid);
    }

    @Override
    public CompanyDetails getcompanydetailsbyid(Integer appid) {
        return companyrepository.findByAppId(appid);
    }

    @Override
    public CompanyAddress getCompanyAddressdetails(Integer appid) {
        return addressRepository.findByAppId(appid) ;
    }


}
