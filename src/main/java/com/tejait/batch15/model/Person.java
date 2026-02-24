package com.tejait.batch15.model;


import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.tejait.batch15.Constants.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="person_b15")
@Entity
public class Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pid;
	
	@Column(name="person_name", nullable=false)
	private String name;
	
	@Column(name="mail_id",nullable=false, unique=true)
	private String mail;
	
	private int age;
	//@pattern(regexp="^[A-z]{5}[0-9]{4} [A-z]{1}$")
	private String pan;
	
	@Transient
	private long balance;
	
	@CreationTimestamp
	private LocalDateTime createdat;
	
	@CreationTimestamp
	private LocalDateTime updateat;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	
	
	
	
	
	
	


}
