import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

public class CountValidHours {

	public static int solution(int A, int B, int C, int D) {
		String nums[] = {String.valueOf(A), String.valueOf(B), String.valueOf(C), String.valueOf(D)};
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
		formatter.setLenient(false);

        Set<String> timeSets = new HashSet<String>();
		
		for(int w=0 ; w<nums.length ; w++) {
			for(int x=0; x<nums.length ; x++) {
				if(x==w) {
					continue;
				}

				for(int y=0; y<nums.length ; y++) {
					if(y==w || y==x) {
						continue;
					}

					for(int z=0; z<nums.length ; z++) {
						if(z==w || z==x || z==y) {
							continue;
						}
						try {
							String time = nums[w] + nums[x] + ":" + nums[y] + nums[z];
							formatter.parse(time);
							timeSets.add(time);
							
						} catch(Exception e) {
							
						}
					}
				}
			}
		}
		
		return timeSets.size();
	}
}
