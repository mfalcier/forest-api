/**
 * 
 */
package org.mfalcier.forest.api.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

import org.mfalcier.forest.api.domain.Forest;

/**
 * The ForestRepository interface
 * 
 * @author marcofalcier
 *
 */
@Repository
public interface ForestRepository extends GraphRepository<Forest> {

	/**
	 * This method returns a {@link Forest} from a given id
	 * 
	 * @param forestId
	 * @return Forest
	 */
	@Query("MATCH (forest:Forest) WHERE id(forest)={0} RETURN forest")
	Forest getForestById(Long forestId);

	/**
	 * This method returns the size of a {@link Forest} from a given forest id
	 * 
	 * @param forestId
	 * @return size
	 */
	@Query("MATCH (forest:Forest)-[:FORMED_BY]-(tree:Tree) WHERE id(forest)={0} RETURN COUNT(tree)")
	int getForestSize(Long forestId);
}
