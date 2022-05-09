package hackerearth;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class CyclicRotationTest {
	
	@Test
	public void testInstance() {
		assertNotNull(new CyclicRotation());
	}
	
	@Test
	public void testEmptyArray() {
		int[] before = {};
		assertEquals(0, CyclicRotation.goRotate(before, 3).length);
	}
	
	@Test
	public void testGoRotate1() {
		int[] before = {3, 8, 9, 7, 6};
		int[] expected = {9, 7, 6, 3, 8};
		int[] after = CyclicRotation.goRotate(before, 3);
			
		for(int x=0 ; x<expected.length ; x++) {
			assertEquals(expected[x], after[x]);
		}
	}

	@Test
	public void testGoRotate2() {
		int[] before = {1, 2, 3, 4};
		int[] expected = {1, 2, 3, 4};
		int[] after = CyclicRotation.goRotate(before, 4);
			
		for(int x=0 ; x<expected.length ; x++) {
			assertEquals(expected[x], after[x]);
		}
	}

	@Test
	public void testGoRotate3() {
		int[] before = {1, 0, 0};
		int[] expected = {0, 1, 0};
		int[] after = CyclicRotation.goRotate(before, 1);
			
		for(int x=0 ; x<expected.length ; x++) {
			assertEquals(expected[x], after[x]);
		}
	}

	@Test
	public void testGoRotate4() {
		int[] before = {1,0,0,0,0,0,0,0,0,0,0};
		int[] expected = {0,0,0,0,0,0,0,1,0,0,0};
		int[] after = CyclicRotation.goRotate(before, 40);
			
		for(int x=0 ; x<expected.length ; x++) {
			assertEquals(expected[x], after[x]);
		}
	}
}
