package com.fdl.xml.read;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class ReadXMLFileImpl implements ReadXMLFile {
	
	private static String OUTPUT_FOLDER = "/home/zakaria/Bureau/PhD/test-folder";
	
	private Article article;
	
	public ReadXMLFileImpl() {
		super();
		
	}

	public void read() {
		  
		    try {
		 
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			
			for (File file : new File(OUTPUT_FOLDER).listFiles()) {
				
				article = new Article();
			
			Document doc = dBuilder.parse(file);
			
			doc.getDocumentElement().normalize();
		 
			NodeList nListAuthor = doc.getElementsByTagName("Author");
		 
			for (int temp = 0; temp < nListAuthor.getLength(); temp++) {
		 
				Node nNode = nListAuthor.item(temp);
				
				String given = "";
				String family = "";
				String fullName = "";
		 
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		 
					Element eElement = (Element) nNode;
		 
					NodeList givenNames = eElement.getElementsByTagName("GivenName");
					for (int i = 0; i < givenNames.getLength(); i++) {
					    given = given + " " + givenNames.item(i).getTextContent();
					}
					family = eElement.getElementsByTagName("FamilyName").item(0).getTextContent();
					fullName = given + " " + family;
					fullName = fullName.trim();
					
					article.getNomCompletAuteur().add(fullName);
					
				}
			}
			NodeList nListArticleInfo = doc.getElementsByTagName("ArticleInfo");
			 
			for (int temp = 0; temp < nListArticleInfo.getLength(); temp++) {
		 
				Node nNode = nListArticleInfo.item(temp);
				
				String title = "";
		 
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		 
					Element eElement = (Element) nNode;

					title = eElement.getElementsByTagName("ArticleTitle").item(0).getTextContent();
					
					article.setTitre(title);
				}
			}
			
			NodeList nListAffiliation = doc.getElementsByTagName("Affiliation");
			 
			for (int temp = 0; temp < nListAffiliation.getLength(); temp++) {
		 
				Node nNode = nListAffiliation.item(temp);
				
				String orgName = "";
		 
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		 
					Element eElement = (Element) nNode;

					orgName = eElement.getElementsByTagName("OrgName").item(0).getTextContent();

					article.getOrgName().add(orgName);
				}
			}
			
			NodeList nListOrgAddress = doc.getElementsByTagName("OrgAddress");
			 
			for (int temp = 0; temp < nListOrgAddress.getLength(); temp++) {
		 
				Node nNode = nListOrgAddress.item(temp);
				
				String country = "";
		 
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		 
					Element eElement = (Element) nNode;
					
					try {
						country = eElement.getElementsByTagName("Country").item(0).getTextContent();
					} catch(Exception e) {
						country = "";
					}
					
					article.getCountry().add(country);
				}
			}

			System.out.println(article.toString());
			
			}
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		  }
	
}
