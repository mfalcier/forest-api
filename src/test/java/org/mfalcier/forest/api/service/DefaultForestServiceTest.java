package org.mfalcier.forest.api.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.powermock.api.mockito.PowerMockito.when;

import java.util.Set;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mfalcier.forest.api.repository.ForestRepository;
import org.mfalcier.forest.api.service.impl.DefaultForestService;
import org.mfalcier.forest.api.util.Graph;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import org.mfalcier.forest.api.bean.Area;

@RunWith(PowerMockRunner.class)
@PrepareForTest(ForestService.class)
public class DefaultForestServiceTest {

	@Mock
	private ForestRepository forestRepository;
	@InjectMocks
	private DefaultForestService forestService;

	/*
	 * getAreasFromForestAndCutDownTotal
	 */
	@Test
	public void getAreasFromForestAndCutDownTotalShouldWorkForTotal2() {
		when(forestRepository.getForestById(0l)).thenReturn(Graph.FOREST_ONE);
		when(forestRepository.getForestSize(0l)).thenReturn(Graph.FOREST_ONE_SIZE);
		Set<Area> cutDownAreas = this.forestService.getAreasFromForestAndCutDownTotal(0l, 2);

		assertNotNull(cutDownAreas);

		assertEquals(3, cutDownAreas.size());
		assertTrue(cutDownAreas.contains(Graph.AREA_1_1_2_2));
		assertTrue(cutDownAreas.contains(Graph.AREA_2_2_3_3));
		assertTrue(cutDownAreas.contains(Graph.AREA_3_3_4_4));
	}

	@Test
	public void getAreasFromForestAndCutDownTotalShouldWorkForTotal1() {
		when(forestRepository.getForestById(0l)).thenReturn(Graph.FOREST_ONE);
		when(forestRepository.getForestSize(0l)).thenReturn(Graph.FOREST_ONE_SIZE);
		Set<Area> cutDownAreas = this.forestService.getAreasFromForestAndCutDownTotal(0l, 1);

		assertNotNull(cutDownAreas);

		assertEquals(4, cutDownAreas.size());
	}

	@Test
	public void getAreasFromForestAndCutDownTotalShouldWorkForTotal4() {
		when(forestRepository.getForestById(0l)).thenReturn(Graph.FOREST_ONE);
		when(forestRepository.getForestSize(0l)).thenReturn(Graph.FOREST_ONE_SIZE);
		Set<Area> cutDownAreas = this.forestService.getAreasFromForestAndCutDownTotal(0l, 4);

		assertNotNull(cutDownAreas);

		assertEquals(1, cutDownAreas.size());
	}

	@Test
	public void getAreasFromForestAndCutDownTotalShouldWorkForTotal0() {
		when(forestRepository.getForestById(0l)).thenReturn(Graph.FOREST_ONE);
		when(forestRepository.getForestSize(0l)).thenReturn(Graph.FOREST_ONE_SIZE);
		Set<Area> cutDownAreas = this.forestService.getAreasFromForestAndCutDownTotal(0l, 0);

		assertNotNull(cutDownAreas);

		assertEquals(0, cutDownAreas.size());
	}

	/*
	 * deleteForestArea
	 */
	@Ignore
	@Test
	public void deleteForestArea() {
		//TODO: implement deleteForestArea unit tests
	}
}
