package org.mfalcier.forest.api.bean;

import org.mfalcier.forest.api.domain.Tree;

/**
 * The Area bean class
 * 
 * @author marcofalcier
 *
 */
public class Area {
	private Tree first;
	private Tree last;

	public Area() {

	}

	public Area(Tree first, Tree last) {
		this.first = first;
		this.last = last;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		result = prime * result + ((last == null) ? 0 : last.hashCode());
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
		Area other = (Area) obj;
		if (first == null) {
			if (other.first != null)
				return false;
		} else if (!first.equals(other.first))
			return false;
		if (last == null) {
			if (other.last != null)
				return false;
		} else if (!last.equals(other.last))
			return false;
		return true;
	}

}
