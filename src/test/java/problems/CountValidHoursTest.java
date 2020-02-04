package problems;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import problems.CountValidHours;

public class CountValidHoursTest {
	
	@Test
	public void testSolution() {
		assertEquals(6, CountValidHours.solution(1,8,3,2));

		assertEquals(3, CountValidHours.solution(2,3,3,2));

		assertEquals(0, CountValidHours.solution(6,2,4,7));
	}
}
