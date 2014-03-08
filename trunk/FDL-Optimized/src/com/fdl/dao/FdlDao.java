package com.fdl.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.fdl.entity.Graph;
import com.fdl.entity.Link;
import com.fdl.entity.Node;

public class FdlDao extends HibernateDaoSupport{

	public Graph getGraph(){
		Graph graph = new Graph();

		Node n1 = new Node("N1",0);
		Node n2 = new Node("N2",1);
		Node n3 = new Node("N3",2);

		Link link1 = new Link(0, 1, 1);
		Link link2 = new Link(0, 2, 2);
		Link link3 = new Link(1, 2, 3);

		graph.getLinks().add(link1);
		graph.getLinks().add(link2);
		graph.getLinks().add(link3);
		
		graph.getNodes().add(n1);
		graph.getNodes().add(n2);
		graph.getNodes().add(n3);
		
		return graph;	
	}


	public Graph getGraph2(){
		//getHibernateTemplate().save(link);		
		List<Node> nodes =getHibernateTemplate().find("From Node");
		List<Link> links =getHibernateTemplate().find("From Link");
		Graph graph = new Graph(nodes,links);
		return graph;
	}

}
