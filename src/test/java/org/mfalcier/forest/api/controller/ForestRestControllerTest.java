package org.mfalcier.forest.api.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.powermock.api.mockito.PowerMockito.when;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mfalcier.forest.api.service.ForestService;
import org.mfalcier.forest.api.util.Graph;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import org.mfalcier.forest.api.bean.Area;

@RunWith(PowerMockRunner.class)
@PrepareForTest(ForestRestController.class)
public class ForestRestControllerTest {
	
	@Mock
    ForestService forestService;
	
	@InjectMocks
	private ForestRestController forestRestController;
	
	/*
	 * getCutDownAreas
	 */
	@Test
	public void getCutDownAreasShouldWork() {
		Set<Area> cutDownAreas = new LinkedHashSet<Area>();
		cutDownAreas.add(Graph.AREA_1_1_2_2);
		cutDownAreas.add(Graph.AREA_2_2_3_3);
		cutDownAreas.add(Graph.AREA_3_3_4_4);
		when(forestService.getAreasFromForestAndCutDownTotal(0l, 2)).thenReturn(cutDownAreas);
		
		assertNotNull(this.forestRestController.getCutDownAreas(0l, 2));
		assertEquals(ArrayList.class, this.forestRestController.getCutDownAreas(0l, 2).getClass());
		assertEquals(ArrayList.class, this.forestRestController.getCutDownAreas(0l, 2).get(0).getClass());
		assertEquals(long[].class, this.forestRestController.getCutDownAreas(0l, 2).get(0).get(0).getClass());
	}

}
