import java.util.Arrays;


public class SingleNumber {
	public int[] A;
	public int solution(int[] A){
		if(A == null || A.length == 0){
			return 0;
		}
		if(A.length == 1){
			return A[0];
		}
		Arrays.sort(A);
		int i = 0;
		while(i + 1< A.length){
			if(A[i] != A[i+1]){
				return A[i];
			}
			i += 2;
		}
		return A[i];		
	}
	
	public int solution1(int[] nums){
		int[] digits = new int[32];
		for(int i = 0; i < 32; i++){
			for(int j = 0; j < nums.length; j++){
				digits[i] += (nums[j] >> i) & 1;
			}
		}
		int res = 0;
		for(int i = 0; i < 32; i++){
			res += (digits[i]%2)<<i;
		}
		return res;		
	}

}
