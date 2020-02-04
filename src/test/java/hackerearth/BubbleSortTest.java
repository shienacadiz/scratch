package hackerearth;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import hackerearth.BubbleSort;

public class BubbleSortTest {
	@Test
	public void testInstance() {
		assertNotNull(new BubbleSort());
	}
	
	@Test
	public void testPerformBubbleSort() {
		int before[] = { 2, 5, -2, 6, -3, 8, 0, -7, -9, 4 };
		int after[] = { -9, -7, -3, -2, 0, 2, 4, 5, 6, 8 };
		BubbleSort.performBubbleSort(before);
		
		for(int ctr=0; ctr<after.length ; ctr++) {
			assertEquals(after[ctr], before[ctr]);
		}
	}
}
