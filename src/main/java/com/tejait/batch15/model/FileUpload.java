package com.tejait.batch15.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;
@Table(name="fileUpload_b15")
@Entity
@Data
public class FileUpload {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String filename;
	private String filetype;
	
	@Lob
	@Column(columnDefinition = "LONGBLOB")
	private  byte[] data;
	
}
