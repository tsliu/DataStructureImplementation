import java.util.ArrayList;

public class balancedNumberInMatrix {
	public static ArrayList<ArrayList<Integer>> solution(int[][] matrix){
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
			return null;
		}
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		int row = matrix.length;
		int column = matrix[0].length;
		int[] rowSum = new int[row];
		int[] columnSum = new int[column];
		int sum = 0;
		for(int i = 0; i < row; i++){
			for(int j = 0; j < column; j++){
				rowSum[i] += matrix[i][j];
				columnSum[j] += matrix[i][j];
				sum += matrix[i][j];
			}
		}
		int[] rowSumUp = new int[row];
		int[] rowSumDown = new int[row];
		int[] columnSumLeft = new int[column];
		int[] columnSumRight = new int[column];
		rowSumDown[0] = sum;
		columnSumRight[0] = sum;
		for(int i = 1; i < row; i++){
			rowSumUp[i] = rowSumUp[i-1] + rowSum[i - 1];
			rowSumDown[i] = sum - rowSumUp[i] - rowSum[i];
		}
		for(int j = 1; j < column; j++){
			columnSumLeft[j] = columnSumLeft[j-1] + columnSum[j - 1];
			columnSumRight[j] = sum - columnSumLeft[j] - columnSum[j];			
		}
		for(int i = 0; i < row; i++){
			for(int j = 0; j < column; j++){
				if(rowSumUp[i] == rowSumDown[i] && columnSumLeft[j] == columnSumRight[j]){
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.add(j);
					temp.add(i);
					res.add(temp);
				}
			}
		}
		return res;		
	}
	
	public static void main(String[] args){
		balancedNumberInMatrix temp = new balancedNumberInMatrix();
		int[][] test1 = {{1, 1, 2, 5}, {7, 2, 3, 3}, {1, 1, 1, 9},  {2, 11, 2, 9}};
		System.out.println(solution(test1));
	}

}
