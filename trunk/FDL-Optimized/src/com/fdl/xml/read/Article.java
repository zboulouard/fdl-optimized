package com.fdl.xml.read;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "article")
public class Article {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idArticle")
	private int IdArticle;
	
	@Column(name = "title")
	private String titre;
	
	
	private ArrayList<String> nomCompletAuteur;
	
	
	private ArrayList<String> orgName;
	
	
	private ArrayList<String> country;
	
	public Article() {
		super();
		nomCompletAuteur = new ArrayList<String>();
		orgName = new ArrayList<String>();
		country = new ArrayList<String>();
	}

	public Article(String titre, ArrayList<String> nomCompletAuteur,
			ArrayList<String> orgName, ArrayList<String> country) {
		super();
		this.titre = titre;
		this.nomCompletAuteur = nomCompletAuteur;
		this.orgName = orgName;
		this.country = country;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public ArrayList<String> getNomCompletAuteur() {
		return nomCompletAuteur;
	}

	public void setNomCompletAuteur(ArrayList<String> nomCompletAuteur) {
		this.nomCompletAuteur = nomCompletAuteur;
	}

	public ArrayList<String> getOrgName() {
		return orgName;
	}

	public void setOrgName(ArrayList<String> orgName) {
		this.orgName = orgName;
	}

	public ArrayList<String> getCountry() {
		return country;
	}

	public void setCountry(ArrayList<String> country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Article [Title = " + titre + ", Authors = "
				+ nomCompletAuteur + ", Organisms = " + orgName + ", Countries = "
				+ country + "]";
	}

	

}
