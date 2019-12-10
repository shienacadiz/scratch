

public class LargestSumPair {

	public static int solution(int[] A) {
		int maxSum = 0;
		int[][] sums = new int[A.length][2];
		
		for(int x=0 ; x<A.length ; x++){
			sums[x][0] = A[x];
			
			String asString = String.valueOf(A[x]);
			sums[x][1] = Integer.parseInt(Character.toString(asString.charAt(0))) + Integer.parseInt(Character.toString(asString.charAt(1)));
		}
		
		for(int x=0 ; x<sums.length; x++) {
			int left = sums[x][1];
			for(int y=x+1 ; y<sums.length ; y++) {
				int right = sums[y][1];
				
				if(right == left && (sums[x][0] + sums[y][0])>maxSum) {
					maxSum = sums[x][0] + sums[y][0];
				}
			}
		}
		
		if(maxSum == 0) {
			return -1;
		}
		
		return maxSum;
		
	}

}
