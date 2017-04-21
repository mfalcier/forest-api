package org.mfalcier.forest.api.util;

import org.mfalcier.forest.api.bean.Area;
import org.mfalcier.forest.api.domain.Abscissa;
import org.mfalcier.forest.api.domain.Forest;
import org.mfalcier.forest.api.domain.Ordinate;
import org.mfalcier.forest.api.domain.Tree;

/**
 * Class used for storing graph costants
 * 
 * @author marcofalcier
 *
 */
public class Graph {

	public static final Forest FOREST_ONE;
	public static final int FOREST_ONE_SIZE;
	public static final Abscissa ABSCISSA_ONE;
	public static final Ordinate ORDINATE_ONE;
	public static final Tree ONEONE;
	public static final Abscissa ABSCISSA_TWO;
	public static final Ordinate ORDINATE_TWO;
	public static final Tree TWOTWO;
	public static final Abscissa ABSCISSA_THREE;
	public static final Ordinate ORDINATE_THREE;
	public static final Tree THREETHREE;
	public static final Abscissa ABSCISSA_FOUR;
	public static final Ordinate ORDINATE_FOUR;
	public static final Tree FOURFOUR;
	public static final Area AREA_1_1_2_2;
	public static final Area AREA_2_2_3_3;
	public static final Area AREA_3_3_4_4;

	static {
		// CREATING TREES
		ABSCISSA_ONE = new Abscissa(1l);
		ORDINATE_ONE = new Ordinate(1l);
		ONEONE = new Tree(ABSCISSA_ONE, ORDINATE_ONE);

		ABSCISSA_TWO = new Abscissa(2l);
		ORDINATE_TWO = new Ordinate(2l);
		TWOTWO = new Tree(ABSCISSA_TWO, ORDINATE_TWO);

		ABSCISSA_THREE = new Abscissa(3l);
		ORDINATE_THREE = new Ordinate(3l);
		THREETHREE = new Tree(ABSCISSA_THREE, ORDINATE_THREE);

		ABSCISSA_FOUR = new Abscissa(4l);
		ORDINATE_FOUR = new Ordinate(4l);
		FOURFOUR = new Tree(ABSCISSA_FOUR, ORDINATE_FOUR);

		// LINKING TREES TOGETHER
		ONEONE.setNext(TWOTWO);
		TWOTWO.setNext(THREETHREE);
		THREETHREE.setNext(FOURFOUR);

		// CREATING FOREST
		FOREST_ONE = new Forest();
		FOREST_ONE.formedBy(ONEONE);
		FOREST_ONE.formedBy(TWOTWO);
		FOREST_ONE.formedBy(THREETHREE);
		FOREST_ONE.formedBy(FOURFOUR);
		FOREST_ONE.setFirst(ONEONE);
		FOREST_ONE.setLast(FOURFOUR);

		FOREST_ONE_SIZE = 4;

		// CREATING AREAS
		AREA_1_1_2_2 = new Area(ONEONE, TWOTWO);
		AREA_2_2_3_3 = new Area(TWOTWO, THREETHREE);
		AREA_3_3_4_4 = new Area(THREETHREE, FOURFOUR);
	}
}
