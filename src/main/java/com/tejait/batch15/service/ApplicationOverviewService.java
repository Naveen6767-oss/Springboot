package com.tejait.batch15.service;

import com.tejait.batch15.model.ApplicationOverview;
import org.springframework.stereotype.Service;


public interface ApplicationOverviewService {

    ApplicationOverview getoverviewbyid(int appid);
}