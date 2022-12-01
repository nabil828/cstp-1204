package permutationcipher;

import static org.junit.Assert.*;

import org.junit.Test;

public class PermutationCipherTest {

	@Test
	public void test1() {
		int[] permutationArray = { 1, 2, 0 };
		try {
			assertEquals("cab", PermutationCipher.encrypt("abc", permutationArray, 1));
		} catch (IllegalKeyException e) {
			fail("We should not be here, Dororthy!");
		}
	}

	@Test
	public void test2() {
		int[] permutationArray = { 4, 3, 2, 1, 0 };
		try {
			assertEquals("edcba", PermutationCipher.encrypt("abcde", permutationArray, 1));
		} catch (IllegalKeyException e) {
			fail("We should not be here, Dororthy!");
		}
	}

	@Test
	public void test3() {
		int[] permutationArray = { 4, 3, 2, 1, 0 };
		try {
			assertEquals("abcde", PermutationCipher.encrypt("abcde", permutationArray, 2));
		} catch (IllegalKeyException e) {
			fail("We should not be here, Dororthy!");
		}
	}

	@Test
	public void test4() {
		int[] permutationArray = { 4, 3, 6, 2, 5, 1, 0, 7 };
		try {
			assertEquals("goodluck", PermutationCipher.encrypt("uogcodlk", permutationArray, 44));
		} catch (IllegalKeyException e) {
			fail("We should not be here, Dororthy!");
		}
	}

	@Test
	public void test5() {
		int[] permutationArray = { 7, 3, 4, 4, 5, 2, 1, 0 };
		try {
			PermutationCipher.encrypt("tomorrow", permutationArray, 8);
		} catch (IllegalKeyException e) {
			// We expect an exception in this test case
			assertEquals(true, true);
		}
	}

}
