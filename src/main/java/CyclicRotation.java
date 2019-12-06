
public class CyclicRotation {
	public static int[] goRotate(int[] array, int cycle) {	
		int[] rotated = new int[array.length];
		if(array.length < 1) {
			return rotated;
		}
		int reducedCycle = cycle % array.length;
		int start = array.length - reducedCycle;
		int left = 0;
		
		for(int x=0; x<array.length ; x++) {
			if(x<reducedCycle) {
				rotated[x] = array[start];
				start++;
			}
			else {
				rotated[x] = array[left];
				left++;
			}
		}
		
		return rotated;
	}
}
