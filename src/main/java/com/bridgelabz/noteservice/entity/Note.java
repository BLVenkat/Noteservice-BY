package com.bridgelabz.noteservice.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Note implements Serializable{

	private static final long serialVersionUID = -9097182656814289090L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String title;
	
	private String description;
	
	private String reminder;
	
	private String colour;
	
	private Boolean archive;

	private Boolean pin;
	
	private Boolean trash;
	
	@CreationTimestamp
	private LocalDateTime createdTimeStamp;
	
	@UpdateTimestamp
	private LocalDateTime updatedTimeStamp;
	
	private Long userId;
	
}