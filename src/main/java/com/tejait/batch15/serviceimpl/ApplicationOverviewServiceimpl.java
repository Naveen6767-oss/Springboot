package com.tejait.batch15.serviceimpl;

import com.tejait.batch15.model.*;
import com.tejait.batch15.repository.BusinessProductRepository;
import com.tejait.batch15.repository.CompanyAddressRepository;
import com.tejait.batch15.repository.CompanyDetailsRepository;
import com.tejait.batch15.repository.LoansRepository;
import com.tejait.batch15.service.ApplicationOverviewService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ApplicationOverviewServiceimpl implements ApplicationOverviewService {
    private final CompanyDetailsRepository companyDetailsRepository;
    private final CompanyAddressRepository companyAddressRepository;
    private final BusinessProductRepository businessProductRepository;
    private final LoansRepository loansRepository;

    @Override
    public ApplicationOverview getoverviewbyid(int appId) {
        // Fetch single objects (NOT LIST)
        CompanyDetails company =
                companyDetailsRepository.findByAppId(appId);

        CompanyAddress address =
                companyAddressRepository.findByAppId(appId);

        BusinessProducts product =
                businessProductRepository.findByAppId(appId);

        Loans loan =
                loansRepository.findByAppId(appId);

        // Create overview object
        ApplicationOverview overview = new ApplicationOverview();

        overview.setAppId(appId);

        // Company Details Mapping
        if (company != null) {
            overview.setCompanyName(company.getCompanyName());
            overview.setCompanyPan(company.getCompanyPan());
        }

        // Loan Mapping
        if (loan != null) {
            overview.setMail(loan.getMailId());
            overview.setMobile(loan.getMobile());
        }

        // Address Mapping
        if (address != null) {
            overview.setCity(address.getCity());
        }

        // Business Product Mapping
        if (product != null) {
            overview.setLoanAmt(product.getLoanAmount());
            overview.setTenure(product.getTenure());
        }

        return overview;
    }


}