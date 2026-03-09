
package com.tejait.batch15.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class BusinessProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int appId;
    private String purposeOfLoan;
    private String natureOfBusiness;
    private int tenure;
    private Long loanAmount;
}
