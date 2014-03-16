package com.fdl.dao;

import java.util.HashSet;
import java.util.Set;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.fdl.entity.Graph;
import com.fdl.entity.Link;
import com.fdl.entity.Node;

public class FdlDao extends HibernateDaoSupport{

	public Graph getGraph2(){
		//getHibernateTemplate().save(link);	
		Set<Node> nodes = new HashSet<Node>(getHibernateTemplate().find("From Node"));
		Set<Link> links = new HashSet<Link>(getHibernateTemplate().find("From Link"));
		Graph graph = new Graph(nodes,links);
		return graph;
	}
	
	public void addGraph(){
		Graph g = new Graph();
		g.setName("g1");
		getHibernateTemplate().save(g);
	}

}
