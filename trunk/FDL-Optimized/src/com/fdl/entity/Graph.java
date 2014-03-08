package com.fdl.entity;

import java.util.ArrayList;
import java.util.List;

public class Graph {

	private List<Node> nodes = new ArrayList<Node>();  
	private List<Link> links = new ArrayList<Link>();
	
	
	public Graph() {}
	
	public Graph(List<Node> nodes, List<Link> links) {
		super();
		this.nodes = nodes;
		this.links = links;
	}

	public List<Node> getNodes() {
		return nodes;
	}

	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}

	public List<Link> getLinks() {
		return links;
	}
	public void setLinks(List<Link> links) {
		this.links = links;
	}  

	
	
}
