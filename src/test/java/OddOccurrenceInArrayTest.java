import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class OddOccurrenceInArrayTest {

	@Test
	public void testGetOddOccurrence() {
		ArrayList<Integer> arr1 = new ArrayList<Integer>();
		arr1.add(9);
		arr1.add(3);
		arr1.add(9);
		arr1.add(3);
		arr1.add(9);
		arr1.add(7);
		arr1.add(9);
		assertEquals((Integer) 7, (Integer) OddOccurrenceInArray.getOddOccurrence(arr1));
		
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		arr2.add(1);
		arr2.add(1);
		arr2.add(0);
		arr2.add(3);
		arr2.add(3);
		arr2.add(0);
		arr2.add(0);
		assertEquals((Integer) 0, (Integer) OddOccurrenceInArray.getOddOccurrence(arr2));
	}
}
