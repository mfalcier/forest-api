package org.mfalcier.forest.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.mfalcier.forest.api.bean.Area;
import org.mfalcier.forest.api.domain.Tree;
import org.mfalcier.forest.api.service.ForestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import org.mfalcier.forest.api.domain.Forest;
import org.mfalcier.forest.api.util.DbInitializr;

/**
 * The ForestRestController class
 * 
 * @author marcofalcier
 *
 */
@RestController
public class ForestRestController {

	@Autowired
	private ForestService forestService;

	@Autowired
	private DbInitializr dbInitializr;

	/**
	 * This controller expose a service that returns an List of List of long
	 * array, containing all the couple of vertex regarding the areas to cut
	 * down, from a given {@link Forest} id and the total number of {@link Tree}
	 * to be cut down
	 * 
	 * @param forestId
	 * @param total
	 * @return List<List<long[]>>
	 */
	@GetMapping("/forest/discover/{forestId}/{total}")
	public List<List<long[]>> getCutDownAreas(@PathVariable long forestId, @PathVariable int total) {
		List<List<long[]>> results = new ArrayList<List<long[]>>();

		for (Area area : this.forestService.getAreasFromForestAndCutDownTotal(forestId, total)) {
			List<long[]> middle = new ArrayList<long[]>();
			long[] first = { area.getFirst().getAbscissa().getValue(), area.getFirst().getOrdindate().getValue() };
			long[] last = { area.getLast().getAbscissa().getValue(), area.getLast().getOrdindate().getValue() };
			middle.add(first);
			middle.add(last);
			results.add(middle);
		}

		return results;
	}

	/**
	 * This method initialize a small data set for the in-memory database
	 * 
	 * @return
	 */
	@GetMapping("/forest/initialize")
	public String initialize() {
		this.dbInitializr.initialize();
		return "Database initialization completed :3 <br> A demo forest has been created with ID: 0.";
	}

}
