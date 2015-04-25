import java.util.ArrayList;
import java.util.HashMap;


public class CountLeftAndRight {
	public static ArrayList<String> solution(int[] num){
		ArrayList<String> res = new ArrayList<String>();
		if(num == null || num.length == 0){
			return res;
		}
		HashMap<Integer, ArrayList<Integer>> dict = new HashMap<Integer, ArrayList<Integer>>();
		for(int i = 0; i < num.length; i++){
			if(dict.containsKey(num[i])){
				dict.get(num[i]).add(i);
			}
			else{
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(i);
				dict.put(num[i], temp);
			}
		}
		StringBuilder sba = new StringBuilder();
		StringBuilder sbb = new StringBuilder();
		for(int i = 0; i < num.length; i++){
			ArrayList<Integer> temp = dict.get(num[i]);
			if(temp.size() == 1){
				sba.append('0');
				sbb.append('0');
			}
			else{
				int left = 0;
				int right = 0;
				for(int j = 0; j < temp.size(); j++){
					if(temp.get(j) < i){
						left++;
					}
					if(temp.get(j) > i){
						right++;
					}
				}
				sba.append(left);
				sbb.append(right);
			}
		}
		res.add(sba.toString());
		res.add(sbb.toString());
		return res;
	}
	
	public static void main(String[] agrs){
		CountLeftAndRight temp = new CountLeftAndRight();
		int[] test1 = {1, 3, 2, 3, 4, 1};
		int[] test2 = {1, 1, 1, 1, 1, 5};
		System.out.println(solution(test1));
		System.out.println(solution(test2));
	}

}
