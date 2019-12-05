import java.io.IOException;
import java.util.Scanner;

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
	
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String line = br.readLine();
//        System.out.println(getCommonFactor(line));
       int left = 0, right = 0;
       Scanner scanner = new Scanner(System.in);
       if (scanner.hasNextInt()) {
          left = scanner.nextInt();
       }
       if (scanner.hasNextInt()) {
          right = scanner.nextInt();
       }
       System.out.println(getCommonFactor(left, right));
       scanner.close();
	}
}

