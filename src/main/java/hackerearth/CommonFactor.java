package hackerearth;

public class CommonFactor {
	public static int getCommonFactor(int left, int right) {
		int numOfFactor = 0, counter = 0;
		
		//get maximum counter possible
		if(left <= right) {
			counter = left;
		} else {
			counter = right;
		}
		
		for(int x=1 ; x<=counter ; x++) {
			if(left%x==0 && right%x==0) {
				numOfFactor++;
			}
		}
		
		return numOfFactor;
	}
}

