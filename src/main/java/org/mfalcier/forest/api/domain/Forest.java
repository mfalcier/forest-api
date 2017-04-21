package org.mfalcier.forest.api.domain;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

/**
 * The Forest domain class
 * 
 * @author marcofalcier
 *
 */
@NodeEntity
public class Forest {

	@GraphId
	private Long id;
	private Long length;
	private Long height;
	
	@Relationship(type="FORMED_BY", direction=Relationship.OUTGOING)
	private Set<Tree> trees;
	
	@Relationship(type="FIRST", direction=Relationship.OUTGOING)
	private Tree first;
	
	@Relationship(type="LAST", direction=Relationship.OUTGOING)
	private Tree last;

	public Forest() {
		trees = new HashSet<Tree>();
	}

	public Forest(long length, long height) {
		this.length = length;
		this.height = height;
		trees = new HashSet<Tree>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getLength() {
		return length;
	}

	public void setLength(Long length) {
		this.length = length;
	}

	public Long getHeight() {
		return height;
	}

	public void setHeight(Long height) {
		this.height = height;
	}

	public Set<Tree> getTrees() {
		return trees;
	}

	public void setTrees(Set<Tree> trees) {
		this.trees = trees;
	}
	
	public Tree getFirst() {
		return first;
	}

	public void setFirst(Tree first) {
		this.first = first;
	}

	public Tree getLast() {
		return last;
	}

	public void setLast(Tree last) {
		this.last = last;
	}

	public void formedBy(Tree tree) {
		this.trees.add(tree);
	}
	
}
