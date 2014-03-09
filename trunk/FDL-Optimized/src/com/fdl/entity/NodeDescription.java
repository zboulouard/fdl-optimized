package com.fdl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="nodedescription")
public class NodeDescription {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String author;

	@Column
	private String organism;
	
	
	@Column
	private String country;

	@Column
	private String subjPrime;
	
	@Column
	private String keywords;

	public NodeDescription() {
		super();
		
	}

	public NodeDescription(String author, String organism, String country,
			String subjPrime, String keywords) {
		super();
		this.author = author;
		this.organism = organism;
		this.country = country;
		this.subjPrime = subjPrime;
		this.keywords = keywords;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getOrganism() {
		return organism;
	}

	public void setOrganism(String organism) {
		this.organism = organism;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getSubjPrime() {
		return subjPrime;
	}

	public void setSubjPrime(String subjPrime) {
		this.subjPrime = subjPrime;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

}
