
package com.tejait.batch15.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class CompanyAddress {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int id;
 private int appId;
 private String flatnum;
 private String building;
 private String line;
 private String state;
 private String city;
 private String landmark;
 private String area;
 private Long pincode;






}
