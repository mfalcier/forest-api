package org.mfalcier.forest.api.util;

import org.mfalcier.forest.api.repository.ForestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Class used for in-memory demo database initialization
 * 
 * @author marcofalcier
 *
 */
@Component
public class DbInitializr {

	@Autowired
	private ForestRepository forestRepository;

	public void initialize() {
		this.forestRepository.save(Graph.FOREST_ONE);
	}
}
