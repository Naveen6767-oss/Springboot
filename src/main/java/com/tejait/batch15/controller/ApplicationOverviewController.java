
package com.tejait.batch15.controller;


import com.tejait.batch15.model.ApplicationOverview;
import com.tejait.batch15.service.ApplicationOverviewService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("loans")
public class ApplicationOverviewController {

    ApplicationOverviewService service;
    
    @GetMapping("getOverviewDeatils/{appid}")
    public ResponseEntity<ApplicationOverview> getbyappId(@PathVariable int appid){
        ApplicationOverview applicationoverview =service.getoverviewbyid(appid);
        return new ResponseEntity<>(applicationoverview, HttpStatus.OK);
    }
}