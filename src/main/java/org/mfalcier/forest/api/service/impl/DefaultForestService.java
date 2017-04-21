/**
 * 
 */
package org.mfalcier.forest.api.service.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.mfalcier.forest.api.domain.Tree;
import org.mfalcier.forest.api.repository.ForestRepository;
import org.mfalcier.forest.api.service.ForestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.mfalcier.forest.api.bean.Area;
import org.mfalcier.forest.api.domain.Forest;

/**
 * The DefaultForestService class
 * 
 * @author marcofalcier
 *
 */
@Service
public class DefaultForestService implements ForestService {

	@Autowired
	private ForestRepository forestRepository;

	@Override
	public Set<Area> getAreasFromForestAndCutDownTotal(Long forestId, int total) {
		Set<Area> cutDownAreas = new LinkedHashSet<Area>();

		Forest forest = this.forestRepository.getForestById(forestId);
		int forestSize = this.forestRepository.getForestSize(forestId);
		if (forestSize != 0 && total != 0) {
			if (total == forestSize) {
				// total is equals to the whole forest
				cutDownAreas.add(new Area(forest.getFirst(), forest.getLast()));
			} else if (total > forestSize) {
				// total is greater then the whole forest
			} else if (total == 1) {
				// total is 1, so every tree is an area himself
				Tree currentTree = forest.getFirst();
				if (currentTree != null) {
					while (currentTree != null) {
						cutDownAreas.add(new Area(currentTree, currentTree));
						currentTree = currentTree.getNext();
					}
				}
			} else {
				/*
				 * total is lesser then the whole forest, let's find out how
				 * many cutDownAreas we've got
				 */
				int count;
				Tree currentTree = forest.getFirst();
				while (currentTree.hasNext()) {
					count = 0;
					Tree first = null;
					Tree last = null;
					Tree internalTree = currentTree;

					while (internalTree != null) {
						if (first == null) {
							first = internalTree;
						}
						count++;
						if (count == total) {
							last = internalTree;
							cutDownAreas.add(new Area(first, last));
							break;
						}
						internalTree = internalTree.getNext();
					}

					currentTree = currentTree.getNext();
				}
			}
		}

		return cutDownAreas;
	}

	@Override
	public int deleteForestArea(Long forestId, Area cutDownArea) {
		int total = 0;
		
		//TODO: implement deleteForestArea method
		
		return total;
	}
}
