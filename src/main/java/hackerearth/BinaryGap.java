package hackerearth;

public class BinaryGap {

	public static String convertToBinary(int num) {		
		if(num/2 < 1) {
			return Integer.toString(num % 2); 
		}
		else {
			return convertToBinary(num/2) + (num%2);
		}
	}

	public static int getBinaryGap(String string) {
		int largestCount = 0;
		boolean hasFoundOne = false;
		int zeroCount = 0;

		for(int x=0 ; x<string.length() ; x++) {
			if("1".equals(String.valueOf(string.charAt(x)))) {
				if(zeroCount > 0 && hasFoundOne) {
					if(zeroCount>largestCount) {
						largestCount = zeroCount;
					}
					zeroCount = 0;
				}
				hasFoundOne = true;
			}
			else if(hasFoundOne) {
				zeroCount++;
			}
		}
		
		return largestCount;
	}
}
