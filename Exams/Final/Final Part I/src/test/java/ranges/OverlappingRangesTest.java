package ranges;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class OverlappingRangesTest {

	@Test
	public void test1() {
		Integer[] sp = { 1, 2, 3, 7 };
		Integer[] ep = { 6, 6, 4, 10 };
		ArrayList<Integer> startPoints = new ArrayList<Integer>(
				Arrays.asList(sp));
		ArrayList<Integer> endPoints = new ArrayList<Integer>(Arrays.asList(ep));
		try {
			assertEquals(
					OverlappingRanges.maxOverlapInt(startPoints, endPoints),
					new Integer(3));
		} catch (NoOverlapException e) {
			fail("Should not be here!");
		}
	}

	@Test
	public void test2() {
		Integer[] sp = { 2, 1 };
		Integer[] ep = { 5, 10 };
		ArrayList<Integer> startPoints = new ArrayList<Integer>(
				Arrays.asList(sp));
		ArrayList<Integer> endPoints = new ArrayList<Integer>(Arrays.asList(ep));
		try {
			assertEquals(
					OverlappingRanges.maxOverlapInt(startPoints, endPoints),
					new Integer(2));
		} catch (NoOverlapException e) {
			fail("Should not be here!");
		}
	}

	@Test
	public void test3() {
		Integer[] sp = { 10, 1, 11, 0 };
		Integer[] ep = { 15, 20, 25, 2 };
		ArrayList<Integer> startPoints = new ArrayList<Integer>(
				Arrays.asList(sp));
		ArrayList<Integer> endPoints = new ArrayList<Integer>(Arrays.asList(ep));
		try {
			assertEquals(
					OverlappingRanges.maxOverlapInt(startPoints, endPoints),
					new Integer(11));
		} catch (NoOverlapException e) {
			fail("Should not be here!");
		}
	}

}
