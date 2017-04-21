package org.mfalcier.forest.api.domain;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

/**
 * The Tree domain class
 * 
 * @author marcofalcier
 *
 */
@NodeEntity
public class Tree {

	@GraphId
	private Long id;
	@Relationship(type="RESIDES_ON", direction=Relationship.OUTGOING)
	private Abscissa abscissa;
	@Relationship(type="RESIDES_ON", direction=Relationship.OUTGOING)
	private Ordinate ordindate;
	@Relationship(type="NEXT", direction=Relationship.OUTGOING)
	Tree next;

	public Tree() {

	}

	public Tree(Abscissa abscissa, Ordinate ordinate) {
		this.abscissa = abscissa;
		this.ordindate = ordinate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Abscissa getAbscissa() {
		return abscissa;
	}

	public void setAbscissa(Abscissa abscissa) {
		this.abscissa = abscissa;
	}

	public Ordinate getOrdindate() {
		return ordindate;
	}

	public void setOrdindate(Ordinate ordindate) {
		this.ordindate = ordindate;
	}
	
	public Tree getNext() {
		return next;
	}

	public void setNext(Tree next) {
		this.next = next;
	}

	public boolean hasNext() {
		return this.next != null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((abscissa == null) ? 0 : abscissa.hashCode());
		result = prime * result + ((ordindate == null) ? 0 : ordindate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tree other = (Tree) obj;
		if (abscissa == null) {
			if (other.abscissa != null)
				return false;
		} else if (!abscissa.equals(other.abscissa))
			return false;
		if (ordindate == null) {
			if (other.ordindate != null)
				return false;
		} else if (!ordindate.equals(other.ordindate))
			return false;
		return true;
	}
}
