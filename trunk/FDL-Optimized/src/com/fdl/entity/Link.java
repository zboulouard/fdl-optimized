package com.fdl.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;


@Entity
@Table(name="link")
@Embeddable
public class Link {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private Integer source;
	
	@Column
	private Integer target;
	
	@ManyToOne(fetch = FetchType.EAGER)
	LinkDescription value;
	
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "links")
	@OrderBy("id")
	private Set<Graph> graph;
	
	
	
	public Link() {}
	
	public Link(Integer source, Integer target) {
		super();
		this.source = source;
		this.target = target;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSource() {
		return source;
	}
	public void setSource(Integer source) {
		this.source = source;
	}
	public Integer getTarget() {
		return target;
	}
	public void setTarget(Integer target) {
		this.target = target;
	}






	public Set<Graph> getGraph() {
		return graph;
	}

	public void setGraph(Set<Graph> graph) {
		this.graph = graph;
	}
	
	
}
