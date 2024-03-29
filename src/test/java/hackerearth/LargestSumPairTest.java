package hackerearth;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class LargestSumPairTest {

	@Test
	public void testInstance() {
		assertNotNull(new LargestSumPair());
	}
	
	@Test
	public void testSolution() {
		int[] num = {51, 71, 17, 42};
		assertEquals(93, LargestSumPair.solution(num));		

		int[] num1 = {42, 33, 60};
		assertEquals(102, LargestSumPair.solution(num1));

		int[] num2 = {51, 32, 43};
		assertEquals(-1, LargestSumPair.solution(num2));
	}
}
