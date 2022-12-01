package numberlinetravel;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumberLineTravelTest {

	@Test
	public void test1() {
		int[] x = { 4, 7, 1, 3, 5 };
		assertEquals(2, NumberLineTravel.howManyCitiesCanIVisit(x, 1));
	}

	@Test
	public void test2() {
		int[] x = { 100, 101, 103, 105, 107 };
		assertEquals(4, NumberLineTravel.howManyCitiesCanIVisit(x, 2));
	}

	@Test
	public void test3() {
		int[] x = { 17, 10, 22, 14, 6, 1, 2, 3 };
		assertEquals(6, NumberLineTravel.howManyCitiesCanIVisit(x, 4));
	}

	@Test
	public void test4() {
		int[] x = {0};
		assertEquals(0, NumberLineTravel.howManyCitiesCanIVisit(x, 1000));
	}

}
