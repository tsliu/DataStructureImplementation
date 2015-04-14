
public class TSMaxPriorityQueue {
	 private Integer[] PQ;
	 private int N;
	 public TSMaxPriorityQueue(int capacity){
		 PQ = new Integer[capacity+1];
	 }
	 
	 public boolean isEmpty(){
		 return N == 0;
	 }
	 
	 public void insert(Integer num){
		 PQ[++N] = num;
		 swim(N);		 
	 }
	 
	 public Integer deleteMax(){
		 Integer max = PQ[1];
		 exchange(1, N);
		 PQ[N--] = null;
		 sink(1);		 
		 return max;
	 }
	 
	 private void swim(int k){
		 while(k > 1 && less(k/2, k)){
			 exchange(k/2, k);
		 }
		 k = k/2;
	 }
	 
	 private void sink(int k){
		 while(2*k <= N){
			 int j = 2*k;
			 if(j < N && less(j, j+1)){
				 j++;
			 }
			 if(!less(k, j)){
				 break;
			 }
			 exchange(k, j);
			 k = j;
		 }
		 
	 }
	 
	 private boolean less(int num1, int num2){
		 return PQ[num1] < PQ[num2];
	 }
	 
	 private void exchange(int num1, int num2){
		 int temp = PQ[num1];
		 PQ[num1] = PQ[num2];
		 PQ[num2] = temp;
	 }
	 
	 public static void main(String[] args){
		 TSMaxPriorityQueue check = new TSMaxPriorityQueue(10);
		 check.insert(1);
		 check.insert(2);
		 check.insert(9);
		 check.insert(4);
		 check.insert(7);
		 System.out.println(check.deleteMax());
		 System.out.println(check.deleteMax());
		 System.out.println(check.deleteMax());
		 System.out.println(check.deleteMax());
	 }
}
