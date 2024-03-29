package com.fdl.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.fdl.entity.Graph;
import com.fdl.entity.Link;

public class FdlDao extends HibernateDaoSupport{
	
	
	private static String OUTPUT_FOLDER = "/home/zakaria/Bureau/PhD/test-folder";

	public Graph getGraph2(){
		//getHibernateTemplate().save(link);	
		Set<com.fdl.entity.Node> nodes = new HashSet<com.fdl.entity.Node>(getHibernateTemplate().find("From Node"));
		Set<Link> links = new HashSet<Link>(getHibernateTemplate().find("From Link"));
		Graph graph = new Graph(nodes,links);
		return graph;
	}
	
	public void addGraph(){

		  
	    try {
	 
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		
		
		/*
		 * Boucler sur les fichier de dossier 
		 * */
		int fileNumber = 0;
		for (File file : new File(OUTPUT_FOLDER).listFiles()) {
			
			fileNumber++;
			
			/*
			 * La liste qui contien les noms des auteurs
			 * */
			List<String> authorsList = new ArrayList<String>();
			
			System.out.println("############### File #"+fileNumber+" ################");

			Document doc = dBuilder.parse(file);
			doc.getDocumentElement().normalize();
			
				
					NodeList nListAuthor = doc.getElementsByTagName("Author");
					/*
					 * Bouler sur la list des auteurs pour chaque fichier
					 * */
					for (int temp = 0; temp < nListAuthor.getLength(); temp++) {			
						
						com.fdl.entity.Node author = new com.fdl.entity.Node();
						Node nNode = nListAuthor.item(temp);
						
						String given = "";
						String family = "";
						String fullName = "";
				 
							if (nNode.getNodeType() == Node.ELEMENT_NODE) {	 
								Element eElement = (Element) nNode;
								NodeList givenNames = eElement.getElementsByTagName("GivenName");
								/*
								 * concaténer les balises <GivenName> 
								 * */
								for (int i = 0; i < givenNames.getLength(); i++) {
								    given = given + " " + givenNames.item(i).getTextContent();
								}
								family = eElement.getElementsByTagName("FamilyName").item(0).getTextContent();
								fullName = given + " " + family;
								fullName = fullName.trim();
							}
							
							System.out.println("Auteur #"+temp+" : "+fullName);
							author.setName(fullName);
							authorsList.add(fullName);
							
							List list = getHibernateTemplate().find("FROM Node WHERE name = '"+fullName+"'");
							if(list.size() == 0 ){
								getHibernateTemplate().save(author);								
							}
							

					}


					NodeList nListArticleInfo = doc.getElementsByTagName("ArticleInfo");
			
					/*
					 * Bouler sur les titres d'un artice pour constituer le titre 
					 * */
					String title = "";
					for (int temp = 0; temp < nListArticleInfo.getLength(); temp++) {
						Node nNode = nListArticleInfo.item(temp);
						if (nNode.getNodeType() == Node.ELEMENT_NODE) {
							Element eElement = (Element) nNode;
							title = eElement.getElementsByTagName("ArticleTitle").item(0).getTextContent();
						}
					}
					
					/*Algorithme de combinaison */
					 Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
					 Transaction transaction = session.beginTransaction();
					Query query = 
							session.createQuery("from Node n where n.name in (:authorNames)")
							.setParameterList("authorNames", authorsList);
					/*Recuperer les Auteurs avec les IDs*/
					List<com.fdl.entity.Node> listOfNodesWithIds = query.list();
					
//					System.out.println(listOfNodesWithIds.size());
					
					/*
					 * Boucler sur la combinason des auteurs
					 * qui esiste dàjà dans la variable listOfNodesWithIds
					 * */
					/*Debut */
					
					int item, item2;

					for (int i=0; i<listOfNodesWithIds.size(); i++) {
						   item = listOfNodesWithIds.get(i).getId();
						   for(int j=i+1; j<listOfNodesWithIds.size(); j++) {
								Link article = new Link();
								System.out.println("Article  : "+title);
							   item2 = listOfNodesWithIds.get(j).getId();
	
							   System.out.println(item + ", " + item2);
								
							   	article.setSource(item);					
								article.setTarget(item2);
								article.setTitle(title);
								List list = getHibernateTemplate().find("FROM Link WHERE title = '"+title+"' AND source = '"+(item)+"'"+" AND target = '"+(item2)+"'");
								if(list.size() == 0 ){
									getHibernateTemplate().save(article);								
								}
								
								
								
						   }
					}

					
					
					transaction.commit();

					
					
					
//				NodeList nListAffiliation = doc.getElementsByTagName("Affiliation");
				/*
				 * Bouler sur les auteurs pour recuperer l'organisme 
				 * */	
//				for (int temp = 0; temp < nListAffiliation.getLength(); temp++) {
//					Node nNode = nListAffiliation.item(temp);
//					String orgName = "";
//					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
//						Element eElement = (Element) nNode;
//						orgName = eElement.getElementsByTagName("OrgName").item(0).getTextContent();
//						article.getOrgName().add(orgName);						
//					}
//				}
//		
//				NodeList nListOrgAddress = doc.getElementsByTagName("OrgAddress");
		 
				/*
				 * Bouler sur les auteurs pour recuperer les pays 
				 * */	
//				for (int temp = 0; temp < nListOrgAddress.getLength(); temp++) {	 
//					Node nNode = nListOrgAddress.item(temp);
//					String countryName = "";
//					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
//						Element eElement = (Element) nNode;
//						try {
//							countryName = eElement.getElementsByTagName("Country").item(0).getTextContent();
//						} catch(Exception e) {
//							countryName = "";
//						}						
//						article.getCountry().add(countryName);
//					}
//				}		
		}
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	  
	}

}
