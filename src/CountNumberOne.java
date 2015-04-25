import java.util.ArrayList;


public class CountNumberOne {
	public static int solution(int num){
		if(num == 0){
			return 0;
		}
		String str = Integer.toString(num);
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i) == '1'){
				temp.add(i);
			}
		}
		int res = 0;
		for(int i = 1; i < temp.size(); i++){
			res = Math.max(res, temp.get(i) - temp.get(i-1) - 1);
		}
		return res;
	}
	
	public static void main(String[] args){
		CountNumberOne temp = new CountNumberOne();
		int test1 = 00000;
		int test2 = 000111;
		int test3 = 11000;
		int test4 = 101000001;
		System.out.println(solution(test1));
		System.out.println(solution(test2));
		System.out.println(solution(test3));
		System.out.println(solution(test4));
	}

}
