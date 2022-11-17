package sortasquares;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

public class SortaSquareTest {

	@Test
	public void test1() {
		Integer[] myArray = {16, 25};
		HashSet<Integer> s = new HashSet<Integer>(Arrays.asList(myArray));
		assertEquals(s, SortaSquare.getSortaSquares(s));
	}
	
	@Test
	public void test2() {
		Integer[] myArray = {-1, 7, 18, 49};
		Integer[] ansArray = {18, 49};
		HashSet<Integer> s1 = new HashSet<Integer>(Arrays.asList(myArray));
		HashSet<Integer> s2 = new HashSet<Integer>(Arrays.asList(ansArray));
		assertEquals(s2, SortaSquare.getSortaSquares(s1));
	}
	
	@Test
	public void test3() {
		Integer[] myArray = {12, 125};
		Integer[] ansArray = {};
		HashSet<Integer> s1 = new HashSet<Integer>(Arrays.asList(myArray));
		HashSet<Integer> s2 = new HashSet<Integer>(Arrays.asList(ansArray));
		assertEquals(s2, SortaSquare.getSortaSquares(s1));
	}
}
