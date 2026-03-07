package com.tejait.batch15.serviceimpl;


import com.tejait.batch15.model.CompanyDetails;
import com.tejait.batch15.repository.CompanyDetailsRepository;
import com.tejait.batch15.service.CompanyDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CompanyDetailsServiceimpl implements CompanyDetailsService {
    CompanyDetailsRepository repository;

    @Override
    public CompanyDetails saveCompanydetails(CompanyDetails details) {

        // check if record already exists for this appId
        CompanyDetails existing =
                repository.findByAppId(details.getAppId());

        // if exists → convert save into update
        if (existing != null) {
            details.setId(existing.getId());
        }

        return repository.save(details);
    }
}
