
public class TwoOperations {
	public static int solution(int num){
		if(num == 0){
			return 0;
		}
		int zeroNum = 0;
		int oneNum = 0;
		while(num > 0){
			int temp = num & 1;
			num = num >> 1;
			if(temp == 1){
				oneNum++;
			}
			else{
				zeroNum++;
			}
		}
		int res = 0;
		res = zeroNum + 2*oneNum - 1;		
		return res;
	}
	
	public static void main(String[] agrs){
		TwoOperations temp = new TwoOperations();
		int test1 = 6;
		int test2 = 7;
		int test3 = 5;
		int test4 = 111;
		int test5 = 0;
		int test6 = 3;
		System.out.println(solution(test1));
		System.out.println(solution(test2));
		System.out.println(solution(test3));
		System.out.println(solution(test4));
		System.out.println(solution(test5));
		System.out.println(solution(test6));
	}
}
