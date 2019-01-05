
public class Test {

	public static void main(String[] args) {
		
		Stack stack = new ArrayStack(); // stack 按眉 积己
		System.out.println("[Test Stack]");
		stack.push("Monday"); // push() test
		stack.push("Tuesday");
		stack.push("Wednesday");
		System.out.println(stack.pop()); // pop() test
		System.out.println(stack.pop());
		stack.push("Thursday"); // push() test
		stack.push("Friday");
		System.out.println(stack.pop()); // pop() test
		stack.push("Saturday"); // push() test
		stack.push("Sunday");
		System.out.println(stack.pop()); // pop() test
		System.out.println(stack.pop());
		System.out.println(" "); // 啊刀己阑 困茄 俺青

		Queue queue = new ArrayQueue(); // queue 按眉 积己
		System.out.println("[Test Queue]");
		queue.add("Monday"); // add() test
		queue.add("Tuesday");
		queue.add("Wednesday");
		System.out.println(queue.remove()); // remove() test
		System.out.println(queue.remove());
		queue.add("Thursday"); // add() test
		queue.add("Friday");
		System.out.println(queue.remove()); // remove() test
		queue.add("Saturday"); // add() test
		queue.add("Sunday");
		System.out.println(queue.remove()); // remove() test
		System.out.println(queue.remove());

	}

}
