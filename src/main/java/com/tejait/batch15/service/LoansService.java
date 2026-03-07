package com.tejait.batch15.service;

import com.tejait.batch15.model.BusinessProducts;
import com.tejait.batch15.model.CompanyAddress;
import com.tejait.batch15.model.CompanyDetails;
import com.tejait.batch15.model.Loans;

import java.util.List;

public interface LoansService {
    Loans saveloandetails(Loans loan);

    List<Loans> getallloandetails();


    BusinessProducts getallbusinessdetails(Integer appid);

    CompanyDetails getcompanydetailsbyid(Integer appid);

    CompanyAddress getCompanyAddressdetails(Integer appid);
}
