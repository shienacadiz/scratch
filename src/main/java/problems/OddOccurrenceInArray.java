package problems;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class OddOccurrenceInArray {

	public static Integer getOddOccurrence(ArrayList<Integer> arrayList) {
		Set<Integer> occurrenceSet = new HashSet<Integer>();
		
		for(int x : arrayList) {
			if(occurrenceSet.contains(x)) {
				occurrenceSet.remove(x);
			}
			else {
				occurrenceSet.add(x);
			}
		}		

//		return occurrenceSet.stream().findFirst().orElse(0);
		return occurrenceSet.iterator().next();
	}
	
    public int solution(int[] A) {
		Set<Integer> occurrenceSet = new HashSet<Integer>();
		
		for(int x : A) {
			if(occurrenceSet.contains(x)) {
				occurrenceSet.remove(x);
			}
			else {
				occurrenceSet.add(x);
			}
		}		

		return occurrenceSet.iterator().next();
    }
}
