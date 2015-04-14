import java.util.Stack;

public class QueueWithTwoStacks<Item> {
	private Stack<Item> stack1;
	private Stack<Item> stack2;
	
	public QueueWithTwoStacks(){
		stack1 = new Stack<Item>();
		stack2 = new Stack<Item>();		
	}
	
	public boolean empty(){
		return stack1.isEmpty() && stack2.isEmpty();
	}
	
	public int size(){
		return stack1.size() + stack2.size();
	}
	
	public void push(Item item){
		stack1.push(item);
	}
	
	public Item peek(){
		if(stack1.isEmpty() && stack2.isEmpty()){
			return null;
		}
		if(stack2.isEmpty()){
			moveStack1toStack2();
		}
		return stack2.peek();
	}
	
	public Item poll(){
		if(stack1.isEmpty() && stack2.isEmpty()){
			return null;
		}
		if(stack2.isEmpty()){
			moveStack1toStack2();
		}
		return stack2.pop();
	}
	
	private void moveStack1toStack2(){
		while(!stack1.isEmpty()){
			stack2.push(stack1.pop());
		}
	}
	
	public static void main(String[] args){
		QueueWithTwoStacks<Integer> test = new QueueWithTwoStacks<Integer>();
		test.push(1);
		test.push(2);
		test.push(3);
		System.out.println(test.poll());
		System.out.println(test.poll());
		System.out.println(test.poll());		
	}
}
