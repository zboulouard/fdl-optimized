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
import javax.persistence.OrderBy;
import javax.persistence.Table;


@Entity
@Table(name="link")
@Embeddable
public class Link {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	@Column
	private Integer source;
	
	@Column
	private Integer target;
	
	@Column
	private Integer value;
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "links")
	@OrderBy("id")
	private Set<Graph> graph;
	
	
	
	public Link() {}
	
	public Link(Integer source, Integer target, Integer value) {
		super();
		this.source = source;
		this.target = target;
		this.value = value;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
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
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}

	public Set<Graph> getGraph() {
		return graph;
	}

	public void setGraph(Set<Graph> graph) {
		this.graph = graph;
	}
	
	
}
