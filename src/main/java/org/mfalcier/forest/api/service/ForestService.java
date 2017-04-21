package org.mfalcier.forest.api.service;

import java.util.Set;

import org.mfalcier.forest.api.bean.Area;
import org.mfalcier.forest.api.domain.Forest;
import org.mfalcier.forest.api.domain.Tree;

/**
 * The ForestService business interface
 * 
 * @author marcofalcier
 *
 */
public interface ForestService {

	/**
	 * This method returns a {@link Set} of {@link Area} to cut down, from a
	 * given {@link Forest} id and the total number of {@link Tree} to be cut
	 * down
	 * 
	 * @param forestId
	 * @param total
	 * @return Set<Area>
	 */
	Set<Area> getAreasFromForestAndCutDownTotal(Long forestId, int total);

	/**
	 * This method delete a given {@link Area} from a given {@link Forest} id;
	 * it will returns the total amount of deleted trees
	 * 
	 * @param forestId
	 * @param cutDownArea
	 * @return total
	 */
	int deleteForestArea(Long forestId, Area cutDownArea);
}
