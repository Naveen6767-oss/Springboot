
package com.tejait.batch15.model;


import lombok.Data;

@Data
public class ApplicationOverview {

    private int appId;
    private String companyName;
    private String city;
    private Long mobile;
    private String mail;
    private Long loanAmt;
    private String companyPan;
    private int tenure;


}
